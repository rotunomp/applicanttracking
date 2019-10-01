package com.application.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.beans.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Integer>{
	
}
