package com.teamtwo.action;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.teamtwo.model.PaymentTokenDTO;

public class PaymentTokenAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
    
    URL url = new URL("https://api.iamport.kr/users/getToken");
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    
    conn.setRequestMethod("POST"); // http 메서드
    conn.setRequestProperty("Content-Type", "application/json"); // header Content-Type 정보
    conn.setDoInput(true); // 서버에 전달할 값이 있다면 true
    conn.setDoOutput(true); // 서버로부터 받는 값이 있다면 true
    
    // 서버에 데이터 전달
    JSONObject obj = new JSONObject();
    
    obj.put("imp_key", "6350412825581068");
    obj.put("imp_secret", "");
    
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
    bw.write(obj.toString()); // 버퍼에 담기
    bw.flush(); // 버퍼에 담긴 데이터 전달
    bw.close();
    
    // 서버로부터 데이터 읽어오기
    BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
    StringBuilder sb = new StringBuilder();
    String line = null;
    
    while((line = br.readLine()) != null) { // 읽을 수 있을 때 까지 반복
        sb.append(line);
    }
    
    Gson gson = new GsonBuilder().create();        
    PaymentTokenDTO token = gson.fromJson(sb.toString(), PaymentTokenDTO.class);
    
    request.setAttribute("access_token", token.getAccessToken());
    
    ActionForward forward = new ActionForward();
    
    forward.setRedirect(false);
    forward.setPath("paymentInfo.do");
    
    return forward;
  }

}
