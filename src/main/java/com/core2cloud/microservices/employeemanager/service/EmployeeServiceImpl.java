package com.core2cloud.microservices.employeemanager.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.core2cloud.microservices.employeemanager.entity.Employee;
import com.core2cloud.microservices.employeemanager.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(Employee employee) {
		logger.debug("Saving employee, {}",employee);
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> fetchAllEmployees() {
		List<Employee> allEmployees = employeeRepository.findAll();
		return allEmployees;
	}

	@Override
	public Employee getEmployeeById(Long id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if (employee.isPresent()) {
			return employee.get();
		}
		return null;
	}

	@Override
	public Employee updateEmployeeById(Long id, Employee employee) {
		logger.debug("Updating employee, {}",employee);
		Optional<Employee> employee1 = employeeRepository.findById(id);

		if (employee1.isPresent()) {
			Employee originalEmployee = employee1.get();

			if (Objects.nonNull(employee.getName()) && !"".equalsIgnoreCase(employee.getName())) {
				originalEmployee.setName(employee.getName());
			}
			if (Objects.nonNull(employee.getSalary()) && employee.getSalary() != 0) {
				originalEmployee.setSalary(employee.getSalary());
			}
			return employeeRepository.save(originalEmployee);
		}
		return null;
	}

	@Override
	public String deleteDepartmentById(Long id) {
		if (employeeRepository.findById(id).isPresent()) {
			employeeRepository.deleteById(id);
			return "Employee deleted successfully";
		}
		return "No such employee in the database";
	}
}