package com.teamtwo.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.teamtwo.model.ProductDAO;
import com.teamtwo.model.ProductDTO;

public class ModifyProductAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
    
    //상품 이미지 저장 경로
    String saveFolder = "";
    
    //첨부파일 용량(크기) 제한 - 파일 업로드 최대 크기
    int fileSize = 10 * 1024 * 1024; //10MB
    
    //파일 업로드를 위한 객체 생성
    MultipartRequest multi = new MultipartRequest(
                               request,     //request 객체
                               saveFolder,  //첨푸파일이 저장될 위치
                               fileSize,    //첨부 파일 최대 크기
                               "UTF-8",     //한글 처리
                               new DefaultFileRenamePolicy()
                               );
    
    //프론트에서 넘어온 데이터 받기
    int product_id = Integer.parseInt(multi.getParameter("product_id").trim());
    String product_name = multi.getParameter("product_name").trim();
    int product_price = Integer.parseInt(multi.getParameter("product_price").trim());
    int product_stock = Integer.parseInt(multi.getParameter("product_stock").trim());
    
    //상품 이미지 재등록
    String product_image = multi.getFilesystemName("p_image_new");
    
    if(product_image == null) {
      product_image = multi.getParameter("p_image_old");
    }
        
    ProductDTO dto = new ProductDTO();
    
    dto.setProductId(product_id);
    dto.setProductName(product_name);
    dto.setProductPrice(product_price);
    dto.setProductStock(product_stock);
    dto.setProductImage(product_image);
    
    ProductDAO dao = ProductDAO.getInstance();
    
    dao.update(dto);
    
    return null;
  }

}
