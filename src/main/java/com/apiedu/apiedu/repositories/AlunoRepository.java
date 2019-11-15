package com.apiedu.apiedu.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.apiedu.apiedu.domain.Aluno;
import com.apiedu.apiedu.domain.Curso;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

	@Query("FROM Aluno")
	List<Aluno> buscarAlunos();
	
	@Query("from Curso where id = :id")
	Curso buscarCurso(@Param(value = "id") Integer cursoId);
	
}
