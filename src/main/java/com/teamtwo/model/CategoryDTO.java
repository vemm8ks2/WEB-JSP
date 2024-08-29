package com.teamtwo.model;

public class CategoryDTO {

  private int categoryId;
  private String categoryName;
  private int categoryParentFk;
  
  
  public int getCategoryId() {
    return categoryId;
  }
  public void setCategoryId(int categoryId) {
    this.categoryId = categoryId;
  }
  public String getCategoryName() {
    return categoryName;
  }
  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }
  public int getCategoryParentFk() {
    return categoryParentFk;
  }
  public void setCategoryParentFk(int categoryParentFk) {
    this.categoryParentFk = categoryParentFk;
  }

  

}
