package com.gslab.sample.business.json;

import java.util.HashSet;
import java.util.Set;


public class DepartmentTO {
	
	private long departmentId;
	
	private String departmentName;

	private Set<EmployeeTO> employees = new HashSet<EmployeeTO>();
	
	/**
	 * @return the departmentId
	 */
	public long getDepartmentId() {
		return departmentId;
	}

	/**
	 * @param departmentId the departmentId to set
	 */
	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}

	/**
	 * @return the departmentName
	 */
	public String getDepartmentName() {
		return departmentName;
	}

	/**
	 * @param departmentName the departmentName to set
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	/**
	 * @return the employees
	 */
	public Set<EmployeeTO> getEmployees() {
		return employees;
	}

	/**
	 * @param employees the employees to set
	 */
	public void setEmployees(Set<EmployeeTO> employees) {
		this.employees = employees;
	}
	
	
}
