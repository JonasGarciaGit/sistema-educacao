package com.apiedu.apiedu.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.apiedu.apiedu.domain.Atividade;
import com.apiedu.apiedu.domain.Curso;

@Repository
public interface AtividadeRepository extends JpaRepository<Atividade, Integer> {

	@Query("from Curso where id = :id")
	Curso buscarCurso(@Param(value = "id") Integer cursoId);
	
	@Query(value = "select * from atividade at, login_model lm where at.curso_id = lm.id" , nativeQuery = true)
	List<Atividade> buscarAtividades();
}
