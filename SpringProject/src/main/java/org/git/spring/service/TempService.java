package org.git.spring.service;

import org.git.spring.dao.SpringProjectDAO;
import org.git.spring.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TempService {
	
	
	private SpringProjectDAO springProjectDAO;
	
	public String getStaticTempTest(){
		return "Static Test Text from Temp Service";
	}

	public SpringProjectDAO getSpringProjectDAO() {
		return springProjectDAO;
	}
	@Autowired
	public void setSpringProjectDAO(SpringProjectDAO springProjectDAO) {
		this.springProjectDAO = springProjectDAO;
	}
	
	public void addPerson(Person p){
		getSpringProjectDAO().addPerson(p);
	}
	
	public int fetchRecords(){
		return getSpringProjectDAO().totalRecords();
	}
}
