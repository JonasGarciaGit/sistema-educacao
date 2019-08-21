package com.apiedu.apiedu.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apiedu.apiedu.domain.Aluno;
import com.apiedu.apiedu.services.AlunoService;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoController {

	@Autowired
	public AlunoService service;
	
	
	@GetMapping(value = "/buscar")
	public List<Aluno> find() {
		return service.buscar();
	}
	
	@PostMapping(value = "/inserir")
	public void inserirAluno(Aluno aluno) {		
		service.inserir(aluno);
	}
	
	@DeleteMapping(value = "/deletar/{id}")
	public void deletarAluno(@PathVariable Integer id) {
		service.deletarPeloId(id);
	}
	
	@PutMapping(value = "/atualizar")
	public void atualizarAluno(Aluno aluno) {
		service.atualizar(aluno);
	}
}
