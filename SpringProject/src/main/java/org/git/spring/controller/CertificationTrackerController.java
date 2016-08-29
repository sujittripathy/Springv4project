package org.git.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cert")
public class CertificationTrackerController {
	
	@RequestMapping("/home")
	public String home(){
		return "certhome";
	}
	
	@RequestMapping("/list-all-cert")
	public String listAllCertifications(){
		return "certificationlist";
	}
	@RequestMapping("/add-new-cert")
	public String addNewCertifications(){
		return "certadd";
	}
}
