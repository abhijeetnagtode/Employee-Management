package com.empcrud.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "fourdigitnum")
public class fourDigitNum {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer otpid;
	private Integer otp;

	public Integer getOtpid() {
		return otpid;
	}

	public void setOtpid(Integer otpid) {
		this.otpid = otpid;
	}

	public Integer getOtp() {
		return otp;
	}

	public void setOtp(Integer otp) {
		this.otp = otp;
	}

}
