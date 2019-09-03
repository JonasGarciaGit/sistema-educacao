package com.apiedu.apiedu.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Atividade implements Serializable{
	private static final long serialVersionUID = 1L;
	
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

	public Atividade(Integer id, String nome, String descricao, Date prazoFinal, Professor professor) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.prazoFinal = prazoFinal;
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
	

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}

	@Override
	public String toString() {
		return "Atividade [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", prazoFinal=" + prazoFinal
				+ ", termino=" + ", professor=" + professor + "]";
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
		Atividade other = (Atividade) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	
}
