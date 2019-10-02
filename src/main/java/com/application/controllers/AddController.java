package com.application.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.application.beans.Evaluation;
import com.application.beans.Profile;

@Controller
public class AddController extends AbstractController {
		
	@PostMapping("/addProfile") 
	public ModelAndView addProfile(Profile profile) {
		
		Profile respProfile = this.restTemplate.postForObject
				(this.PROFILE_URI, profile, Profile.class);
		
		// TODO: make redirect to view page of object we just added
		ModelAndView modelAndView = new ModelAndView("home");
		return modelAndView;
	}
	
	@PostMapping("/addEvaluation")
	public ModelAndView addEvaluation(Evaluation evaluation) {
		
		Evaluation respEvaluation = this.restTemplate.postForObject
				(this.EVALUATION_URI, evaluation, Evaluation.class);
		
		// TODO: make redirect to view page of object we just added
		ModelAndView modelAndView = new ModelAndView("home");
		return modelAndView;
	}

}
