package org.git.rest.jersey;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.git.spring.dao.EmployeeCertDAOImpl;
import org.git.spring.util.SpringProjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/cert")
public class JerseyRestfulResource {

	@Autowired
	private EmployeeCertDAOImpl employeeCertDAOImpl;
	@Autowired
	private SpringProjectUtil springProjectUtil;
	
	@GET
	@Path("test")
	public String getCertTest(){
		return springProjectUtil.getMeHelloW();
	}
	
	@SuppressWarnings("rawtypes")
	@GET
	@Path("all")
	@Produces(MediaType.APPLICATION_JSON)
	public List getAllCertifications(){
		return employeeCertDAOImpl.getAllCertBooks();
	}
}
