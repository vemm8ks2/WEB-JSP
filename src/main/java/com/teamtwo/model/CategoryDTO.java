package com.teamtwo.model;

public class CategoryDTO {

  private int categoryId;
  private String categoryName;
  private Integer categoryParentFk;

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

  public Integer getCategoryParentFk() {
    return categoryParentFk;
  }

  public void setCategoryParentFk(Integer categoryParentFk) {
    this.categoryParentFk = categoryParentFk;
  }

}
