package com.teamtwo.api;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.teamtwo.model.ProductDAO;
import com.teamtwo.model.ProductDTO;

@WebServlet("/product")
public class Product extends ApiServlet {
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    ProductDAO dao = ProductDAO.getInstance();

    JSONObject json = new JSONObject();
    json.put("productList", dao.getAll());

    response.setContentType("application/json; charset=utf-8");
    response.getWriter().print(json);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    /**
     * TODO(24.09.19): 테이블 칼럼 추가 및 기존 이미지 경로 DB 수정
     */
    int fileSize = 10 * 1024 * 1024;
    
    MultipartRequest multi =
        new MultipartRequest(request, saveImagePath, fileSize, "UTF-8", new DefaultFileRenamePolicy());

    String name = multi.getParameter("product_name");
    String price = multi.getParameter("product_price");
    String stock = multi.getParameter("product_stock");
    File image = multi.getFile("product_image");
    String desc = multi.getParameter("product_description");
    String category = multi.getParameter("product_category");
    
    ProductDTO dto = new ProductDTO();
    
    dto.setProductName(name);
    dto.setProductPrice(Integer.parseInt(price));
    dto.setProductStock(Integer.parseInt(stock));
    dto.setProductImage(getFilePath(image));
    // dto.setDescription(desc); 
    dto.setProductCategoryFk(Integer.parseInt(category));
    
    ProductDAO dao = ProductDAO.getInstance();
    
    dao.save(dto);

    JSONObject json = new JSONObject();
    json.put("msg", "상품 생성 성공.");

    response.setContentType("application/json; charset=utf-8");
    response.getWriter().print(json);
  }

  protected void doPut(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {}

  protected void doDelete(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {}

  
}
