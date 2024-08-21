package com.teamtwo.model;

public class OrderDTO {
	private int order_no; 				// 주문식별자 [id]
	private String order_receiverName; 	// 수취인 이름[receiver_name]
	private String order_receiverPhone; // 수취인 연락처[receiver_phone]
	private String order_receiverAddr; 	// 수취인 주소 [receiver_addr]
	private String order_status; 		// 주문상태 [order_status]
	private String order_createdAt; 	// 주문일 [creater_at]
	private String order_deliveredAt; 	// 배송완료일 [delivered_at]
	private int user_no; 				// UserDTO 유저식별자[user_id]
	
	public int getOrder_no() {
		return order_no;
	}
	
	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}
	
	public String getOrder_receiverName() {
		return order_receiverName;
	}
	
	public void setOrder_receiverName(String order_receiverName) {
		this.order_receiverName = order_receiverName;
	}
	
	public String getOrder_receiverPhone() {
		return order_receiverPhone;
	}
	
	public void setOrder_receiverPhone(String order_receiverPhone) {
		this.order_receiverPhone = order_receiverPhone;
	}
	
	public String getOrder_receiverAddr() {
		return order_receiverAddr;
	}
	
	public void setOrder_receiverAddr(String order_receiverAddr) {
		this.order_receiverAddr = order_receiverAddr;
	}
	
	public String getOrder_status() {
		return order_status;
	}
	
	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}
	
	public String getOrder_createdAt() {
		return order_createdAt;
	}
	
	public void setOrder_createdAt(String order_createdAt) {
		this.order_createdAt = order_createdAt;
	}
	
	public String getOrder_deliveredAt() {
		return order_deliveredAt;
	}
	
	public void setOrder_deliveredAt(String order_deliveredAt) {
		this.order_deliveredAt = order_deliveredAt;
	}
	
	public int getUser_no() {
		return user_no;
	}
	
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}


}
