package com.apiedu.apiedu.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Atividade {

	private Integer id;
	private String nome;
	private String descricao;
	private Date inicio;
	private Date termino;
	
	List<Aluno> aluno = new ArrayList<Aluno>();
	private Professor professor;
	
	public Atividade() {
	}

	public Atividade(Integer id, String nome, String descricao, Date inicio, Date termino, Professor professor) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.inicio = inicio;
		this.termino = termino;
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

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getTermino() {
		return termino;
	}

	public void setTermino(Date termino) {
		this.termino = termino;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	@Override
	public String toString() {
		return "Atividade [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", inicio=" + inicio
				+ ", termino=" + termino + ", professor=" + professor + "]";
	}
	
	
	
}
