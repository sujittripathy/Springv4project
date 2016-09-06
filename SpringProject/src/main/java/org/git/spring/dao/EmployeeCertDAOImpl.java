package org.git.spring.dao;

import java.util.List;

import javax.ws.rs.WebApplicationException;

import org.git.spring.model.Certification;
import org.git.spring.model.TestCenterLocation;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeCertDAOImpl {

	@Autowired
	public SessionFactory sessionFactory;
	
	public void addNewCertification(Certification cert){
		Session session = this.sessionFactory.openSession();
		TestCenterLocation testCenterLocation= new TestCenterLocation();
		testCenterLocation.setCity("Brea");
		testCenterLocation.setState("CA");
		testCenterLocation.setZip("92821");
		cert.setTestCenterLocation(testCenterLocation);
		session.save(cert);
		System.out.println("$$$ New Certification Stored $$$");
	}
	
	
	public boolean removeCertification(int certID){
		
		/*Session session = this.sessionFactory.openSession();
		session.createQuery("delete from Certification where certID="+certID).executeUpdate();
		System.out.println("$$$ Certification Removed $$$");*/
		
		Certification cert = getCertification(certID);
		if(cert!=null){
			Session session = this.sessionFactory.openSession();
			session.delete(cert);
			session.flush();
			System.out.println("$$$ Certification Object Removed [New Way]$$$"+ cert);
			return true;
		}else {
			throw new WebApplicationException(404);
		}		
	}
	
	public void removeCertificationObject(Certification cert){
		Session session = this.sessionFactory.openSession();
		System.out.println("Cert to be delete :: "+ cert);
		session.delete(cert);
		System.out.println("$$$ Certification Object Removed $$$");
	}
	
	@SuppressWarnings("unchecked")
	public List<Certification> getAllCertifications(){
		System.out.println("sessionFactory obj >>"+this.sessionFactory);
		Session session = this.sessionFactory.openSession();
		System.out.println("SESSION obj "+session);
		return session.createQuery("from Certification certification").list();
	}
	
	public List<Certification> getAllCertBooks(){
		return sessionFactory.openSession().createCriteria(Certification.class).list();
	}

	public Certification getCertification(int certID){
		Session session = this.sessionFactory.openSession();
		return (Certification)session
					.createQuery("from Certification certification where certID = "+certID).uniqueResult();
	}
	
	public Certification getCertificationWithCriteria(int certID){
		Session session = this.sessionFactory.openSession();
		Criteria c = session.createCriteria(Certification.class);
		c.add(Restrictions.idEq(new Integer(certID)));
		return (Certification)c.list().get(0);
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
