package br.jafer.vagas.entity;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@SuppressWarnings("serial")
@Entity
public class Pessoa extends GenericEntity {

	private SimpleDateFormat format;

	// 1 PARA IDOSO - 2 PARA PNE

	@Column(columnDefinition = "smallint", nullable = false)
	private Integer tipo;

	@Column(nullable = false, name = "data_primeira_credencial")
	@Temporal(TemporalType.DATE)
	private Date dataPrimeiraCredencial;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_renovacao")
	private Date dataRenovacao;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false, name = "data_vencimento")
	private Date vencimento;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String cpf;

	@Column(nullable = false)
	private String rg;	

	@Temporal(TemporalType.DATE)
	@Column(name = "data_nasc", nullable = false)
	private Date nascimento;

	@Column(nullable = false)
	private String logradouro;

	@Column(nullable = false)
	private String bairro;

	@Column(nullable = false)
	private String cep;

	@Column(nullable = true)
	private String cidade;

	@Column(nullable = false)
	private String estado;

	private String telefone;

	private String celular;
	
	

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
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
		this.cpf = cpf;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Date getNascimento() {
		return nascimento;
	}
	
	@Transient
	public String getNascimentoFormat() {
		formatDate();
		return format.format(getNascimento());
	}
	
	@Transient
	private void formatDate() {
		format = new SimpleDateFormat("dd/MM/yyyy");
		format.setLenient(false);
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public String getDataPrimeiraCredencial() {
		formatDate();
		return format.format(dataPrimeiraCredencial);
	}

	public void setDataPrimeiraCredencial(Date dataPrimeiraCredencial) {
		this.dataPrimeiraCredencial=dataPrimeiraCredencial;
	}

	public String getDataRenovacao() {
		formatDate();
		if(dataRenovacao != null) {
			return format.format(dataRenovacao);			
		}else {
			return "-";
		}
	}

	public void setDataRenovacao(Date dataRenovacao) {
		this.dataRenovacao = dataRenovacao;
	}

	public String getVencimento() {
		formatDate();
		return format.format(vencimento);
	}

	public void setVencimento(Date vencimento) {
		this.vencimento = vencimento;

	}

}
