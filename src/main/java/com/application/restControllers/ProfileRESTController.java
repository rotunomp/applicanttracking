package com.application.restControllers;

import java.util.Optional;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.application.beans.Profile;
import com.application.repositories.ProfileRepository;
import com.application.services.ProfileService;

@RestController
public class ProfileRESTController {
	
	@Autowired
	ProfileService profileService;
	ProfileRepository repo;
	
	@PostMapping("/profile")
	public Profile addProfile(@RequestBody Profile profile) {
		profileService.addProfile(profile);
		return profile;
	}
	
	@PostMapping("/profile/{id}")
	@ResponseBody
	public Object getProfile(@PathVariable("id") int id) {
		return repo.findById(id);
	}
	
	@PostMapping("/profiles")
	@ResponseBody
	public java.util.List<Profile> listProfiles() {
		return repo.findAll();
	}
}
