package br.com.fapen.generallysposts.controllers;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fapen.generallysposts.models.Produto;
import br.com.fapen.generallysposts.repositories.FornecedorRepository;
import br.com.fapen.generallysposts.repositories.ProdutoRepository;
import br.com.fapen.generallysposts.services.ArquivoService;
import br.com.fapen.generallysposts.services.ProdutoService;
import br.com.fapen.generallysposts.validations.ProdutoValidator;


@Controller
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRep;

	@Autowired
	private FornecedorRepository fornecedorRep;
	
	@Autowired
	private ProdutoValidator produtoValidator;
	
	@Autowired
	private ArquivoService arquivoService;

	@Autowired
	private ProdutoService produtoService;

	@InitBinder("produto")
	protected void init(WebDataBinder binder) {
		binder.setValidator(produtoValidator);
	}
	
	

	@GetMapping(name = "listarProdutos")
	public ModelAndView listProduct(@RequestParam(defaultValue = "1") Integer pagina, @RequestParam(defaultValue = "") String busca, Principal principal) {
		
		Page<Produto> listaProdutos = produtoService.listar(busca, pagina, principal);

		ModelAndView mav = new ModelAndView("produto/listar");
		mav.addObject("listaPaginada", listaProdutos);

		return mav;
	}

	@GetMapping(value = "/novo", name = "novoProduto")
	public ModelAndView newProduct(Produto produto) {
		
		ModelAndView mav = new ModelAndView("/produto/novo");
		mav.addObject("listaFornecedores", fornecedorRep.findAllByInativoFalse());
		return mav;
	}
	
	@PostMapping(value = "/salvar", name = "salvarProduto")
	public ModelAndView createProduct(@Valid Produto produto, BindingResult resultadoValidacao, RedirectAttributes atributos) {
		
		if(resultadoValidacao.hasErrors()) {
			return newProduct(produto);
		}
		
		produtoRep.save(produto);
		atributos.addFlashAttribute("mensagemSucesso", "Produto salvo com sucesso!");
		return new ModelAndView("redirect:/produtos");
	}
	
	@GetMapping(value = "/{id}/editar", name = "editarProduto")
	public ModelAndView editProduct(@PathVariable Long id, Model model) {
		
		Produto produto = produtoRep.getOne(id);
		model.addAttribute(produto);
		return newProduct(produto);
	}
	
	@PostMapping(value = "/{id}/apagar", name = "apagarProduto")
	public String inativar(@PathVariable Long id, RedirectAttributes atributos) {
		Produto produto = produtoRep.findOneByIdProduto(id);
	
		produto.setInativo(true);

		produtoRep.save(produto);
		atributos.addFlashAttribute("mensagemSucesso", "Produto apagado com sucesso!");
		return "redirect:/produtos";
	}
	
	@GetMapping(value = "/{id}", name = "visualizarProduto")
	public ModelAndView viewProduct(@PathVariable Long id, RedirectAttributes atributos) {
		
		Produto produto = produtoRep.findOneByIdProduto(id);
		if(produto == null || produto.isInativo() == true) {
			atributos.addFlashAttribute("mensagemErro", "Produto n??o foi encontrado.");
			return new ModelAndView("redirect:/produtos");
		}
		ModelAndView mav = new ModelAndView("produto/visualizar");
		mav.addObject("produto", produto);
		
		return mav;
	}
	
	@PostMapping(value = "/alterarFoto", name = "alterarFotoProduto")
	public String alterarFotoProduto(MultipartFile foto, Produto produto, RedirectAttributes atributos) {
		
		String caminhoDaFoto = arquivoService.salvarArquivo(foto);
		Produto prod = produtoRep.getOne(produto.getIdProduto());
		prod.setCaminhoFoto(caminhoDaFoto);
		produtoRep.save(prod);
		
		atributos.addFlashAttribute("mensagemSucesso", "Imagem do produto alterada com sucesso!");
		return "redirect:/produtos";
	}
}