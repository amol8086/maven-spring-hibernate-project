package com.gslab.sample.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="EMPLOYEE")
public class Employee implements Serializable {
	
	private static final long serialVersionUID = -7301669336384081878L;
	
	private long employeeId;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private String phoneNumber;
	private Department department;
	private Set<Meeting> meetings = new HashSet<Meeting>();
	
	public Employee() {
		super();
	}
	
	public Employee (String firstname, String lastname, String phone) {
        this.firstName = firstname;
        this.lastName = lastname;
        this.dateOfBirth = new Date(System.currentTimeMillis());
        this.phoneNumber = phone;
    }
	
	/**
	 * @return the employeeId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="EMPLOYEE_ID", unique = true, nullable = false)
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
	@Column(name = "FIRSTNAME")
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
	@Column(name = "LASTNAME")
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
	@Column(name = "BIRTH_DATE")
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
	@Column(name = "CELL_PHONE")
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
	@ManyToOne
	@Cascade(value={CascadeType.SAVE_UPDATE})
	@JoinColumn(name = "DEPARTMENT_ID", nullable = false)
	public Department getDepartment() {
		return department;
	}
	/**
	 * @param department the department to set
	 */
	public void setDepartment(Department department) {
		this.department = department;
	}

	/**
	 * @return the meetings
	 */
	 @ManyToMany
	 @JoinTable(name="EMPLOYEE_MEETING", 
     joinColumns={@JoinColumn(name="EMPLOYEE_ID")}, 
     inverseJoinColumns={@JoinColumn(name="MEETING_ID")})
	public Set<Meeting> getMeetings() {
		return meetings;
	}

	/**
	 * @param meetings the meetings to set
	 */
	public void setMeetings(Set<Meeting> meetings) {
		this.meetings = meetings;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", dateOfBirth=" + dateOfBirth + ", phoneNumber=" + phoneNumber + "]";
	}
	
	
	
}
