package com.teamtwo.model;

public class CartDTO {
	
	private int cartId;
	private int cartProductCount;
	private int cartCustomerFk;
	private int cartProductFk;
	
	public int getCartId() {
		return cartId;
	}
	
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	
	public int getCartProductCount() {
		return cartProductCount;
	}
	
	public void setCartProductCount(int cartProductCount) {
		this.cartProductCount = cartProductCount;
	}
	
	public int getCartCustomerFk() {
		return cartCustomerFk;
	}
	
	public void setCartCustomerFk(int cartCustomerFk) {
		this.cartCustomerFk = cartCustomerFk;
	}
	
	public int getCartProductFk() {
		return cartProductFk;
	}
	
	public void setCartProductFk(int cartProductFk) {
		this.cartProductFk = cartProductFk;
	}
	
	
}
