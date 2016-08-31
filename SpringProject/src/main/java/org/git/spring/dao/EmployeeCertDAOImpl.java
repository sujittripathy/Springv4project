package org.git.spring.dao;

import java.util.List;

import org.git.spring.model.Certification;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeCertDAOImpl {

	public SessionFactory sessionFactory;
	
	public void addNewCertification(Certification cert){
		Session session = this.sessionFactory.openSession();
		session.save(cert);
		System.out.println("$$$ New Certification Stored $$$");
	}
	
	public void removeCertification(int certID){
		//Certification c = getCertification(certID);
		Session session = this.sessionFactory.openSession();
		session.createQuery("delete from Certification where certID="+certID).executeUpdate();
		System.out.println("$$$ Certification Removed $$$");
	}
	
	@SuppressWarnings("unchecked")
	public List<Certification> getAllCertifications(){
		Session session = this.sessionFactory.openSession();
		return session.createQuery("from Certification certification").list();
	}

	public Certification getCertification(int certID){
		Session session = this.sessionFactory.openSession();
		return (Certification)session.createQuery("from Certification certification where certID = "+certID);
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
