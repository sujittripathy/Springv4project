package org.git.rest.jersey;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.git.spring.dao.EmployeeCertDAOImpl;
import org.git.spring.model.Certification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/cert")
public class JerseyRestfulResource {

	@Autowired
	private EmployeeCertDAOImpl employeeCertDAOImpl;
	
	@GET
	@Path("test")
	public String getCertTest(){
		return "Certification Test Successful !!!";
	}
	
	@GET
	@Path("all")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Certification> getAllCertifications(){
		/*List<CertificationForm> certList= new ArrayList<CertificationForm>();
		
		CertificationForm c1= new CertificationForm();
		c1.setCertName("Hello CERT");
		c1.setGwCenter("PC");
		c1.setModule("Integration");
		c1.setAvailableSince(new Date());
		certList.add(c1);*/
		System.out.println("employeeCertDAOImpl val :: "+employeeCertDAOImpl);
		return employeeCertDAOImpl.getAllCertBooks();
		//return certList;	
	}
}
