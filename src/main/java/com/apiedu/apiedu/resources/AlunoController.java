package com.apiedu.apiedu.resources;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.apiedu.apiedu.domain.Aluno;
import com.apiedu.apiedu.services.AlunoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "API REST SISTEMA-EDU")
@CrossOrigin("*")
@RestController
@RequestMapping(value = "/sistema-edu")
public class AlunoController {

	@Autowired
	public AlunoService service;

	@ApiOperation(value = "Lista todos os alunos do banco.")
	@GetMapping(value = "/aluno" , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> buscarAluno() throws JSONException {
		JSONObject responseJson = new JSONObject();
		try {
			responseJson = service.buscarAlunos();
			responseJson.put("code","200");
			responseJson.put("description","OK");
			return new ResponseEntity<String>(responseJson.toString(), HttpStatus.OK);	
		}catch(Exception e) {
			System.out.println(e.getMessage());
			responseJson.put("code","1000");
			responseJson.put("description","Internal Server error = Time Out");
			return new ResponseEntity<String>(responseJson.toString(), HttpStatus.INTERNAL_SERVER_ERROR);	
		}
		
	}

	@ApiOperation(value = "Insere um novo aluno no banco.")
	@PostMapping(value = "/aluno", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseEntity<String> inserirAluno(@RequestBody Aluno aluno) throws JSONException {
		JSONObject responseJson = new JSONObject();
		try {
			responseJson = service.inserir(aluno);
			return new ResponseEntity<String>(responseJson.toString(), HttpStatus.OK);

		}catch(Exception e) {
			System.out.println(e.getMessage());
			responseJson.put("code", "1000");
			responseJson.put("description", "Internal Server Error - Time Out");
			return new ResponseEntity<String>(responseJson.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation(value = "Deleta um aluno do banco de dados.")
	@DeleteMapping(value = "/aluno/{id}")
	public @ResponseBody ResponseEntity<String> deletarAluno(@PathVariable Integer id) throws JSONException {
		JSONObject responseJson = new JSONObject();
		try {
			responseJson = service.deletarPeloId(id);
			return new ResponseEntity<String>(responseJson.toString(), HttpStatus.OK);
		}catch(Exception e) {
			responseJson.put("code", "1000");
			responseJson.put("description", "Internal Server Error - Time Out");
			System.out.println(e.getMessage());
			return new ResponseEntity<String>(responseJson.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation(value = "Atualiza um aluno ja existente.")
	@PutMapping(value = "/aluno" , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseEntity<String> atualizarAluno(@RequestBody Aluno aluno) throws JSONException {
		JSONObject responseJson = new JSONObject();
		try {
			responseJson = service.atualizar(aluno);
			return new ResponseEntity<String>(responseJson.toString(), HttpStatus.OK);

		}catch(Exception e) {
			System.out.println(e.getMessage());
			responseJson.put("code", "1000");
			responseJson.put("description", "Internal Server Error - Time Out");
			return new ResponseEntity<String>(responseJson.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
