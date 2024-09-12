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

public class AdminDAO implements BaseDAO<AdminDTO> {

  private Connection conn = null;
  private PreparedStatement pstmt = null;
  private ResultSet rs = null;
  String sql = null;

  private static AdminDAO instance = null;

  private AdminDAO() {}

  public static AdminDAO getInstance() {
    if (instance == null)
      instance = new AdminDAO();

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
  public AdminDTO get(int id) {
    AdminDTO dto = null;

    try {
      open();

      sql = "select * from t_admin where admin_id = ?";

      pstmt = conn.prepareStatement(sql);

      pstmt.setInt(1, id);

      rs = pstmt.executeQuery();

      if (rs.next()) {
        dto = new AdminDTO();
        dto.setAdminId(rs.getInt("admin_id"));
        dto.setAdminLoginId(rs.getString("admin_login_id"));
        dto.setAdminPassword(rs.getString("admin_password"));
        dto.setAdminName(rs.getString("admin_name"));
        dto.setAdminEmail(rs.getString("admin_email"));
        dto.setAdminPhoneNumber(rs.getString("admin_phone_number"));
        dto.setAdminCreateAt(rs.getString("admin_create_at"));
        dto.setAdminLastAccessedAt(rs.getString("admin_last_accessed_at"));
        dto.setAdminLastAccessedIp(rs.getString("admin_last_accessed_ip"));
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }

    return dto;
  } // AdminDTo get() end

  @Override
  public List<AdminDTO> getAll() {
    List<AdminDTO> list = new ArrayList<>();

    try {
      open();

      sql = "select * from t_admin";

      pstmt = conn.prepareStatement(sql);

      rs = pstmt.executeQuery();

      while (rs.next()) {

        AdminDTO dto = new AdminDTO();

        dto.setAdminId(rs.getInt("admin_id"));
        dto.setAdminLoginId(rs.getString("admin_login_id"));
        dto.setAdminPassword(rs.getString("admin_password"));
        dto.setAdminName(rs.getString("admin_name"));
        dto.setAdminEmail(rs.getString("admin_email"));
        dto.setAdminPhoneNumber(rs.getString("admin_Phone_number"));
        dto.setAdminCreateAt(rs.getString("admin_create_at"));
        dto.setAdminLastAccessedAt(rs.getString("admin_last_accessed_at"));
        dto.setAdminLastAccessedIp(rs.getString("admin-last_accessed_ip"));

        list.add(dto);
      }

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }

    return list;
  } // List<> end

  @Override
  public void save(AdminDTO dto) {
    try {
      open();

      sql = "insert into t_admin (admin_id, admin_login_id, admin_password, "
          + " admin_name, admin_email, admin_phone_number, admin_create_at,"
          + " admin_last_accessed_at, admin_last_accessed_ip) "
          + " values(?,?,?,?,?,?,sysdate,?,?)";

      pstmt = conn.prepareStatement(sql);

      pstmt.setInt(1, dto.getAdminId());
      pstmt.setString(2, dto.getAdminLoginId());
      pstmt.setString(3, dto.getAdminPassword());
      pstmt.setString(4, dto.getAdminName());
      pstmt.setString(5, dto.getAdminEmail());
      pstmt.setString(6, dto.getAdminPhoneNumber());
      pstmt.setString(7, dto.getAdminLastAccessedAt());
      pstmt.setString(8, dto.getAdminLastAccessedIp());

      pstmt.executeUpdate();

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }
  } // save() end

  @Override
  public void update(AdminDTO dto) {

    try {
      open();

      sql = "select * from t_admin where admin_id = ?";

      pstmt = conn.prepareStatement(sql);

      pstmt.setInt(1, dto.getAdminId());

      rs = pstmt.executeQuery();

      if (rs.next()) {
        if (dto.getAdminPassword().equals(rs.getString("adminloginid"))) {

          sql = "update t_admin set" + " admin_name = ?" + " admin_phone_number = ?"
              + " where admin_id = ?";

          pstmt = conn.prepareStatement(sql);

          pstmt.setString(1, dto.getAdminName());
          pstmt.setString(2, dto.getAdminPhoneNumber());
          pstmt.setInt(3, dto.getAdminId());

          pstmt.executeUpdate();
        } else {
          // 비밀번호 불일치 처리
        }
      }

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }

  } // update() end

  @Override
  public void delete(int id) {

    try {
      open();

      sql = "select * from t_admin where admin_id = ?";

      pstmt = conn.prepareStatement(sql);

      pstmt.setInt(1, id);

      rs = pstmt.executeQuery();

      if (rs.next()) {

        sql = "delete from t_admin where admin_id = ?";

        pstmt = conn.prepareStatement(sql);

        pstmt.setInt(1, id);

        pstmt.executeUpdate();

      } // if end

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }

  } // delete() end

  /**
   * 로그인 아이디로 어드민 데이터를 가져옵니다.
   * 
   * @param 어드민의 로그인 아이디를 인자로 받습니다.
   * @author skwns0472
   */
  public AdminDTO getAdminByLoginId(String loginId) { 
    AdminDTO dto = null;

    try {
      open();

      sql = "SELECT * FROM t_admin WHERE admin_login_id = ?";

      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, loginId);

      rs = pstmt.executeQuery();

      if (rs.next()) {
        dto = new AdminDTO();

        dto.setAdminId(rs.getInt("admin_id"));
        dto.setAdminLoginId(rs.getString("admin_login_id"));
        dto.setAdminPassword(rs.getString("admin_password"));
        dto.setAdminName(rs.getString("admin_name"));
        dto.setAdminEmail(rs.getString("admin_email"));
        /**
         * TODO(24.09.12): 어드민 테이블의 열 이름이 틀렸으므로 수정해야합니다.
         * 현재 어드민으로 로그인 시 부적합한 열 이름 에러가 발생하는 게 맞습니다.
         * admin_phone_numbr -> admin_phone_number
         */
        dto.setAdminPhoneNumber(rs.getString("admin_phone_number"));
        dto.setAdminCreateAt(rs.getString("admin_create_at"));
        dto.setAdminLastAccessedAt(rs.getString("admin_last_accessed_at"));
        dto.setAdminLastAccessedIp(rs.getString("admin_last_accessed_ip"));
      }


    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      close();
    }

    return dto;

  } // getAdminByLoginId() end

} // class end
