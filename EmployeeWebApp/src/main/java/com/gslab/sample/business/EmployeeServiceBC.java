package com.gslab.sample.business;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

import com.gslab.sample.business.json.DepartmentTO;
import com.gslab.sample.business.json.EmployeeTO;
import com.gslab.sample.business.json.MeetingTO;
import com.gslab.sample.dac.EmployeeServiceDAC;
import com.gslab.sample.entity.Department;
import com.gslab.sample.entity.Employee;
import com.gslab.sample.entity.Meeting;

@Transactional
public class EmployeeServiceBC {
	
	EmployeeServiceDAC employeeServiceDAC;
	
	/**
	 * @return the employeeServiceDAC
	 */
	public EmployeeServiceDAC getEmployeeServiceDAC() {
		return employeeServiceDAC;
	}


	/**
	 * @param employeeServiceDAC the employeeServiceDAC to set
	 */
	public void setEmployeeServiceDAC(EmployeeServiceDAC employeeServiceDAC) {
		this.employeeServiceDAC = employeeServiceDAC;
	}

	public List<EmployeeTO> findAllEmployees() {
		List<Employee> employees = getEmployeeServiceDAC().findAllEmployees();
		List<EmployeeTO> employeeTOs = new ArrayList<>();
		for (Employee employee : employees) {
			EmployeeTO employeeTO = createEmployeeTO(employee);
			employeeTOs.add(employeeTO);
		}
		
		return employeeTOs;
	}


	public EmployeeTO findEmployee(long employeeId) {
		Employee employee = getEmployeeServiceDAC().findEmployee(employeeId);
		EmployeeTO employeeTO = createEmployeeTO(employee);
		return employeeTO;
	}


	public EmployeeTO addEmployee(EmployeeTO newEmployee) {
		Employee employee = createEmployee(newEmployee);
		Employee addedEmployee = getEmployeeServiceDAC().addEmployee(employee);
		newEmployee = createEmployeeTO(addedEmployee);
		return newEmployee;
	}


	public EmployeeTO updateEmployee(EmployeeTO employeeTO) {
		Employee employee = createEmployee(employeeTO);
		getEmployeeServiceDAC().updateEmployee(employee);
		return employeeTO;
	}


	public void deleteEmployee(long employeeId) {		
		getEmployeeServiceDAC().deleteEmployee(employeeId);
	}
	
	private EmployeeTO createEmployeeTO(Employee employee) {
		
		EmployeeTO employeeTO = new EmployeeTO();
		employeeTO.setEmployeeId(employee.getEmployeeId());
		employeeTO.setDateOfBirth(employee.getDateOfBirth());
		
		Department dept = employee.getDepartment();
		DepartmentTO departmentTO = new DepartmentTO();
		departmentTO.setDepartmentId(dept.getDepartmentId());
		departmentTO.setDepartmentName(dept.getDepartmentName());
		
		employeeTO.setDepartment(departmentTO);
		employeeTO.setFirstName(employee.getFirstName());
		employeeTO.setLastName(employee.getLastName());
		employeeTO.setPhoneNumber(employee.getPhoneNumber());
		
		Set<Meeting> meetings = employee.getMeetings();
		Set<MeetingTO> meetingTOs = new HashSet<>();
		
		for (Meeting meeting : meetings) {
			MeetingTO meetingTO = new MeetingTO();
			meetingTO.setSubject(meeting.getSubject());
			meetingTO.setMeetingDate(meeting.getMeetingDate());
			meetingTO.setMeetingId(meeting.getMeetingId());
			meetingTOs.add(meetingTO);
		}
		
		employeeTO.setMeetings(meetingTOs);
		
		return employeeTO;
	}

	private Employee createEmployee(EmployeeTO employeeTO) {

		Employee employee = new Employee();
		employee.setEmployeeId(employeeTO.getEmployeeId());
		employee.setDateOfBirth(employeeTO.getDateOfBirth());

		Department dept = new Department();
		DepartmentTO departmentTO = employeeTO.getDepartment();

		dept.setDepartmentId(departmentTO.getDepartmentId());
		dept.setDepartmentName(departmentTO.getDepartmentName());

		employee.setDepartment(dept);
		employee.setFirstName(employeeTO.getFirstName());
		employee.setLastName(employeeTO.getLastName());
		employee.setPhoneNumber(employeeTO.getPhoneNumber());

		Set<Meeting> meetings = new HashSet<>();
		Set<MeetingTO> meetingTOs = employeeTO.getMeetings();

		for (MeetingTO meetingTO : meetingTOs) {
			Meeting meeting = new Meeting();
			meeting.setSubject(meetingTO.getSubject());
			meeting.setMeetingDate(meetingTO.getMeetingDate());
			meeting.setMeetingId(meetingTO.getMeetingId());
			meetings.add(meeting);
		}

		employee.setMeetings(meetings);

		return employee;
	}
}
