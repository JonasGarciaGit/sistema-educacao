package com.apiedu.apiedu.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apiedu.apiedu.domain.Professor;
import com.apiedu.apiedu.services.ProfessorService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "API REST SISTEMA-EDU")
@CrossOrigin("*")
@RestController
@RequestMapping(value = "/sistema-edu")
public class ProfessorController {

	@Autowired
	ProfessorService professorService;
	
	@ApiOperation(value = "Lista todos os professores do banco.")
	@GetMapping(value = "/professor")
	public List<Professor> buscarProfessor(){
		return professorService.buscarProfessores();
	}
	
	@ApiOperation(value = "Insere um novo professor no banco.")
	@PostMapping(value = "/professor")
	public Professor inserirProfessor(@RequestBody Professor professor) {
		return professorService.inserirProfessor(professor);
	}
	
	@ApiOperation(value = "Atualiza as informações de um professor.")
	@PutMapping(value = "/professor")
	public Professor atualizar(@RequestBody Professor professor) {
		return professorService.atualizarProfessor(professor);
	}
	
	@ApiOperation(value = "Deleta um professor do banco de dados.")
	@DeleteMapping(value = "/professor/{id}")
	public void deletarProfessor(@PathVariable Integer id) {
		professorService.deletarProfessor(id);
	}
	
}
