package com.apiedu.apiedu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apiedu.apiedu.domain.Atividade;

@Repository
public interface AtividadeRepository extends JpaRepository<Atividade, Integer> {

}
