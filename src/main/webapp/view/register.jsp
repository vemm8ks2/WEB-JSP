<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="register-wrapper">
  <p class="register-typo">회원가입</p>
  <form action="" class="register-form">
    <label for="register_id" class="primary-input">
      <input id="register_id" placeholder="&nbsp;" />
      <span>아이디</span>
    </label>
    <label for="register_pwd" class="primary-input">
      <input id="register_pwd" type="password" placeholder="&nbsp;" />
      <span>비밀번호</span>
    </label>
    <label for="register_pwd_confirm" class="primary-input">
      <input
        id="register_pwd_confirm"
        type="password"
        placeholder="&nbsp;"
      />
      <span>비밀번호확인</span>
    </label>
    <label for="register_name" class="primary-input">
      <input id="register_name" placeholder="&nbsp;" />
      <span>이름</span>
    </label>
    <label for="register_phone" class="primary-input">
      <input id="register_phone" placeholder="&nbsp;" />
      <span>휴대폰</span>
    </label>
    <label for="register_addr" class="primary-input">
      <input id="register_addr" placeholder="&nbsp;" />
      <span>주소</span>
    </label>
    <button>가입하기</button>
  </form>
  <div>
    <p>이미 계정이 있으신가요?</p>
    <a href="loginView.do">로그인하러 가기</a>
  </div>
</div>