package com.empcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empcrud.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	public Employee findByUsername(String username);

}
