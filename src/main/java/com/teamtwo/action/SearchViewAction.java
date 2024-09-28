package com.teamtwo.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.teamtwo.model.CategoryDTO;
import com.teamtwo.model.ProductDAO;
import com.teamtwo.model.ProductDTO;
import com.teamtwo.model.SearchDTO;

public class SearchViewAction implements Action {

  List<CategoryDTO> categoryList;
  ArrayList<CategoryDTO>[] categoryGraph;
  boolean[] visited;

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {

    /**
     * Q(24.09.12): 검색어(keyword)가 없는 경우는 어떻게 핸들링하는 게 적절할까?
     */

    String keyword = request.getParameter("keyword");
    String sort = request.getParameter("sort-filter");
    String price = request.getParameter("price-filter");
    String[] categoryIds = request.getParameterValues("category-filter");

    categoryList = (List<CategoryDTO>) request.getServletContext().getAttribute("categoryList");
    categoryGraph = new ArrayList[categoryList.size() + 1];

    visited = new boolean[categoryList.size() + 1];

    for (int i = 0; i < categoryGraph.length; i++)
      categoryGraph[i] = new ArrayList<>();

    for (CategoryDTO category : categoryList)
      categoryGraph[category.getCategoryParentFk()].add(category);

    List<Integer> parentCategoryIdList = new ArrayList<>();

    for (String categoryId : categoryIds) {
      int id = Integer.parseInt(categoryId);

      parentCategoryIdList.addAll(findAllParentIds(id));
      dfs(id);
    }

    /* 콘솔용 반복문 START */
    for (int id : parentCategoryIdList)
      System.out.println("오픈될 카테고리 ID: " + id);
    for (int i = 0; i < visited.length; i++)
      System.out.println(i + "번째 방문 여부: " + visited[i]);
    /* 콘솔용 반복문 END */

    List<Integer> categoryIdsIncludingChild = new ArrayList<>();

    for (CategoryDTO category : categoryList) {
      if (visited[category.getCategoryId()]) {
        categoryIdsIncludingChild.add(category.getCategoryId());
      }
    }

    /* 대체 예정 코드 START */
    /*
     * List<Integer> parentCategoryIdList = new ArrayList<>();
     * 
     * if (categoryIds != null) { for (String categoryId : categoryIds) { int id =
     * Integer.parseInt(categoryId); parentCategoryIdList.addAll(findAllParentIds(id,
     * categoryList)); } }
     * 
     * List<String> categoryIdsIncludingChild = new ArrayList<>();
     * categoryIdsIncludingChild.addAll(Arrays.stream(categoryIds).map(id ->
     * id.toString()).toList());
     * 
     * for (String categoryId : categoryIds) { int id = Integer.parseInt(categoryId); List<Integer>
     * childCategories = findChildCategoryIds(id, categoryList);
     * 
     * List<String> parsedCategories = childCategories.stream().map(num -> num.toString()).toList();
     * categoryIdsIncludingChild.addAll(parsedCategories); }
     */
    /* 대체 예정 코드 END */


    SearchDTO dto = new SearchDTO();

    dto.setKeyword(keyword);
    dto.setSort(sort);
    dto.setPrice(price);
    dto.setCategories(
        categoryIdsIncludingChild.stream().map(c -> c.toString()).toList().toArray(new String[0]));

    ProductDAO dao = ProductDAO.getInstance();

    List<ProductDTO> list = dao.searchByKeywordAndFilter(dto);

    request.setAttribute("keyword", keyword);
    request.setAttribute("list", list);
    request.setAttribute("selectedCategories", ""); // TODO(24.09.27): 선택되어진 카테고리 목록을 JSP 페이지로 보낸 후
                                                    // 선택되게 하기
    request.setAttribute("opennedCategories", parentCategoryIdList.stream().distinct().toList());

    request.setAttribute("url", "search.jsp");
    request.setAttribute("stylesheet", "search.css");
    request.setAttribute("javascript", "search.js");

    ActionForward forward = new ActionForward();

    forward.setRedirect(false);
    forward.setPath("view/layout.jsp");

    return forward;
  }

  private void dfs(int categoryId) {
    visited[categoryId] = true;

    for (CategoryDTO category : categoryGraph[categoryId]) {
      if (!visited[category.getCategoryId()])
        dfs(category.getCategoryId());
    }
  }

  private List<Integer> findAllParentIds(int categoryId) {
    List<Integer> parentCategories = new ArrayList<>();

    /* 1. 인자로 받은 categoryId의 부모 카테고리의 식별자를 찾은 후 변수에 할당합니다. */
    int curr = categoryList.stream().filter(category -> category.getCategoryId() == categoryId)
        .findFirst().get().getCategoryParentFk();

    /* 2. 부모 카테고리부터 반복문을 시작하게 되며 최상위 부모 카테고리까지 찾습니다. */
    while (curr != 0) {
      CategoryDTO category = null;

      for (CategoryDTO dto : categoryList) {
        if (dto.getCategoryId() == curr) {
          category = dto;
          break;
        }
      }

      if (category == null)
        break;

      parentCategories.add(curr);
      curr = category.getCategoryParentFk();
    }

    return parentCategories;
  }

  private List<Integer> findChildCategoryIds(int categoryId, List<CategoryDTO> categoryList) {
    List<Integer> childCategories = new ArrayList<>(categoryId);

    for (CategoryDTO category : categoryList) {
      if (category.getCategoryParentFk() == categoryId)
        childCategories.add(category.getCategoryId());
    }

    return childCategories;
  }

}
