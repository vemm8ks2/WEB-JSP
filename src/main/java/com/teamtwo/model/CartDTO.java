package com.teamtwo.model;

public class CartDTO {

  private int cartId;
  private int cartProductCount;
  private int cartUserFk;
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

  public int getCartUserFk() {
    return cartUserFk;
  }

  public void setCartUserFk(int cartUserFk) {
    this.cartUserFk = cartUserFk;
  }

  public int getCartProductFk() {
    return cartProductFk;
  }

  public void setCartProductFk(int cartProductFk) {
    this.cartProductFk = cartProductFk;
  }


}
