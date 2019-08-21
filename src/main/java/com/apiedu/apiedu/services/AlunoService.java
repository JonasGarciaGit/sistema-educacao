package com.apiedu.apiedu.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiedu.apiedu.domain.Aluno;
import com.apiedu.apiedu.repositories.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository repo;

	
	public void inserir(Aluno aluno) {
		repo.save(aluno);
	}
	
	public void deletarPeloId(Integer id) {
		repo.deleteById(id);
	}
	
	public void atualizar(Aluno aluno) {
			repo.save(aluno);
	}

	public List<Aluno> buscarAlunos(){
		return repo.findAll();
	}
}
