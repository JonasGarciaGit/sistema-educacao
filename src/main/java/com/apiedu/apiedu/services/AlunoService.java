package com.apiedu.apiedu.services;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;

import com.apiedu.apiedu.domain.Aluno;
import com.apiedu.apiedu.repositories.AlunoRepository;

import net.bytebuddy.build.Plugin.Engine.Source.Empty;


@Service
public class AlunoService {

	@Autowired
	private AlunoRepository repo;

	public JSONObject inserir(@RequestBody Aluno aluno) throws JSONException {
		JSONObject responseJson = new JSONObject();
		try {
			if (StringUtils.isEmpty(aluno.getNome()) || StringUtils.isEmpty(aluno.getEmail()) || StringUtils.isEmpty(aluno.getEndereco())
					|| StringUtils.isEmpty(aluno.getTelefone())|| aluno.getIdade() == 0) {
				responseJson.put("code", "422");
				responseJson.put("description", "Unprocessable Entity");
				return responseJson;
			} else {
				repo.save(aluno);
				responseJson.put("code", "200");
				responseJson.put("description", "OK");
				responseJson.put("nome", aluno.getNome());
				responseJson.put("email", aluno.getEmail());
				responseJson.put("endereco", aluno.getEndereco());
				responseJson.put("telefone", aluno.getTelefone());
				responseJson.put("idade", aluno.getIdade());
				return responseJson;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			responseJson.put("code", "1000");
			responseJson.put("description", "Internal server error - Time Out");
			return responseJson;
		}

	}

	public JSONObject deletarPeloId(Integer id) throws JSONException {
		JSONObject responseJson = new JSONObject();
		try {
			if(repo.findById(id).isEmpty()) {
				responseJson.put("code", "404");
				responseJson.put("description", "NOT_FOUND");
				responseJson.put("erro","id inválido");
				return responseJson;
			}
			else {
				repo.deleteById(id);
				responseJson.put("code", "200");
				responseJson.put("description", "OK");
				responseJson.put("msg","Usuário deletado...");
				return responseJson;
			}
			
		}catch(Exception e) {
			responseJson.put("code", "1000");
			responseJson.put("description", "Internal Server Error - Time Out");
			System.out.println(e.getMessage());
			return responseJson;
		}
	}

	public JSONObject atualizar(Aluno aluno) throws JSONException {
		JSONObject responseJson = new JSONObject();
		try {
			if (aluno.getId() == null || StringUtils.isEmpty(aluno.getNome()) || StringUtils.isEmpty(aluno.getEmail()) || StringUtils.isEmpty(aluno.getEndereco())
					|| StringUtils.isEmpty(aluno.getTelefone()) || aluno.getIdade() == null) {
				responseJson.put("code", "422");
				responseJson.put("description", "Unprocessable Entity");
				return responseJson;
			} else {
				repo.save(aluno);
				responseJson.put("code", "200");
				responseJson.put("description", "OK");
				responseJson.put("id", aluno.getId());
				responseJson.put("nome", aluno.getNome());
				responseJson.put("email", aluno.getEmail());
				responseJson.put("endereco", aluno.getEndereco());
				responseJson.put("telefone", aluno.getTelefone());
				responseJson.put("idade", aluno.getIdade());
				return responseJson;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			responseJson.put("code", "1000");
			responseJson.put("description", "Internal server error - Time Out");
			return responseJson;
		}
	}

	public JSONObject buscarAlunos() {
		JSONArray resultJson = new JSONArray();
		JSONObject responseJson = new JSONObject();
		try {
			List<Aluno> alunos = repo.buscarAlunos();
			for (Aluno aluno : alunos) {
				resultJson.put(new JSONObject(aluno));
			}
			responseJson.put("Alunos", resultJson);

		} catch (Exception e) {
			e.getMessage();
		}
		return responseJson;
	}
}
