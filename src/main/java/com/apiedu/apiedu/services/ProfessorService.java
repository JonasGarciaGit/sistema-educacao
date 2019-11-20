package com.apiedu.apiedu.services;

import java.util.Calendar;
import java.util.List;
import java.util.Random;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.apiedu.apiedu.domain.Professor;
import com.apiedu.apiedu.repositories.ProfessorRepository;

@Service
public class ProfessorService {

	@Autowired
	private ProfessorRepository repoProfessor;

	Calendar data = Calendar.getInstance();
	Integer dateYear = data.get(Calendar.YEAR);
	
	
	public JSONObject buscarProfessores() throws JSONException {
		JSONObject professoresJson = new JSONObject();
		JSONArray professorArray = new JSONArray();
		JSONObject temporaryJson = new JSONObject();
		try {
			List<Professor> listProfessor = repoProfessor.findAllProfessor();
			for (Professor prof : listProfessor) {
			
				temporaryJson.put("id", prof.getId());
				temporaryJson.put("nome", prof.getNome());
				temporaryJson.put("email", prof.getEmail());
				temporaryJson.put("cpf", prof.getCpf());
				temporaryJson.put("telefone", prof.getTelefone());
				temporaryJson.put("endereco", prof.getEndereco());
				temporaryJson.put("login", prof.getLogin());
				temporaryJson.put("senha", prof.getSenha());
				professorArray.put(temporaryJson);
				temporaryJson = new JSONObject();
			}
			professoresJson.put("Professor", professorArray);
			professoresJson.put("code", "200");
			professoresJson.put("description", "OK");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			professoresJson.put("code", "1000");
			professoresJson.put("description", "TIME OUT - INTERNAL SERVER ERROR");
		}
		return professoresJson;
	}

	public JSONObject inserirProfessor(Professor professor) throws JSONException {
		JSONObject professorJson = new JSONObject();
		try {
			if (StringUtils.isEmpty(professor.getNome()) || StringUtils.isEmpty(professor.getEndereco())) {
				professorJson.put("code", "422");
				professorJson.put("description", "UNPROCESSABLE_ENTITY");
			} else {
				Integer senha = new Random().nextInt(5000);
				professor.setLogin(professor.getNome() + "@" + dateYear.toString());
				professor.setSenha(senha.toString());
				repoProfessor.save(professor);
				professorJson.put("id", professor.getId());
				professorJson.put("email", professor.getEmail());
				professorJson.put("endereco", professor.getEndereco());
				professorJson.put("cpf", professor.getCpf());
				professorJson.put("telefone", professor.getTelefone());
				professorJson.put("login", professor.getLogin());
				professorJson.put("senha", professor.getSenha());
				professorJson.put("code", "200");
				professorJson.put("description", "OK");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			professorJson.put("code", "1000");
			professorJson.put("description", "TIME OUT - INTERNAL SERVER ERROR");
		}
		return professorJson;
	}

	public JSONObject atualizarProfessor(Professor professor) throws JSONException {
		JSONObject professorJson = new JSONObject();
		try {
			if (professor.getId() == null) {
				professorJson.put("code", "422");
				professorJson.put("description", "UNPROCESSABLE_ENTITY");
			} else {
				Integer senha = new Random().nextInt(5000);
				professor.setLogin(professor.getNome() + "@" + dateYear.toString());
				professor.setSenha(senha.toString());
				repoProfessor.save(professor);
				professorJson.put("id", professor.getId());
				professorJson.put("email", professor.getEmail());
				professorJson.put("endereco", professor.getEndereco());
				professorJson.put("telefone", professor.getTelefone());
				professorJson.put("cpf", professor.getCpf());
				professorJson.put("login", professor.getLogin());
				professorJson.put("senha", professor.getSenha());
				professorJson.put("code", "200");
				professorJson.put("description", "OK");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			professorJson.put("code", "1000");
			professorJson.put("description", "TIME OUT - INTERNAL SERVER ERROR");

		}
		return professorJson;
	}

	public JSONObject deletarProfessor(Integer id) throws JSONException {
		JSONObject responseJson = new JSONObject();
		try {
			if (id == null) {
				responseJson.put("code", "422");
				responseJson.put("description", "UNPROCESSABLE_ENTITY");
			} else {
				repoProfessor.deleteById(id);
				responseJson.put("code", "200");
				responseJson.put("description", "OK");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			responseJson.put("code", "1000");
			responseJson.put("description", "TIME OUT - INTERNAL SERVER ERROR");

		}
		return responseJson;
	}
}
