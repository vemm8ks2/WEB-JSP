package com.teamtwo.model;

public class CustomerDTO {
	
	private int customerId;				// 유저식별자
	private String customerLoginId;		// 유저아이디
	private String customerPassword;	// 유저비밀번호
	private String customerName;		// 유저이름
	private String customerEmail;		// 유저이메일
	private String customerPhoneNumber;	// 유저연락처
	private String customerGender;		// 유저성별
	private String customerBirth;		// 유저생일
	private String customerCreatedAt;	// 회원가입일
	private String customerUpdatedAt;	// 업데이트일
	
	public int getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public String getCustomerLoginId() {
		return customerLoginId;
	}
	
	public void setCustomerLoginId(String customerLoginId) {
		this.customerLoginId = customerLoginId;
	}
	
	public String getCustomerPassword() {
		return customerPassword;
	}
	
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public String getCustomerEmail() {
		return customerEmail;
	}
	
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	
	public String getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}
	
	public void setCustomerPhoneNumber(String customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}
	
	public String getCustomerGender() {
		return customerGender;
	}
	
	public void setCustomerGender(String customerGender) {
		this.customerGender = customerGender;
	}
	
	public String getCustomerBirth() {
		return customerBirth;
	}
	
	public void setCustomerBirth(String customerBirth) {
		this.customerBirth = customerBirth;
	}
	
	public String getCustomerCreatedAt() {
		return customerCreatedAt;
	}
	
	public void setCustomerCreatedAt(String customerCreatedAt) {
		this.customerCreatedAt = customerCreatedAt;
	}
	
	public String getCustomerUpdatedAt() {
		return customerUpdatedAt;
	}
	
	public void setCustomerUpdatedAt(String customerUpdatedAt) {
		this.customerUpdatedAt = customerUpdatedAt;
	}
	
}
