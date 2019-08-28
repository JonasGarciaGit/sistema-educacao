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

import com.apiedu.apiedu.domain.Aluno;
import com.apiedu.apiedu.services.AlunoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "API REST SISTEMA-EDU")
@CrossOrigin("*")
@RestController
@RequestMapping(value = "/sistema-edu")
public class AlunoController {

	@Autowired
	public AlunoService service;

	@ApiOperation(value = "Lista todos os alunos do banco.")
	@GetMapping(value = "/aluno")
	public List<Aluno> find() {
		return service.buscarAlunos();
	}

	@ApiOperation(value = "Insere um novo aluno no banco.")
	@PostMapping(value = "/aluno")
	public void inserirAluno(@RequestBody Aluno aluno) {
		if ((aluno.getNome().equals("")) || (aluno.getEmail().equals("")) || (aluno.getIdade() == null)
				|| (aluno.getEndereco().equals(""))) {
			System.out.println("Aluno não inserido por falta de dados");
		} else {
			service.inserir(aluno);
			System.out.println(aluno);
		}
	}

	@ApiOperation(value = "Deleta um aluno do banco de dados.")
	@DeleteMapping(value = "/aluno/{id}")
	public void deletarAluno(@PathVariable Integer id) {
		service.deletarPeloId(id);
	}

	@ApiOperation(value = "Atualiza um aluno ja existente.")
	@PutMapping(value = "/aluno")
	public void atualizarAluno(Aluno aluno) {
		service.atualizar(aluno);
	}
}
