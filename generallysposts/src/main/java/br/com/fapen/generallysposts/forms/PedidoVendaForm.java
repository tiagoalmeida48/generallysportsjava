package br.com.fapen.generallysposts.forms;

import java.util.ArrayList;
import java.util.List;

import br.com.fapen.generallysposts.models.ItensPedidoVenda;
import br.com.fapen.generallysposts.models.PedidoVenda;

public class PedidoVendaForm {

	private PedidoVenda pedidoVenda;
	private List<ItensPedidoVenda> itensPedidoVenda = new ArrayList<ItensPedidoVenda>();
	
	public PedidoVendaForm() {
		
	}
	
	public PedidoVendaForm(PedidoVenda pedido) {
		this.pedidoVenda = pedido;
		this.itensPedidoVenda = pedido.getItens();
	}

	public PedidoVenda getPedidoVenda() {
		return pedidoVenda;
	}

	public void setPedidoVenda(PedidoVenda pedidoVenda) {
		this.pedidoVenda = pedidoVenda;
	}

	public List<ItensPedidoVenda> getItensPedidoVenda() {
		return itensPedidoVenda;
	}

	public void setItensPedidoVenda(List<ItensPedidoVenda> itensPedidoVenda) {
		this.itensPedidoVenda = itensPedidoVenda;
	}
	
	
}
