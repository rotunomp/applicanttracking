package com.application.controllers;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.application.beans.Evaluation;
import com.application.beans.Profile;

@Controller
public class AddController extends AbstractController {
		
	@PostMapping("/addProfile")
	public ModelAndView addProfile(
			@RequestParam("resume") MultipartFile resume,
			@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			@RequestParam("email") String email)
	{
		Profile profile = new Profile();
		profile.setFirstName(firstName);
		profile.setLastName(lastName);
		profile.setEmail(email);
		
		// TODO: Figure out file upload
		
		Profile respProfile = this.restTemplate.postForObject
				(this.PROFILE_URI, profile, Profile.class);
		
		// TODO: make redirect to view page of object we just added
		ModelAndView modelAndView = new ModelAndView("home");
		return modelAndView;
	}
	
	@PostMapping("addEvaluation")
	public ModelAndView addEvaluation(
			@RequestParam("reviewerEmail") String reviewerEmail,
			@RequestParam("date") String justDate,
			@RequestParam("time") String time,
			@RequestParam("profile") int profileId
			)
	{
		// TODO: figure best way to move business logic out of the controller

		// We need to set the date of eval from the stuff we got in the front
		int year = Integer.parseInt(justDate.substring(0, 4));
		int month = Integer.parseInt(justDate.substring(5, 7));
		int day = Integer.parseInt(justDate.substring(8));
		int hours = Integer.parseInt(time.substring(0, 2));
		int minutes = Integer.parseInt(time.substring(3));
		
		System.out.println(hours);
		
	      SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd"); 
	      System.out.print(justDate + " Parses as "); 
	      Date interviewDate = null;
	      try {
	         interviewDate = ft.parse(justDate); 
	         System.out.println(interviewDate); 
	      } catch (ParseException e) { 
	         System.out.println("Unparseable using " + ft); 
	      }		
	     interviewDate.setHours(hours);
	     interviewDate.setMinutes(minutes);
	      		
		
		// Make the profile with the correct id to inject into the class
		Profile profile = this.restTemplate.getForObject
				(this.PROFILE_URI + "/" + profileId, Profile.class);
		
		
		Evaluation evaluation = new Evaluation();
		evaluation.setReviewerEmail(reviewerEmail);
		evaluation.setInterviewDate(interviewDate);
		evaluation.setProfile(profile);
//		profile.getEvalutaions().add(evaluation);
		
		Evaluation respEvaluation = this.restTemplate.postForObject
				(this.EVALUATION_URI, evaluation, Evaluation.class);
		
		// TODO: make redirect to view page of object we just added
		ModelAndView modelAndView = new ModelAndView("home");
		return modelAndView;
	}

}
