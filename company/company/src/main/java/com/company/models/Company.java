package com.company.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Company {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	  int id; 
	  
    String name; 
  
    // In months 
    int duration; 
    String profile; 
  
    // Can be 0 
    int stipend; 
    boolean work_from_home;
    
    public Company() {}
    
	public Company(int id, String name, int duration, String profile, int stipend, boolean work_from_home) {
		super();
		this.id = id;
		this.name = name;
		this.duration = duration;
		this.profile = profile;
		this.stipend = stipend;
		this.work_from_home = work_from_home;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public int getStipend() {
		return stipend;
	}
	public void setStipend(int stipend) {
		this.stipend = stipend;
	}
	public boolean iswork_from_home() {
		return work_from_home;
	}
	public void setwork_from_home(boolean work_from_home) {
		this.work_from_home = work_from_home;
	} 
    
}
