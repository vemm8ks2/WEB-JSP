package com.teamtwo.api;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.UUID;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import org.json.JSONObject;

public class ApiServlet extends HttpServlet {

  private static final long serialVersionUID = 8252578721858016245L;
  protected final String saveImagePath = "C:\\upload";

  protected final JSONObject readJsonFormat(HttpServletRequest request) throws IOException {

    String rawData = null;
    String jsonFormat = "";

    BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));

    while ((rawData = br.readLine()) != null)
      jsonFormat += rawData;

    return new JSONObject(jsonFormat);
  }

  protected final String getFilePath(File file) {
    UUID uuid = UUID.randomUUID();
    String filename = uuid.toString();
    String ext = file.getName().substring(file.getName().lastIndexOf(".") + 1);

    Calendar cal = Calendar.getInstance();

    int year = cal.get(Calendar.YEAR);
    int month = cal.get(Calendar.MONTH) + 1;
    int day = cal.get(Calendar.DAY_OF_MONTH);

    // ex) */upload/2024-8-20
    String dir = saveImagePath + "/" + year + "-" + month + "-" + day;

    // 날짜 폴더를 만든다.
    File path = new File(dir);

    if (!path.exists())
      path.mkdir();

    file.renameTo(new File(dir + "/" + filename + "." + ext));

    // 실제 DB upload_file 칼럼에 들어가는 파일 이름. ex) '/2024-8-20/저장날짜_UUID'
    String saveFilename = "/" + year + "-" + month + "-" + day + "/" + filename + "." + ext;

    return saveFilename;
  }

}
