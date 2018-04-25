package br.jafer.vagas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@SuppressWarnings("serial")
@Entity
public class Usuario extends GenericEntity {
	
	@Column(length=32, nullable=false)
	private String senha;
	
	@Transient
	private String senhaNCript;
	
	@Column(nullable=false)
	private Character tipo;
	
	@Column(nullable=false)
	private Boolean ativo;
	
	@Column(nullable=false)
	private String userName;
	

	private String email;
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Character getTipo() {
		return tipo;
	}

	public void setTipo(Character tipo) {
		this.tipo = tipo;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	
	public String getSenhaNCript() {
		return senhaNCript;
	}
	
	public void setSenhaNCript(String senhaNCript) {
		this.senhaNCript = senhaNCript;
	}
	

}
