package com.luv2code.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
private EmployeeService employeeService;	
	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService=employeeService;
	}
//-----------Retrieve all Employee List----------
	@GetMapping("/employees")
	public List<Employee> findAllEmployee() {
		return employeeService.findAll();
		
	}
//----------Find Employee by Id---------------
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		Employee employee = employeeService.findById(employeeId);
		
		if(employee==null) {
			throw new RuntimeException();
		}
		return employee;
	}
	
	//-----------Save Employee-------------------
	@PostMapping("/employees")
	public Employee saveEmployee(@RequestBody Employee employee) {
		employee.setId(0);
		employeeService.save(employee);
		return employee;
	}
	
	//----------Update Employee-------------
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee) {
		
		employeeService.save(employee);
		return employee;
	}
	
	//-----------Delete Employee By ID------------
	@DeleteMapping("/employees/{employeeId}") 
		public String deleteEmployee(@PathVariable int employeeId) {
			employeeService.deleteById(employeeId);
			return "Deleted id:"+employeeId;
		}
}

