package com.examples.dev.sessionfactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.examples.dev.domain.model.Department;
import com.examples.dev.domain.model.Employee;

public class SingletonSessionFactory {

	private static SessionFactory sessionFactory;

	private SingletonSessionFactory() {

	}

	public static Session getSession() {
		if (null == sessionFactory) {
			Configuration configuration = new AnnotationConfiguration()
					.addAnnotatedClass(Employee.class)
					.addAnnotatedClass(Department.class).configure();
			sessionFactory = configuration.buildSessionFactory();
		}
		return sessionFactory.openSession();
	}

}
