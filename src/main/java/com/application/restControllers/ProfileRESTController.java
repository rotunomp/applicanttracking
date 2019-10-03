package com.application.restControllers;

import java.util.Optional;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	@PutMapping("/profile/{id}")
	public Profile updateProfile(@PathVariable("id") int id,@RequestBody Profile profile) {
		profile.setId(id);
		profileService.addProfile(profile);
		return profile;
	}
	
	@GetMapping("/profile/{id}")
	public Object getProfile(@PathVariable("id") int id) {
		return profileService.getProfile(id);
	}
	
	@GetMapping("/listProfiles")
	public java.util.List<Profile> listProfiles() {
		return profileService.getProfileList();
	}
}
