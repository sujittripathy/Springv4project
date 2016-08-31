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
		System.out.println("getAvailableSince >>> "+cert.getAvailableSince());
		session.save(cert);
		System.out.println("$$$ Record Stored $$$");
	}
	
	@SuppressWarnings("unchecked")
	public List<Certification> getAllCertifications(){
		Session session = this.sessionFactory.openSession();
		return session.createQuery("select certID from Certification certification").list();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
