package com.apiedu.apiedu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.apiedu.apiedu.domain.Curso;
import com.apiedu.apiedu.repositories.CursoRepository;

@SpringBootApplication
public class ApieduApplication implements CommandLineRunner{
	
	@Autowired
	private CursoRepository repo; 

	public static void main(String[] args) {
		SpringApplication.run(ApieduApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Curso cursoGimp = new Curso(null, "Gimp", "Introdução ao Gimp", 80); 
		Curso cursoOfice = new Curso(null,"Office","Introdução ao pacote office",80);
		Curso cursoInformatica = new Curso(null,"Informática","Conceitos básicos e exercicios práticos",80);
		
		repo.save(cursoInformatica);
		repo.save(cursoOfice);
		repo.save(cursoGimp);
		
	}

}
