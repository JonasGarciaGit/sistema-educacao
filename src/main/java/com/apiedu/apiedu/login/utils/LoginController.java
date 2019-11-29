package com.apiedu.apiedu.login.utils;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@Api(value = "API REST SISTEMA-EDU")
@CrossOrigin("*")
@RestController
@RequestMapping(value = "/sistema-edu")
public class LoginController {

	@Autowired
	LoginService service;
	
	@PostMapping(value = "/login")
	public @ResponseBody void guardaId(@RequestBody LoginModel loginModel){
		try {
			service.guardaLogin(loginModel);
		}catch(Exception e) {
		 System.out.println(e.getMessage());
		}
	}
	
	@GetMapping(value = "/login")
	public @ResponseBody List<LoginModel> pegaId(){
		List<LoginModel> lista = service.pegaId();
		return lista;
	}
	
	@PostMapping(value = "/validarLogin" , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseEntity<String> validarLogin(@RequestBody LoginModel login) throws JSONException{
		JSONObject responseJson = new JSONObject();
		try {
			System.out.println(login);
			responseJson = service.validarLogin(login);
			
			responseJson.put("code", "200");
			responseJson.put("description", "OK");
			return new ResponseEntity<String>(responseJson.toString(), HttpStatus.OK);
		}catch(Exception e) {
			System.out.println("ERRO.: " + e.getMessage());
			responseJson.put("code", "1000");
			responseJson.put("description", "Internal server error - Time Out");
			return new ResponseEntity<String>(responseJson.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
}
