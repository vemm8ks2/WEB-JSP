package com.teamtwo.model;

public class CartResultDTO {

  CartDTO cartDTO;
  ProductDTO productDTO;
  
  public CartDTO getCartDTO() {
    return cartDTO;
  }
  
  public void setCartDTO(CartDTO cartDTO) {
    this.cartDTO = cartDTO;
  }
  
  public ProductDTO getProductDTO() {
    return productDTO;
  }
  
  public void setProductDTO(ProductDTO productDTO) {
    this.productDTO = productDTO;
  }
  
}
