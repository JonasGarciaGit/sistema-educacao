package com.apiedu.apiedu.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Aluno implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
		
	private String nome;
	private Integer idade;
	private String email;
	private String telefone;
	private String endereco;
	
	@ManyToOne
	@JoinColumn(name = "curso_id")
	private Curso curso;
	
	@ManyToMany 
	@JoinTable(name = "ALUNO_ATIVIDADES",
	joinColumns = @JoinColumn(name = "aluno_id"),
	inverseJoinColumns = @JoinColumn(name= "atividade_id"))
	private List<Atividade> atividades = new ArrayList<>();
	
	
	public Aluno() {
		
	}


	public Aluno(String nome, String email, Integer idade, Integer id, String telefone, String endereco, Curso curso) {
		super();
		this.nome = nome;
		this.email = email;
		this.idade = idade;
		this.id = id;
		this.telefone = telefone;
		this.endereco = endereco;
		this.curso = curso;
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


	public Integer getIdade() {
		return idade;
	}


	public void setIdade(Integer idade) {
		this.idade = idade;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
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


	public Curso getCurso() {
		return curso;
	}


	public void setCurso(Curso curso) {
		this.curso = curso;
	}


	public List<Atividade> getAtividades() {
		return atividades;
	}


	public void setAtividades(List<Atividade> atividades) {
		this.atividades = atividades;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
