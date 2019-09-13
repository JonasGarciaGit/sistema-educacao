package com.apiedu.apiedu.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.apiedu.apiedu.domain.Atividade;
import com.apiedu.apiedu.repositories.AtividadeRepository;

@Service
public class AtividadeService {
	
	@Autowired
	private AtividadeRepository repo;
	
	public List <Atividade> buscarAtividades(){
		return repo.findAll();
	}
	
	public Atividade inserirAtividade(@RequestBody Atividade atv) {
		return repo.save(atv);
	}
	
	public Atividade atualizarAtividade(@RequestBody Atividade atv) {			
			return repo.save(atv);
	}
	
	public void deletarAtividade(@PathVariable Integer id) {
		repo.deleteById(id);
	}
	
}
