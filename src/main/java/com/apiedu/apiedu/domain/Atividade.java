package com.apiedu.apiedu.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Atividade implements Serializable{
	private static final long serialVersionUID = -5587071203355421158L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	private String nome;
	private String descricao;
	private Date prazoFinal;
	private String caminho;
	
	@ManyToOne
	@JoinColumn(name = "curso_id")
	private Curso curso;
	
	
	@ManyToOne
	@JoinColumn(name = "professor_id")
	private Professor professor;
	
	public Atividade() {
	}

	
	public Atividade(Integer id, String nome, String descricao, Date prazoFinal, String caminho, Curso curso,
			Professor professor) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.prazoFinal = prazoFinal;
		this.caminho = caminho;
		this.curso = curso;
		this.professor = professor;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getprazoFinal() {
		return prazoFinal;
	}

	public void setprazoFinal(Date prazoFinal) {
		this.prazoFinal = prazoFinal;
	}


	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	

	@Override
	public String toString() {
		return "Atividade [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", prazoFinal=" + prazoFinal
				+ ", caminho=" + caminho + ", curso=" + curso + ", professor=" + professor + "]";
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}
	
	
}
