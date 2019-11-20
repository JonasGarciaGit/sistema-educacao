package com.apiedu.apiedu.login.utils;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
}
