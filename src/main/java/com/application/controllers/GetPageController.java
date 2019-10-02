package com.application.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import com.application.beans.Evaluation;
import com.application.beans.Profile;

@Controller
public class GetPageController extends AbstractController {

	@GetMapping("/")
	public ModelAndView home() {
		return new ModelAndView("home");
	}

	@GetMapping("addProfile") 
	public ModelAndView addProfile() {
		return new ModelAndView("addProfile");
	}
	
	@GetMapping("addEvaluation")
	public ModelAndView addEvaluation() {
		return new ModelAndView("addEvaluation");
	}
	
	@GetMapping("getEvaluation/{id}")
	public ModelAndView getEvaluation(@PathVariable("id") int id) {
		
		Evaluation respEvaluation = this.restTemplate.getForObject
				(this.EVALUATION_URI + "/" + id, Evaluation.class);
		
		return new ModelAndView("getEvaluation").addObject(respEvaluation);
	}

	@GetMapping("getProfile/{id}")
	public ModelAndView getProfile(@PathVariable("id") int id) {
		Profile respProfile = this.restTemplate.getForObject
				(this.PROFILE_URI + "/" + id , Profile.class);
		
		return new ModelAndView("getProfile").addObject(respProfile);
	}

	@GetMapping("listProfile")
	public ModelAndView listProfile() {
		List<Profile> profiles = this.restTemplate.getForObject
				(this.LIST_PROFILES + "", List.class);
		
		return new ModelAndView("listProfiles").addObject(profiles);
	}

	@GetMapping("listEvaluation")
	public ModelAndView listEvaluation() {
		List<Evaluation> evaluations = this.restTemplate.getForObject
				(this.LIST_PROFILES + "", List.class);

		return new ModelAndView("listEvaluations").addObject(evaluations);
	}

	@GetMapping("updateProfile/{id}")
	public ModelAndView updateProfile(@PathVariable("id") int id) {
		Profile respProfile = this.restTemplate.getForObject
				(this.PROFILE_URI + "/" + id , Profile.class);
		
		return new ModelAndView("updateProfile").addObject(respProfile);
	}

	@GetMapping("updateEvaluation/{id}")
	public ModelAndView updateEvaluation(@PathVariable("id") int id) {
		Evaluation respEvaluation = this.restTemplate.getForObject
				(this.EVALUATION_URI + "/" + id, Evaluation.class);

		return new ModelAndView("updateEvaluation").addObject(respEvaluation);
	}
	
}
