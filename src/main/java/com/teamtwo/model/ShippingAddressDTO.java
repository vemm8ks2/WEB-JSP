package com.teamtwo.model;

public class ShippingAddressDTO {
	
	private int ShippingAddressId;
	private String ShippingAddressAddress;
	private String ShippingAddressIsDefault;
	private int ShippingAddressUserIdFk;
	
	
	public int getShippingAddressId() {
		return ShippingAddressId;
	}
	public void setShippingAddressId(int shippingAddressId) {
		ShippingAddressId = shippingAddressId;
	}
	public String getShippingAddressAddress() {
		return ShippingAddressAddress;
	}
	public void setShippingAddressAddress(String shippingAddressAddress) {
		ShippingAddressAddress = shippingAddressAddress;
	}
	public String getShippingAddressIsDefault() {
		return ShippingAddressIsDefault;
	}
	public void setShippingAddressIsDefault(String shippingAddressIsDefault) {
		ShippingAddressIsDefault = shippingAddressIsDefault;
	}
	public int getShippingAddressUserIdFk() {
		return ShippingAddressUserIdFk;
	}
	public void setShippingAddressUserIdFk(int shippingAddressUserIdFk) {
		ShippingAddressUserIdFk = shippingAddressUserIdFk;
	}

}
