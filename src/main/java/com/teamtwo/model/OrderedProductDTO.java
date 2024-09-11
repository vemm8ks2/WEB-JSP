package com.teamtwo.model;

public class OrderedProductDTO {

	private int orderedProductId;
	private int orderedProductQunatity;
	private int orderedProductOrderFk;
	private int orderedProductProductFk;
	
	public int getOrderedProductId() {
		return orderedProductId;
	}
	
	public void setOrderedProductId(int orderedProductId) {
		this.orderedProductId = orderedProductId;
	}
	
	public int getOrderedProductQunatity() {
		return orderedProductQunatity;
	}
	
	public void setOrderedProductQunatity(int orderedProductQunatity) {
		this.orderedProductQunatity = orderedProductQunatity;
	}
	
	public int getOrderedProductOrderFk() {
		return orderedProductOrderFk;
	}
	
	public void setOrderedProductOrderFk(int orderedProductOrderFk) {
		this.orderedProductOrderFk = orderedProductOrderFk;
	}
	
	public int getOrderedProductProductFk() {
		return orderedProductProductFk;
	}
	
	public void setOrderedProductProductFk(int orderedProductProductFk) {
		this.orderedProductProductFk = orderedProductProductFk;
	}
	
}
