package com.teamtwo.model;

/**
 * 상품을 검색할 시 페이징 처리 DTO입니다. 따로 데이터베이스 테이블은 존재하지 않습니다.
 * 
 * @author vemm8ks2
 */
public class PaginationDTO {

  private int row;
  private int block;
  private int totalSize;
  private int totalPage;
  private int currPage;
  
  public int getRow() {
    return row;
  }
  
  public void setRow(int row) {
    this.row = row;
  }
  
  public int getBlock() {
    return block;
  }
  
  public void setBlock(int block) {
    this.block = block;
  }
  
  public int getTotalSize() {
    return totalSize;
  }
  
  public void setTotalSize(int totalSize) {
    this.totalSize = totalSize;
  }
  
  public int getTotalPage() {
    return totalPage;
  }
  
  public void setTotalPage(int totalPage) {
    this.totalPage = totalPage;
  }
  
  public int getCurrPage() {
    return currPage;
  }
  
  public void setCurrPage(int currPage) {
    this.currPage = currPage;
  }
  
}
