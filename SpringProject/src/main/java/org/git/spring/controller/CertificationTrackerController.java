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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cert")
public class CertificationTrackerController {
	
	@Autowired
	private EmployeeCertDAOImpl employeeCertDAOImpl;
	@Autowired
	private Certification certification;
	
	
	/*public CertificationTrackerController(EmployeeCertDAOImpl employeeCertDAOImpl){
		this.employeeCertDAOImpl = employeeCertDAOImpl;
	}*/
	@RequestMapping("/home")
	public String home(){
		return "certhome";
	}
	
	@RequestMapping("/remove-cert/{certID}")
	public String removeCertifications(@PathVariable("certID") int certID){
		System.out.println("Certification to be removed >> "+certID);
		employeeCertDAOImpl.removeCertification(certID);
		return "redirect:/cert/list-all-cert";
	}
	
	@RequestMapping("/list-all-cert")
	public ModelAndView listAllCertifications(){
		ModelAndView mandv=new ModelAndView("certificationlist");
		List<Certification> cList = employeeCertDAOImpl.getAllCertifications();
		mandv.addObject("certficationList", cList);
		System.out.println("Size is >>"+employeeCertDAOImpl.getAllCertifications());
		return mandv;
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
		return "redirect:/cert/list-all-cert";
	}
	@InitBinder
	private void dateBinder(WebDataBinder webDataBinder){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(false);
		CustomDateEditor ce = new CustomDateEditor(sdf, true);
		webDataBinder.registerCustomEditor(Date.class, ce);
	}
}
