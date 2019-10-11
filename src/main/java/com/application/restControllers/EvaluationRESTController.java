package com.application.restControllers;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.application.beans.Evaluation;
import com.application.services.EvaluationService;

@RestController
@RequestMapping("/api")
public class EvaluationRESTController {
	
	@Autowired
	EvaluationService evaluationService;
	
	@PostMapping("/evaluations")
	public Evaluation addEvaluation(
			@RequestBody Evaluation evaluation,
			@RequestParam String profileId) {
		System.out.println(evaluation.toString());
		System.out.println(profileId);
		System.out.println(evaluation.getInterviewDate());
		int profileIdInt = Integer.parseInt(profileId);
		evaluationService.addEvaluation(evaluation, profileIdInt);
		// TODO: re-route to view page for the eval we just added
		return evaluation;
	}
	
	@GetMapping("/evaluations/{id}")
	public Object getEvaluation(@PathVariable("id") int id) {
		return evaluationService.getEvaluation(id);
	}
	
	@GetMapping("/evaluations")
	public java.util.List<Evaluation> listEvaluations() {
		return evaluationService.getEvaluationList();
	}
}
