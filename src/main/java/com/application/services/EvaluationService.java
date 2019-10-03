package com.application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.beans.Evaluation;
import com.application.repositories.EvaluationRepository;

@Service
public class EvaluationService {
	
	@Autowired
	private EvaluationRepository evaluationRepository;

	public Evaluation addEvaluation(Evaluation evaluation) {
		System.out.println(evaluation.toString());
		evaluationRepository.saveAndFlush(evaluation);
		return evaluation;
	}
	
	public Optional<Evaluation> getEvaluation(int id) {
		return evaluationRepository.findById(id);
	}

	public List<Evaluation> getEvaluationList() {
		return evaluationRepository.findAll();
	}

}
