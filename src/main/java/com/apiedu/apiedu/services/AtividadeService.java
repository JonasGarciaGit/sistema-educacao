package com.apiedu.apiedu.services;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.apiedu.apiedu.domain.Atividade;
import com.apiedu.apiedu.repositories.AtividadeRepository;

@Service
public class AtividadeService {
	
	@Autowired
	private AtividadeRepository repo;
	
	public JSONObject buscarAtividades() throws JSONException{
		JSONObject responseObj = new JSONObject();
		JSONArray responseArr = new JSONArray();
	try {
		List<Atividade> atividadeList = repo.findAll();
		if(StringUtils.isEmpty(atividadeList)) {
			responseObj.put("code", "404");
			responseObj.put("description", "NOT_FOUND");
		}
		for(Atividade atv : atividadeList) {
			responseArr.put(new JSONObject(atv));
		}
		responseObj.put("Atividades", responseArr);
		responseObj.put("code", "200");
		responseObj.put("description", "OK");
	}catch(Exception e) {
		System.out.println("ERROR::" + e.getMessage());
		responseObj.put("code", "1000");
		responseObj.put("description", "INTERNAL SERVER ERROR");
	}
	return responseObj;
	}
	
	public JSONObject inserirAtividade(Atividade atv) throws JSONException {
		JSONObject response = new JSONObject(); 
	try {
		if(StringUtils.isEmpty(atv.getNome()) || StringUtils.isEmpty(atv.getDescricao())) {
			response.put("code", "422");
			response.put("description", HttpStatus.UNPROCESSABLE_ENTITY);
		}else {
			repo.save(atv);
			response.put("nome", atv.getNome());
			response.put("descricao", atv.getDescricao());
			response.put("data", atv.getprazoFinal());
			response.put("caminho", atv.getCaminho());
			response.put("Curso", atv.getCurso());
			response.put("Professor", atv.getProfessor());
		}
	}catch(Exception e) {
		System.out.println("ERROR::" + e.getMessage());
		response.put("code", "1000");
		response.put("description", "INTERNAL SERVER ERROR");
	}
		return response;
	}
	
	public JSONObject atualizarAtividade(Atividade atv) throws JSONException {			
		JSONObject response = new JSONObject(); 
	try {
		if(atv.getId() == null || StringUtils.isEmpty(atv.getNome()) || StringUtils.isEmpty(atv.getDescricao())) {
			response.put("code", "422");
			response.put("description", "UNPROCESSABLE_ENTITY");
		}else {
			repo.save(atv);
			response.put("nome", atv.getNome());
			response.put("descricao", atv.getDescricao());
			response.put("data", atv.getprazoFinal());
			response.put("caminho", atv.getCaminho());
			response.put("Curso", atv.getCurso());
			response.put("Professor", atv.getProfessor());
			response.put("code", "200");
			response.put("description", "OK");
		}
	}catch(Exception e) {
		System.out.println("ERROR::" + e.getMessage());

	}
		return response;
	}
	
	public JSONObject deletarAtividade(Integer id) throws JSONException {
		JSONObject response = new JSONObject();
		try {
			if(id == null) {
				response.put("code", "422");
				response.put("description", "UNPROCESSABLE_ENTITY");
			}else {
				repo.deleteById(id);
				response.put("code", "200");
				response.put("description", "OK");
			}
		}catch(Exception e) {
			System.out.println("ERROR" + e.getMessage());
			response.put("code", "1000");
			response.put("description", "INTERNAL SERVER ERROR");
		}
		return response;
	}
	
}
