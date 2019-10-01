package com.application.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import com.application.beans.Evaluation;
import com.application.beans.Profile;

@Controller
public class UpdateController extends AbstractController {

	@PostMapping("/updateProfile/{id}")
	public ModelAndView updateProfile(@PathVariable("id") int id, @RequestBody Profile profile) {
		
		profile.setId(id);
		this.restTemplate.put
				(this.PROFILE_URI, profile, Profile.class);
		
		// TODO: make redirect to view page of object we just updated
		ModelAndView modelAndView = new ModelAndView("home");
		return modelAndView;
	}
	
	@PostMapping("/updateEvaluation/{id}")
	public ModelAndView updateEvaluation(@PathVariable("id") int id, @RequestBody Evaluation evaluation) {
		
		evaluation.setId(id);
		this.restTemplate.put
				(this.EVALUATION_URI, evaluation, Evaluation.class);
		
		// TODO: make redirect to view page of object we just updated
		ModelAndView modelAndView = new ModelAndView("home");
		return modelAndView;
	}
	
}
