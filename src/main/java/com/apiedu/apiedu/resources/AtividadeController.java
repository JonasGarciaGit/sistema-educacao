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

import com.apiedu.apiedu.domain.Atividade;
import com.apiedu.apiedu.services.AtividadeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "API REST SISTEMA-EDU")
@CrossOrigin("*")
@RestController
@RequestMapping(value = "/sistema-edu")
public class AtividadeController {

	@Autowired
	private AtividadeService service;

	@ApiOperation(value = "Lista todas as atividades do banco.")
	@GetMapping(value = "/atividade", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseEntity<String> buscarAtividade() throws JSONException {
		JSONObject buscaProfessores = new JSONObject();
		try {
			buscaProfessores = service.buscarAtividades();
			return new ResponseEntity<String>(buscaProfessores.toString(),HttpStatus.OK);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			buscaProfessores.put("code","1000");
			buscaProfessores.put("description", "TIME OUT - INTERNAL SERVER ERROR");
		}
		return new ResponseEntity<String>(buscaProfessores.toString(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ApiOperation(value = "Insere uma nova atividade.")
	@PostMapping(value = "/atividade", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseEntity<String> inserirAtividade(@RequestBody Atividade atividade)
			throws JSONException {
		JSONObject response = new JSONObject();
		try {
			response = service.inserirAtividade(atividade);
		} catch (Exception e) {
			System.out.println("ERROR::" + e.getMessage());
			response.put("code", "1000");
			response.put("description", "INTERNAL SERVER ERROR - TIME OUT");
			return new ResponseEntity<String>(response.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<String>(response.toString(), HttpStatus.ACCEPTED);
	}

	@ApiOperation(value = "Atualiza uma atividade.")
	@PutMapping(value = "/atividade",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseEntity<String> atualizarAtividade(@RequestBody Atividade atividade)
			throws JSONException {
		JSONObject response = new JSONObject();
		try {
			response = service.atualizarAtividade(atividade);
		} catch (Exception e) {
			System.out.println("ERROR::" + e.getMessage());
			response.put("code", "1000");
			response.put("description", "INTERNAL SERVER ERROR - TIME OUT");
			return new ResponseEntity<String>(response.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<String>(response.toString(), HttpStatus.ACCEPTED);
	}

	@ApiOperation(value = "Deleta uma atividade.")
	@DeleteMapping(value = "/atividade/{id}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseEntity<String> deletar(@PathVariable Integer id) throws JSONException {
		JSONObject response = new JSONObject();
		try {
			response = service.deletarAtividade(id);
		} catch (Exception e) {
			System.out.println("ERROR::" + e.getMessage());
			response.put("code", "1000");
			response.put("description", "INTERNAL SERVER ERROR - TIME OUT");
			return new ResponseEntity<String>(response.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<String>(response.toString(), HttpStatus.ACCEPTED);
	}

}
