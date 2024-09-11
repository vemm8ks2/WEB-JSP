class Header extends HTMLElement {
  constructor() {
    super();

    const container = document.querySelector("#container");
    container.insertAdjacentHTML(
      "afterbegin",
      `
      <header>
        <div class="header-top-wrapper">
          <!-- TEAM.T 로고 부분 -->
          <h1 class="header-top__logo">
            <a href="index.html"> TEAM.<span>T</span> </a>
          </h1>

          <!-- 검색창 -->
          <form class="header-top__search">
            <input id="header-search" placeholder="Search" />
            <button>
              <svg
                xmlns="http://www.w3.org/2000/svg"
                x="0px"
                y="0px"
                viewBox="0 0 30 30"
              >
                <path
                  d="M 13 3 C 7.4889971 3 3 7.4889971 3 13 C 3 18.511003 7.4889971 23 13 23 C 15.396508 23 17.597385 22.148986 19.322266 20.736328 L 25.292969 26.707031 A 1.0001 1.0001 0 1 0 26.707031 25.292969 L 20.736328 19.322266 C 22.148986 17.597385 23 15.396508 23 13 C 23 7.4889971 18.511003 3 13 3 z M 13 5 C 17.430123 5 21 8.5698774 21 13 C 21 17.430123 17.430123 21 13 21 C 8.5698774 21 5 17.430123 5 13 C 5 8.5698774 8.5698774 5 13 5 z"
                ></path>
              </svg>
            </button>
          </form>

          <!-- 로그인 UI -->
          <!-- <div class="header-top__logged-in">
            <a href="#">
              <svg
                version="1.1"
                xmlns="http://www.w3.org/2000/svg"
                viewBox="0 0 512 512"
                xmlns:xlink="http://www.w3.org/1999/xlink"
                enable-background="new 0 0 512 512"
              >
                <g>
                  <g>
                    <path
                      d="m464.5,301.1l36.5-178h-359.7l-12.5-59.2-108.4-52.9-9.4,18.7 99,47.8 50,238.8h289c0,0 28.5,17.9 17.5,40.5-4.9,7-12.5,15.6-26.1,15.6h-287.6v20.6h287.7c19.8,0 36.5-10.4 45.9-27 18.4-34.4-21.9-64.9-21.9-64.9zm-286.7-5.7l-32.3-151.6h330.5l-31.3,151.6h-266.9z"
                    />
                    <path
                      d="m212.2,422.1c-21.9,0-39.6,17.6-39.6,39.4s17.7,39.4 39.6,39.4 39.6-17.6 39.6-39.4-17.7-39.4-39.6-39.4zm0,58.1c-10.4,0-18.8-8.3-18.8-18.7s8.3-18.7 18.8-18.7 18.8,8.3 18.8,18.7-8.4,18.7-18.8,18.7z"
                    />
                    <path
                      d="m424.9,422.1c-21.9,0-39.6,17.6-39.6,39.4s17.7,39.5 39.6,39.5 40.7-17.6 39.6-39.4c0-21.8-17.7-39.5-39.6-39.5zm18.8,39.5c0,10.4-8.3,18.7-18.8,18.7s-18.8-8.3-18.8-18.7 8.3-18.7 18.8-18.7 19.8,8.3 18.8,18.7z"
                    />
                  </g>
                </g>
              </svg>
            </a>
            <a href="user.html">
              <svg viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
                <circle cx="12" cy="9" r="3" />
                <circle cx="12" cy="12" r="10" />
                <path
                  d="M17.9691 20C17.81 17.1085 16.9247 15 11.9999 15C7.07521 15 6.18991 17.1085 6.03076 20"
                />
              </svg>
            </a>
          </div> -->

          <!-- 비로그인 UI -->
          <div class="header-top__logged-out">
            <a href="login.html">
              <button class="primary-btn default-btn-color">로그인</button>
            </a>
            <a href="register.html">
              <button class="primary-btn reverse-btn-color">회원가입</button>
            </a>
          </div>
        </div>

        <!-- 카테고리 바 -->
        <nav class="header-bottom__nav">
          <ul class="header-bottom__wrapper">
            <li class="header-bottom__category-level-1">
              <a href="#">
                <span>컴퓨터&#183;노트북</span>
              </a>
              <ul class="header-bottom__category-level-2__wrapper">
                <div>
                  <a href="#">
                    <span>노트북/데스크탑</span>
                  </a>
                  <li class="header-bottom__category-level-2">
                    <div>
                      <ul class="header-bottom__category-level-3__wrapper">
                        <li class="header-bottom__category-level-3">
                          <a href="#">게이밍 노트북</a>
                        </li>
                        <hr />
                        <li class="header-bottom__category-level-3">
                          <a href="#">사무용 노트북</a>
                        </li>
                        <hr />
                        <li class="header-bottom__category-level-3">
                          <a href="#">브랜드 PC</a>
                        </li>
                        <hr />
                        <li class="header-bottom__category-level-3">
                          <a href="#">AI/딥러닝 PC</a>
                        </li>
                        <hr />
                      </ul>
                    </div>
                  </li>
                </div>
                <hr />
                <div>
                  <a href="#">
                    <span>입출력장치</span>
                  </a>
                  <li class="header-bottom__category-level-2">
                    <div>
                      <ul class="header-bottom__category-level-3__wrapper">
                        <li class="header-bottom__category-level-3">
                          <a href="#">모니터</a>
                        </li>
                        <hr />
                        <li class="header-bottom__category-level-3">
                          <a href="#">키보드</a>
                        </li>
                        <hr />
                        <li class="header-bottom__category-level-3">
                          <a href="#">마우스</a>
                        </li>
                        <hr />
                        <li class="header-bottom__category-level-3">
                          <a href="#">웹캠</a>
                        </li>
                        <hr />
                        <li class="header-bottom__category-level-3">
                          <a href="#">프린터</a>
                        </li>
                      </ul>
                    </div>
                  </li>
                </div>
                <hr />
                <div>
                  <a href="#">
                    <span>PC부품</span>
                  </a>
                  <li class="header-bottom__category-level-2">
                    <div>
                      <ul class="header-bottom__category-level-3__wrapper">
                        <li class="header-bottom__category-level-3">
                          <a href="#">CPU</a>
                        </li>
                        <hr />
                        <li class="header-bottom__category-level-3">
                          <a href="#">RAM</a>
                        </li>
                        <hr />
                        <li class="header-bottom__category-level-3">
                          <a href="#">SSD</a>
                        </li>
                      </ul>
                    </div>
                  </li>
                </div>
              </ul>
            </li>
            <li class="header-bottom__category-level-1">
              <a href="#">
                <span>가전&#183;TV</span>
              </a>
              <ul class="header-bottom__category-level-2__wrapper">
                <div>
                  <a href="#">
                    <span>영상/음향가전</span>
                  </a>
                  <li class="header-bottom__category-level-2">
                    <div>
                      <ul class="header-bottom__category-level-3__wrapper">
                        <li class="header-bottom__category-level-3">
                          <a href="#">TV</a>
                        </li>
                        <hr />
                        <li class="header-bottom__category-level-3">
                          <a href="#">프로젝터</a>
                        </li>
                        <hr />
                        <li class="header-bottom__category-level-3">
                          <a href="#">셋톱박스</a>
                        </li>
                        <hr />
                        <li class="header-bottom__category-level-3">
                          <a href="#">사운드바</a>
                        </li>
                        <hr />
                        <li class="header-bottom__category-level-3">
                          <a href="#">앰프</a>
                        </li>
                      </ul>
                    </div>
                  </li>
                </div>
                <hr />
                <div>
                  <a href="#">
                    <span>생활/계절가전</span>
                  </a>
                  <li class="header-bottom__category-level-2">
                    <div>
                      <ul class="header-bottom__category-level-3__wrapper">
                        <li class="header-bottom__category-level-3">
                          <a href="#">세탁기</a>
                        </li>
                        <hr />
                        <li class="header-bottom__category-level-3">
                          <a href="#">건조기</a>
                        </li>
                        <hr />
                        <li class="header-bottom__category-level-3">
                          <a href="#">청소기</a>
                        </li>
                        <hr />
                        <li class="header-bottom__category-level-3">
                          <a href="#">에어컨</a>
                        </li>
                      </ul>
                    </div>
                  </li>
                </div>
                <hr />
                <div>
                  <a href="#">
                    <span>주방가전</span>
                  </a>
                  <li class="header-bottom__category-level-2">
                    <div>
                      <ul class="header-bottom__category-level-3__wrapper">
                        <li class="header-bottom__category-level-3">
                          <a href="#">냉장고</a>
                        </li>
                        <hr />
                        <li class="header-bottom__category-level-3">
                          <a href="#">김치냉장고</a>
                        </li>
                        <hr />
                        <li class="header-bottom__category-level-3">
                          <a href="#">전기밥솥</a>
                        </li>
                      </ul>
                    </div>
                  </li>
                </div>
              </ul>
            </li>
            <li class="header-bottom__category-level-1">
              <a href="#">
                <span>태블릿&#183;모바일&#183;게임</span>
              </a>
              <ul class="header-bottom__category-level-2__wrapper">
                <div>
                  <a href="#">
                    <span>태블릿/스마트폰</span>
                  </a>
                  <li class="header-bottom__category-level-2">
                    <div>
                      <ul class="header-bottom__category-level-3__wrapper">
                        <li class="header-bottom__category-level-3">
                          <a href="#">삼성</a>
                        </li>
                        <hr />
                        <li class="header-bottom__category-level-3">
                          <a href="#">애플</a>
                        </li>
                        <hr />
                        <li class="header-bottom__category-level-3">
                          <a href="#">샤오미</a>
                        </li>
                      </ul>
                    </div>
                  </li>
                </div>
                <hr />
                <div>
                  <a href="#">
                    <span>주변기기</span>
                  </a>
                  <li class="header-bottom__category-level-2">
                    <div>
                      <ul class="header-bottom__category-level-3__wrapper">
                        <li class="header-bottom__category-level-3">
                          <a href="#">스마트워치</a>
                        </li>
                        <hr />
                        <li class="header-bottom__category-level-3">
                          <a href="#">모바일 악세서리</a>
                        </li>
                        <hr />
                        <li class="header-bottom__category-level-3">
                          <a href="#">보조배터리</a>
                        </li>
                      </ul>
                    </div>
                  </li>
                </div>
                <hr />
                <div>
                  <a href="#">
                    <span>게임기</span>
                  </a>
                  <li class="header-bottom__category-level-2">
                    <div>
                      <ul class="header-bottom__category-level-3__wrapper">
                        <li class="header-bottom__category-level-3">
                          <a href="#">스위치</a>
                        </li>
                        <hr />
                        <li class="header-bottom__category-level-3">
                          <a href="#">플레이스테이션</a>
                        </li>
                        <hr />
                        <li class="header-bottom__category-level-3">
                          <a href="#">엑스박스</a>
                        </li>
                      </ul>
                    </div>
                  </li>
                </div>
              </ul>
            </li>
          </ul>
        </nav>
      </header>
      `
    );
  }
}

class Footer extends HTMLElement {
  constructor() {
    super();

    const container = document.querySelector("#container");
    container.insertAdjacentHTML(
      "beforeend",
      `
      <footer>
        <div>
          <p class="footer__logo">TEAM.<span>T</span></p>
          <p class="footer__copyright">
            Copyright &copy; TEAM.T Co. Ltd. All Rights Reserved.
          </p>
        </div>
        <div class="footer__info">
          <span
            >주소 : (우) 03048 서울특별시 종로구 청와대로 1 (세종로,
            청와대)</span
          >
          <div>
            <span>대표이사 : 레이 크록 / Ray Kroc</span>
            <span>사업자번호 : 000-00-00000</span>
          </div>
          <span>통신판매업 : 제1999-서울종로-0420호</span>
        </div>
      </footer>
      `
    );
  }
}

customElements.define("app-header", Header);
customElements.define("app-footer", Footer);
