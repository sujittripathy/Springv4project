package org.git.spring.dao;

import java.util.List;

import org.git.spring.model.Certification;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("employeeCertDAOImpl")
public class EmployeeCertDAOImpl {

	@Autowired
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
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
