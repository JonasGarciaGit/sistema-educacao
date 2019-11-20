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

import com.apiedu.apiedu.domain.Professor;
import com.apiedu.apiedu.services.ProfessorService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "API REST SISTEMA-EDU")
@CrossOrigin("*")
@RestController
@RequestMapping(value = "/sistema-edu")
public class ProfessorController {

	@Autowired
	ProfessorService professorService;

	@ApiOperation(value = "Lista todos os professores do banco.")
	@GetMapping(value = "/professor",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseEntity<String> buscarProfessor() throws JSONException {
		JSONObject buscaProfessores = new JSONObject();
		try {
			buscaProfessores = professorService.buscarProfessores();
		}catch(Exception e) {
			System.out.println(e.getMessage());
			buscaProfessores.put("code","1000");
			buscaProfessores.put("description", "TIME OUT - INTERNAL SERVER ERROR");
			return new ResponseEntity<String>(buscaProfessores.toString(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<String>(buscaProfessores.toString(),HttpStatus.OK);
	}

	@ApiOperation(value = "Insere um novo professor no banco.")
	@PostMapping(value = "/professor",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseEntity<String> inserirProfessor(@RequestBody Professor professor) throws JSONException {
		JSONObject salvaProfessorJson = new JSONObject();
		try {
			salvaProfessorJson = professorService.inserirProfessor(professor);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			salvaProfessorJson.put("code", "1000");
			salvaProfessorJson.put("description", "TIME OUT - INTERNAL SERVER ERROR");
			return new ResponseEntity<String>(salvaProfessorJson.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<String>(salvaProfessorJson.toString(), HttpStatus.OK);
	}

	@ApiOperation(value = "Atualiza as informações de um professor.")
	@PutMapping(value = "/professor",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseEntity<String> atualizarProfessor(@RequestBody Professor professor) throws JSONException {
		JSONObject atualizaProfessorJson = new JSONObject();
		try {
			atualizaProfessorJson = professorService.atualizarProfessor(professor);
			return new ResponseEntity<String>(atualizaProfessorJson.toString(), HttpStatus.OK);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			atualizaProfessorJson.put("code", "1000");
			atualizaProfessorJson.put("description", "TIME OUT - INTERNAL SERVER ERROR");
		}
		return new ResponseEntity<String>(atualizaProfessorJson.toString(), HttpStatus.OK);

	}

	@ApiOperation(value = "Deleta um professor do banco de dados.")
	@DeleteMapping(value = "/professor/{id}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseEntity<String> deletarProfessor(@PathVariable Integer id) throws JSONException {
		JSONObject deletaProfessorJson = new JSONObject();
		try {
			deletaProfessorJson = professorService.deletarProfessor(id);
			return new ResponseEntity<String>(deletaProfessorJson.toString(), HttpStatus.OK);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			deletaProfessorJson.put("code", "1000");
			deletaProfessorJson.put("description", "TIME OUT - INTERNAL SERVER ERROR");
		}
		return new ResponseEntity<String>(deletaProfessorJson.toString(), HttpStatus.OK);
	}

}
