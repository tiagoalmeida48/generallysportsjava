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
import br.com.fapen.generallysposts.models.Voucher;
import br.com.fapen.generallysposts.repositories.VoucherRepository;
import br.com.fapen.generallysposts.services.ArquivoService;
import br.com.fapen.generallysposts.services.VoucherService;
import br.com.fapen.generallysposts.validations.VoucherValidator;


@Controller
@RequestMapping("/voucher")
public class VoucherController {
	
	@Autowired
	private ArquivoService arquivoService;

	@Autowired
	private VoucherService voucherService;
	
	@Autowired
	private VoucherValidator voucherValidator;
	
	@Autowired
	private VoucherRepository voucherRep;
	
	@InitBinder("voucher")
	protected void init(WebDataBinder binder) {
		binder.setValidator(voucherValidator);
	}

	@GetMapping(name = "listarVoucher")
	public ModelAndView listVoucher(@RequestParam(defaultValue = "1") Integer pagina, @RequestParam(defaultValue = "") String busca, Principal principal) {
		
		Page<Voucher> listaVoucher = voucherService.listar(busca, pagina, principal);

		ModelAndView mav = new ModelAndView("voucher/listar");
		mav.addObject("listaPaginada", listaVoucher);

		return mav;
	}
	
	@GetMapping(value = "/novo", name = "novoVoucher")
	public ModelAndView newVoucher(Voucher voucher) {
		
		ModelAndView mav = new ModelAndView("/voucher/novo");
		return mav;
	
	}
	
	@GetMapping(value = "/{id}", name = "visualizarVoucher")
	public ModelAndView viewVoucher(@PathVariable Long id, RedirectAttributes atributos) {
		
		Voucher voucher = voucherRep.findOneByIdVoucher(id);
		if(voucher == null) {
			atributos.addFlashAttribute("mensagemErro", "Voucher não foi encontrado.");
			return new ModelAndView("redirect:/voucher");
		}
		ModelAndView mav = new ModelAndView("voucher/visualizar");
		mav.addObject("voucher", voucher);
		
		return mav;
	}
	
	@PostMapping(value = "/salvar", name = "salvarVoucher")
	public ModelAndView createVoucher(@Valid Voucher voucher, BindingResult resultadoValidacao, RedirectAttributes atributos) {
		
		if(resultadoValidacao.hasErrors()) {
			return newVoucher(voucher);
		}
		
		voucherRep.save(voucher);
		atributos.addFlashAttribute("mensagemSucesso", "Voucher salvo com sucesso!");
		return new ModelAndView("redirect:/voucher");
	}

	//private ModelAndView newVoucher(@Valid Voucher voucher) {
		// TODO Auto-generated method stub
		//return null;
	//}
	
	@GetMapping(value = "/{id}/editar", name = "editarVoucher")
	public ModelAndView editVoucher(@PathVariable Long id, Model model) {
		
		Voucher voucher = voucherRep.getOne(id);
		model.addAttribute(voucher);
		return newVoucher(voucher);
	}
	
	@PostMapping(value = "/alterarFoto", name = "alterarFotoVoucher")
	public String alterarFotoVoucher(MultipartFile foto, Voucher voucher, RedirectAttributes atributos) {
		
		String caminhoDaFoto = arquivoService.salvarArquivo(foto);
		Voucher vouc = voucherRep.getOne(voucher.getIdVoucher());
		vouc.setCaminhoFoto(caminhoDaFoto);
		voucherRep.save(vouc);
		
		atributos.addFlashAttribute("mensagemSucesso", "Imagem do voucher alterada com sucesso!");
		return "redirect:/voucher";
	}
	
	@PostMapping(value = "/{id}/apagar", name = "apagarVoucher")
	public String inativar(@PathVariable Long id, RedirectAttributes atributos) {
		Voucher voucher = voucherRep.findOneByIdVoucher(id);
	
		voucher.setInativo(true);

		voucherRep.save(voucher);
		atributos.addFlashAttribute("mensagemSucesso", "Voucher apagado com sucesso!");
		return "redirect:/voucher";
	}
	
}
