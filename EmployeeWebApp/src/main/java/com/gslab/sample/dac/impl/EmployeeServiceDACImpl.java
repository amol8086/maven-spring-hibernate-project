/**
 * 
 */
package com.gslab.sample.dac.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.gslab.sample.dac.EmployeeServiceDAC;
import com.gslab.sample.entity.Employee;

/**
 * @author GS-1014
 *
 */
@Transactional
public class EmployeeServiceDACImpl implements EmployeeServiceDAC {
	private static Logger LOGGER = Logger.getLogger(EmployeeServiceDACImpl.class);
	
	private SessionFactory sessionFactory;

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

	@Override
	public List<Employee> findAllEmployees() {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(Employee.class);
		List<Employee> employees = criteria.list();
		
		LOGGER.info("Fetched all Employees.");
		return employees;
	}

	@Override
	public Employee findEmployee(long employeeId) {
		Session session = getSessionFactory().getCurrentSession();
		Employee employee = (Employee) session.get(Employee.class, employeeId);  
		LOGGER.info("Fetched employee with id: " + employeeId + " found employee : " + employee);
		return employee;
	}

	@Override
	public Employee addEmployee(Employee newEmployee) {
		Session session = getSessionFactory().getCurrentSession();
		session.save(newEmployee);
		LOGGER.info("Added employee with id: " + newEmployee.getEmployeeId() + 
				" employee : " + newEmployee);
		return newEmployee;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		Session session = getSessionFactory().getCurrentSession();
		session.saveOrUpdate(employee);
		LOGGER.info("Updated employee with id: " + employee.getEmployeeId() + 
				" employee : " + employee);
		return employee;
	}

	@Override
	public void deleteEmployee(long employeeId) {
		Session session = getSessionFactory().getCurrentSession();
		Employee employee = (Employee) session.get(Employee.class, employeeId);
		session.delete(employee);
		LOGGER.info("Deleted employee with id: " + employee.getEmployeeId() + 
				" employee : " + employee);
	}

}
