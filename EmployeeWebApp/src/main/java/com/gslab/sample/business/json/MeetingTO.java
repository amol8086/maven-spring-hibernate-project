package com.gslab.sample.business.json;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;


public class MeetingTO {
	
	private Long meetingId;
	private String subject;
	private Date meetingDate;
	private Set<EmployeeTO> employees = new HashSet<EmployeeTO>();
	
	/**
	 * @return the meetingId
	 */
	public Long getMeetingId() {
		return meetingId;
	}
	/**
	 * @param meetingId the meetingId to set
	 */
	public void setMeetingId(Long meetingId) {
		this.meetingId = meetingId;
	}
	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}
	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	/**
	 * @return the meetingDate
	 */
	public Date getMeetingDate() {
		return meetingDate;
	}
	/**
	 * @param meetingDate the meetingDate to set
	 */
	public void setMeetingDate(Date meetingDate) {
		this.meetingDate = meetingDate;
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
