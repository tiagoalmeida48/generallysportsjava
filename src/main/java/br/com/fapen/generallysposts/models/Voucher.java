package br.com.fapen.generallysposts.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "tb_voucher")
public class Voucher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_voucher")
	private Long idVoucher;
	
	private BigDecimal precoVenda;
	
	@Column(name = "voucher")
	private String titulo;
	
	@Column(name = "caminho_foto")
	private String caminhoFoto;
	
	private String fotoEmString;
	
	@Column(columnDefinition = "boolean default false")
	private boolean inativo;

	public Long getIdVoucher() {
		return idVoucher;
	}

	public void setIdVoucher(Long idVoucher) {
		this.idVoucher = idVoucher;
	}

	public BigDecimal getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(BigDecimal precoVenda) {
		this.precoVenda = precoVenda;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
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

	public boolean isInativo() {
		return inativo;
	}

	public void setInativo(boolean inativo) {
		this.inativo = inativo;
	}
	
	@Override
	public String toString() {
		return "Voucher [idVoucher=" + idVoucher 
			+ ", titulo=" + titulo 
			+ ", caminhoFoto=" + caminhoFoto 
			+ ", fotoEmString=" + fotoEmString 
			+ ", inativo=" + inativo 
			+ ", getIdVoucher()=" + getIdVoucher() 
			+ ", titulo()=" + getTitulo() 
			+ ", isInativo()=" + isInativo()
			+ ", getCaminhoFoto()=" + getCaminhoFoto()
			+ ", getFotoEmString()=" + getFotoEmString() 
			+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
			+ ", toString()=" + super.toString() + "]";
	}
}
