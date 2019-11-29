package com.apiedu.apiedu.login.utils;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiedu.apiedu.domain.Aluno;

@Service
public class LoginService {

	@Autowired
	LoginRepository loginRepo;
	
	public void guardaLogin(LoginModel loginModel) throws JSONException {
		List<LoginModel> testeLogin = loginRepo.findAll();
		try {
			if(testeLogin == null) {
				loginRepo.save(loginModel);
			}else {
				for(LoginModel id : testeLogin) {
					loginRepo.deleteById(id.getId());
				}
				loginRepo.save(loginModel);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public List<LoginModel> pegaId(){
		List<LoginModel> login = loginRepo.findAll();
		return login;
	}
	
	public JSONObject validarLogin(LoginModel login) throws JSONException {
		JSONObject responseJson = new JSONObject();
		try {
			if(loginRepo.validarLoginAluno(login.getLogin(), login.getSenha()) != null) {
				Aluno aluno = loginRepo.buscarIdAluno(login.getLogin(), login.getSenha());				
				responseJson.put("user", "A");	
				responseJson.put("cursoId", aluno.getCurso().getId());	
				return responseJson;
			}
			else if(loginRepo.validarLoginProfessor(login.getLogin(), login.getSenha()) != null) {
				responseJson.put("user", "P");
				return responseJson;
			}else {
				responseJson.put("user", "invalid user");
				return responseJson;
			}
			
		}catch(Exception e) {
			System.out.println("Error.:" + e.getMessage());
			responseJson.put("code", "1000");
			responseJson.put("description", "Service Internal server error - Time Out");
			return responseJson;
		}
	}
	
}
