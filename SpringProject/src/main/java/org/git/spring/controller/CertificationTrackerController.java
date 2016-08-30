package org.git.spring.controller;

import org.git.spring.dao.EmployeeCertDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cert")
public class CertificationTrackerController {
	
	
	private EmployeeCertDAOImpl employeeCertDAOImpl;
	@Autowired
	public CertificationTrackerController(EmployeeCertDAOImpl employeeCertDAOImpl){
		this.employeeCertDAOImpl = employeeCertDAOImpl;
	}
	@RequestMapping("/home")
	public String home(){
		return "certhome";
	}
	
	@RequestMapping("/list-all-cert")
	public String listAllCertifications(){
		System.out.println("Size is >>"+employeeCertDAOImpl.getAllCertifications().size());
		return "certificationlist";
	}
	
	@RequestMapping("/add-new-cert")
	public String addNewCertifications(){
		return "certadd";
	}
}
