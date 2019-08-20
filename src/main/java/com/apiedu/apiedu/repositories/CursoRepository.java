package com.apiedu.apiedu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apiedu.apiedu.domain.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {

}
