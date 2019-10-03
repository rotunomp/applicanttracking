package com.application.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.application.beans.Evaluation;
import com.application.beans.Profile;

@Controller
public class UpdateController extends AbstractController {

	@PostMapping("/updateProfile/{id}")
	public ModelAndView updateProfile(@PathVariable("id") int id,
			@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			@RequestParam("email") String email) {
		
		//TODO: Figure out how we're going to deal with files.
		//			I'm using RequestParam instead of @RequestBody for this reason.
		
		Profile profile = new Profile();
		
		profile.setId(id);
		profile.setFirstName(firstName);
		profile.setLastName(lastName);
		profile.setEmail(email);
		
		
		System.out.println(profile);
		
		//Put was giving me crap so I'm using this instead?
		this.restTemplate.postForObject
				(this.PROFILE_URI, profile, Profile.class);
		
		System.out.println("this.restTemplate ran");
		
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
