package com.apiedu.apiedu.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.apiedu.apiedu.domain.Professor;
import com.apiedu.apiedu.repositories.ProfessorRepository;

@Service
public class ProfessorService {

	@Autowired
	private ProfessorRepository repoProfessor;
	
	public List <Professor> buscarProfessores(){
		return repoProfessor.findAll();
	}
	
	public Professor inserirProfessor(@RequestBody Professor professor) {
		return repoProfessor.save(professor);
	}
	
	public Professor atualizarProfessor(@RequestBody Professor professor) {			
			return repoProfessor.save(professor);
	}
	
	public void deletarProfessor(Integer id) {
		repoProfessor.deleteById(id);
	}
}
