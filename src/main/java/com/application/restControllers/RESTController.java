package com.application.restControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.beans.Profile;
import com.application.services.ProfileService;

@RestController
public class RESTController {

	@Autowired
	private ProfileService profileService;

}
