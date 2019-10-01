package com.application.restControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.application.beans.Profile;
import com.application.services.ProfileService;

@RestController
public class ProfileRESTController {

	@Autowired
	ProfileService profileService;
	
	@PostMapping("/profile")
	public Profile addProfile(@RequestBody Profile profile) {
		profileService.addProfile(profile);
		return profile;
	}
	
}
