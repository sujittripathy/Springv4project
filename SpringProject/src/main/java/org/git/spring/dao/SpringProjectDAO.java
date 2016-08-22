package org.git.spring.dao;

import org.git.spring.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SpringProjectDAO {
		
		public SessionFactory sessionFactory;
		
		public final void addPerson(Person p){
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			session.save(p);
			session.getTransaction().commit();
			System.out.println("Added >>>");
		}
		
		public int totalRecords(){
			String hql = "from Person";
			return this.sessionFactory.getCurrentSession().createQuery(hql).list().size();
		}

		public SessionFactory getSessionFactory() {
			return sessionFactory;
		}
		
		@Autowired
		public void setSessionFactory(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
		}
}
