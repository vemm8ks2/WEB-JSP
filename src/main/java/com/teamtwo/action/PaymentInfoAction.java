package com.teamtwo.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.teamtwo.model.PaymentResponseDTO;

public class PaymentInfoAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {

    String impUid = request.getParameter("imp_uid");
    String accessToken = request.getParameter("access_token");

    URL url = new URL("https://api.iamport.kr/payments/" + impUid);
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();

    conn.setRequestMethod("GET"); // http 메서드
    conn.setRequestProperty("Authorizaion", accessToken); // header의 accessToken
    conn.setDoOutput(true); // 서버로부터 받는 값이 있다면 true

    // 서버로부터 데이터 읽어오기
    BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
    StringBuilder sb = new StringBuilder();
    String line = null;

    while ((line = br.readLine()) != null) { // 읽을 수 있을 때 까지 반복
      sb.append(line);
    }
    
    System.out.println(sb.toString());

    Gson gson = new GsonBuilder().create();
    PaymentResponseDTO payment = gson.fromJson(sb.toString(), PaymentResponseDTO.class);

    request.setAttribute("payment", payment);

    ActionForward forward = new ActionForward();

    forward.setRedirect(false);
    forward.setPath("paymentCheck.do");

    return forward;
  }

}
