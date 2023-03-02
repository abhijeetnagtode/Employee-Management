package com.empcrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empcrud.exceptionhandler.ExceptionHandler;
import com.empcrud.model.Employee;
import com.empcrud.model.fourDigitNum;
import com.empcrud.repository.EmployeeRepository;
import com.empcrud.repository.fourDigitNumRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private fourDigitNumRepo fourDigitNumRepo;

	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	public fourDigitNumRepo getFourDigitNumRepo() {
		return fourDigitNumRepo;
	}

	public void setFourDigitNumRepo(fourDigitNumRepo fourDigitNumRepo) {
		this.fourDigitNumRepo = fourDigitNumRepo;
	}

	public EmployeeRepository getEmployeeRepository() {
		return employeeRepository;
	}

	// save
	@Override
	public Employee save(Employee employee) {
		return this.employeeRepository.save(employee);
	}

	// getall
	@Override
	public List<Employee> getAll() {
		List<Employee> all = this.employeeRepository.findAll();
		return all;
	}

	@Override
	public void deleteById(Integer id) {
		this.employeeRepository.findById(id).orElseThrow(() -> new ExceptionHandler("Product not found"));
		this.employeeRepository.deleteById(id);

	}

	@Override
	public Employee getById(Integer id) {
		return this.employeeRepository.findById(id).orElseThrow(() -> new ExceptionHandler("Product not found"));

	}

	@Override
	public Employee updateEmp(Employee employee, Integer id) {
		Employee emp = this.employeeRepository.findById(id)
				.orElseThrow(() -> new ExceptionHandler("Product not found"));
		emp.setName(employee.getName());
		emp.setEmail(employee.getEmail());
		emp.setAddress(employee.getAddress());
		Employee emp1 = this.employeeRepository.save(emp);
		return emp1;
	}

	// login
	@Override
	public Employee loginEmp(String username, String password) {
		Employee employee = this.employeeRepository.findByUsername(username);
		if (employee == null) {
			throw new ExceptionHandler("No record found");
		} else {
			if (employee.getUsername().equals(username) && employee.getPassword().equals(password)) {
				return employee;
			}
			throw new ExceptionHandler("Encorrenct password");
		}
	}

	@Override
	public fourDigitNum saveFourDigitNum(fourDigitNum fourDigitNumber) {
		return this.fourDigitNumRepo.save(fourDigitNumber);
	}
}