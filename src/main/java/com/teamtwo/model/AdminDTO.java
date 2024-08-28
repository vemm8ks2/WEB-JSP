package com.teamtwo.model;

public class AdminDTO {

  private int adminId; // 관리자식별자
  private String adminLoginId; // 관리자아이디
  private String adminPassword; // 관리자비밀번호
  private String adminName; // 관리자이메일
  private String adminPhoneNumber; // 관리자연락처
  private String adminCreateAt; // 관리자등록일
  private String adminLastAccessedAt; // 마지막접속일
  private String adminLastAccessedIp; // 마지막접속아이피

  public int getAdminId() {
    return adminId;
  }

  public void setAdminId(int adminId) {
    this.adminId = adminId;
  }

  public String getAdminLoginId() {
    return adminLoginId;
  }

  public void setAdminLoginId(String adminLoginId) {
    this.adminLoginId = adminLoginId;
  }

  public String getAdminPassword() {
    return adminPassword;
  }

  public void setAdminPassword(String adminPassword) {
    this.adminPassword = adminPassword;
  }

  public String getAdminName() {
    return adminName;
  }

  public void setAdminName(String adminName) {
    this.adminName = adminName;
  }

  public String getAdminPhoneNumber() {
    return adminPhoneNumber;
  }

  public void setAdminPhoneNumber(String adminPhoneNumber) {
    this.adminPhoneNumber = adminPhoneNumber;
  }

  public String getAdminCreateAt() {
    return adminCreateAt;
  }

  public void setAdminCreateAt(String adminCreateAt) {
    this.adminCreateAt = adminCreateAt;
  }

  public String getAdminLastAccessedAt() {
    return adminLastAccessedAt;
  }

  public void setAdminLastAccessedAt(String adminLastAccessedAt) {
    this.adminLastAccessedAt = adminLastAccessedAt;
  }

  public String getAdminLastAccessedIp() {
    return adminLastAccessedIp;
  }

  public void setAdminLastAccessedIp(String adminLastAccessedIp) {
    this.adminLastAccessedIp = adminLastAccessedIp;
  }

}
