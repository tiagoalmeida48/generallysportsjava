package br.com.fapen.generallysposts.models;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity(name = "tb_pessoa")
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pessoa")
	private Long idPessoa;

	@Column(length = 100, nullable = false)
	private String nome;

	@Column(length = 11, nullable = false)
	private String cpf;

	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "dt_nascimento", nullable = false)
	private LocalDate dtNascimento;

	@Column(length = 1, nullable = false)
	private String sexo;

	@Column(length = 11)
	private String celular;

	@Column(length = 10)
	private String telefone;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_endereco")
	private Endereco endereco;

	public Long getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Long idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf.replaceAll("[^0-9]", "");
	}

	public LocalDate getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(LocalDate dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular.replaceAll("[^0-9]", "");
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone.replaceAll("[^0-9]", "");
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "{" + " idPessoa='" + getIdPessoa() + "'" + ", nome='" + getNome() + "'" + ", cpf='" + getCpf() + "'"
				+ ", dtNascimento='" + getDtNascimento() + "'" + ", sexo='" + getSexo() + "'" + ", celular='" + getCelular()
				+ "'" + ", telefone='" + getTelefone() + "'" + ", endereco='" + getEndereco() + "'" + "}";
	}

}
