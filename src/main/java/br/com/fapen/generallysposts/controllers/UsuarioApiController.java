package br.com.fapen.generallysposts.controllers;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fapen.generallysposts.DTO.Base64ImageRequestDTO;
import br.com.fapen.generallysposts.DTO.JwtRequestDTO;
import br.com.fapen.generallysposts.DTO.JwtResponseDTO;
import br.com.fapen.generallysposts.forms.UsuarioForm;
import br.com.fapen.generallysposts.models.Endereco;
import br.com.fapen.generallysposts.models.Usuario;
import br.com.fapen.generallysposts.repositories.EnderecoRepository;
import br.com.fapen.generallysposts.repositories.UsuarioRepository;
import br.com.fapen.generallysposts.services.ArquivoService;
import br.com.fapen.generallysposts.services.EmailService;
import br.com.fapen.generallysposts.services.JwtTokenService;
import br.com.fapen.generallysposts.services.UsuarioService;
import br.com.fapen.generallysposts.templates.HtmlTemplate;
import br.com.fapen.generallysposts.validations.UsuarioFormValidator;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/usuarios")
public class UsuarioApiController {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private UsuarioRepository usuarioRep;

	@Autowired
	private JwtTokenService jwtTokenService;

	@Autowired
	private ArquivoService arquivoService;

	@Autowired
	private EmailService emailService;

	@Autowired
	private EnderecoRepository enderecoRep;

	@Autowired
	private UsuarioFormValidator usuarioFormValidator;

	@InitBinder("usuarioForm")
	protected void init(WebDataBinder binder) {
		binder.setValidator(usuarioFormValidator);
	}

	@Autowired
	private AuthenticationManager authenticationManager;

	@GetMapping
	public List<Usuario> listarTodos() {
		return usuarioService.findAll();
	}

	@PostMapping("/login")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequestDTO authenticationRequest)
			throws Exception {
		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		final UserDetails userDetails = usuarioService.loadUserByUsername(authenticationRequest.getUsername());
		final String token = jwtTokenService.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponseDTO(token));
	}

	// Metodo que realiza a autenticacao no Spring Security
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}

	@PostMapping("/criarUsuario")
	public ResponseEntity<Object> incluir(@Valid @RequestBody UsuarioForm usuarioForm,
			BindingResult resultadoValidacao) {

		if (resultadoValidacao.hasErrors()) {
			return new ResponseEntity<Object>(resultadoValidacao.getAllErrors(), HttpStatus.BAD_REQUEST);
		}
		if (usuarioForm.getUsuario().getCaminhoFoto() == "") {
			usuarioForm.getUsuario().setCaminhoFoto(null);
		}
		usuarioService.salvar(usuarioForm);

		emailService.enviarEmailHtml(usuarioForm.getUsuario().getEmail(), "Cadastro de Usu??rio - Generally Sports",
				HtmlTemplate.emailCadastro(usuarioForm.getUsuario().getLogin(),
						usuarioForm.getUsuario().getPessoa().getNome(), usuarioForm.getUsuario().getEmail()));
		
		return new ResponseEntity<Object>(usuarioForm, HttpStatus.CREATED);

	}

	@CrossOrigin
	@GetMapping("/{login}")
	public ResponseEntity<Usuario> buscarPorLogin(@PathVariable String login) throws IOException {
		Usuario usuario = usuarioRep.findByLogin(login);

		if (usuario.equals("") || usuario.equals(null)) {
			return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
		}

		if (usuario.getCaminhoFoto() != null) {
			usuario.setFotoEmString("data:image/png;base64," + arquivoService.ImageToString(usuario.getCaminhoFoto()));
		} else {
			usuario.setFotoEmString("");
		}

		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}

	@PostMapping(value = "/avatarUpdate")
	public ResponseEntity<Object> alterarFotoPerfil(@RequestBody Base64ImageRequestDTO requestForm) throws IOException {

		String avatarPath = arquivoService.saveBase64Image(requestForm.getBase64Image());

		Usuario usuario = usuarioRep.findByLogin(requestForm.getUserLogin());
		usuario.setCaminhoFoto(avatarPath);
		usuarioRep.save(usuario);

		return new ResponseEntity<Object>(HttpStatus.ACCEPTED);
	}
	
	@CrossOrigin
	@PutMapping(value = "/addressUpdate/{id}")
	public ResponseEntity<Object> AlterarEndereco(@RequestBody Endereco endereco, @PathVariable Long id) {
		
		endereco.setId(id);
		
		enderecoRep.save(endereco);
		return new ResponseEntity<Object>(endereco, HttpStatus.ACCEPTED);
	}

}
