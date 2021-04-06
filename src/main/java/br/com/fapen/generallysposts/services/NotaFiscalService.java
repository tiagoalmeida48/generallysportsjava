package br.com.fapen.generallysposts.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.fapen.generallysposts.forms.NotaFiltroForm;
import br.com.fapen.generallysposts.models.NotaFiscal;
import br.com.fapen.generallysposts.repositories.NotaFiscalRepository;
import br.com.fapen.generallysposts.repositories.Paginacao;

@Service
public class NotaFiscalService {

	@Autowired
	private NotaFiscalRepository notaFiscalRep;

	public Page<NotaFiscal> listar(NotaFiltroForm notaFiltroForm) {

		if (notaFiltroForm.isNovoFiltro()) {
			notaFiltroForm.setPagina(1);
		}
		Pageable paginacao = Paginacao.getPaginacao(notaFiltroForm.getPagina());
		
		if (notaFiltroForm.getTipoFiltro().equals("NF")) {
			if (notaFiltroForm.getNumeroNota() != null) {
				return notaFiscalRep.findByNumeroNotaFiscal(notaFiltroForm.getNumeroNota(), paginacao);
			} else {
				return notaFiscalRep.findAll(paginacao);
			}
		} else if(notaFiltroForm.getTipoFiltro().equals("DTNF")) {
			return notaFiscalRep.findAllByDtNotaFiscalBetween(notaFiltroForm.getDataNfInicial(),
					notaFiltroForm.getDataNfFinal(), paginacao);
		} else if(notaFiltroForm.getTipoFiltro().equals("DTRE")) {
			return notaFiscalRep.findAllByDtRecebimentoBetween(notaFiltroForm.getDataRecebInicial(),
					notaFiltroForm.getDataRecebFinal(), paginacao);
		} else if (notaFiltroForm.getTipoFiltro().equals("NP")) {
			if (notaFiltroForm.getNumeroPedido() != null) {
				return notaFiscalRep.findByPedidoIdPedido(notaFiltroForm.getNumeroPedido(), paginacao);
			} else {
				return notaFiscalRep.findAll(paginacao);
			}
		}
		else {
			return notaFiscalRep.findAll(paginacao);
		}
	}
}
