package com.gslab.sample.dac;

import java.util.List;

import com.gslab.sample.entity.Employee;


public interface EmployeeServiceDAC {
	
	List<Employee> findAllEmployees();	
	
	Employee findEmployee(long employeeId);

	Employee addEmployee(Employee newEmployee);
	
	Employee updateEmployee(Employee employee);
	
	void deleteEmployee(long employeeId);
}
