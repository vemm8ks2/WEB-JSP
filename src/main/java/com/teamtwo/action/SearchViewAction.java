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
    categoryGraph =
        (ArrayList<CategoryDTO>[]) request.getServletContext().getAttribute("categoryGraph");
    visited = new boolean[categoryList.size() + 1];

    List<Integer> parentCategoryIdList = new ArrayList<>();

    if (categoryIds != null) {
      for (String categoryId : categoryIds) {
        int id = Integer.parseInt(categoryId);

        parentCategoryIdList.addAll(findAllParentIds(id));
        findChildCategoryIds(id);
      }
    }

    List<Integer> categoryIdsIncludingChild = new ArrayList<>();

    for (CategoryDTO category : categoryList) {
      if (visited[category.getCategoryId()]) {
        categoryIdsIncludingChild.add(category.getCategoryId());
      }
    }

    SearchDTO dto = new SearchDTO();

    dto.setKeyword(keyword);
    dto.setSort(sort);
    dto.setPrice(price);
    dto.setCategories(
        categoryIdsIncludingChild.stream().map(c -> c.toString()).toList().toArray(new String[0]));

    ProductDAO dao = ProductDAO.getInstance();

    List<ProductDTO> productList = dao.searchByKeywordAndFilter(dto);
    Integer[] priceList = productList.stream().map(product -> product.getProductPrice()).toList()
        .toArray(new Integer[0]);

    Arrays.sort(priceList);

    request.setAttribute("keyword", keyword);
    request.setAttribute("list", productList);
    request.setAttribute("opennedCategories", parentCategoryIdList.stream().distinct().toList());
    request.setAttribute("Q1", findQuartile(priceList, 1));
    request.setAttribute("Q2", findQuartile(priceList, 2));
    request.setAttribute("Q3", findQuartile(priceList, 3));

    request.setAttribute("url", "search.jsp");
    request.setAttribute("stylesheet", "search.css");
    request.setAttribute("javascript", "search.js");

    ActionForward forward = new ActionForward();

    forward.setRedirect(false);
    forward.setPath("view/layout.jsp");

    return forward;
  }

  private void findChildCategoryIds(int categoryId) {
    visited[categoryId] = true;

    for (CategoryDTO category : categoryGraph[categoryId]) {
      if (!visited[category.getCategoryId()])
        findChildCategoryIds(category.getCategoryId());
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

  private int findQuartile(Integer[] data, int quartile) {
    int i = data.length;
    boolean isEven = i % 2 == 0;

    if (quartile < 1 || quartile > 3) {
      throw new IllegalArgumentException("Quartile must be 1, 2, or 3");
    }

    if (quartile == 2) {
      return isEven ? (data[i / 2 - 1] + data[i / 2]) / 2 : data[i / 2];
    }

    int k = (quartile * (i + 1)) / 4;

    if (k % 1 == 0) {
      return data[k - 1];
    }

    int lower = (int) Math.floor(k) - 1;
    int upper = (int) Math.ceil(k) - 1;

    return (data[lower] + data[upper]) / 2;
  }
}
