package com.gslab.sample.business.json;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class EmployeeTO {
	
	private long employeeId;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private String phoneNumber;
	private DepartmentTO department;
	private Set<MeetingTO> meetings = new HashSet<MeetingTO>();
	/**
	 * @return the employeeId
	 */
	public long getEmployeeId() {
		return employeeId;
	}
	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * @return the department
	 */
	public DepartmentTO getDepartment() {
		return department;
	}
	/**
	 * @param department the department to set
	 */
	public void setDepartment(DepartmentTO department) {
		this.department = department;
	}
	
	/**
	 * @return the meetings
	 */
	public Set<MeetingTO> getMeetings() {
		return meetings;
	}

	/**
	 * @param meetings the meetings to set
	 */
	public void setMeetings(Set<MeetingTO> meetings) {
		this.meetings = meetings;
	}
	
	
}
