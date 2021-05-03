package br.com.fapen.generallysposts.models;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "tb_carrinho_compra")
public class CarrinhoCompra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_carrinho")
	private Long idCarrinho;
	
	@Column(name = "id_usuario")
	private Long idUsuario;

	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "id_produto")
	private Produto produto;

	@Column(name = "quantidade_carrinho")
	private Long quantidadeCarrinho;

	public Long getIdCarrinho() {
		return idCarrinho;
	}

	public void setIdCarrinho(Long idCarrinho) {
		this.idCarrinho = idCarrinho;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Long getQuantidadeCarrinho() {
		return quantidadeCarrinho;
	}

	public void setQuantidadeCarrinho(Long quantidadeCarrinho) {
		this.quantidadeCarrinho = quantidadeCarrinho;
	}

}
