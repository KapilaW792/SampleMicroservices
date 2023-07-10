package com.core2cloud.microservices.employeemanager.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.core2cloud.microservices.employeemanager.entity.Employee;
import com.core2cloud.microservices.employeemanager.service.EmployeeService;

@RestController
public class EmployeeController {

	private Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/employee")
	public Employee saveEmployee(@RequestBody Employee employee) {
		logger.debug("Saving employee");
		return employeeService.saveEmployee(employee);
	}

	@GetMapping("/employee")
	public List<Employee> getAllEmployees() {
		logger.debug("Get all employees");
		return employeeService.fetchAllEmployees();
	}

	@GetMapping("/employee/{id}")
	public Employee getEmployeeById(@PathVariable("id") Long id) {
		logger.debug("Get employee by id, {}", id);
		return employeeService.getEmployeeById(id);
	}

	@PutMapping("/employee/{id}")
	public Employee updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee) {
		logger.debug("Updating employee");
		return employeeService.updateEmployeeById(id, employee);
	}

	@DeleteMapping("/employee/{id}")
	public String deleteEmployee(@PathVariable("id") Long id) {
		logger.debug("Deleting employee id, {}", id);
		return employeeService.deleteDepartmentById(id);
	}
}