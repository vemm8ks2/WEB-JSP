<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">

<body>
  <div class="login-wrapper">
    <p class="login-typo">로그인</p>
    <form method="POST" action="login.do" class="login-form">
      <label for="login_id" class="primary-input">
        <input id="login_id" name="login_id" placeholder="&nbsp;" />
        <span>아이디</span>
      </label>
      <label for="login_pwd" class="primary-input">
        <input id="login_pwd" name="login_pwd" type="password" placeholder="&nbsp;" />
        <span>비밀번호</span>
      </label>
      <div>
        <a href="#">아이디 찾기</a>
        <span>|</span>
        <a href="#">비밀번호 찾기</a>
      </div>
      <button class="primary-btn default-btn-color">로그인</button>
      <a href="registerView.do">
        <button type="button" class="primary-btn reverse-btn-color">
          회원가입
        </button>
      </a>
    </form>
  </div>
</body>

</html>