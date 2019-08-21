package com.apiedu.apiedu.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apiedu.apiedu.domain.Curso;
import com.apiedu.apiedu.services.CursoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "API REST SISTEMA-EDU")
@CrossOrigin("*")
@RestController
@RequestMapping(value = "/sistema-edu")
public class CursoController {

	@Autowired
	public CursoService service;
	
	@ApiOperation(value = "Lista todos os cursos do banco.")
	@GetMapping(value = "/curso")
	public List<Curso> find() {
		return service.buscar();
	}
	
	@ApiOperation(value = "Insere novos cursos no banco.")
	@PostMapping(value = "/curso")
	public void inserirCurso(Curso curso) {		
		service.inserir(curso);
	}
	
	@ApiOperation(value = "Deleta um curso do banco.")
	@DeleteMapping(value = "/curso/{id}")
	public void deletarCurso(@PathVariable Integer id) {
		service.deletarPeloId(id);
	}
	
	@ApiOperation(value = "Atualiza um curso do banco.")
	@PutMapping(value = "/curso")
	public void atualizarCurso(Curso curso) {
		service.atualizar(curso);
	}
}
