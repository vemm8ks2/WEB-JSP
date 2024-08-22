package com.teamtwo.model;

public class OrderProductDTO {

	private int OrderProductId;
	private String OrderProductQunatity;
	private int OrderProductUserIdFk;
	private int OrderProductProdIdFk;
	
	
	public int getOrderProductId() {
		return OrderProductId;
	}
	public void setOrderProductId(int orderProductId) {
		OrderProductId = orderProductId;
	}
	public String getOrderProductQunatity() {
		return OrderProductQunatity;
	}
	public void setOrderProductQunatity(String orderProductQunatity) {
		OrderProductQunatity = orderProductQunatity;
	}
	public int getOrderProductUserIdFk() {
		return OrderProductUserIdFk;
	}
	public void setOrderProductUserIdFk(int orderProductUserIdFk) {
		OrderProductUserIdFk = orderProductUserIdFk;
	}
	public int getOrderProductProdIdFk() {
		return OrderProductProdIdFk;
	}
	public void setOrderProductProdIdFk(int orderProductProdIdFk) {
		OrderProductProdIdFk = orderProductProdIdFk;
	}
	
}
