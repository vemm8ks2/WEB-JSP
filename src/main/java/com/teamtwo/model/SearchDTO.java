package com.teamtwo.model;

/**
 * 상품을 검색할 때 사용하는 DTO입니다. 따로 데이터베이스 테이블은 존재하지 않습니다.
 * 
 * @author vemm8ks2
 */
public class SearchDTO {

  String keyword;
  String sort;
  String price;
  String[] categories;
  PaginationDTO pagination;

  public String getKeyword() {
    return keyword;
  }
  
  public void setKeyword(String keyword) {
    this.keyword = keyword;
  }
  
  public String getSort() {
    return sort;
  }
  
  public void setSort(String sort) {
    this.sort = sort;
  }
  
  public String getPrice() {
    return price;
  }
  
  public void setPrice(String price) {
    this.price = price;
  }
  
  public String[] getCategories() {
    return categories;
  }
  
  public void setCategories(String[] categories) {
    this.categories = categories;
  }

  public PaginationDTO getPagination() {
    return pagination;
  }

  public void setPagination(PaginationDTO pagination) {
    this.pagination = pagination;
  }
  
}
