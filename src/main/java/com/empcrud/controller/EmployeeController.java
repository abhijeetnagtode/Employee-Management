package com.empcrud.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empcrud.model.Employee;
import com.empcrud.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/save")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		Employee employee1 = employeeService.save(employee);
		return ResponseEntity.ok().body(employee1);
	}

	@GetMapping("/get/{Id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("Id") Integer Id) {
		Employee employee = employeeService.getById(Id);
		return ResponseEntity.ok().body(employee);

	}

	@PostMapping("update/{Id}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable Integer Id) {
		Employee employee1 = employeeService.updateEmp(employee, Id);
		return ResponseEntity.ok().body(employee1);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Employee>> getAll() {
		List<Employee> all = employeeService.getAll();
		return ResponseEntity.ok().body(all);
	}

	@DeleteMapping("/delete/{Id}")
	public ResponseEntity<Map<String, String>> deleteEmployee(@PathVariable("Id") Integer Id) {
		employeeService.deleteById(Id);
		Map<String, String> message = Map.of("message", "record delete successfully");
		return ResponseEntity.ok().body(message);
	}

	@PostMapping("/login")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		String uname = employee.getUsername();
		String Pass = employee.getPassword();
		employee = employeeService.loginEmp(uname, Pass);
		return ResponseEntity.ok().body(employee);
	}
}
