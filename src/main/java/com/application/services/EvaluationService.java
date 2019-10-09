package com.application.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.beans.Evaluation;
import com.application.beans.Profile;
import com.application.repositories.EvaluationRepository;
import com.application.repositories.ProfileRepository;

@Service
public class EvaluationService {
	
	@Autowired
	private EvaluationRepository evaluationRepository;
	@Autowired 
	private ProfileRepository profileRepository;

	public Evaluation addEvaluation(
			String reviewerEmail,
			String date, 
			String time, 
			int profileId) {
		
		// We need to set the date of eval from the stuff we got in the front
		int year = Integer.parseInt(date.substring(0, 4));
		int month = Integer.parseInt(date.substring(5, 7));
		int day = Integer.parseInt(date.substring(8));
		int hours = Integer.parseInt(time.substring(0, 2));
		int minutes = Integer.parseInt(time.substring(3));
		
	      SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd"); 
	      System.out.print(date + " Parses as "); 
	      Date interviewDate = null;
	      try {
	         interviewDate = ft.parse(date); 
	         System.out.println(interviewDate); 
	      } catch (ParseException e) { 
	         System.out.println("Unparseable using " + ft); 
	      }		
	     interviewDate.setHours(hours);
	     interviewDate.setMinutes(minutes);
	      		
		
		// Make the profile with the correct id to inject into the class
		Optional<Profile> profile = this.profileRepository.findById(profileId);
		
		Evaluation evaluation = new Evaluation();
		evaluation.setReviewerEmail(reviewerEmail);
		evaluation.setInterviewDate(interviewDate);
		evaluation.setProfile(profile.get());
		
		evaluationRepository.save(evaluation);
		return evaluation;
	}
	
	public Optional<Evaluation> getEvaluation(int id) {
		return evaluationRepository.findById(id);
	}

	public List<Evaluation> getEvaluationList() {
		return evaluationRepository.findAll();
	}

}
