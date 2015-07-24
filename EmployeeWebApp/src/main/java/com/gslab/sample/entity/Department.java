package com.gslab.sample.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="DEPARTMENT")
public class Department implements Serializable {
	
	private static final long serialVersionUID = -7557571154822333813L;

	private long departmentId;
	private String departmentName;
	private Set<Employee> employees = new HashSet<>();
	
	/**
	 * @return the departmentId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DEPARTMENT_ID", unique = true, nullable = false)
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
	@Column(name = "DEPT_NAME")
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
	@OneToMany(mappedBy = "department", orphanRemoval = true)
	@Cascade(value = {CascadeType.SAVE_UPDATE})
	public Set<Employee> getEmployees() {
		return employees;
	}

	/**
	 * @param employees the employees to set
	 */
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + "]";
	}
	
	
}
