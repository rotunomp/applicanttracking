package com.application.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

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
	
}
