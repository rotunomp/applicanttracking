package com.application.restControllers;

import java.util.Optional;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.application.beans.Evaluation;
import com.application.services.EvaluationService;

@RestController
public class EvaluationRESTController {
	
	@Autowired
	EvaluationService evaluationService;
	
	@PostMapping("/evaluation")
	public Evaluation addEvaluation(@RequestBody Evaluation evaluation) {
		evaluationService.addEvaluation(evaluation);
		return evaluation;
	}
	
	@GetMapping("/evaluation/{id}")
	public Object getEvaluation(@PathVariable("id") int id) {
		return evaluationService.getEvaluation(id);
	}
	
	@GetMapping("/listEvaluations")
	public java.util.List<Evaluation> listEvaluations() {
		return evaluationService.getEvaluationList();
	}
}
