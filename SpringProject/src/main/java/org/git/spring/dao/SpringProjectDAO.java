package org.git.spring.dao;

import java.util.List;

import org.git.spring.model.Person;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SpringProjectDAO {
		
		public SessionFactory sessionFactory;
		
		@Autowired
		SpringProjectDAO(SessionFactory sessionFactory){
			this.sessionFactory=sessionFactory;
		}
		public final void addPerson(Person p){
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			session.save(p);
			session.getTransaction().commit();
			System.out.println("Added >>>");
		}
		
		public int totalRecords(){
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			String hql = "from Person";
			return session.createQuery(hql).list().size();
		}
		
		public List<Person> listAllRecords(){
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			Criteria c = session.createCriteria(Person.class);
			List<Person> result = c.list();
			System.out.println("Total Records" + result.size() + ", result :: "+result);
			return result;
		}
	
}
