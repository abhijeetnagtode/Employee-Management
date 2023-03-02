package com.empcrud.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.empcrud.model.fourDigitNum;
import com.empcrud.service.EmployeeService;

@RestController
@RequestMapping("/otp")
public class OtpController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/getRandomNumber")
	public ResponseEntity<fourDigitNum> getRandomNumber(@RequestParam String mobileNumber) {
		Random rnd = new Random();
		int number = rnd.nextInt(9999);
		fourDigitNum fourDigitNum = new fourDigitNum();
		fourDigitNum.setOtp(number);
		fourDigitNum fourDigitNum1 = this.employeeService.saveFourDigitNum(fourDigitNum);
		return ResponseEntity.ok().body(fourDigitNum1);
	}

}
