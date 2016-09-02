package org.git.spring.dao;

import java.util.List;

import org.git.spring.model.Certification;
import org.git.spring.model.TestCenterLocation;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeCertDAOImpl {

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
	
	
	public void removeCertification(int certID){
		
		/*Session session = this.sessionFactory.openSession();
		session.createQuery("delete from Certification where certID="+certID).executeUpdate();
		System.out.println("$$$ Certification Removed $$$");*/
		
		Certification cert = getCertification(certID);
		Session session = this.sessionFactory.openSession();
		session.delete(cert);
		System.out.println("$$$ Certification Object Removed [New Way]$$$"+ cert);
	}
	
	public void removeCertificationObject(Certification cert){
		Session session = this.sessionFactory.openSession();
		System.out.println("Cert to be delete :: "+ cert);
		session.delete(cert);
		System.out.println("$$$ Certification Object Removed $$$");
	}
	
	@SuppressWarnings("unchecked")
	public List<Certification> getAllCertifications(){
		Session session = this.sessionFactory.openSession();
		return session.createQuery("from Certification certification").list();
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
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
