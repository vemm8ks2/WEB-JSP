package com.teamtwo.model;

public class CategoryDTO {
	
	private String categoryId;
	private String categoryName;
	private String categoryParentFk;
	
	public String getCategoryId() {
		return categoryId;
	}
	
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	
	public String getCategoryName() {
		return categoryName;
	}
	
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	public String getCategoryParentFk() {
		return categoryParentFk;
	}
	
	public void setCategoryParentFk(String categoryParentFk) {
		this.categoryParentFk = categoryParentFk;
	}
	
}
