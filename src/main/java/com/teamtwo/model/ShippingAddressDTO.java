package com.teamtwo.model;

public class ShippingAddressDTO {
	
	private int shippingAddressId;
	private String shippingAddressDestination;
	private String shippingAddressIsDefault;
	private int shippingAddressCustomerFk;
	
	public int getShippingAddressId() {
		return shippingAddressId;
	}
	public void setShippingAddressId(int shippingAddressId) {
		this.shippingAddressId = shippingAddressId;
	}
	public String getShippingAddressDestination() {
		return shippingAddressDestination;
	}
	public void setShippingAddressDestination(String shippingAddressDestination) {
		this.shippingAddressDestination = shippingAddressDestination;
	}
	public String getShippingAddressIsDefault() {
		return shippingAddressIsDefault;
	}
	public void setShippingAddressIsDefault(String shippingAddressIsDefault) {
		this.shippingAddressIsDefault = shippingAddressIsDefault;
	}
	public int getShippingAddressCustomerFk() {
		return shippingAddressCustomerFk;
	}
	public void setShippingAddressCustomerFk(int shippingAddressCustomerFk) {
		this.shippingAddressCustomerFk = shippingAddressCustomerFk;
	}
}
	
