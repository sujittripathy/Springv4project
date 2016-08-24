package org.git.spring.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.git.spring.model.Person;
import org.git.spring.model.TempModel;
import org.git.spring.service.TempService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/temp")
public class TempController {

	private TempService tempService;
	
	@Inject
	public TempController(TempService ts){
		this.tempService = ts;
	}
	
	@RequestMapping("/static")
	public @ResponseBody String getStaticTempText(){
		return "This is a static temp text [updated on MAC 2 now]/";
	}
	
	@RequestMapping(value="/add/{name}/{country}", method=RequestMethod.GET)
	public @ResponseBody String addNewPerson(@PathVariable String name, @PathVariable String country){
		Person newPerson= new Person();
		newPerson.setId(tempService.fetchRecords()+1);
		newPerson.setName(name);
		newPerson.setCountry(country);
		tempService.addPerson(newPerson);
		return "A new Person Added : Name > "+name;
	}
	
	
	
	@RequestMapping(value="/entry", method=RequestMethod.GET)
	public String entry(){
		return "new";
	}
	
	@RequestMapping(value="/new")
	public String newRecord(@ModelAttribute("person") Person person){
		return "new";
	}
	
	@RequestMapping(value = "/submit", method=RequestMethod.POST)
	public ModelAndView submit (@Valid Person person, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if (result.hasErrors()) {
			System.out.println("Error");
			mav.setViewName("new");
		} else {
			System.out.println("No Error");
			mav.setViewName("success");
			System.out.println(person.getName() + "," + person.getCountry());
			tempService.addPerson(person);
			mav.addObject("status", "SUCCESS");
		}
		return mav;
	}
	
	@RequestMapping("/count")
	public ModelAndView fetchRecords(){
		ModelAndView model=new ModelAndView("view");
		model.addObject("message",tempService.fetchRecords());
		return model;
	}
	
	@RequestMapping("/list") 
	public ModelAndView listRecords(){
		ModelAndView model=new ModelAndView("view");
		model.addObject("personList",tempService.listAllRecords());
		System.out.println("Total Records Fetched : "+tempService.listAllRecords());
		return model;
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ModelAndView delete(@ModelAttribute Person person){
		ModelAndView mav=new ModelAndView();
		System.out.println("delete method --"+person.getId());
		tempService.deletePerson(person);
		mav.setViewName("success");
		return mav;
	}
	
	@RequestMapping(value="/citytemp", method=RequestMethod.GET)
	public @ResponseBody TempModel getTemp(HttpServletRequest request){
		//String name = request.getParameter("name");
		TempModel t=new TempModel();
		t.setCity("Brea");
		t.setTemp(90);
		//return "Hello "+name;
		return t;
	}
}
