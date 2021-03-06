package br.com.fapen.generallysposts.controllers;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fapen.generallysposts.forms.PedidoVendaForm;
import br.com.fapen.generallysposts.models.ItensPedidoVenda;
import br.com.fapen.generallysposts.models.PedidoVenda;
import br.com.fapen.generallysposts.models.Produto;
import br.com.fapen.generallysposts.models.Usuario;
import br.com.fapen.generallysposts.repositories.PedidoVendaRepository;
import br.com.fapen.generallysposts.repositories.ProdutoRepository;
import br.com.fapen.generallysposts.repositories.UsuarioRepository;
import br.com.fapen.generallysposts.services.ArquivoService;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/pedidos")
public class PedidoVendaApiController {

	@Autowired
	private PedidoVendaRepository pedidoRep;

	@Autowired
	private UsuarioRepository usuarioRep;
	
	@Autowired
	private ProdutoRepository produtoRep;

	@Autowired
	private ArquivoService arquivoService;

	@PostMapping
	public ResponseEntity<Object> salvarPedidoVenda(@RequestBody PedidoVendaForm pedidoVendaForm,
			BindingResult resultadoValidacao, RedirectAttributes atributos) {

		
		Usuario usuario = usuarioRep.findByLogin(pedidoVendaForm.getPedidoVenda().getUsuario().getLogin());

		for (ItensPedidoVenda item : pedidoVendaForm.getItensPedidoVenda()) {
			item.setPedido_venda(pedidoVendaForm.getPedidoVenda());
			pedidoVendaForm.getPedidoVenda().getItens().add(item);

		}
		BigDecimal total = BigDecimal.ZERO;
		for (ItensPedidoVenda item : pedidoVendaForm.getPedidoVenda().getItens()) {
			BigDecimal qtde = new BigDecimal(item.getQuantidade());
			BigDecimal totalItem = item.getValor().multiply(qtde);
			total = total.add(totalItem);
		}
		
		pedidoVendaForm.getPedidoVenda().setUsuario(usuario);
		pedidoVendaForm.getPedidoVenda().setValorFinal(total);
		
		pedidoRep.save(pedidoVendaForm.getPedidoVenda());
		
		for (ItensPedidoVenda item : pedidoVendaForm.getPedidoVenda().getItens()) {
			Produto produto = item.getProduto();

			produto.setFotoEmString("");
			produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - item.getQuantidade().intValue());

			//System.out.println(item.getQuantidade().intValue());
			produtoRep.save(produto);

		}

		return new ResponseEntity<Object>(pedidoVendaForm, HttpStatus.ACCEPTED);

	}
	
	@CrossOrigin
	@GetMapping("/list/{login}")
	public List<PedidoVenda> listarPedidoPorLogin(@PathVariable String login) throws IOException {
		
		Usuario usuario = usuarioRep.findByLogin(login);
		
		List<PedidoVenda> pedidos = pedidoRep.findAllByUsuario(usuario);
		


		return pedidos;
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<PedidoVenda> buscarPorId(@PathVariable Long id) throws IOException {
		Optional<PedidoVenda> pedido = pedidoRep.findById(id);

		if (pedido.isEmpty()) {
			return new ResponseEntity<PedidoVenda>(HttpStatus.NOT_FOUND);
		}
		
		for(ItensPedidoVenda item : pedido.get().getItens()) {
			Produto produto = item.getProduto();
			
			if (produto.getCaminhoFoto() != null) {
				produto.setFotoEmString(
						"data:image/png;base64," + arquivoService.ImageToString(produto.getCaminhoFoto()));
			} else {
				produto.setFotoEmString("");
			}
		}

		return new ResponseEntity<PedidoVenda>(pedido.get(), HttpStatus.OK);
	}
	
	

}
