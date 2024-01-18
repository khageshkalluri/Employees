package com.ManagementSystem.Employees.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ManagementSystem.Employees.Exception.UserNotFoundException;
import com.ManagementSystem.Employees.Model.Employee;
import com.ManagementSystem.Employees.Repository.EmployeeRepository;


@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	
	public void addEmployee(Employee emp) {
		employeeRepository.save(emp);
	}
	
	public void deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
	}
	public Employee findEmployee(Long id) {
		Optional<Employee> tem= employeeRepository.findById(id);
		if(tem.isPresent())
			return tem.get();
		throw new UserNotFoundException("Not found");
	}
	
	public List<Employee> all(){
		return employeeRepository.findAll();
	}
     
	public void updateE(Employee empp) {
		System.out.println("YAS");
		employeeRepository.save(empp);
	}
}
