package com.apiedu.apiedu.login.utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
}
