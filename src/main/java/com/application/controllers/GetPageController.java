package com.application.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
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
	
	@GetMapping("/addEvaluation")
	public ModelAndView addEvaluation() {
		
		ResponseEntity<Profile[]> profileResponseEntity = this.restTemplate
				.getForEntity(this.PROFILE_URI, Profile[].class);
		List<Profile> profiles = Arrays.asList(profileResponseEntity.getBody());
		
		return new ModelAndView("/addEvaluation").addObject("profiles", profiles);
	}
	
	@GetMapping("getEvaluation/{id}")
	public ModelAndView getEvaluation(@PathVariable("id") int id) {
		
		Evaluation respEvaluation = this.restTemplate.getForObject
				(this.EVALUATION_URI + id, Evaluation.class);
		
		return new ModelAndView("getEvaluation").addObject(respEvaluation);
	}

	@GetMapping("getProfile/{id}")
	public ModelAndView getProfile(@PathVariable("id") int id) {
		Profile respProfile = this.restTemplate.getForObject
				(this.PROFILE_URI + id , Profile.class);
		
		return new ModelAndView("getProfile").addObject(respProfile);
	}

	@GetMapping("listProfile")
	public ModelAndView listProfile() {
		ResponseEntity<Profile[]> profileResponseEntity = this.restTemplate
				.getForEntity(this.PROFILE_URI, Profile[].class);
		List<Profile> profiles = Arrays.asList(profileResponseEntity.getBody());
				
		return new ModelAndView("listProfiles").addObject("profiles", profiles);
	}

	@GetMapping("listEvaluation")
	public ModelAndView listEvaluation() {
		ResponseEntity<Evaluation[]> evaluationResponseEntity = this.restTemplate
				.getForEntity(this.EVALUATION_URI, Evaluation[].class);
		List<Evaluation> evaluations = Arrays.asList(evaluationResponseEntity.getBody());
		
		return new ModelAndView("listEvaluations").addObject("evaluations", evaluations);
	}

	@GetMapping("updateProfile/{id}")
	public ModelAndView updateProfile(@PathVariable("id") int id) {
		Profile respProfile = this.restTemplate.getForObject
				(this.PROFILE_URI + id , Profile.class);
		
		return new ModelAndView("updateProfile").addObject(respProfile);
	}

	@GetMapping("updateEvaluation/{id}")
	public ModelAndView updateEvaluation(@PathVariable("id") int id) {
		Evaluation respEvaluation = this.restTemplate.getForObject
				(this.EVALUATION_URI + id, Evaluation.class);

		return new ModelAndView("updateEvaluation").addObject(respEvaluation);
	}
	
}
