package org.git.spring.controller;

import javax.validation.Valid;

import org.git.spring.dao.EmployeeCertDAOImpl;
import org.git.spring.model.Certification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/cert")
public class CertificationTrackerController {
	
	
	private EmployeeCertDAOImpl employeeCertDAOImpl;
	/*@Autowired
	private Certification certification;*/
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
	
	@RequestMapping(value="/add-new-cert", method=RequestMethod.GET,params="new")
	public String addNewCertifications(@ModelAttribute Certification certification){
		return "certadd";
	}
	
	@RequestMapping(value="/add-new-cert-submit",method=RequestMethod.POST)
	public String addNewCertificationSubmit(@Valid Certification certification, BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return "certadd";
		}
		System.out.println("Date >>> "+ certification.getAvailableSince());
		employeeCertDAOImpl.addNewCertification(certification);		
		return "enrollconfirm";
	}
	
/*	@InitBinder
	private void dateBinder(WebDataBinder webDataBinder){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(false);
		CustomDateEditor ce = new CustomDateEditor(sdf, true);
		webDataBinder.registerCustomEditor(Date.class, ce);
	}*/
}
