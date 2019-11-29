package com.apiedu.apiedu.login.utils;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.apiedu.apiedu.domain.Aluno;

@Repository
public interface LoginRepository extends JpaRepository<LoginModel, Integer> {

	@Query("from Aluno Where login = :login and senha = :senha")
	public Object validarLoginAluno(@Param(value = "login") String login , @Param(value = "senha") String senha);
	
	@Query("from Professor Where login = :login and senha = :senha")
	public Object validarLoginProfessor(@Param(value = "login") String login , @Param(value = "senha") String senha);
	
	
	@Query("from Aluno where login = :login and senha =:senha")
	public Aluno buscarIdAluno(@Param(value = "login") String login , @Param(value = "senha") String senha);
}
