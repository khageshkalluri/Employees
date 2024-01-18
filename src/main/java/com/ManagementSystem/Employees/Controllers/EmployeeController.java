package com.ManagementSystem.Employees.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ManagementSystem.Employees.Model.Employee;
import com.ManagementSystem.Employees.Service.EmployeeService;

@RestController
@RequestMapping("/employee")
@CrossOrigin
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	@GetMapping("/getAll")
	public ResponseEntity<List<Employee>> findall(){
		
		List<Employee> result=employeeService.all();
		
		return new ResponseEntity<>(result,HttpStatus.OK);
	}
	
	@GetMapping("/getE/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable Long id) {
		Employee ans=employeeService.findEmployee(id);
		return new ResponseEntity<>(ans,HttpStatus.OK);
	}
	
	@PostMapping("/addE")
	public ResponseEntity<String> addingE(@RequestBody Employee e) {
		employeeService.addEmployee(e);
		return new ResponseEntity<>("Added Employee",HttpStatus.OK);
		
	}
	
	@PutMapping("/update")
	 public ResponseEntity<String> updatingE(@RequestBody Employee emplo){
		employeeService.updateE(emplo);
		return new ResponseEntity<>("Updated Employee",HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteing(@PathVariable Long id){
		employeeService.deleteEmployee(id);
		return new ResponseEntity<>("Employee removed",HttpStatus.OK);
	}
	
	
}
