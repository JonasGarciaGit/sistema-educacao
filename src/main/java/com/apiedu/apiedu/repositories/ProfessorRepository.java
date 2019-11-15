package com.apiedu.apiedu.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.apiedu.apiedu.domain.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
	
	@Query("FROM Professor")
	List<Professor> findAllProfessor();
}
