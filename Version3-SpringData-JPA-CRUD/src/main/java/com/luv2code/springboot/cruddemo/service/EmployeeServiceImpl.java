package com.luv2code.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.luv2code.springboot.cruddemo.dao.EmployeeRepository;
import com.luv2code.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	@Autowired
	 public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository=employeeRepository;
	}
	
	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int id) {
		
		Optional<Employee> result=employeeRepository.findById(id);
		
		Employee employee=null;
		
		if(result.isPresent()) {
			employee=result.get();
		}
		else {
			throw new  RuntimeException();
		}
		return employee;
}

	@Override
	public void save(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public void deleteById(int id) {
		employeeRepository.deleteById(id);
	}

}
