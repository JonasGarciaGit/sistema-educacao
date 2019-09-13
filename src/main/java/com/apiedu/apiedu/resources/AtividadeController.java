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

import com.apiedu.apiedu.domain.Atividade;
import com.apiedu.apiedu.services.AtividadeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "API REST SISTEMA-EDU")
@CrossOrigin("*")
@RestController
@RequestMapping(value = "/sistema-edu")
public class AtividadeController {

	@Autowired
	private AtividadeService service;

	@ApiOperation(value = "Lista todas as atividades do banco.")
	@GetMapping(value = "/atividade")
	public List<Atividade> buscarAtividade() {
		return service.buscarAtividades();
	}

	@ApiOperation(value = "Insere uma nova atividade.")
	@PostMapping(value = "/atividade")
	public Atividade inserirAtividade(@RequestBody Atividade atividade) {
			System.out.println(atividade);
			return service.inserirAtividade(atividade);
	}

	@ApiOperation(value = "Atualiza uma atividade.")
	@PutMapping(value = "/atividade")
	public Atividade atualizarAtividade(@RequestBody Atividade atividade) {
		return service.atualizarAtividade(atividade);
	}

	@ApiOperation(value = "Deleta uma atividade.")
	@DeleteMapping(value = "/atividade/{id}")
	public void deletar(@PathVariable Integer id) {
		service.deletarAtividade(id);
	}
}
