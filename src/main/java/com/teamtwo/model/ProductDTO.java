package com.teamtwo.model;

public class ProductDTO {
	
	private String Product_id;
	private String Product_name;
	private String Product_price;
	private String Product_stock;
	private String Product_image;
	private String Product_createdAt;
	private String Product_updatedAt;
	private String Productcategory_id;
	
	
	public String getProduct_id() {
		return Product_id;
	}
	public void setProduct_id(String product_id) {
		Product_id = product_id;
	}
	public String getProduct_name() {
		return Product_name;
	}
	public void setProduct_name(String product_name) {
		Product_name = product_name;
	}
	public String getProduct_price() {
		return Product_price;
	}
	public void setProduct_price(String product_price) {
		Product_price = product_price;
	}
	public String getProduct_stock() {
		return Product_stock;
	}
	public void setProduct_stock(String product_stock) {
		Product_stock = product_stock;
	}
	public String getProduct_image() {
		return Product_image;
	}
	public void setProduct_image(String product_image) {
		Product_image = product_image;
	}
	public String getProduct_createdAt() {
		return Product_createdAt;
	}
	public void setProduct_createdAt(String product_createdAt) {
		Product_createdAt = product_createdAt;
	}
	public String getProduct_updatedAt() {
		return Product_updatedAt;
	}
	public void setProduct_updatedAt(String product_updatedAt) {
		Product_updatedAt = product_updatedAt;
	}
	public String getProductcategory_id() {
		return Productcategory_id;
	}
	public void setProductcategory_id(String productcategory_id) {
		Productcategory_id = productcategory_id;
	}

}
