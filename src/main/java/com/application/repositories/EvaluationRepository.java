package com.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.beans.Evaluation;

public interface EvaluationRepository extends JpaRepository<Evaluation, Integer>{

}
