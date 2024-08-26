<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">

<body>
  <div class="flex flex-col m-auto gap-4">
    <p class="text-center mb-6 text-2xl">회원가입</p>
    <form action="" class="flex flex-col items-center">
      <label for="register_id" class="relative w-full">
        <input id="register_id" placeholder="&nbsp;" class="w-full border-b p-2 focus:outline-none focus:border-b-slate-500 [&:focus+span]:translate-y-[-25px] [&:focus+span]:text-xs [&:not(:placeholder-shown)+span]:translate-y-[-25px] [&:not(:placeholder-shown)+span]:text-xs">
        <span class="absolute top-2 left-2 transition-all text-slate-500 pointer-events-none">아이디</span>
      </label>
      <label for="register_pwd" class="relative w-full mt-8">
        <input id="register_pwd" type="password" placeholder="&nbsp;" class="w-full border-b p-2 focus:outline-none focus:border-b-slate-500 [&:focus+span]:translate-y-[-25px] [&:focus+span]:text-xs [&:not(:placeholder-shown)+span]:translate-y-[-25px] [&:not(:placeholder-shown)+span]:text-xs">
        <span class="absolute top-2 left-2 transition-all text-slate-500 pointer-events-none">비밀번호</span>
      </label>
      <label for="register_pwd_confirm" class="relative w-full mt-8">
        <input id="register_pwd_confirm" type="password" placeholder="&nbsp;" class="w-full border-b p-2 focus:outline-none focus:border-b-slate-500 [&:focus+span]:translate-y-[-25px] [&:focus+span]:text-xs [&:not(:placeholder-shown)+span]:translate-y-[-25px] [&:not(:placeholder-shown)+span]:text-xs">
        <span class="absolute top-2 left-2 transition-all text-slate-500 pointer-events-none">비밀번호확인</span>
      </label>
      <label for="register_name" class="relative w-full mt-8">
        <input id="register_name" placeholder="&nbsp;" class="w-full border-b p-2 focus:outline-none focus:border-b-slate-500 [&:focus+span]:translate-y-[-25px] [&:focus+span]:text-xs [&:not(:placeholder-shown)+span]:translate-y-[-25px] [&:not(:placeholder-shown)+span]:text-xs">
        <span class="absolute top-2 left-2 transition-all text-slate-500 pointer-events-none">이름</span>
      </label>
      <label for="register_phone" class="relative w-full mt-8">
        <input id="register_phone" placeholder="&nbsp;" class="w-full border-b p-2 focus:outline-none focus:border-b-slate-500 [&:focus+span]:translate-y-[-25px] [&:focus+span]:text-xs [&:not(:placeholder-shown)+span]:translate-y-[-25px] [&:not(:placeholder-shown)+span]:text-xs">
        <span class="absolute top-2 left-2 transition-all text-slate-500 pointer-events-none">휴대폰</span>
      </label>
      <label for="register_addr" class="relative w-full mt-8">
        <input id="register_addr" placeholder="&nbsp;" class="w-full border-b p-2 focus:outline-none focus:border-b-slate-500 [&:focus+span]:translate-y-[-25px] [&:focus+span]:text-xs [&:not(:placeholder-shown)+span]:translate-y-[-25px] [&:not(:placeholder-shown)+span]:text-xs">
        <span class="absolute top-2 left-2 transition-all text-slate-500 pointer-events-none">주소</span>
      </label>
      <button class="border mt-8 px-32 py-2 rounded-md bg-black text-white">가입하기</button>
    </form>
    <div class="flex justify-between text-sm">
      <p>이미 계정이 있으신가요?</p>
      <a href="loginView.do">로그인하러 가기</a>
    </div>
  </div>
</body>

</html>