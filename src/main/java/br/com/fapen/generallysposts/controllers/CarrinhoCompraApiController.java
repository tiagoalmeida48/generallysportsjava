package br.com.fapen.generallysposts.controllers;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fapen.generallysposts.models.CarrinhoCompra;
import br.com.fapen.generallysposts.models.Produto;
import br.com.fapen.generallysposts.repositories.CarrinhoCompraRepository;
import br.com.fapen.generallysposts.services.ArquivoService;

@RestController
@CrossOrigin
@RequestMapping("/api/carrinhocompras")
public class CarrinhoCompraApiController {

	@Autowired
	private CarrinhoCompraRepository carrinhoCompraRep;
	
	@Autowired
	private ArquivoService arquivoService;

	@GetMapping("/{id}")
	public ResponseEntity<Object> listarCarrinhoPorUsuario(@PathVariable Long id) throws IOException {
		List<CarrinhoCompra> carrinhoCompra =  carrinhoCompraRep.findByIdUsuario(id).stream()
			.collect(Collectors.toList()); 

		for (CarrinhoCompra carrinho : carrinhoCompra) {
			if (carrinho.getProduto().getCaminhoFoto() != null) {
				carrinho.getProduto().setFotoEmString(
						"data:image/png;base64," + arquivoService.ImageToString(carrinho.getProduto().getCaminhoFoto()));
			} else {
				carrinho.getProduto().setFotoEmString("");
			}
		}

		if(carrinhoCompra.isEmpty())
			return new ResponseEntity<Object>(carrinhoCompra, HttpStatus.NOT_FOUND);

		return new ResponseEntity<Object>(carrinhoCompra, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Object> incluir(@Valid @RequestBody CarrinhoCompra carrinhoCompra) {
		carrinhoCompraRep.save(carrinhoCompra);
		return new ResponseEntity<Object>(carrinhoCompra, HttpStatus.CREATED);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<Object> alterar(@Valid @RequestBody CarrinhoCompra carrinhoCompra, @PathVariable Long id) {
	 	carrinhoCompra.setIdCarrinho(id);
		
		carrinhoCompraRep.save(carrinhoCompra);
		return new ResponseEntity<Object>(carrinhoCompra, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> delete(@Valid @RequestBody CarrinhoCompra carrinhoCompra, @PathVariable Long id) {
		carrinhoCompraRep.deleteById(id);
		return new ResponseEntity<Object>(carrinhoCompra, HttpStatus.OK);
	}
}
