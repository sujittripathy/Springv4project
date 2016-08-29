package org.git.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	@GeneratedValue
	private int employeeID;
	private String fName;
	private String lName;
	private String email;
	private String region;
	private String location;
	private String totalExperience;
	private String gwExperience;

	
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getTotoapExperience() {
		return totalExperience;
	}
	public void setTotoapExperience(String totalExperience) {
		this.totalExperience = totalExperience;
	}
	public String getGwExperience() {
		return gwExperience;
	}
	public void setGwExperience(String gwExperience) {
		this.gwExperience = gwExperience;
	}
	
}
