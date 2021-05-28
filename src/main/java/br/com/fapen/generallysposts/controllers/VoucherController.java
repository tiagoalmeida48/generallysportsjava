package br.com.fapen.generallysposts.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ModelAndView listProduct(@RequestParam(defaultValue = "1") Integer pagina, @RequestParam(defaultValue = "") String busca, Principal principal) {
		
		Page<Voucher> listaVoucher = voucherService.listar(busca, pagina, principal);

		ModelAndView mav = new ModelAndView("voucher/listar");
		mav.addObject("listaPaginada", listaVoucher);

		return mav;
	}
	
	@GetMapping(value = "/novo", name = "novoVoucher")
	public String newProvider(Voucher voucher) {
		return "/voucher/novo";
	
	}
	
	@GetMapping(value = "/{id}", name = "visualizarVoucher")
	public ModelAndView viewProduct(@PathVariable Long id, RedirectAttributes atributos) {
		
		Voucher voucher = voucherRep.findOneByIdVoucher(id);
		if(voucher == null) {
			atributos.addFlashAttribute("mensagemErro", "Voucher não foi encontrado.");
			return new ModelAndView("redirect:/voucher");
		}
		ModelAndView mav = new ModelAndView("voucher/visualizar");
		mav.addObject("voucher", voucher);
		
		return mav;
	}
}
