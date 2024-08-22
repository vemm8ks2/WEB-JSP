package com.teamtwo.model;

public class UserDTO {
	
	private int userId;				// 유저식별자
	private String userLoginId;		// 유저아이디
	private String userPassword;	// 유저비밀번호
	private String userName;		// 유저이름
	private String userEmail;		// 유저이메일
	private String userPhoneNumber;	// 유저연락처
	private String userGender;		// 유저성별
	private String userBirth;		// 유저생일
	private String userCreatedAt;	// 회원가입일
	private String userUpdatedAt;	// 업데이트일
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUserLoginId() {
		return userLoginId;
	}
	
	public void setUserLoginId(String userLoginId) {
		this.userLoginId = userLoginId;
	}
	
	public String getUserPassword() {
		return userPassword;
	}
	
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserEmail() {
		return userEmail;
	}
	
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}
	
	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}
	
	public String getUserGender() {
		return userGender;
	}
	
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	
	public String getUserBirth() {
		return userBirth;
	}
	
	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}
	
	public String getUserCreatedAt() {
		return userCreatedAt;
	}
	
	public void setUserCreatedAt(String userCreatedAt) {
		this.userCreatedAt = userCreatedAt;
	}
	
	public String getUserUpdatedAt() {
		return userUpdatedAt;
	}
	
	public void setUserUpdatedAt(String userUpdatedAt) {
		this.userUpdatedAt = userUpdatedAt;
	}
	
}
