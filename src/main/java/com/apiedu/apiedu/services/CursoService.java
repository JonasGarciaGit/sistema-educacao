package com.apiedu.apiedu.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiedu.apiedu.domain.Curso;
import com.apiedu.apiedu.repositories.CursoRepository;

@Service
public class CursoService {

	@Autowired
	private CursoRepository repo;
	
	public List<Curso> buscar() {
		return repo.findAll();
	}
	
	public void inserir(Curso curso) {
		repo.save(curso);
	}
	
	public void deletarPeloId(Integer id) {
		repo.deleteById(id);
	}
	
	public void atualizar(Curso curso) {
			repo.save(curso);
	}
}
