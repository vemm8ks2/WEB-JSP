package com.teamtwo.action;

/*
 * ActionForward 클래스 역할
 * 
 * 1. Action 인터페이스에서 리턴 타입으로 사용될 클래스다.
 * 2. 클래스 구성 요소
 *   1) isRedirect 멤버 - 반환형은 boolean 타입이다.
 *     - true : *.go 페이지
 *     - false : *.jsp 페이지
 *   2) path 멤버 : 반환형은 String 타입이다.
 *     - 파일 경로를 설정한다.
 */

public class ActionForward {

	private boolean isRedirect;
	private String path;
	
	public boolean isRedirect() {
		return isRedirect;
	}
	
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	
	public String getPath() {
		return path;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
}
