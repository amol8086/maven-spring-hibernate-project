package com.gslab.sample.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="MEETING")
public class Meeting implements Serializable {

	private static final long serialVersionUID = 6031285161869300009L;
	
	private Long meetingId;

	private String subject;

	private Date meetingDate;

	private Set<Employee> employees = new HashSet<Employee>();

	public Meeting() {
		super();
	}
	
	public Meeting(String subject) {
		this.subject = subject;
		this.meetingDate = new Date(new java.util.Date().getTime());
	}

	/**
	 * @return the meetingId
	 */
	@Id
	@Column(name = "MEETING_ID")
	@GeneratedValue
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
	@Column(name = "SUBJECT")
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
	@Column(name = "MEETING_DATE")
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
	@ManyToMany(mappedBy = "meetings")
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
		return "Meeting [meetingId=" + meetingId + ", subject=" + subject + ", meetingDate=" + meetingDate + "]";
	}

}
