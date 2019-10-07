package com.application.beans;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

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
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH, targetEntity = Profile.class)
    @JoinColumn(name = "profile_id", nullable=false)
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
	public Profile getProfile() {
		return profile;
	}
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	@Override
	public String toString() {
		return "Evaluation [id=" + id + ", reviewerEmail=" + reviewerEmail + ", interviewDate=" + interviewDate
				+ ", feedback=" + feedback + ", rating=" + rating + ", profile=" + profile + "]";
	}
	
	
	
}
