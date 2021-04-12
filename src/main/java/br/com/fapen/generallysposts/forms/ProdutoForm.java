package br.com.fapen.generallysposts.forms;

import java.util.ArrayList;
import java.util.List;

import br.com.fapen.generallysposts.models.Fornecedor;
import br.com.fapen.generallysposts.models.Produto;

public class ProdutoForm {

	private Produto produto;
	private List<Fornecedor> listaFornecedores = new ArrayList<>();
	private Fornecedor fornecedorSelecionado;
	

	public ProdutoForm() {
	}


	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Fornecedor> getListaFornecedores() {
		return listaFornecedores;
	}

	public void setListaFornecedores(List<Fornecedor> listaFornecedores) {
		this.listaFornecedores = listaFornecedores;
	}

	public Fornecedor getFornecedorSelecionado() {
		return fornecedorSelecionado;
	}

	public void setFornecedorSelecionado(Fornecedor fornecedorSelecionado) {
		this.fornecedorSelecionado = fornecedorSelecionado;
	}
	
}
