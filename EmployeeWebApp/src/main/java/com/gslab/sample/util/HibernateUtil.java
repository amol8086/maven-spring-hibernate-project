package com.gslab.sample.util;
 
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
 
public class HibernateUtil {
 
	private static final SessionFactory sessionFactory = createSessionFactory();
 
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
 
	public static void shutdown() {
		// Close caches and connection pools
		getSessionFactory().close();
	}
	
	private static SessionFactory createSessionFactory() {
		Configuration configuration = new Configuration().
			//addPackage("com.gslab.sample.entity").configure().
			/*addAnnotatedClass(com.gslab.sample.entity.Message.class).
			addAnnotatedClass(com.gslab.sample.entity.Department.class).
			addAnnotatedClass(com.gslab.sample.entity.Employee.class).*/
			configure();
	
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
	            configuration.getProperties()).build();
		
		return configuration.buildSessionFactory(serviceRegistry);
	}
 
}