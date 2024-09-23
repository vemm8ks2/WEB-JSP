package com.teamtwo.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import com.teamtwo.model.CategoryDAO;
import com.teamtwo.model.CategoryDTO;

@WebServlet("/category")
public class Category extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CategoryDAO dao = CategoryDAO.getInstance();

		JSONObject json = new JSONObject();
		json.put("categoryList", dao.getAll());

		response.setContentType("application/json; charset=utf-8");
		response.getWriter().print(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String categoryName = request.getParameter("category_name");
		String categoryParentFkParam = request.getParameter("category_parent_fk");
		Integer categoryParentFk = null;

		if (!(categoryParentFkParam == null)) {
			categoryParentFk = Integer.parseInt(categoryParentFkParam);
		}

		CategoryDAO dao = CategoryDAO.getInstance();

		CategoryDTO dto = new CategoryDTO();

		dto.setCategoryId(dao.getCategoryId());
		dto.setCategoryName(categoryName);
		dto.setCategoryParentFk(categoryParentFk);

		dao.save(dto);

		JSONObject json = new JSONObject();
		json.put("msg", "카테고리 생성 성공.");

		response.setContentType("application/json; charset=utf-8");
		response.getWriter().print(json);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		JSONObject jsonObject = readJsonFormat(request);

		int categoryId = jsonObject.getInt("category_id");
		String categoryNameBeforeUpdate = jsonObject.getString("category_name_before_update");
		String categoryNameAfterUpdate = jsonObject.getString("category_name_after_update");

		CategoryDAO dao = CategoryDAO.getInstance();

		CategoryDTO category = dao.get(categoryId);

		/* 클라이언트에게 받은 데이터를 원본 데이터와 비교하여 검증 */
		if (!(category.getCategoryId() == categoryId)
				|| !(category.getCategoryName().equals(categoryNameBeforeUpdate))) {

			return;
		}

		CategoryDTO dto = new CategoryDTO();

		dto.setCategoryId(categoryId);
		dto.setCategoryName(categoryNameAfterUpdate);
		dto.setCategoryParentFk(category.getCategoryParentFk());

		dao.update(dto);

		JSONObject responseJson = new JSONObject();
		responseJson.put("msg", "카테고리 업데이트 성공.");

		response.setContentType("application/json; charset=utf-8");
		response.getWriter().print(responseJson);

	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/**
		 * TODO(24.09.16): 삭제 이전에 어드민 세션의 여부를 확인해야 할 것 같다. (삭제 뿐만 아니라 CRUD 모든 프로세스 해당)
		 * init 메소드?
		 */
		/**
		 * TODO(24.09.16): 자식 카테고리가 있는 경우 삭제가 불가능하도록 해야한다.
		 */
		/**
		 * TODO(24.09.16): 상품 테이블에서 카테고리 테이블을 외래키로 사용하고 있다. 참조되고 있는 카테고리는 무결성 제약조건에 반하여 오라클 에러가
		 * 발생한다. 카테고리 삭제 시 상품도 함께 삭제할지 아니면 삭제 메소드를 실행 시 삭제 여부 칼럼을 추가하여 상태를 바꿔줄지 의사결정이 필요하다.
		 */

		JSONObject jsonObject = readJsonFormat(request);

		int categoryId = jsonObject.getInt("category_id");
		String categoryName = jsonObject.getString("category_name");
		int categoryParentFk = jsonObject.getInt("category_parent_fk");

		CategoryDAO dao = CategoryDAO.getInstance();

		CategoryDTO category = dao.get(categoryId);

		boolean isSameCategory = category.getCategoryId() == categoryId
				&& category.getCategoryName().equals(categoryName)
				&& category.getCategoryParentFk() == categoryParentFk;
		
		/**
		 * TODO(24.09.16): 에러 핸들링
		 */
		if (!isSameCategory) {
			return;
		}

		dao.delete(categoryId);
		
		JSONObject responseJson = new JSONObject();
		responseJson.put("msg", "카테고리 삭제 성공.");

		response.setContentType("application/json; charset=utf-8");
		response.getWriter().print(responseJson);
		
	}
	
	private JSONObject readJsonFormat(HttpServletRequest request) throws IOException {

		String rawData = null;
		String jsonFormat = "";

		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));

		while ((rawData = br.readLine()) != null)
			jsonFormat += rawData;

		return new JSONObject(jsonFormat);
	}
}
