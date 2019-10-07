package com.application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public abstract class AbstractController {

	@Autowired
	RestTemplate restTemplate;

	protected final String PROFILE_URI = "http://localhost:8080/api/profiles/"; 
	protected final String EVALUATION_URI = "http://localhost:8080/api/evaluations/"; 

}
