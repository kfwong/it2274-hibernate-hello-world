package com.it2274.hibernate.example.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.it2274.hibernate.example.dto.Student;
import com.it2274.hibernate.example.util.HibernateUtil;

public class StudentDao {
	public void create(Student student){
		// Please refer to my comments in HibernateUtil.java about this syntax
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		// Open a session
		Session session = sessionFactory.openSession();
		
		// Begin transaction
		session.beginTransaction();
		
		// Save object
		// Alternatively, session.saveOrUpdate(Object obj) is also a useful method to handle both create and update
		// You should use the setters to set the values into the Student object
		// Using session.save method, Hibernate will take care of the database ends!
		// *****NOTE: Please look at the Servlets for more details on setting the values!*****
		session.save(student);
		
		// Commit transaction
		session.getTransaction().commit();
		
		// Close session
		session.close();
	}
	
	public void update(Student student){
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		session.update(student);
		session.getTransaction().commit();
		
		session.close();
	}
	
	public void delete(Student student){
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		session.delete(student);
		session.getTransaction().commit();
		
		session.close();
	}
	
	public List<Student> getAll(){
		// Hibernate provides a few ways to retrives records from database
		// From what I know they are: HQL (Hibernate Query Language)/Hibernate Criteria API, named query (annotation), native SQL
		// In this case, I'll be using HQL as this is the recommended method
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		// HQL is very similar to SQL, except that it allows developer to view it at entity level, that's my own understanding.
		// You can omit the SELECT clause unless you want to select only specific columns.
		// Take note that the operand at FROM clause is the entity class name, not the database table name.
		// You can also include standard SQL WHERE clause, except that all fields should be in terms of entity's property name
		// e.g:
		//
		// List<Student> students = session.createQuery("FROM Student WHERE age < 10").list();
		//
		// Note that the age field is the property name from the Student entity
		List<Student> students = session.createQuery("FROM Student").list();
		
		// Once the HQL is formed, Hibernate will translate HQL into the apropriate SQL base on the type of database you are using, whether it's MySQL or Microsoft SQL Server etc.
		// This ensures the portablity in case the application migrates to different database.
		
		// Also, instead of writing HQL in pure String manner, Hibernate provides Criteria API for readability purpose.
		// It's very useful while handling complex statement.
		// e.g:
		//
		// List students = session.createCriteria(Student.class)
	    // 				.add( Restrictions.like("name", "Wong%") )
	    // 				.add( Restrictions.between("age", 10, 20) )
		// 				.list();
		//
		// Please refer to Hibernate Documentation for more examples.
		
		session.close();
		
		return students;
	}
}
