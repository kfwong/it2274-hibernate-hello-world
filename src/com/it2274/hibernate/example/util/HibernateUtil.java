package com.it2274.hibernate.example.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * @author kfwong
 * 
 * Static Singleton class
 *
 */
public class HibernateUtil {
	// Hibernate maintains all the references of Session object using Factory pattern.
	// SessionFactory is a heavy object.
	// Each database should have only ONE SessionFactory object unless you know what you are doing.
	// The HibernateUtil class is a helper class implemented in static singleton pattern to make sure only 1 instance of SessionFactory throughout the application.
	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			Configuration configuration = new Configuration();
			configuration.configure();
			ServiceRegistryBuilder serviceRegistryBuilder = new ServiceRegistryBuilder().applySettings(configuration.getProperties());
			return configuration.buildSessionFactory(serviceRegistryBuilder.buildServiceRegistry());
		} catch (Throwable ex) {
			// Make sure you log the exceptio nn, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}