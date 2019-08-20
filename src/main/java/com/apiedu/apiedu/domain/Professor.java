package com.apiedu.apiedu.domain;

import java.util.ArrayList;
import java.util.List;

public class Professor {

	private Integer id;
	private String nome;
	private String email;
	private String telefone;
	private String endereco;
	
	List<Atividade> atv = new ArrayList<Atividade>();
	private Curso curso;
	
	public Professor() {
	}

	public Professor(Integer id, String nome, String email, String telefone, String endereco) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Professor [id=" + id + ", nome=" + nome + ", email=" + email + ", telefone=" + telefone + ", endereco="
				+ endereco + ", at=" + atv + "]";
	}
	
}
