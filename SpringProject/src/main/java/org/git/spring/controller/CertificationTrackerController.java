package org.git.spring.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.beanutils.BeanUtils;
import org.git.spring.dao.EmployeeCertDAOImpl;
import org.git.spring.model.Certification;
import org.git.spring.model.client.CertificationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/cert")
public class CertificationTrackerController {
	
	
	private EmployeeCertDAOImpl employeeCertDAOImpl;
	@Autowired
	private Certification certification;
	
	@Autowired
	public CertificationTrackerController(EmployeeCertDAOImpl employeeCertDAOImpl){
		this.employeeCertDAOImpl = employeeCertDAOImpl;
	}
	@RequestMapping("/home")
	public String home(){
		return "certhome";
	}
	
	@RequestMapping("/list-all-cert")
	public String listAllCertifications(ModelMap certList){
		List<Certification> cList = employeeCertDAOImpl.getAllCertifications();
		certList.addAttribute("certficationList", cList);
		System.out.println("Size is >>"+employeeCertDAOImpl.getAllCertifications().size());
		return "certificationlist";
	}
	
	@RequestMapping(value="/add-new-cert", method=RequestMethod.GET,params="new")
	public String addNewCertifications(@ModelAttribute("certificationForm") CertificationForm certificationForm){
		return "certadd";
	}
	
	@RequestMapping(value="/add-new-cert-submit",method=RequestMethod.POST)
	public String addNewCertificationSubmit(@Valid CertificationForm certificationForm, BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			System.out.println("!!! Screen has error !!!");
			return "certadd";
		}
		try {
			BeanUtils.copyProperties(certification, certificationForm);
			System.out.println("certification Date >>> "+ certification.getAvailableSince()+","+
					"certificationForm Date >>> "+ certificationForm.getAvailableSince().toString());

		} catch (Exception e) {
			e.printStackTrace();
		} 
		employeeCertDAOImpl.addNewCertification(certification);		
		return "enrollconfirm";
	}
	@InitBinder
	private void dateBinder(WebDataBinder webDataBinder){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(false);
		CustomDateEditor ce = new CustomDateEditor(sdf, true);
		webDataBinder.registerCustomEditor(Date.class, ce);
	}
}
