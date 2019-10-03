package com.application.beans;

import java.sql.Blob;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Entity
public class Profile {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private Blob resume;
//	private List<String> technologies;
	@OneToMany(mappedBy = "profile", cascade = CascadeType.ALL, targetEntity = Evaluation.class)
	private List<Evaluation> evalutaions;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Blob getResume() {
		return resume;
	}
	public void setResume(Blob resume) {
		this.resume = resume;
	}
//	public List<String> getTechnologies() {
//		return technologies;
//	}
//	public void setTechnologies(List<String> technologies) {
//		this.technologies = technologies;
//	}
	public List<Evaluation> getEvalutaions() {
		return evalutaions;
	}
	public void setEvalutaions(List<Evaluation> evalutaions) {
		this.evalutaions = evalutaions;
	}
	@Override
	public String toString() {
		return "Profile [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", resume=" + resume + "]";
	}
	
	
}

