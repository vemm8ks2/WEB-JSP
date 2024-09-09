package com.teamtwo.model;

public class OrderDTO {
	
	private int orderId; 				// 주문식별자 [id] // orderNo => orderId로 변경함.
	private String orderReceiverName; 	// 수취인 이름[receiver_name]
	private String orderReceiverPhone; 	// 수취인 연락처[receiver_phone]
	private String orderReceiverAddr; 	// 수취인 주소 [receiver_addr]
	private String orderStatus; 		// 주문상태 [order_status]
	private String orderCreatedAt; 		// 주문일 [creater_at]
	private String orderDeliveredAt; 	// 배송완료일 [delivered_at]
	private int orderCustomerFk; 			// CustomerDTO 유저식별자[customer_id] customerNo => customerId로 변경함.
	
	public int getOrderId() {
		return orderId;
	}
	
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	public String getOrderReceiverName() {
		return orderReceiverName;
	}
	
	public void setOrderReceiverName(String orderReceiverName) {
		this.orderReceiverName = orderReceiverName;
	}
	
	public String getOrderReceiverPhone() {
		return orderReceiverPhone;
	}
	
	public void setOrderReceiverPhone(String orderReceiverPhone) {
		this.orderReceiverPhone = orderReceiverPhone;
	}
	
	public String getOrderReceiverAddr() {
		return orderReceiverAddr;
	}
	
	public void setOrderReceiverAddr(String orderReceiverAddr) {
		this.orderReceiverAddr = orderReceiverAddr;
	}
	
	public String getOrderStatus() {
		return orderStatus;
	}
	
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	public String getOrderCreatedAt() {
		return orderCreatedAt;
	}
	
	public void setOrderCreatedAt(String orderCreatedAt) {
		this.orderCreatedAt = orderCreatedAt;
	}
	
	public String getOrderDeliveredAt() {
		return orderDeliveredAt;
	}
	
	public void setOrderDeliveredAt(String orderDeliveredAt) {
		this.orderDeliveredAt = orderDeliveredAt;
	}

	public int getOrderCustomerFk() {
		return orderCustomerFk;
	}

	public void setOrderCustomerFk(int orderCustomerFk) {
		this.orderCustomerFk = orderCustomerFk;
	}

}
