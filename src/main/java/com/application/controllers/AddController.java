package com.application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import com.application.beans.Profile;

@Controller
public class AddController extends AbstractController {
		
	@PostMapping("/addProfile") 
	public ModelAndView addProfile(Profile profile) {
		
		Profile respProfile = restTemplate.postForObject
				(this.PROFILE_URI, profile, Profile.class);
		
		ModelAndView modelAndView = new ModelAndView("home");
		return modelAndView;
	}

	

}
