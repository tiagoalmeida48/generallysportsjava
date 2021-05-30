package br.com.fapen.generallysposts.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fapen.generallysposts.DTO.ResponseEstoqueDTO;
import br.com.fapen.generallysposts.models.Voucher;
import br.com.fapen.generallysposts.repositories.VoucherRepository;
import br.com.fapen.generallysposts.services.ArquivoService;

@RestController
@CrossOrigin
@RequestMapping("/api/voucher")
public class VoucherApiController {
	
	@Autowired
	private VoucherRepository voucherRep;

	@Autowired
	private ArquivoService arquivoService;
	
	@CrossOrigin
	@GetMapping
	public List<Voucher> listar() throws IOException {
		List<Voucher> vouchers = voucherRep.findAllByInativoFalseAndEstoque();

		for (Voucher voucher : vouchers) {
			if (voucher.getCaminhoFoto() != null) {
				voucher.setFotoEmString(
						"data:image/png;base64," + arquivoService.ImageToString(voucher.getCaminhoFoto()));
			} else {
				voucher.setFotoEmString("");
			}
		}
		return vouchers;
	}
	
	@GetMapping("/verificaEstoque/{id}")
	public ResponseEntity<ResponseEstoqueDTO> verificaEstoque(@PathVariable Long id) {
		
		ResponseEstoqueDTO estoque = new ResponseEstoqueDTO();

		try {
			Optional<Voucher> vouc = voucherRep.findById(id);

			int voucherEstoque = vouc.get().getQuantidadeEstoque();

			if (voucherEstoque > 0) {
				estoque.setTemEstoque(true);
				estoque.setQuantidade_estoque(voucherEstoque);

			} else {
				estoque.setTemEstoque(false);
				estoque.setQuantidade_estoque(0);
			}

		} catch (Exception e) {
			estoque.setTemEstoque(false);
			estoque.setQuantidade_estoque(0);
			return new ResponseEntity<ResponseEstoqueDTO>(estoque, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<ResponseEstoqueDTO>(estoque, HttpStatus.OK);

	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Voucher> buscarPorId(@PathVariable Long id) throws IOException {
		Optional<Voucher> vouc = voucherRep.findById(id);

		if (vouc.isEmpty()) {
			return new ResponseEntity<Voucher>(HttpStatus.NOT_FOUND);
		}

		if (vouc.get().getCaminhoFoto() != null) {
			vouc.get().setFotoEmString(
					"data:image/png;base64," + arquivoService.ImageToString(vouc.get().getCaminhoFoto()));
		} else {
			vouc.get().setFotoEmString("");
		}
		return new ResponseEntity<Voucher>(vouc.get(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Object> incluir(@Valid @RequestBody Voucher voucher) {
		voucherRep.save(voucher);
		return new ResponseEntity<Object>(voucher, HttpStatus.CREATED);
	}

}
