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
    <main class="flex flex-col flex-1 px-4 py-10"> <!-- #wrapper -->
      <nav>
        <ul class="flex items-center gap-3 text-sm"> <!-- .product-category -->
          <li><a href="#">태블릿&#183;모바일&#183;게임</a></li>
          <span class="w-1 h-1 rounded-full bg-slate-300"></span>
          <li><a href="#">게임기</a></li>
          <span class="w-1 h-1 rounded-full bg-slate-300"></span>
          <li><a href="#">플레이스테이션</a></li>
        </ul>
      </nav>
      <div class="flex gap-8 mt-4"> <!-- .product-top -->
        <div class="flex-1">
          <div class="w-full rounded-xl overflow-hidden"> <!-- .product-top__image-wrapper -->
            <img src="static/images/ps5.avif" alt="" srcset="">
          </div>
        </div>
        <div class="flex-1">
          <p class="text-2xl font-bold">플레이스테이션 5 슬림 1TB 본체</p> <!-- .product-top__name -->
          <div class="flex items-center gap-2 mt-2"> <!-- .product-top__review -->
            <div class="flex gap-1">
              <svg class="w-5 fill-yellow-300" version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 473.486 473.486" xml:space="preserve">
                <polygon points="473.486,182.079 310.615,157.952 235.904,11.23 162.628,158.675 0,184.389 117.584,299.641 91.786,462.257 237.732,386.042 384.416,460.829 357.032,298.473 "/>
              </svg>
              <svg class="w-5 fill-yellow-300" version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 473.486 473.486" xml:space="preserve">
                <polygon points="473.486,182.079 310.615,157.952 235.904,11.23 162.628,158.675 0,184.389 117.584,299.641 91.786,462.257 237.732,386.042 384.416,460.829 357.032,298.473 "/>
              </svg>
              <svg class="w-5 fill-yellow-300" version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 473.486 473.486" xml:space="preserve">
                <polygon points="473.486,182.079 310.615,157.952 235.904,11.23 162.628,158.675 0,184.389 117.584,299.641 91.786,462.257 237.732,386.042 384.416,460.829 357.032,298.473 "/>
              </svg>
              <svg class="w-5 fill-yellow-300" version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 473.486 473.486" xml:space="preserve">
                <polygon points="473.486,182.079 310.615,157.952 235.904,11.23 162.628,158.675 0,184.389 117.584,299.641 91.786,462.257 237.732,386.042 384.416,460.829 357.032,298.473 "/>
              </svg>
              <svg class="w-5 fill-gray-200" version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 473.486 473.486" xml:space="preserve">
                <polygon points="473.486,182.079 310.615,157.952 235.904,11.23 162.628,158.675 0,184.389 117.584,299.641 91.786,462.257 237.732,386.042 384.416,460.829 357.032,298.473 "/>
              </svg>
            </div>
            <span class="text-sm text-slate-500">42 reviews</span>
          </div>
          <p class="mt-4 font-bold"><span class="text-2xl">669,000</span> 원</p> <!-- .product-top__price -->
          <hr class="mt-8 mb-4">
          <ul class="flex flex-col gap-4 text-slate-500 text-sm [&>li]:flex [&>li>p:first-child]:w-32"> <!-- .product-top__info -->
            <li>
              <p>배송</p>
              <p>무료배송</p>
            </li>
            <hr>
            <li>
              <p>판매자</p>
              <p>TEAM.T</p>
            </li>
            <hr>
            <li>
              <p>게임기 구성</p>
              <p>게임기</p>
            </li>
            <hr>
            <li>
              <p>게임기 종류</p>
              <p>플레이스테이션</p>
            </li>
            <hr>
            <li>
              <p>형태</p>
              <p>거치용</p>
            </li>
            <hr>
            <li>
              <p>PS 시리즈</p>
              <p>PS5</p>
            </li>
            <hr>
            <li>
              <p>상품번호</p>
              <p>00000000-000000000</p>
            </li>
          </ul>
          <hr class="mt-4 mb-8">
          <div class="flex flex-col items-end gap-2"> <!-- .product-top__total-price-wrapper -->
            <div class="flex gap-4">
              <button class="bg-slate-700 w-7 h-7 rounded-full">
                <svg class="w-3 m-auto fill-slate-50" version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 459.313 459.314" xml:space="preserve">
                  <g>
                    <path d="M459.313,229.648c0,22.201-17.992,40.199-40.205,40.199H40.181c-11.094,0-21.14-4.498-28.416-11.774 C4.495,250.808,0,240.76,0,229.66c-0.006-22.204,17.992-40.199,40.202-40.193h378.936
                      C441.333,189.472,459.308,207.456,459.313,229.648z"/>
                  </g>
                </svg>
              </button>
              <span class="font-bold text-slate-500">1</span>
              <button class="bg-slate-700 w-7 h-7 rounded-full">
                <svg class="w-3 m-auto fill-slate-50" version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 45.402 45.402" xml:space="preserve">
                  <g>
                    <path d="M41.267,18.557H26.832V4.134C26.832,1.851,24.99,0,22.707,0c-2.283,0-4.124,1.851-4.124,4.135v14.432H4.141 c-2.283,0-4.139,1.851-4.138,4.135c-0.001,1.141,0.46,2.187,1.207,2.934c0.748,0.749,1.78,1.222,2.92,1.222h14.453V41.27
                      c0,1.142,0.453,2.176,1.201,2.922c0.748,0.748,1.777,1.211,2.919,1.211c2.282,0,4.129-1.851,4.129-4.133V26.857h14.435 c2.283,0,4.134-1.867,4.133-4.15C45.399,20.425,43.548,18.557,41.267,18.557z"/>
                  </g>
                </svg>
              </button>
            </div>
            <p class="text-sm"> <!-- .product-top__total-price-typo -->
              총 상품금액 : &nbsp;<span class="text-2xl font-bold">669,000</span> <span class="text-xl">원</span>
            </p>
          </div>
          <div class="flex items-center gap-2 mt-4"> <!-- .product-top__purchase-wrapper -->
            <button class="flex-1 rounded-md text-xl py-3 bg-black text-white">바로구매</button>
            <button class="border border-slate-300 p-2.5 rounded-md">
              <svg class="w-8 fill-gray-700" version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 483.1 483.1" xml:space="preserve">
                <g>
                  <path d="M434.55,418.7l-27.8-313.3c-0.5-6.2-5.7-10.9-12-10.9h-58.6c-0.1-52.1-42.5-94.5-94.6-94.5s-94.5,42.4-94.6,94.5h-58.6 c-6.2,0-11.4,4.7-12,10.9l-27.8,313.3c0,0.4,0,0.7,0,1.1c0,34.9,32.1,63.3,71.5,63.3h243c39.4,0,71.5-28.4,71.5-63.3
                    C434.55,419.4,434.55,419.1,434.55,418.7z M241.55,24c38.9,0,70.5,31.6,70.6,70.5h-141.2C171.05,55.6,202.65,24,241.55,24z M363.05,459h-243c-26,0-47.2-17.3-47.5-38.8l26.8-301.7h47.6v42.1c0,6.6,5.4,12,12,12s12-5.4,12-12v-42.1h141.2v42.1
                    c0,6.6,5.4,12,12,12s12-5.4,12-12v-42.1h47.6l26.8,301.8C410.25,441.7,389.05,459,363.05,459z"/>
                </g>
              </svg>
            </button>
          </div>
        </div>
      </div>
      <nav class="mt-12"> <!-- .product-inner-nav -->
        <ul class="flex text-center border rounded-md [&>li]:flex-1 [&>li:not(:last-child)]:border-r"> <!-- .product-inner-nav__wrapper -->
          <li>
            <a href="#prod_desc" class="inline-block w-full py-4">상품설명</a>
          </li>
          <li>
            <a href="#prod_info" class="inline-block w-full py-4">상세정보</a>
          </li>
          <li>
            <a href="#prod_review" class="inline-block w-full py-4">리뷰</a>
          </li>
          <li>
            <a href="#prod_qna" class="inline-block w-full py-4">문의</a>
          </li>
        </ul>
      </nav>
      <div id="prod_desc" class="mt-8"> <!-- .product-detail -->
        <img src="static/images/ps5_prod_detail.jpg" alt="" srcset="">
      </div>
      <hr class="mt-12"> <!-- divider? -->
      <div id="prod_info" class="mt-24"> <!-- .product-info -->
        <h3 class="text-center text-2xl">상품고시정보</h3> <!-- .product-info__attr-header -->
        <ul class="mt-8 text-sm text-slate-500 [&>div]:flex [&>div]:justify-center [&>div>li]:flex [&>div>li>p]:p-4 [&>div>li>p:first-child]:w-44 [&>div>li>p:first-child]:bg-gray-50 [&>div>li>p:last-child]:w-60"> <!-- .product-info__attr-wrapper -->
          <div>
            <li>
              <p>품명 및 모델명</p>
              <p>상품설명 및 상품이미지 참조</p>
            </li>
            <li>
              <p>정격전압, 소비전력</p>
              <p>상품설명 및 상품이미지 참조</p>
            </li>
          </div>
          <div>
            <li>
              <p>제조자, 수임품의 경우 수입자를 함께 표기 &#40;병행수입의 경우 병행수입 여부로 대체 가능&#41;</p>
              <p>소니 인터랙티브 엔터테인먼트 코리아</p>
            </li>
            <li>
              <p>크기, 무게</p>
              <p>상품설명 및 상품이미지 참조</p>
            </li>
          </div>
          <div>
            <li>
              <p>품질보증기준</p>
              <p>영수증에 기재된 구매일로부터 1년</p>
            </li>
            <li>
              <p>KC 인증정보</p>
              <p>상품설명 및 상품이미지 참조</p>
            </li>
          </div>
          <div>
            <li>
              <p>동일모델의 출시년월</p>
              <p>상품설명 및 상품이미지 참조</p>
            </li>
            <li>
              <p>제조국</p>
              <p>상품설명 및 상품이미지 참조</p>
            </li>
          </div>
          <div>
            <li>
              <p>주요 사양</p>
              <p>상품설명 및 상품이미지 참조</p>
            </li>
            <li>
              <p>A/S 책임자와 전화번호</p>
              <p>상품설명 및 상품이미지 참조</p>
            </li>
          </div>
        </ul>
        <div class="mt-16"> <!-- .customer-service-center -->
          <div> <!-- .customer-service-center__header -->
            <h3 class="text-center text-2xl">고객행복센터</h3>
            <p class="mt-8 font-bold text-slate-500">궁금하신 점이나 서비스 이용에 불편한 점이 있으신가요?</p>
            <p class="mt-2">문제가 되는 부분을 사진으로 찍어 아래 중 편하신 방법으로 접수해 주시면 빠르게 도와드리겠습니다.</p>
          </div>
          <div class="mt-4 flex text-slate-500 [&>div]:flex-1 [&>div>p]:mt-2 [&>div>p:first-child]:font-bold"> <!-- .customer-service-center__info -->
            <div>
              <p>전화 문의 0000-0000</p>
              <p>월~토요일 오전 7시 ~ 오후 6시</p>
            </div>
            <div>
              <p>카카오톡 문의</p>
              <p>월~토요일 오전 7시 ~ 오후 6시</p>
              <p>일/공휴일 오전 7시 ~ 오후 1시</p>
            </div>
            <div>
              <p>홈페이지 문의</p>
              <p>365일</p>
              <p>고객센터 운영 시간에 순차적으로 답변해드리겠습니다.</p>
            </div>
          </div>
        </div>
      </div>
      <hr class="mt-12">
      <div id="prod_review" class="mt-24 [&>div]:mt-8 [&>div>div]:flex [&>div>div]:items-center [&>div>div]:text-sm [&>div>div]:text-slate-500 [&>div>p]:mt-2 [&>div>div>p]:ml-2"> <!-- .product-review -->
        <h3 class="text-center text-2xl">상품후기 <span class="text-xl text-slate-500">&#40;42&#41;</span></h3>
        <div>
          <div>
            <div class="w-10 h-10 bg-slate-100 rounded-full"></div>
            <p>파울로 코엘료</p>
            <p>&#183;</p>
            <p>2025.04.12</p>
          </div>
          <p>공무원은 국민전체에 대한 봉사자이며, 국민에 대하여 책임을 진다.</p>
        </div>
        <div>
          <div>
            <div class="w-10 h-10 bg-slate-100 rounded-full"></div>
            <p>다자이 오사무</p>
            <p>&#183;</p>
            <p>2025.02.15</p>
          </div>
          <p>
            국가는 농·어민과 중소기업의 자조조직을 육성하여야 하며, 그 자율적 활동과 발전을 보장한다. 국민경제자문회의의 조직·직무범위 기타 필요한 사항은 법률로 정한다.
            <br><br>
            계엄을 선포한 때에는 대통령은 지체없이 국회에 통고하여야 한다. 국회는 헌법개정안이 공고된 날로부터 60일 이내에 의결하여야 하며, 국회의 의결은 재적의원 3분의 2 이상의 찬성을 얻어야 한다.
          </p>
        </div>
        <div>
          <div>
            <div class="w-10 h-10 bg-slate-100 rounded-full"></div>
            <p>헤르만 헤세</p>
            <p>&#183;</p>
            <p>2025.01.09</p>
          </div>
          <p>재판의 전심절차로서 행정심판을 할 수 있다. 행정심판의 절차는 법률로 정하되, 사법절차가 준용되어야 한다.</p>
        </div>
        <div>
          <div>
            <div class="w-10 h-10 bg-slate-100 rounded-full"></div>
            <p>앙투안 드 생텍쥐페리</p>
            <p>&#183;</p>
            <p>2025.01.08</p>
          </div>
          <p>
            국가는 국민 모두의 생산 및 생활의 기반이 되는 국토의 효율적이고 균형있는 이용·개발과 보전을 위하여 법률이 정하는 바에 의하여 그에 관한 필요한 제한과 의무를 과할 수 있다.
            <br><br>
            대한민국의 주권은 국민에게 있고, 모든 권력은 국민으로부터 나온다.
          </p>
        </div>
      </div>
      <hr class="mt-12">
      <div id="prod_qna" class="mt-24 mb-12"> <!-- .product-qna -->
        <h3 class="text-center text-2xl">상품문의</h3>
        <ul class="mt-8">
          <li class="text-sm text-slate-500">&#183; 상품에 대한 문의를 남기는 공간입니다. 해당 게시판의 성격과 다른 글은 사전동의 없이 담당 게시판으로 이동될 수 있습니다.</li>
          <li class="text-sm text-slate-500">&#183; 배송관련, 주문&#40;취소/교환/환불&#41;관련 문의 및 요청사항은 1:1 문의에 남겨주세요.</li>
        </ul>
        <table class="w-full text-sm mt-8">
          <thead class="border-t-slate-400 border-t-2 border-b-slate-400 border-b-2">
            <tr class="[&>th]:py-4 text-slate-500">
              <th class="">제목</th>
              <th class="w-28">작성자</th>
              <th class="w-28">작성일</th>
              <th class="w-28">답변상태</th>
            </tr>
          </thead>
          <tbody class="text-slate-500 [&>tr>td]:py-4 [&>tr>td:first-child]:px-4 [&>tr>td:not(:first-child)]:text-center">
            <tr class="border-b">
              <td>입고문의</td>
              <td>호메로스</td>
              <td>2025.02.25</td>
              <td>대기중</td>
            </tr>
            <tr class="border-b">
              <td>환불문의</td>
              <td>헤로도토스</td>
              <td>2025.01.12</td>
              <td>답변완료</td>
            </tr>
            <tr class="border-b">
              <td>재입고</td>
              <td>아이스퀼로스</td>
              <td>2025.01.02</td>
              <td>답변완료</td>
            </tr>
          </tbody>
        </table>
      </div>
    </main>
    <app-footer></app-footer>
  </div>
</body>

</html>