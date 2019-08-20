package com.apiedu.apiedu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apiedu.apiedu.domain.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

}
