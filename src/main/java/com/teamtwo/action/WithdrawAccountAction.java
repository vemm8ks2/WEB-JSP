package com.teamtwo.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teamtwo.model.CartDAO;
import com.teamtwo.model.CustomerDAO;
import com.teamtwo.model.OrderDAO;
import com.teamtwo.model.ShippingAddressDAO;

/**
 * 유저의 계정을 삭제하는 Action 입니다.
 * 
 * @author hsheeh
 */
public class WithdrawAccountAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
    
    /**
     * TODO(24.09.03): 유저의 삭제는 본인만 진행해야 합니다. 그렇기 때문에 세션으로부터 유저의 정보를 가져온 후 해당 유저를 삭제해야 합니다.
     * 만약 어드민의 유저 삭제 기능이 추가된다면 파라미터로 받을 수는 있겠으나 어드민 인증이 선행되어야 합니다. 
     */
    int customerId = Integer.parseInt(request.getParameter("customerId").trim());
    
    ShippingAddressDAO sdao = ShippingAddressDAO.getInstance();
    sdao.delete(customerId);
    
    CartDAO cdao = CartDAO.getInstance();
    cdao.delete(customerId);
    
    //OrderDAO odao = OrderDAO.getInstance();
    //odao.delete(customerId);
    
    CustomerDAO dao = CustomerDAO.getInstance();
    dao.delete(customerId);
    
    
    /**
     * 주문은 삭제하면 안될 것 같은디 회원탈퇴를 하더라도 주문내역을 볼 수 있도록 해야함 ex)전화번호 조회
     * 배송완료가 되지 않은 상품을 봐야하니까 ~ 
     * 
     */
    
    return null;
  }

}
