package com.teamtwo.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class AdminDAO {
	   
	   // DB와 연결하는 객체
	   Connection con = null;
	   
	   // DB에 SQL문을 전송하는 객체
	   PreparedStatement pstmt = null;
	   
	   // SQL문을 실행한 후에 결과값을 가지고 있는 객체
	   ResultSet rs = null;
	   
	   // SQL문을 저장할 변수
	   String sql = null;
	   
	   private static AdminDAO instance = null;
	   
	   private AdminDAO() {} //기본 생성자.
	   
	   //외부에서 접근할 수 있도록 해주는 메서드.
	   public static AdminDAO getInstance() {
	      if(instance==null) {
	         instance = new AdminDAO();
	      }
	      return instance;
	   }//getInstance end
	   
	   //DB연동하는 작업을 진행하는 메서드
	   public void openConn() {
	      try {
	         // JNDI 서버 객체 생성.
	         Context initCtx = new InitialContext();
	         // Context 객체 얻어오기.
	         Context ctx = (Context)initCtx.lookup("java:comp/env");
	         // lookup() 메서드를 이용하여 매칭되는 커넥션을 찾아옴.
	         DataSource ds = (DataSource)ctx.lookup("jdbc/myoracle");
	         // DataSource 객체를 이용하여 커넥션을 하나 가져옴.
	         con = ds.getConnection();
	      }//try end 
	      catch (Exception e) {
	         e.printStackTrace();
	      }//catch end
	   }//openConn()end
	   
	   // DB에 연결된 ( rs, pstmt, con )자원을 종료하는 메서드 
	   public void closeConn(ResultSet rs, PreparedStatement pstmt, Connection con ) {
	      
	         try {
	            
	            if(rs != null) rs.close();
	            
	            if(pstmt != null) pstmt.close();
	            
	            if(con != null) con.close();
	            
	         } //try end
	         catch (SQLException e) {
	            e.printStackTrace();
	         } //catch end
	   }//closeConn(rs,pstmt,con) end
	   
	   // DB에 연결된 ( pstmt, con )자원을 종료하는 메서드 
	   public void closeConn(PreparedStatement pstmt, Connection con) {
	      
	         try {
	            
	            if(pstmt != null) pstmt.close();
	            
	            if(con != null) con.close();
	            
	         }//try end
	         catch (SQLException e) 
	         {
	            e.printStackTrace();
	         }//catch end
	         
	   }//closeConn(pstmt,con) end
	   
	   //관리자인지 여부를 확인하는 메서드
	   public int adminCheck(String id, String pwd){
	      int result =0;
	      
	      
	      try {
	         openConn();
	         sql = "select * from admin_test where admin_id =?";
	         pstmt = con.prepareStatement(sql);
	         pstmt.setString(1, id);
	         rs = pstmt.executeQuery();
	         
	         if(rs.next()) {
	            if(pwd.equals(rs.getString("admin_pwd"))) {
	               result = 1;
	            }//if(pwd.equals~) end
	            else { //비밀번호가 일치하지 않다면~
	               result = -1;
	            }//else end
	         }//if(rs.next()) end
	      }//try end 
	      catch (SQLException e) {
	         e.printStackTrace();
	      }//catch end
	      finally {
	         closeConn(rs, pstmt, con);
	      }
	      return result;
	   }//adminCheck(admin_id, admin_pwd) end
	   
	   //admin 상세 정보를 조회하는 메서드
	   public AdminDTO getAdmin(String id) {
	      AdminDTO dto = null;
	      
	      
	      try {
	         openConn();
	         sql ="select * from admin_test where admin_id =?";
	         pstmt = con.prepareStatement(sql);
	         pstmt.setString(1, id);
	         rs = pstmt.executeQuery();
	         if(rs.next()) {
	            dto = new AdminDTO();
	            
	            dto.setAdminId(rs.getInt(1));
	            dto.setAdminLoginId(rs.getString(2));
	            dto.setAdminPassword(rs.getString(3));
	            dto.setAdminName(rs.getString(4));
	            dto.setAdminPhoneNumber(rs.getString(5));
	            dto.setAdminCreateAt(rs.getString(6));
	            dto.setAdminLastAccessedAt(rs.getString(7));
	            dto.setAdminLastAccessedIp(rs.getString(8));
	            
	         }
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	      finally {
	         closeConn(rs, pstmt, con);
	      }
	      return dto;
	      
	   }//getAdmin(admin_id) end
	   
	   //1-1 상품 만들기 메서드(Create)
	      public int productCreate(ProductDTO dto) {
	         int result =0, count =0;
	         
	         openConn();
	         
	         try {
	            
	            sql ="select max(product_id) from T_product";
	            
	            pstmt = con.prepareStatement(sql);
	            
	            rs = pstmt.executeQuery();
	            
	            if(rs.next()) {
	               count = rs.getInt(1)+1;
	            }
	            
	            sql = "insert into T_product values(?,?,?,?,?,sysdate,sysdate,?)";
	            
	            pstmt =con.prepareStatement(sql);
	            
	            pstmt.setInt(1, count);
	            pstmt.setString(2, dto.getProductName());
	            pstmt.setInt(3, dto.getProductPrice());
	            pstmt.setInt(4, dto.getProductStock());
	            pstmt.setString(5, dto.getProductImage());
	            pstmt.setString(6, dto.getProductCreatedAt());
	            pstmt.setString(7, dto.getProductUpdatedAt());
	            pstmt.setInt(8, dto.getProductCategoryFk());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	            
	            result =pstmt.executeUpdate();
	         } 
	         catch (SQLException e) {
	            e.printStackTrace();
	         }
	         finally {
	            closeConn(rs, pstmt, con);
	         }
	         return result;
	      }// productCreate(ProductDTO dto) end
	      
	   //2-1 상품 전체 목록 메서드(Read) 
	   public List<ProductDTO> getProductList(){
	      
	      List<ProductDTO> list = new ArrayList<ProductDTO>();
	   
	      try {
	         
	         openConn();
	         
	         sql= "select * from T_product order by product_id desc";
	         
	         pstmt = con.prepareStatement(sql);
	         
	         rs = pstmt.executeQuery();
	         
	         while (rs.next()) {
	            ProductDTO dto = new ProductDTO();
	            
	            dto.setProductId(rs.getInt("product_id"));
	            dto.setProductName(rs.getString("product_name"));
	            dto.setProductPrice(rs.getInt("product_price"));
	            dto.setProductStock(rs.getInt("product_stock"));
	            dto.setProductImage(rs.getString("product_image"));
	            dto.setProductCreatedAt(rs.getString("product_createdAt"));
	            dto.setProductUpdatedAt(rs.getString("product_updatedAt"));
	            dto.setProductCategoryFk(rs.getInt("product_category_fk"));
	            
	            list.add(dto);
	         }
	      } 
	      catch (SQLException e) {
	         e.printStackTrace();
	      }
	      
	      finally {
	         closeConn(rs, pstmt, con);
	      }
	      return list;
	      
	   }//getProductList() end
	   
	   //2-2 아이디별로 하나의 상품 가져오는 메소드
	   public ProductDTO getProductContent(int id) {
	      ProductDTO dto = null;
	      
	      try {

	         openConn();
	         
	         sql="select * from T_product where product_id =?";
	         
	         pstmt = con.prepareStatement(sql);
	         
	         pstmt.setInt(1, id);
	         
	         rs = pstmt.executeQuery();
	         
	         if(rs.next()) {
	            dto = new ProductDTO();
	            
	            dto.setProductId(rs.getInt("product_id"));
	            dto.setProductName(rs.getString("product_name"));
	            dto.setProductPrice(rs.getInt("product_price"));
	            dto.setProductStock(rs.getInt("product_stock"));
	            dto.setProductImage(rs.getString("product_image"));
	            dto.setProductCreatedAt(rs.getString("product_createdAt"));
	            dto.setProductUpdatedAt(rs.getString("product_updatedAt"));
	            dto.setProductCategoryFk(rs.getInt("product_category_fk"));
	            
	         }
	         
	      } 
	      catch (SQLException e) {
	         e.printStackTrace();
	      }
	      finally {
	         closeConn(rs, pstmt, con);
	      }
	      
	      return dto;
	   }//getProductContent(int id)end
}
