package com.empcrud.service;

import java.util.List;

import com.empcrud.model.Employee;
import com.empcrud.model.fourDigitNum;

public interface EmployeeService {

	// save
	public Employee save(Employee employee);

	// getall
	public List<Employee> getAll();

	// delete
	void deleteById(Integer id);

	// get
	public Employee getById(Integer id);

	// update
	public Employee updateEmp(Employee employee, Integer id);

	// login
	public Employee loginEmp(String username, String password);

	// otp
	public fourDigitNum saveFourDigitNum(fourDigitNum fourDigitNum);

}
