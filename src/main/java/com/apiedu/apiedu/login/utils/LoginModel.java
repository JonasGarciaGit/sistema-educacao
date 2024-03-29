package com.apiedu.apiedu.login.utils;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LoginModel implements Serializable {
	private static final long serialVersionUID = -8276580439429949233L;
	
	@Id
	private Integer id;
	private String login;
	private String senha;
	
	public LoginModel() {
	}

	public LoginModel(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "LoginModel [id=" + id + ", login=" + login + ", senha=" + senha + "]";
	}

	
	
}
