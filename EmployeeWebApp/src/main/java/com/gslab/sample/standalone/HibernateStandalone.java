package com.gslab.sample.standalone;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.gslab.sample.entity.Department;
import com.gslab.sample.entity.Employee;
import com.gslab.sample.entity.Meeting;

public class HibernateStandalone {
	private SessionFactory sessionFactory;
	
	public HibernateStandalone() {
		createSessionFactory();
	}
	
	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	private void createSessionFactory() {
		Configuration configuration = new Configuration().
			//addPackage("com.gslab.sample.entity").configure().
			/*addAnnotatedClass(com.gslab.sample.entity.Message.class).
			addAnnotatedClass(com.gslab.sample.entity.Department.class).
			addAnnotatedClass(com.gslab.sample.entity.Employee.class).*/
			configure();
	
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
	            configuration.getProperties()).build();
		
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}
	
	public void closeSessionFactory() {
		getSessionFactory().close();
	}

	public static void main(String[] args) {
		
		HibernateStandalone standalone = new HibernateStandalone();
		Session session = standalone.getSessionFactory().openSession();
		session.beginTransaction();
		
		
/*		Department department = new Department();
        department.setDepartmentId(138);
		
        session.delete(department);
*/
        /*Department department = new Department();
        department.setDepartmentId(142L);
        department.setDepartmentName("Research2");

        Employee emp1 = new Employee("Mario3", "C", "333");
        //Employee emp2 = new Employee("Dora", "Explorer", "444");
 
        emp1.setDepartment(department);
        //emp2.setDepartment(department);
        
		//session.save(department); 
        
        session.save(emp1);*/
        //session.save(emp2);
        
		Department department = new Department();
        department.setDepartmentId(139);
        department.setDepartmentName("Research");
		
		Employee emp1 = new Employee("Mario3", "Carlos", "333");
		emp1.setEmployeeId(52);
		emp1.setDepartment(department);
		
		Meeting meeting = new Meeting();
		meeting.setMeetingDate(new Date(new java.util.Date().getTime()));
		meeting.setMeetingId(13L);
		meeting.setSubject("Yearly Sales meeting");
		Meeting meeting2 = new Meeting();
		meeting2.setMeetingId(14L);
		meeting2.setMeetingDate(new Date(new java.util.Date().getTime()));
		meeting2.setSubject("Yearly Marketting meeting");
		emp1.getMeetings().add(meeting);
		emp1.getMeetings().add(meeting2);
		
		session.delete(emp1);
		
		/*List<Message> messages = session.createCriteria(Message.class).list();
		System.out.println("\nMessages Size : " + messages.size());
	    for (Message message : messages) {
			System.out.println("\nMessage Text: " + message.getPreDefinedMessageText());
			System.out.println("Gender: " + message.getGender());
			System.out.println("Age: " + message.getAge());
			System.out.println("\n");
		}*/
		
		
		/*Employee emp = (Employee) session.get(Employee.class, 3L);
		System.out.println("employee Name: " + emp.getFirstName() + " - " + emp.getLastName());
		System.out.println("employee Department: " + emp.getDepartment().getDepartmentName());*/
		
		/*Department dept = (Department) session.get(Department.class, 117L);
		System.out.println("Dept Name: " + dept.getDepartmentName());
		System.out.println("Employees under Dept: " + dept.getEmployees().size());
		*/
		
		
		/*Meeting meeting1 = new Meeting("Quaterly Sales meeting");
		Meeting meeting2 = new Meeting("Weekly Status meeting");

		Employee employee1 = new Employee("Sergey", "Brin", "321");
		Employee employee2 = new Employee("Larry", "Page", "432");

		Department department = new Department();
        department.setDepartmentName("Research");
        employee1.setDepartment(department);
        employee2.setDepartment(department);
		
		employee1.getMeetings().add(meeting1);
		employee1.getMeetings().add(meeting2);
		employee2.getMeetings().add(meeting1);

		session.save(employee1);
		session.save(employee2);
		*/
		
		/*Employee emp = (Employee) session.get(Employee.class, 29L);
		
		System.out.println("employee name: " + emp.getFirstName() + " - " + emp.getLastName());
		System.out.println("dept name: " + emp.getDepartment().getDepartmentName());
		System.out.println("employee meetings: " + emp.getMeetings().size());*/
		
		
		/*Employee employee = (Employee) session.get(Employee.class, 28L);
		session.delete(employee);
		System.out.println("Employee Deleted...!");*/
		
        session.getTransaction().commit();
        //session.close();
		standalone.closeSessionFactory();
		
	}
}
