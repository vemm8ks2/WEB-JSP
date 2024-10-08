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
      if (rs != null)
        rs.close();
      if (pstmt != null)
        pstmt.close();
      if (conn != null)
        conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public ProductDTO get(int id) {

    ProductDTO dto = null;

    try {
      open();

      String sql = "SELECT * FROM T_product WHERE product_id = ?";

      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, id);

      rs = pstmt.executeQuery();

      if (rs.next()) {
        dto = new ProductDTO();

        dto.setProductId(rs.getInt("product_id"));
        dto.setProductName(rs.getString("product_name"));
        dto.setProductPrice(rs.getInt("product_price"));
        dto.setProductStock(rs.getInt("product_stock"));
        dto.setProductImage(rs.getString("product_image"));
        dto.setProductCreatedAt(rs.getString("product_created_at"));
        dto.setProductUpdatedAt(rs.getString("product_updated_at"));
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

      String sql = "SELECT * FROM T_product ORDER BY product_id DESC";

      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();

      while (rs.next()) {
        ProductDTO dto = new ProductDTO();

        dto.setProductId(rs.getInt("product_id"));
        dto.setProductName(rs.getString("product_name"));
        dto.setProductPrice(rs.getInt("product_price"));
        dto.setProductStock(rs.getInt("product_stock"));
        dto.setProductImage(rs.getString("product_image"));
        dto.setProductCreatedAt(rs.getString("product_created_at"));
        dto.setProductUpdatedAt(rs.getString("product_updated_at"));
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

    try {
      open();

      String sql = "SELECT max(product_id) FROM T_product";

      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();

      int count = 0;

      if (rs.next())
        count = rs.getInt(1) + 1;

      sql = "INSERT INTO T_product VALUES(?, ?, ?, ?, ?, sysdate, '', ?)";

      pstmt = conn.prepareStatement(sql);

      pstmt.setInt(1, count);
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
    /**
     * TODO(24.09.03): 에러 발생 시 에러 던져주기
     */

    try {
      open();

      String sql =
          "UPDATE T_product SET product_price = ?, product_stock = ?, product_updated_at = sysdate WHERE product_id = ?";

      pstmt = conn.prepareStatement(sql);

      pstmt.setInt(1, dto.getProductPrice());
      pstmt.setInt(2, dto.getProductStock());
      pstmt.setInt(3, dto.getProductId());

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

      String sql = "DELETE FROM T_product WHERE product_id = ?";

      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, id);

      pstmt.executeUpdate();

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }

  }


  public List<ProductDTO> searchByKeyword(String name) {
    List<ProductDTO> list = new ArrayList<>();

    try {
      open();

      String sql = "SELECT * FROM T_product WHERE product_name LIKE ?";

      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, "%" + name + "%");

      rs = pstmt.executeQuery();

      while (rs.next()) {
        ProductDTO dto = new ProductDTO();

        dto.setProductId(rs.getInt("product_id"));
        dto.setProductName(rs.getString("product_name"));
        dto.setProductPrice(rs.getInt("product_price"));
        dto.setProductStock(rs.getInt("product_stock"));
        dto.setProductImage(rs.getString("product_image"));
        dto.setProductCreatedAt(rs.getString("product_created_at"));
        dto.setProductUpdatedAt(rs.getString("product_updated_at"));
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

  public List<ProductDTO> searchByKeywordAndFilter(SearchDTO dto) {
    List<ProductDTO> list = new ArrayList<>();

    /* SQL문 예시
      SELECT * 
      FROM (
          SELECT ROWNUM AS pnum, p.* 
          FROM (
              SELECT *
              FROM t_product
              WHERE upper(product_name) LIKE upper('%%')
              ORDER BY product_price DESC
          ) p
      ) 
      WHERE pnum >= 1 AND pnum <= 10;
     */

    try {
      open();

      String sql =
          "SELECT * "
          + "FROM ("
          +     "SELECT ROWNUM AS pnum, p.* "
          +     "FROM ("
          +         "SELECT * "
          +         "FROM t_product "
          +         "WHERE upper(product_name) LIKE upper(?)";

      if (dto.getPrice() != null) {
        String price = dto.getPrice();

        sql += " AND ";

        if (price.equals("60000~")) {
          sql += "product_price >= 60000";
        } else if (price.equals("30000~60000")) {
          sql += "product_price BETWEEN 30000 AND 60000";
        } else if (price.equals("10000~30000")) {
          sql += "product_price BETWEEN 10000 AND 30000";
        } else if (price.equals("~10000")) {
          sql += "produce_price <= 10000";
        }
      }

      /**
       * TODO(24.09.12): 현재는 카테고리가 정확하게 맞아야 해당하는 상품을 보여주지만 부모 카테고리를 선택했을 때 자식 카테고리에 해당하는 상품도 보여지도록
       * 하는 것이 적절할 것이다.
       */
      if (dto.getCategories() != null && dto.getCategories().length > 0) {
        String[] categories = dto.getCategories();

        sql += " AND product_category_fk in(";

        for (int i = 0; i < categories.length; i++) {
          if (i == categories.length - 1) {
            sql += categories[i];
          } else {
            sql += (categories[i] + ",");
          }
        }

        sql += ")";
      }

      if (dto.getSort() != null) {
        String sort = dto.getSort();

        sql += " ORDER BY ";

        if (sort.equals("latest")) {
          sql += "product_created_at DESC";
        } else if (sort.equals("earliest")) {
          sql += "product_created_at";
        } else if (sort.equals("low-to-high")) {
          sql += "product_price";
        } else if (sort.equals("high-to-low")) {
          sql += "product_price DESC";
        }
      }
      
      sql += ") p ) WHERE pnum >= ? AND pnum <= ?";

      pstmt = conn.prepareStatement(sql);

      if (dto.getKeyword() == null) {
        pstmt.setString(1, "%" + "%");
      } else {
        pstmt.setString(1, "%" + dto.getKeyword() + "%");
      }
      
      int page = dto.getPagination().getCurrPage();
      int row = dto.getPagination().getRow();
      
      int sNum = (page * row) - (row - 1);
      int eNum = page * row;
      
      pstmt.setInt(2, sNum);
      pstmt.setInt(3, eNum);

      rs = pstmt.executeQuery();

      while (rs.next()) {
        ProductDTO product = new ProductDTO();

        product.setProductId(rs.getInt("product_id"));
        product.setProductName(rs.getString("product_name"));
        product.setProductPrice(rs.getInt("product_price"));
        product.setProductStock(rs.getInt("product_stock"));
        product.setProductImage(rs.getString("product_image"));
        product.setProductCreatedAt(rs.getString("product_created_at"));
        product.setProductUpdatedAt(rs.getString("product_updated_at"));
        product.setProductCategoryFk(rs.getInt("product_category_fk"));

        list.add(product);
      }

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }

    return list;
  }

  public List<ProductDTO> getProductsByIds(String[] ids) {
    List<ProductDTO> list = new ArrayList<>();

    if (ids.length == 0)
      return list;

    try {
      open();

      String sql = "SELECT * FROM t_product WHERE product_id in (";

      for (int i = 0; i < ids.length; i++) {
        if (i == ids.length - 1)
          sql += ids[i];
        else
          sql += ids[i] + ",";
      }

      sql += ")";

      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();

      while (rs.next()) {
        ProductDTO product = new ProductDTO();

        product.setProductId(rs.getInt("product_id"));
        product.setProductName(rs.getString("product_name"));
        product.setProductPrice(rs.getInt("product_price"));
        product.setProductStock(rs.getInt("product_stock"));
        product.setProductImage(rs.getString("product_image"));
        product.setProductCreatedAt(rs.getString("product_created_at"));
        product.setProductUpdatedAt(rs.getString("product_updated_at"));
        product.setProductCategoryFk(rs.getInt("product_category_fk"));

        list.add(product);
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }

    return list;
  }

  public int getProductCount() {
    int cnt = 0;

    try {
      open();

      String sql = "SELECT count(*) FROM t_product";

      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();

      if (rs.next())
        cnt = rs.getInt(1);

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }

    return cnt;
  }
  
  public int getProductCountByKeywordAndFilter(SearchDTO dto) {
    int cnt = 0;
    
    try {
      open();
      
      String sql = "SELECT count(*) FROM t_product WHERE upper(product_name) LIKE upper(?)";

      if (dto.getPrice() != null) {
        String price = dto.getPrice();

        sql += " AND ";

        if (price.equals("60000~")) {
          sql += "product_price >= 60000";
        } else if (price.equals("30000~60000")) {
          sql += "product_price BETWEEN 30000 AND 60000";
        } else if (price.equals("10000~30000")) {
          sql += "product_price BETWEEN 10000 AND 30000";
        } else if (price.equals("~10000")) {
          sql += "produce_price <= 10000";
        }
      }

      /**
       * TODO(24.09.12): 현재는 카테고리가 정확하게 맞아야 해당하는 상품을 보여주지만 부모 카테고리를 선택했을 때 자식 카테고리에 해당하는 상품도 보여지도록
       * 하는 것이 적절할 것이다.
       */
      if (dto.getCategories() != null && dto.getCategories().length > 0) {
        String[] categories = dto.getCategories();

        sql += " AND product_category_fk in(";

        for (int i = 0; i < categories.length; i++) {
          if (i == categories.length - 1) {
            sql += categories[i];
          } else {
            sql += (categories[i] + ",");
          }
        }

        sql += ")";
      }
      
      pstmt = conn.prepareStatement(sql);

      if (dto.getKeyword() == null) {
        pstmt.setString(1, "%" + "%");
      } else {
        pstmt.setString(1, "%" + dto.getKeyword() + "%");
      }
      
      rs = pstmt.executeQuery();

      if (rs.next())
        cnt = rs.getInt(1);
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }
    
    return cnt;
  }

}
