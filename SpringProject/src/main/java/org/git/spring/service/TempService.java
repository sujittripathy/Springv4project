package org.git.spring.service;

import java.util.List;

import org.git.spring.dao.SpringProjectDAO;
import org.git.spring.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TempService {
	
	private SpringProjectDAO springProjectDAO;
	
	@Autowired
	public TempService(SpringProjectDAO springProjectDAO){
		this.springProjectDAO = springProjectDAO;
	}
	public String getStaticTempTest(){
		return "Static Test Text from Temp Service";
	}

	public void addPerson(Person p){
		springProjectDAO.addPerson(p);
	}
	
	public int fetchRecords(){
		return springProjectDAO.totalRecords();
	}
	
	public List<Person> listAllRecords(){
		return springProjectDAO.listAllRecords();
	}
	
	public void deletePerson(Person p){
		springProjectDAO.deletePerson(p);
	}
}
