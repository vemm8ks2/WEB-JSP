package com.teamtwo.model;

public class OrderedProductDTO {

	private int orderedProductId;
	private int orderedProductQunatity;
	private int orderedProductCustomerIdFk;
	private int orderedProductProdIdFk;
	
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
	
	public int getOrderedProductCustomerIdFk() {
		return orderedProductCustomerIdFk;
	}
	
	public void setOrderedProductCustomerIdFk(int orderedProductCustomerIdFk) {
		this.orderedProductCustomerIdFk = orderedProductCustomerIdFk;
	}
	
	public int getOrderedProductProdIdFk() {
		return orderedProductProdIdFk;
	}
	
	public void setOrderedProductProdIdFk(int orderedProductProdIdFk) {
		this.orderedProductProdIdFk = orderedProductProdIdFk;
	}
	
	
	
}
