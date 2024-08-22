<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <link rel="stylesheet" href="static/css/main.css">
  <script src="static/js/main.js"></script>
</head>

<body>
  <div id="container" class="max-w-5xl m-auto flex flex-col min-h-screen">
    <app-header></app-header>
    <main class="flex flex-col flex-1 px-4 py-10 text-slate-500">
      <div class="flex flex-col m-auto gap-4">
        <p class="text-center mb-6 text-2xl">로그인</p>
        <form action="" class="flex flex-col items-center">
          <label for="login_id" class="relative w-full">
            <input id="login_id" placeholder="&nbsp;" class="w-full border-b p-2 focus:outline-none focus:border-b-slate-500 [&:focus+span]:translate-y-[-25px] [&:focus+span]:left-1 [&:focus+span]:scale-75 [&:not(:placeholder-shown)+span]:translate-y-[-25px] [&:not(:placeholder-shown)+span]:left-1 [&:not(:placeholder-shown)+span]:scale-75">
            <span class="absolute top-2 left-3 transition-all text-slate-500 pointer-events-none">아이디</span>
          </label>
          <label for="login_pwd" class="relative w-full mt-8">
            <input id="login_pwd" type="password" placeholder="&nbsp;" class="w-full border-b p-2 focus:outline-none focus:border-b-slate-500 [&:focus+span]:translate-y-[-25px] [&:focus+span]:left-1 [&:focus+span]:scale-75 [&:not(:placeholder-shown)+span]:translate-y-[-25px] [&:not(:placeholder-shown)+span]:left-1 [&:not(:placeholder-shown)+span]:scale-75">
            <span class="absolute top-2 left-3 transition-all text-slate-500 pointer-events-none">비밀번호</span>
          </label>
          <div class="w-full flex justify-end items-center mt-4">
            <a href="#" class="text-sm">아이디 찾기</a>
            <span class="mx-2 text-xs">|</span>
            <a href="#" class="text-sm">비밀번호 찾기</a>
          </div>
          <button class="border mt-8 px-32 py-2 rounded-md bg-black text-white">로그인</button>
        </form>
        <a href="register.do" class="border text-center py-2 rounded-md">
          <button>회원가입</button>
        </a>
      </div>
    </main>
    <app-footer></app-footer>
  </div>
</body>

</html>