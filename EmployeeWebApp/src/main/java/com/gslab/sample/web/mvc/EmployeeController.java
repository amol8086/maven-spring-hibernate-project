package com.gslab.sample.web.mvc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gslab.sample.business.EmployeeServiceBC;
import com.gslab.sample.business.json.EmployeeTO;

@RestController
@RequestMapping(value={"api/employees", "api/employee"})
public class EmployeeController {

    @Resource
	private EmployeeServiceBC employeeServiceBC;
    
	/**
	 * @return the employeeServiceBC
	 */
	public EmployeeServiceBC getEmployeeServiceBC() {
		return employeeServiceBC;
	}

	/**
	 * @param employeeServiceBC the employeeServiceBC to set
	 */
	public void setEmployeeServiceBC(EmployeeServiceBC employeeServiceBC) {
		this.employeeServiceBC = employeeServiceBC;
	}

	@RequestMapping(method = RequestMethod.GET)
    public @ResponseBody Map<String, Object> findAllEmployees(HttpServletResponse response) {
    	List<EmployeeTO> employees = getEmployeeServiceBC().findAllEmployees();
    	Map<String, Object> jsonMap = new HashMap<String, Object>();
    	jsonMap.put("employees", employees);
    	response.setHeader("Vary", "Accept-Encoding");
    	response.setHeader("Connection", "keep-alive");
    	response.setHeader("Access-Control-Allow-Origin", "*");
    	//response.setHeader("Content-Length", Integer.toString(jsonMap.toString().length()));
    	
		return jsonMap;
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody Map<String, Object> findEmployee(@PathVariable("id") long id) {
    	EmployeeTO employee = getEmployeeServiceBC().findEmployee(id);
        Map<String, Object> jsonMap = new HashMap<String, Object>();
    	jsonMap.put("employee", employee);
		return jsonMap;
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public @ResponseBody Map<String, Object> updateEmployee(@PathVariable("id") long id, 
    		@RequestBody EmployeeTO employee) {
    	employee.setEmployeeId(id);
    	
    	EmployeeTO updatedEmployee = getEmployeeServiceBC().updateEmployee(employee);
    	Map<String, Object> jsonMap = new HashMap<String, Object>();
     	jsonMap.put("employee", updatedEmployee);
		return jsonMap;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> addEmployee(@RequestBody EmployeeTO employee) {
    	EmployeeTO addedEmployee = getEmployeeServiceBC().addEmployee(employee);
        Map<String, Object> jsonMap = new HashMap<String, Object>();
     	jsonMap.put("employee", addedEmployee);
     	
		return jsonMap;
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public @ResponseBody Map<String, Object> deleteEmployee(@PathVariable("id") long id) {
    	getEmployeeServiceBC().deleteEmployee(id);
        Map<String, Object> jsonMap = new HashMap<String, Object>();
     	jsonMap.put("status", "Deleted Employee.");
		return jsonMap;
    }
    
}
