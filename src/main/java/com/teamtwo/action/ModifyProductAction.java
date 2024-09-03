package com.teamtwo.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.teamtwo.model.ProductDAO;
import com.teamtwo.model.ProductDTO;

/**
 * 상품을 수정하는 Action입니다. 이는 주로 어드민이 제어합니다.
 * 
 * @author aeranixia
 */
public class ModifyProductAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {

    /**
     * TODO(24.09.03): 이미지 저장 경로 지정하기
     */
    // 상품 이미지 저장 경로
    String saveFolder = "";

    // 첨부파일 용량(크기) 제한 - 파일 업로드 최대 크기
    int fileSize = 10 * 1024 * 1024; // 10MB

    // 파일 업로드를 위한 객체 생성
    MultipartRequest multi = new MultipartRequest(request, // request 객체
        saveFolder, // 첨푸파일이 저장될 위치
        fileSize, // 첨부 파일 최대 크기
        "UTF-8", // 한글 처리
        new DefaultFileRenamePolicy());

    // 프론트에서 넘어온 데이터 받기
    int productId = Integer.parseInt(multi.getParameter("product_id").trim());
    String productName = multi.getParameter("product_name").trim();
    int productPrice = Integer.parseInt(multi.getParameter("product_price").trim());
    int productStock = Integer.parseInt(multi.getParameter("product_stock").trim());

    // 상품 이미지 재등록
    String productImage = multi.getFilesystemName("p_image_new");

    if (productImage == null) {
      productImage = multi.getParameter("p_image_old");
    }

    ProductDTO dto = new ProductDTO();

    dto.setProductId(productId);
    dto.setProductName(productName);
    dto.setProductPrice(productPrice);
    dto.setProductStock(productStock);
    dto.setProductImage(productImage);

    ProductDAO dao = ProductDAO.getInstance();

    /**
     * TODO(24.09.03): 에러핸들링
     */
    dao.update(dto);

    return null;
  }

}
