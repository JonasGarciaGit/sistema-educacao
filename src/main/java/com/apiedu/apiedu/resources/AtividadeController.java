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

import com.apiedu.apiedu.domain.Atividade;
import com.apiedu.apiedu.services.AtividadeService;

@RestController
@RequestMapping(value = "/sistema-edu")
public class AtividadeController {

	@Autowired
	private AtividadeService service;
	
	@GetMapping(value = "/atividade")
	public List<Atividade> buscarAtividade() {
		return service.buscarAtividades();
	}
	
	@PostMapping(value = "/atividade")
	public Atividade inserirAtividade(@RequestBody Atividade atividade) {
		return service.inserirAtividade(atividade);
	}
	
	@PutMapping(value = "/atividade")
	public Atividade atualizarAtividade(@RequestBody Atividade atividade) {
		return service.atualizarAtividade(atividade);
	}
	
	@DeleteMapping(value = "/atividade")
	public void deletar(@RequestBody Atividade atividade) {
		service.deletarAtividade(atividade);
	}
}
