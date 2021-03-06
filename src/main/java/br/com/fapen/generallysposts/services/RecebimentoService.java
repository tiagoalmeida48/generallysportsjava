package br.com.fapen.generallysposts.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.fapen.generallysposts.enums.StatusPedidoEnum;
import br.com.fapen.generallysposts.forms.DescricaoRecebimentoForm;
import br.com.fapen.generallysposts.forms.RecebimentoForm;
import br.com.fapen.generallysposts.models.DescricaoNotaFiscal;
import br.com.fapen.generallysposts.models.DescricaoPedido;
import br.com.fapen.generallysposts.models.NotaFiscal;
import br.com.fapen.generallysposts.models.PedidoCompra;
import br.com.fapen.generallysposts.models.Produto;
import br.com.fapen.generallysposts.repositories.NotaFiscalRepository;
import br.com.fapen.generallysposts.repositories.PedidoCompraRepository;
import br.com.fapen.generallysposts.repositories.ProdutoRepository;

@Service
public class RecebimentoService {

	@Autowired
	private PedidoCompraService pedidoService;

	@Autowired
	private PedidoCompraRepository pedidoRep;

	@Autowired
	private ProdutoRepository produtoRep;

	@Autowired
	private NotaFiscalRepository notaFiscalRep;

	public void carregarItensRecebimento(RecebimentoForm recebimentoForm) {

		recebimentoForm.getItens().clear();

		if (recebimentoForm.getPedido() != null) {
			for (DescricaoPedido itemPedido : recebimentoForm.getPedido().getItens()) {
				DescricaoRecebimentoForm itemRecebimento = new DescricaoRecebimentoForm();
				itemRecebimento.setProduto(itemPedido.getProduto());
				itemRecebimento.setQuantidade(itemPedido.getQuantidade());
				itemRecebimento.setPrecoUnitario(itemPedido.getValor());
				itemRecebimento.setValorTotal(pedidoService.calculaQtdTotal(itemPedido));
				recebimentoForm.getItens().add(itemRecebimento);

			}
		}
	}

	@Transactional
	public void salvarRecebimento(RecebimentoForm recebimentoForm) {
		NotaFiscal notaFiscal = new NotaFiscal();

		notaFiscal.setIdNotaFiscal(recebimentoForm.getIdRecebimento());
		notaFiscal.setSerieNotaFiscal(recebimentoForm.getSerieNotaFiscal());
		notaFiscal.setNumeroNotaFiscal(recebimentoForm.getNumeroNotaFiscal());
		notaFiscal.setDtNotaFiscal(recebimentoForm.getDtNotaFiscal());
		notaFiscal.setDtRecebimento(recebimentoForm.getDtRecebimento());
		notaFiscal.setPedido(recebimentoForm.getPedido());

		for (DescricaoRecebimentoForm itemReceb : recebimentoForm.getItens()) {
			DescricaoNotaFiscal itemNotaFiscal = new DescricaoNotaFiscal();

			itemNotaFiscal.setNotaFiscal(notaFiscal);
			itemNotaFiscal.setProduto(itemReceb.getProduto());
			itemNotaFiscal.setQuantidade(itemReceb.getQuantidade());
			itemNotaFiscal.setPrecoUnitario(itemReceb.getPrecoUnitario());
			itemNotaFiscal.setValorTotal(itemReceb.getValorTotal());

			notaFiscal.getItensNotaFiscal().add(itemNotaFiscal);
		}

		notaFiscalRep.save(notaFiscal);

		for (DescricaoNotaFiscal itemNF : notaFiscal.getItensNotaFiscal()) {
			Produto produto = itemNF.getProduto();

			produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() + itemNF.getQuantidade().intValue());

			produtoRep.save(produto);

		}

		PedidoCompra pedido = pedidoRep.getOne(recebimentoForm.getPedido().getIdPedido());

		pedido.setSituacaoPedido(StatusPedidoEnum.RECEBIDO);

		pedidoRep.save(pedido);

	}
	
	@Transactional
	public void estornar(Long id) {
		NotaFiscal nfe = notaFiscalRep.findByPedidoIdPedido(id);
		PedidoCompra pedido = nfe.getPedido();

		for (DescricaoNotaFiscal itemNfe : nfe.getItensNotaFiscal()) {
			Produto produto = itemNfe.getProduto();
			produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - itemNfe.getQuantidade().intValue());
			
			produtoRep.save(produto);
		}

		pedido.setSituacaoPedido(StatusPedidoEnum.EM_DIGITACAO);
		notaFiscalRep.delete(nfe);
	}
	
	
}
