package org.git.spring4.samples;

public class Employee {
	private Certification certification; 
	public Employee(Certification certification){
		this.certification=certification;
	}
	
	public void takeCertification(){
		certification.getCertificationDetails();
	}
	
	public void init(){
		System.out.println("Initialization..");
	}
	
	public void clean(){
		System.out.println("Destroying..");
	}
}
