package com.apiedu.apiedu.services;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.apiedu.apiedu.domain.Atividade;
import com.apiedu.apiedu.domain.Curso;
import com.apiedu.apiedu.repositories.AtividadeRepository;

@Service
public class AtividadeService {
	
	@Autowired
	private AtividadeRepository repo;
	
	Curso curso = new Curso();
	
	public JSONObject buscarAtividades(){
		JSONObject responseJson = new JSONObject();
		List<Atividade> atividades = new ArrayList<Atividade>();
		JSONObject temporaryAtv = new JSONObject();
		JSONArray atvArrayJson = new JSONArray();
		
		try {
			atividades = repo.buscarAtividades();
			for(Atividade atv: atividades) {
				
				temporaryAtv.put("id", atv.getId());
				temporaryAtv.put("descricao", atv.getDescricao());		
				temporaryAtv.put("nome", atv.getNome());
				temporaryAtv.put("cursoId", atv.getCurso().getId());
				temporaryAtv.put("caminho", atv.getCaminho());
				temporaryAtv.put("prazoFinal", atv.getprazoFinal());
				temporaryAtv.put("uploadNome", atv.getUploadNome());
				atvArrayJson.put(temporaryAtv);
				temporaryAtv = new JSONObject();
			}
			
			responseJson.put("atividades", atvArrayJson);
			return responseJson;
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	return responseJson;
	}
	
	public JSONObject findAll(){
		JSONObject responseJson = new JSONObject();
		List<Atividade> atividades = new ArrayList<Atividade>();
		JSONObject temporaryAtv = new JSONObject();
		JSONArray atvArrayJson = new JSONArray();
		
		try {
			atividades = repo.findAll();
			for(Atividade atv: atividades) {
				
				temporaryAtv.put("id", atv.getId());
				temporaryAtv.put("descricao", atv.getDescricao());		
				temporaryAtv.put("nome", atv.getNome());
				temporaryAtv.put("cursoId", atv.getCurso().getId());
				temporaryAtv.put("caminho", atv.getCaminho());
				temporaryAtv.put("prazoFinal", atv.getprazoFinal());
				temporaryAtv.put("uploadNome", atv.getUploadNome());
				atvArrayJson.put(temporaryAtv);
				temporaryAtv = new JSONObject();
			}
			
			responseJson.put("atividades", atvArrayJson);
			return responseJson;
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	return responseJson;
	}
	
	public JSONObject inserirAtividade(Atividade atv) throws JSONException {
		JSONObject response = new JSONObject(); 
	try {
		if(StringUtils.isEmpty(atv.getNome()) || StringUtils.isEmpty(atv.getDescricao())) {
			response.put("code", "422");
			response.put("description", HttpStatus.UNPROCESSABLE_ENTITY);
		}else {	
			curso = repo.buscarCurso(atv.getCursoId());
			atv.setCurso(curso);
			repo.save(atv);
			response.put("nome", atv.getNome());
			response.put("descricao", atv.getDescricao());
			response.put("data", atv.getprazoFinal().toString());
			response.put("caminho", atv.getCaminho());
			response.put("uploadNome", atv.getUploadNome());
			response.put("Curso", atv.getCurso().getId());
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
			response.put("uploadNome", atv.getUploadNome());
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
