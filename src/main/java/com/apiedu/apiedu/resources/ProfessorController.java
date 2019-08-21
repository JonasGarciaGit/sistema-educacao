package com.apiedu.apiedu.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apiedu.apiedu.domain.Professor;
import com.apiedu.apiedu.services.ProfessorService;

@RestController
@RequestMapping(value = "/sistema-edu")
public class ProfessorController {

	@Autowired
	ProfessorService professorService;
	
	@GetMapping(value = "/professor")
	public List<Professor> buscarProfessor(){
		return professorService.buscarProfessores();
	}
	
	@PostMapping(value = "/professor")
	public Professor inserirProfessor(@RequestBody Professor professor) {
		return professorService.inserirProfessor(professor);
	}
	
	@PutMapping(value = "/professor")
	public Professor atualizar(@RequestBody Professor professor) {
		return professorService.atualizarProfessor(professor);
	}
	
	@DeleteMapping(value = "/professor")
	public void deletarProfessor(@RequestBody Professor professor) {
		professorService.deletarProfessor(professor);
	}
	
}
