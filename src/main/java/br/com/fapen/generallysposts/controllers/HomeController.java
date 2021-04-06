package br.com.fapen.generallysposts.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fapen.generallysposts.forms.ContatoSiteForm;
import br.com.fapen.generallysposts.services.EmailService;
import br.com.fapen.generallysposts.templates.HtmlTemplate;

@Controller
public class HomeController {
	
	@Autowired
	private EmailService emailService;

	@RequestMapping(value = "/home", method = RequestMethod.GET, name = "home")
	public String home() {
		return "home";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homePrincipal() {
		return "home";
	}
	
	@RequestMapping(value = "/sobre", method = RequestMethod.GET, name = "sobre")
	public String sobre() {
		return "sobre";
	}

	@RequestMapping(value = "/academias", method = RequestMethod.GET, name = "academias")
	public String academias() {
		return "academias";
	}

	@RequestMapping(value = "/clinicas", method = RequestMethod.GET, name = "clinicas")
	public String clinicas() {
		return "clinicas";
	}

	@RequestMapping(value = "/acessorios", method = RequestMethod.GET, name = "acessorios")
	public String acessorios() {
		return "acessorios";
	}

	@RequestMapping(value = "/suplementos", method = RequestMethod.GET, name = "suplementos")
	public String suplementos() {
		return "suplementos";
	}

	@RequestMapping(value = "/contato", method = RequestMethod.GET, name = "contato")
	public String contato() {
		return "contato";
	}

	@RequestMapping(value = "/politica", method = RequestMethod.GET, name = "politica")
	public String politica() {
		return "politica";
	}

	@RequestMapping(value = "/perguntas", method = RequestMethod.GET, name = "perguntas")
	public String perguntas() {
		return "perguntas";
	}

	@RequestMapping(value = "/termos", method = RequestMethod.GET, name = "termos")
	public String termos() {
		return "termos";
	}

	@RequestMapping(value = "/seguranca", method = RequestMethod.GET, name = "seguranca")
	public String seguranca() {
		return "seguranca";
	}

	@RequestMapping(value = "/trocas", method = RequestMethod.GET, name = "trocas")
	public String trocas() {
		return "trocas";
	}

	@RequestMapping(value = "/servicos", method = RequestMethod.GET, name = "servicos")
	public String servicos() {
		return "servicos";
	}

	@RequestMapping(value = "/investidores", method = RequestMethod.GET, name = "investidores")
	public String investidores() {
		return "investidores";
	}

	@RequestMapping(value = "/marketplace", method = RequestMethod.GET, name = "marketplace")
	public String marketplace() {
		return "marketplace";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET, name = "login")
	public String login() {
		return "login";
	}

	@PostMapping(value = "/enviar-email", name = "contatoViaSite")
	public String contatoViaSite(ContatoSiteForm contatoSiteForm, RedirectAttributes atributos) {
		
		emailService.enviarEmailHtml("seuphone.apple@gmail.com", "Contato via Site", HtmlTemplate.contatoViaSite(contatoSiteForm));
		
		atributos.addFlashAttribute("mensagemSucesso", "Sua mensagem foi enviada, logo entraremos em contato!");
		return "redirect:/home";
	}
	
	
}
