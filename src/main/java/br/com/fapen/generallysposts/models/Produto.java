package br.com.fapen.generallysposts.models;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity(name = "tb_produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_produto")
	private Long idProduto;
	
	private BigDecimal custoUnitario;
	private BigDecimal precoVenda;
	private Double saldoAtual;
	

	@Column(length = 255)
	private String descricao;
	
	@Column
	private String categoria;
	
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "data_validade")
	private LocalDate validade;

	@Column(name = "quantidade_estoque")
	private int quantidadeEstoque;
	
	@Column(name = "caminho_foto")
	private String caminhoFoto;
	
	private String fotoEmString;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_fornecedor")
	private Fornecedor fornecedor;
	
	@Column(columnDefinition = "boolean default false")
	private boolean inativo;


	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}


	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public boolean isInativo() {
		return inativo;
	}

	public void setInativo(boolean inativo) {
		this.inativo = inativo;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public String getCaminhoFoto() {
		return caminhoFoto;
	}

	public void setCaminhoFoto(String caminhoFoto) {
		this.caminhoFoto = caminhoFoto;
	}

	public String getFotoEmString() {
		return fotoEmString;
	}

	public void setFotoEmString(String fotoEmString) {
		this.fotoEmString = fotoEmString;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	

	public LocalDate getValidade() {
		return validade;
	}

	public void setValidade(LocalDate validade) {
		this.validade = validade;
	}

	public BigDecimal getCustoUnitario() {
		return custoUnitario;
	}

	public void setCustoUnitario(BigDecimal custoUnitario) {
		this.custoUnitario = custoUnitario;
	}

	public BigDecimal getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(BigDecimal precoVenda) {
		this.precoVenda = precoVenda;
	}

	public Double getSaldoAtual() {
		return saldoAtual;
	}

	public void setSaldoAtual(Double saldoAtual) {
		this.saldoAtual = saldoAtual;
	}
	
	

	@Override
	public String toString() {
		return "Produto [idProduto=" + idProduto + ", descricao=" + descricao + ", quantidadeEstoque=" + quantidadeEstoque
				+ ", caminhoFoto=" + caminhoFoto + ", fotoEmString=" + fotoEmString + ", fornecedor=" + fornecedor
				+ ", inativo=" + inativo + ", getIdProduto()=" + getIdProduto() + ", getDescricao()=" + getDescricao()
				+ ", getQuantidadeEstoque()=" + getQuantidadeEstoque() + ", isInativo()=" + isInativo()
				+ ", getFornecedor()=" + getFornecedor() + ", getCaminhoFoto()=" + getCaminhoFoto()
				+ ", getFotoEmString()=" + getFotoEmString() 
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
	
}
