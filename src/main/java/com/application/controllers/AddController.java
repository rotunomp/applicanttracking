package com.application.controllers;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.application.beans.Evaluation;
import com.application.beans.Profile;

@Controller
public class AddController extends AbstractController {
		
	@PostMapping("/addProfile")
	public ModelAndView addProfile(
			@RequestParam("resume") MultipartFile resume,
			@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			@RequestParam("email") String email)
	{
		Profile profile = new Profile();
		profile.setFirstName(firstName);
		profile.setLastName(lastName);
		profile.setEmail(email);
		
		// TODO: Figure out file upload
		
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
