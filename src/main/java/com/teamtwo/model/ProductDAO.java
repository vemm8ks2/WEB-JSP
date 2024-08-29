package com.teamtwo.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ProductDAO implements BaseDAO<ProductDTO> {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private static ProductDAO instance = null;
	
	private ProductDAO() {}
	
	public static ProductDAO getInstance() {
		if (instance == null) 
			instance = new ProductDAO();
		
		return instance;
	}
	
	private void open() {
		try {
			Context initCtx = new InitialContext();
			Context ctx = (Context) initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("jdbc/myoracle");

			conn = ds.getConnection();
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void close() {
		try {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ProductDTO get(int id) {
		ProductDTO dto = null;

		try {
			open();
			
			String sql = "select * from T_product where product_id = ?";
			
			pstmt = conn.prepareStatement(sql);
			
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
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return dto;
	}

	@Override
	public List<ProductDTO> getAll() {
		List<ProductDTO> list = new ArrayList<>();

		try {
			open();
			
			String sql = "select * from T_product order by product_id desc";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
			  
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
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return list;
	}

	@Override
	public void save(ProductDTO dto) {
	  
	  int count = 0;
	  
		try {
			open();
			
			String sql = "select max(product_id) from T_product";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
			  count = rs.getInt(1);
			}
			
			sql = "insert into T_product values(?, ?, ?, ?, ?, sysdate, '', ?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, count + 1);
			pstmt.setString(2, dto.getProductName());
			pstmt.setInt(3, dto.getProductPrice());
			pstmt.setInt(4, dto.getProductStock());
			pstmt.setString(5, dto.getProductImage());
			pstmt.setInt(6, dto.getProductCategoryFk());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
	}

	@Override
	public void update(ProductDTO dto) {
	  
		try {
			open();
			
			String sql = "update T_product set product_name = ?,"
			              + "product_price = ?, product_stock = ?,"
			              + "product_image = ?, product_updatedAt = sysdate,"
			              + "where product_id = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getProductName());
			pstmt.setInt(2, dto.getProductPrice());
			pstmt.setInt(3, dto.getProductStock());
			pstmt.setString(4, dto.getProductImage());
			pstmt.setInt(5, dto.getProductId());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	@Override
	public void delete(int id) {
	  
		try {
			open();
			
			String sql = "delete from T_produt where product_id = ?";
			
	        pstmt = conn.prepareStatement(sql);
	            
	        pstmt.setInt(1, id);
	         
	        pstmt.executeUpdate();
	            
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
	}

}
