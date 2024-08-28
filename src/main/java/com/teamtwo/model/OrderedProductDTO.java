package com.teamtwo.model;

public class OrderedProductDTO {

  private int orderedProductId;
  private int orderedProductQunatity;
  private int orderedProductUserIdFk;
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

  public int getOrderedProductUserIdFk() {
    return orderedProductUserIdFk;
  }

  public void setOrderedProductUserIdFk(int orderedProductUserIdFk) {
    this.orderedProductUserIdFk = orderedProductUserIdFk;
  }

  public int getOrderedProductProdIdFk() {
    return orderedProductProdIdFk;
  }

  public void setOrderedProductProdIdFk(int orderedProductProdIdFk) {
    this.orderedProductProdIdFk = orderedProductProdIdFk;
  }



}
