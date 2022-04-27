package com.chamu.springbootmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chamu.springbootmvc.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
