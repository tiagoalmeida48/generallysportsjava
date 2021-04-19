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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fapen.generallysposts.models.ProdutoFavorito;
import br.com.fapen.generallysposts.repositories.ProdutoFavoritoRepository;

@RestController
@CrossOrigin
@RequestMapping("/api/produtofavorito")
public class ProdutoFavoritoApiController {

	@Autowired
	private ProdutoFavoritoRepository produtoFavoritoRep;

	@GetMapping("/{id}")
	public ResponseEntity<Object> listarCarrinhoPorUsuario(@PathVariable Long id) throws IOException {
		List<ProdutoFavorito> produtoFavorito =  produtoFavoritoRep.findByIdUsuario(id).stream()
			.collect(Collectors.toList()); 

		if(produtoFavorito.isEmpty())
			return new ResponseEntity<Object>(produtoFavorito, HttpStatus.NOT_FOUND);

		return new ResponseEntity<Object>(produtoFavorito, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Object> incluir(@Valid @RequestBody ProdutoFavorito produtoFavorito) {
		produtoFavoritoRep.save(produtoFavorito);
		return new ResponseEntity<Object>(produtoFavorito, HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> delete(@Valid @RequestBody ProdutoFavorito produtoFavorito, @PathVariable Long id) {
		produtoFavoritoRep.deleteById(id);
		return new ResponseEntity<Object>(produtoFavorito, HttpStatus.OK);
	}
}
