package com.teamtwo.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.teamtwo.model.CustomerDAO;
import com.teamtwo.model.CustomerDTO;

public class ShowAllCustomerAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
    
    CustomerDAO dao = CustomerDAO.getInstance();
    
    List<CustomerDTO> list = dao.getAll();
        
    request.setAttribute("customerList", list);
    
    ActionForward forward = new ActionForward();
    
    forward.setRedirect(false);
    
    forward.setPath("view/customer_list.jsp");
    
    return forward;
    
  }

}
