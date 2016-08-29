package org.git.spring.model;

import java.sql.Date;

public class EmployeeCertification {

	private int employeeID;
	private String completedCertName;
	private Date completionDate;
	private Date expirationDate;
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public String getCompletedCertName() {
		return completedCertName;
	}
	public void setCompletedCertName(String completedCertName) {
		this.completedCertName = completedCertName;
	}
	public Date getCompletionDate() {
		return completionDate;
	}
	public void setCompletionDate(Date completionDate) {
		this.completionDate = completionDate;
	}
	public Date getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	
}
