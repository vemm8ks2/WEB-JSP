package com.teamtwo.model;

public class ProductDTO {
	
	private int productId; 				// 상품식별자
	private String productName; 		// 상품명
	private int productPrice;			// 상품가격
	private int productStock;			// 상품재고
	private String productImage;		// 상품이미지
	private String productCreatedAt;	// 상품생성일
	private String productUpdatedAt;	// 업데이트일
	private int productCategoryId;		// [ CategoryDTO ] 카테고리식별자 외래키   
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public int getProductStock() {
		return productStock;
	}
	public void setProductStock(int productStock) {
		this.productStock = productStock;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public String getProductCreatedAt() {
		return productCreatedAt;
	}
	public void setProductCreatedAt(String productCreatedAt) {
		this.productCreatedAt = productCreatedAt;
	}
	public String getProductUpdatedAt() {
		return productUpdatedAt;
	}
	public void setProductUpdatedAt(String productUpdatedAt) {
		this.productUpdatedAt = productUpdatedAt;
	}
	public int getProductCategoryId() {
		return productCategoryId;
	}
	public void setProductCategoryId(int productCategoryId) {
		this.productCategoryId = productCategoryId;
	}	

}
