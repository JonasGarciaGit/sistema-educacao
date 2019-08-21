package com.apiedu.apiedu.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apiedu.apiedu.domain.Aluno;
import com.apiedu.apiedu.services.AlunoService;

@RestController
@RequestMapping(value = "/sistema-edu")
public class AlunoResource {

	@Autowired
	private AlunoService alunoService;
	
	@GetMapping(value = "/alunos")
	public List<Aluno> buscarAlunos(){
		return alunoService.buscarAlunos();
	}
}
