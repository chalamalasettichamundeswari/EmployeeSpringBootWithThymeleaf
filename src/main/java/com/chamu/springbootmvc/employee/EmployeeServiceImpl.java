package com.chamu.springbootmvc.employee;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chamu.springbootmvc.entity.Employee;
import com.chamu.springbootmvc.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository repo;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	@Transactional
	@Override
	public Employee createEmployee(Employee emp) {
		// TODO Auto-generated method stub
		LOGGER.info("Inside createEmployee()");
		return repo.save(emp);
	}
	@Transactional
	@Override
	public Employee updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		LOGGER.info("Inside updateEmployee()");
		return repo.save(emp);
	}
	@Transactional
	@Override
	public void deleteEmployee(Employee emp) {
		// TODO Auto-generated method stub
		LOGGER.info("Inside deleteEmployee()");
         repo.delete(emp);
	}

	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		LOGGER.info("Inside getEmployeeById()");
		return repo.findById(id).get();
	}
	@Transactional
	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		LOGGER.info("Inside getAllEmployees()");
		return (List<Employee>)repo.findAll();
	}

}
