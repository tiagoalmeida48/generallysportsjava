package br.com.fapen.generallysposts.controllers;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fapen.generallysposts.models.Fornecedor;
import br.com.fapen.generallysposts.repositories.FornecedorRepository;
import br.com.fapen.generallysposts.services.FornecedorService;
import br.com.fapen.generallysposts.validations.FornecedorValidator;

@Controller
@RequestMapping("/fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorRepository fornecedorRepository;
    
    @Autowired
    private FornecedorService fornecedorService;
    
    @Autowired
    private FornecedorValidator fornecedorValidator;
    
    @InitBinder("fornecedor")
    protected void init(WebDataBinder binder) {
    	binder.setValidator(fornecedorValidator);
    }

    @GetMapping(name = "listarFornecedores")
	public ModelAndView listProviders(@RequestParam(defaultValue = "1") Integer pagina, @RequestParam(defaultValue = "") String busca, Principal principal) {
		
    	Page<Fornecedor> listaFornecedores = fornecedorService.listarFornecedores(busca, pagina, principal);

		ModelAndView mav = new ModelAndView("fornecedor/listar");
		mav.addObject("listaPaginada", listaFornecedores);

		return mav;
	}

	@GetMapping(value = "/novo", name = "novoFornecedor")
	public String newProvider(Fornecedor fornecedor) {
		return "/fornecedor/novo";
	}
	
	@RequestMapping(value = "/fornecedores/{id}/editar", method = RequestMethod.GET, name = "editarFornecedor")
	public ModelAndView editProvider(@PathVariable Long id) {
		
		Fornecedor fornecedor = fornecedorRepository.getOne(id);
		
		ModelAndView mav = new ModelAndView("fornecedor/novo");
		mav.addObject("fornecedor", fornecedor);
		
		return mav;
	}
	

	@PostMapping(value = "/salvar", name = "salvarFornecedor")
	public String createProvider(@Valid Fornecedor fornecedor, BindingResult resultadoValidacao, RedirectAttributes atributos) {
		
		if(resultadoValidacao.hasErrors()) {
			return newProvider(fornecedor);
		}
		
		
		fornecedorRepository.save(fornecedor);
		atributos.addFlashAttribute("mensagemStatus", "Fornecedor foi salvo com sucesso!");
		return "redirect:/fornecedores";
	}
	
	@GetMapping(value = "/{id}", name = "visualizarFornecedor")
	public ModelAndView visualizar(@PathVariable Long id) {
		Fornecedor fornecedor = fornecedorRepository.getOne(id);
		
		ModelAndView mav = new ModelAndView("fornecedor/visualizar");
		mav.addObject("fornecedor", fornecedor);
		
		return mav;
	}
	
	@PostMapping(value = "/{id}/apagar", name = "apagarFornecedor")
	public String inativar(@PathVariable Long id, RedirectAttributes atributos) {
		Fornecedor fornecedor = fornecedorRepository.findOneById(id);
	
		fornecedor.setInativo(true);

		fornecedorRepository.save(fornecedor);
		
		atributos.addFlashAttribute("mensagemStatus", "Fornecedor foi apagado com sucesso!");
		return "redirect:/fornecedores";
	}
}