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
  <div id="container" class="max-w-5xl min-w-[64rem] m-auto flex flex-col min-h-screen">
    <app-header></app-header>
    <main class="px-4 py-10 flex-1"> <!-- #wrapper -->
      <div class="h-80 rounded-lg bg-gradient-to-tr from-slate-200 to-yellow-50"> <!-- .banner-01 -->
      </div>
      <div class="mt-12"> <!-- .display-products -->
        <p class="text-2xl text-center mb-8">지금 가장 많이 담는 특가</p> <!-- .display-products__header -->
        <div class="flex justify-evenly gap-2 [&>div]:w-52"> <!-- .display-products__wrapper -->
          <div> <!-- .display-products__product -->
            <a href="product.do">
              <div class="h-60 rounded-md bg-gray-50"></div> <!-- .display-products__skeleton -->
              <p class="mt-2">[해운대암소갈비집] 한우 소불고기 전골</p>
              <p>15,900원</p>
            </a>
          </div>
          <div>
            <div class="h-60 rounded-md bg-gray-50"></div>
            <p class="mt-2">[오쏘몰] 오쏘몰 이뮨 드링크+정제 2박스 (60일분)</p>
            <p>169,000원</p>
          </div>
          <div>
            <div class="h-60 rounded-md bg-gray-50"></div>
            <p class="mt-2">미국산 생 블루베리 2종</p>
            <p>4,990원</p>
          </div>
          <div>
            <div class="h-60 rounded-md bg-gray-50"></div>
            <p class="mt-2">[소반옥] 인기 냉면 2종 (택1)</p>
            <p>8,900원</p>
          </div>
        </div>
      </div>
      <div class="mt-12 h-40 rounded-lg bg-gradient-to-tr from-slate-200 to-green-50"></div> <!-- .banner-02 -->
      <div class="mt-12"> <!-- .display-products -->
        <p class="text-2xl text-center mb-8">실시간 인기 랭킹</p> <!-- .display-products__header -->
        <div class="flex justify-evenly gap-2 [&>div]:w-52"> <!-- .display-products__wrapper -->
          <div>
            <div class="h-60 rounded-md bg-gray-50"></div> <!-- .display-products__skeleton -->
            <p class="mt-2">[해운대암소갈비집] 한우 소불고기 전골</p>
            <p>15,900원</p>
          </div>
          <div>
            <div class="h-60 rounded-md bg-gray-50"></div>
            <p class="mt-2">[오쏘몰] 오쏘몰 이뮨 드링크+정제 2박스 (60일분)</p>
            <p>169,000원</p>
          </div>
          <div>
            <div class="h-60 rounded-md bg-gray-50"></div>
            <p class="mt-2">미국산 생 블루베리 2종</p>
            <p>4,990원</p>
          </div>
          <div>
            <div class="h-60 rounded-md bg-gray-50"></div>
            <p class="mt-2">[소반옥] 인기 냉면 2종 (택1)</p>
            <p>8,900원</p>
          </div>
        </div>
      </div>
      <div class="mt-16"> <!-- .display-products -->
        <p class="text-2xl text-center mb-8">베스트 셀러 랭킹</p> <!-- .display-products__header -->
        <div class="flex justify-evenly gap-2 [&>div]:w-52"> <!-- .display-products__wrapper -->
          <div>
            <div class="h-60 rounded-md bg-gray-50"></div> <!-- .display-products__skeleton -->
            <p class="mt-2">[해운대암소갈비집] 한우 소불고기 전골</p>
            <p>15,900원</p>
          </div>
          <div>
            <div class="h-60 rounded-md bg-gray-50"></div>
            <p class="mt-2">[오쏘몰] 오쏘몰 이뮨 드링크+정제 2박스 (60일분)</p>
            <p>169,000원</p>
          </div>
          <div>
            <div class="h-60 rounded-md bg-gray-50"></div>
            <p class="mt-2">미국산 생 블루베리 2종</p>
            <p>4,990원</p>
          </div>
          <div>
            <div class="h-60 rounded-md bg-gray-50"></div>
            <p class="mt-2">[소반옥] 인기 냉면 2종 (택1)</p>
            <p>8,900원</p>
          </div>
        </div>
      </div>
      <div class="mt-16">  <!-- .display-products -->
        <p class="text-2xl text-center mb-8">조회수 랭킹</p> <!-- .display-products__header -->
        <div class="flex justify-evenly gap-2 [&>div]:w-52"> <!-- .display-products__wrapper -->
          <div>
            <div class="h-60 rounded-md bg-gray-50"></div> <!-- .display-products__skeleton -->
            <p class="mt-2">[해운대암소갈비집] 한우 소불고기 전골</p>
            <p>15,900원</p>
          </div>
          <div>
            <div class="h-60 rounded-md bg-gray-50"></div>
            <p class="mt-2">[오쏘몰] 오쏘몰 이뮨 드링크+정제 2박스 (60일분)</p>
            <p>169,000원</p>
          </div>
          <div>
            <div class="h-60 rounded-md bg-gray-50"></div>
            <p class="mt-2">미국산 생 블루베리 2종</p>
            <p>4,990원</p>
          </div>
          <div>
            <div class="h-60 rounded-md bg-gray-50"></div>
            <p class="mt-2">[소반옥] 인기 냉면 2종 (택1)</p>
            <p>8,900원</p>
          </div>
        </div>
      </div>
    </main>
    <app-footer></app-footer>
  </div>
</body>

</html>