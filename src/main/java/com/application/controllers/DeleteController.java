package com.application.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DeleteController extends AbstractController {
	
	@PostMapping("deleteProfile/{id}")
	public ModelAndView deleteProfile(@PathVariable("id") int id) {
		this.restTemplate.delete(this.PROFILE_URI + id);
		
		// TODO: redirect to the list Profile page
		return new ModelAndView("home");
	}
	
	@PostMapping("deleteEvaluation/{id}")
	public ModelAndView deleteEvaluation(@PathVariable("id") int id) {
		this.restTemplate.delete(this.EVALUATION_URI + id);
		
		// TODO: redirect to the list Profile page
		return new ModelAndView("home");
	}
	
}
