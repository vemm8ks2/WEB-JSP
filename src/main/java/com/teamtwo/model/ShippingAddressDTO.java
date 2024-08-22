package com.teamtwo.model;

public class ShippingAddressDTO {
	
	private int shipping_address_id;
	private String shipping_address_address;
	private String shipping_address_is_default;
	private int shipping_address_user_id;
	
	
	public int getShipping_address_id() {
		return shipping_address_id;
	}
	public void setShipping_address_id(int shipping_address_id) {
		this.shipping_address_id = shipping_address_id;
	}
	public String getShipping_address_address() {
		return shipping_address_address;
	}
	public void setShipping_address_address(String shipping_address_address) {
		this.shipping_address_address = shipping_address_address;
	}
	public String getShipping_address_is_default() {
		return shipping_address_is_default;
	}
	public void setShipping_address_is_default(String shipping_address_is_default) {
		this.shipping_address_is_default = shipping_address_is_default;
	}
	public int getShipping_address_user_id() {
		return shipping_address_user_id;
	}
	public void setShipping_address_user_id(int shipping_address_user_id) {
		this.shipping_address_user_id = shipping_address_user_id;
	}

}
