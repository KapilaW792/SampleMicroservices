package com.core2cloud.microservices.employeemanager.service;

import java.util.List;

import com.core2cloud.microservices.employeemanager.entity.Employee;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    List<Employee> fetchAllEmployees();

    Employee getEmployeeById(Long id);

    Employee updateEmployeeById(Long id, Employee employee);

    String deleteDepartmentById(Long id);
}