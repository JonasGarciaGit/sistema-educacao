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
	
	public List<Aluno> buscarAlunos(){
		return repo.findAll();
	}
}
