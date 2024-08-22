package com.teamtwo.model;

public class OrderProductDTO {

	private int Order_product_id;
	private String Order_product_qunatity;
	private int Order_product_user_id;
	private int Order_product_prod_id;
	
	
	public int getOrder_product_id() {
		return Order_product_id;
	}
	public void setOrder_product_id(int order_product_id) {
		Order_product_id = order_product_id;
	}
	public String getOrder_product_qunatity() {
		return Order_product_qunatity;
	}
	public void setOrder_product_qunatity(String order_product_qunatity) {
		Order_product_qunatity = order_product_qunatity;
	}
	public int getOrder_product_user_id() {
		return Order_product_user_id;
	}
	public void setOrder_product_user_id(int order_product_user_id) {
		Order_product_user_id = order_product_user_id;
	}
	public int getOrder_product_prod_id() {
		return Order_product_prod_id;
	}
	public void setOrder_product_prod_id(int order_product_prod_id) {
		Order_product_prod_id = order_product_prod_id;
	}
	
}
