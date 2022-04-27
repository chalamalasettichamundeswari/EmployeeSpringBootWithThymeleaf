package com.chamu.springbootmvc.employee;

import java.util.List;

import com.chamu.springbootmvc.entity.Employee;

public interface EmployeeService {
 Employee createEmployee(Employee emp);
 Employee updateEmployee(Employee emp);
 void deleteEmployee(Employee emp);
 Employee getEmployeeById(int id);
 List<Employee> getAllEmployees();
}
