package com.teamtwo.model;

public class ShippingAddressDTO {

  private int shippingAddressId;
  private String shippingAddressAddress;
  private String shippingAddressIsDefault;
  private int shippingAddressUserIdFk;

  public int getShippingAddressId() {
    return shippingAddressId;
  }

  public void setShippingAddressId(int shippingAddressId) {
    this.shippingAddressId = shippingAddressId;
  }

  public String getShippingAddressAddress() {
    return shippingAddressAddress;
  }

  public void setShippingAddressAddress(String shippingAddressAddress) {
    this.shippingAddressAddress = shippingAddressAddress;
  }

  public String getShippingAddressIsDefault() {
    return shippingAddressIsDefault;
  }

  public void setShippingAddressIsDefault(String shippingAddressIsDefault) {
    this.shippingAddressIsDefault = shippingAddressIsDefault;
  }

  public int getShippingAddressUserIdFk() {
    return shippingAddressUserIdFk;
  }

  public void setShippingAddressUserIdFk(int shippingAddressUserIdFk) {
    this.shippingAddressUserIdFk = shippingAddressUserIdFk;
  }

}
