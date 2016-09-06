package org.git.rest.jersey;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.git.spring.dao.EmployeeCertDAOImpl;
import org.git.spring.model.Certification;
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
	@Path("/test")
	public String getCertTest(){
		return springProjectUtil.getMeHelloW();
	}
	
	// URL -- http://localhost:8080/jersey/cert/all
	@SuppressWarnings("rawtypes")
	@GET
	@Path("/all")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON}) //Accept: application/json
	public Certification[] getAllCertifications(){
		List certList = employeeCertDAOImpl.getAllCertBooks();
		Certification[] certArray = employeeCertDAOImpl.getAllCertBooks().toArray(new Certification[certList.size()]);
		return certArray;
	}
	
	@GET
	@Path("/find/{certID}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	//@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Certification getCert(@PathParam("certID") int certID){
		System.out.println("cID Value >> "+certID);
		return employeeCertDAOImpl.getCertification(certID);
	}
	
	// URL -- http://localhost:8080/jersey/cert/add
	@POST
	@Path("/add")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public void addCert(Certification cert){
		employeeCertDAOImpl.addNewCertification(cert);
	}
	
	@DELETE
	@Path("/delete/{certID}")
	public boolean deleteCert(@PathParam("certID") int certID){
		System.out.println("cID Value >> "+certID);
		return employeeCertDAOImpl.removeCertification(certID);
	}
}
