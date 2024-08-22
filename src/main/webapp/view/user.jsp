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
    <main class="flex flex-col flex-1 px-4 py-10 gap-4 text-slate-500">
      <div class="border flex flex-col flex-1 gap-4 items-center justify-center text-center w-1/2 mx-auto px-4 py-8 rounded-lg [&>hr]:w-full [&>div:not(:first-child)]:w-full">
        <div class="border-8 border-gray-400 w-32 h-32 rounded-full flex justify-center overflow-hidden">
          <svg class="w-full fill-gray-400 translate-y-1" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 32 32" style="enable-background:new 0 0 32 32" xml:space="preserve">
            <path d="M16 14c-3.86 0-7-3.14-7-7s3.14-7 7-7 7 3.14 7 7-3.14 7-7 7zm0-12c-2.757 0-5 2.243-5 5s2.243 5 5 5 5-2.243 5-5-2.243-5-5-5zM27 32a1 1 0 0 1-1-1v-6.115a6.95 6.95 0 0 0-6.942-6.943h-6.116A6.95 6.95 0 0 0 6 24.885V31a1 1 0 1 1-2 0v-6.115c0-4.93 4.012-8.943 8.942-8.943h6.116c4.93 0 8.942 4.012 8.942 8.943V31a1 1 0 0 1-1 1z"/>
          </svg>
        </div>
        <div>
          <p class="text-lg">이지은</p>
          <p>OOOO@naver.com</p>
        </div>
        <hr>
        <div>
          <p>기본 배송지</p>
          <p class="mt-1">경기도 화성시 병점3로 12 신성빌딩 4층</p>
        </div>
        <hr>
        <div>
          <a href="#" class="inline-block w-full py-1">
            <button>주문목록</button>
          </a>
        </div>
        <hr>
        <div>
          <a href="#" class="inline-block w-full py-1">
            <button>마이페이지</button>
          </a>
        </div>
        <hr>
        <div>
          <a href="#" class="inline-block w-full py-1">
            <button>취소&#183;반품&#183;교환목록</button>
          </a>
        </div>
        <hr>
        <div>
          <a href="#" class="inline-block w-full py-1">
            <button>리뷰목록</button>
          </a>
        </div>
        <hr>
        <div class="w-full">
          <a href="#" class="inline-block w-full py-1">
            <button>고객센터</button>
          </a>
        </div>
      </div>
    </main>
    <app-footer></app-footer>
  </div>
</body>

</html>