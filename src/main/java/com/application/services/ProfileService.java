package com.application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.beans.Profile;
import com.application.repositories.ProfileRepository;

@Service
public class ProfileService {

	@Autowired
	private ProfileRepository profileRepository;
	
	public Profile addProfile(Profile profile) {
		profileRepository.save(profile);
		return profile;
	}
	
	public Optional<Profile> getProfile(int id) {
		return profileRepository.findById(id);
	}

	public List<Profile> getProfileList() {
		return profileRepository.findAll();
	}
}
