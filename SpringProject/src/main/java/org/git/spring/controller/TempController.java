package org.git.spring.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.git.spring.model.Person;
import org.git.spring.model.TempModel;
import org.git.spring.service.TempService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@RequestMapping("/fetchrecords")
	public  String fetchRecords(){
		return "Total Records : "+tempService.fetchRecords();
	}
	
	@RequestMapping(value="/entry", method=RequestMethod.GET)
	public String entry(){
		return "new";
	}
	
	@RequestMapping(value="/new", method=RequestMethod.POST)
	public String newRecord(Person person,BindingResult bindingResult){
		System.out.println("val ..."+person);
		return "new";
	}
	
	
	@RequestMapping("/list")
	public @ResponseBody List<Person> listRecords(){
		//return "Total Records : "+tempService.fetchRecords();
		return tempService.listAllRecords();
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
