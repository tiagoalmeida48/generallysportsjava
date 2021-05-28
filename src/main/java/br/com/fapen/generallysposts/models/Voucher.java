package br.com.fapen.generallysposts.models;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity(name = "tb_voucher")
public class Voucher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_voucher")
	private Long idVoucher;
	
	private BigDecimal custoUnitario;
	private BigDecimal precoVenda;
	private Double saldoAtual;
	
	@Column(name = "voucher")
	private String nomeVoucher;
	
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "data_validade")
	private LocalDate validade;
	
	@Column(name = "caminho_foto")
	private String caminhoFoto;
	
	private String fotoEmString;

	public Long getIdVoucher() {
		return idVoucher;
	}

	public void setIdVoucher(Long idVoucher) {
		this.idVoucher = idVoucher;
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

	public String getNomeVoucher() {
		return nomeVoucher;
	}

	public void setNomeVoucher(String nomeVoucher) {
		this.nomeVoucher = nomeVoucher;
	}

	public LocalDate getValidade() {
		return validade;
	}

	public void setValidade(LocalDate validade) {
		this.validade = validade;
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
	
	
	
	
	
}
