package com.application.beans;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Entity
public class Evaluation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String reviewerEmail;
	private Date interviewDate;
//	private List<String> technologies;
	private String feedback;
	private int rating;
	
	@Autowired
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "prof_id")
	private Profile profile;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getReviewerEmail() {
		return reviewerEmail;
	}
	public void setReviewerEmail(String reviewerEmail) {
		this.reviewerEmail = reviewerEmail;
	}
	public Date getInterviewDate() {
		return interviewDate;
	}
	public void setInterviewDate(Date interviewDate) {
		this.interviewDate = interviewDate;
	}
//	public List<String> getTechnologies() {
//		return technologies;
//	}
//	public void setTechnologies(List<String> technologies) {
//		this.technologies = technologies;
//	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
//	public Profile getProfile() {
//		return profile;
//	}
//	public void setProfile(Profile profile) {
//		this.profile = profile;
//	}
	
	
	
}
