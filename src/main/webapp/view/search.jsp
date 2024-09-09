<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="ko">

<body>
  <h3 class="head-typo">
    <span>&apos;플레이스테이션&apos;</span>에 대한 검색 결과
  </h3>
  <div class="display-products__container">
    <div class="display-products__filter">
      <p>필터</p>
      <hr />
      <div class="display-products__filter-sort">
        <p>정렬</p>
        <div>
          <fieldset>
            <div>
              <input
                type="radio"
                id="sort-option-radio-1"
                name="sort-filter"
                class="primary-checkmark-radio"
              />
              <label for="sort-option-radio-1">최신순</label>
            </div>
            <div>
              <input
                type="radio"
                id="sort-option-radio-2"
                name="sort-filter"
                class="primary-checkmark-radio"
              />
              <label for="sort-option-radio-2">과거순</label>
            </div>
            <div>
              <input
                type="radio"
                id="sort-option-radio-3"
                name="sort-filter"
                class="primary-checkmark-radio"
              />
              <label for="sort-option-radio-3">낮은 가격순</label>
            </div>
            <div>
              <input
                type="radio"
                id="sort-option-radio-4"
                name="sort-filter"
                class="primary-checkmark-radio"
              />
              <label for="sort-option-radio-4">높은 가격순</label>
            </div>
          </fieldset>
        </div>
      </div>
      <hr />
      <div class="display-products__filter-price">
        <p>가격</p>
        <fieldset>
          <div>
            <input
              type="radio"
              id="price-option-radio-1"
              name="price-filter"
              class="primary-radio"
            />
            <label for="price-option-radio-1">60,000원 이상</label>
          </div>
          <div>
            <input
              type="radio"
              id="price-option-radio-2"
              name="price-filter"
              class="primary-radio"
            />
            <label for="price-option-radio-2">30,000원 ~ 60,000원</label>
          </div>
          <div>
            <input
              type="radio"
              id="price-option-radio-3"
              name="price-filter"
              class="primary-radio"
            />
            <label for="price-option-radio-3">10,000원 ~ 30,000원</label>
          </div>
          <div>
            <input
              type="radio"
              id="price-option-radio-4"
              name="price-filter"
              class="primary-radio"
            />
            <label for="price-option-radio-4">10,000원 미만</label>
          </div>
        </fieldset>
      </div>
      <hr />
      <div>
        <p>카테고리</p>
        <ul class="display-products__filter-category">
          <li>
            <input
              type="checkbox"
              id="filter-category__item-1"
              name="computer_laptop"
              class="display-products__filter-category__checkbox primary-checkbox"
            />
            <label for="filter-category__item-1"
              >컴퓨터&#183;노트북</label
            >
            <ul
              class="display-products__filter-category__level-2-wrapper"
            >
              <li>
                <input
                  type="checkbox"
                  id="filter-category__item-2"
                  name="labtop_desktop"
                  class="display-products__filter-category__checkbox primary-checkbox"
                />
                <label for="filter-category__item-2"
                  >노트북/데스크탑</label
                >
                <ul
                  class="display-products__filter-category__level-3-wrapper"
                >
                  <li>
                    <input
                      type="checkbox"
                      class="primary-checkbox"
                      id="filter-category__item-3"
                      name="labtop_desktop"
                    />
                    <label for="filter-category__item-3"
                      >게이밍 노트북</label
                    >
                  </li>
                  <li>
                    <input
                      type="checkbox"
                      class="primary-checkbox"
                      id="filter-category__item-4"
                      name="labtop_desktop"
                    />
                    <label for="filter-category__item-4"
                      >사무용 노트북</label
                    >
                  </li>
                  <li>
                    <input
                      type="checkbox"
                      class="primary-checkbox"
                      id="filter-category__item-5"
                      name="labtop_desktop"
                    />
                    <label for="filter-category__item-5">브랜드 PC</label>
                  </li>
                  <li>
                    <input
                      type="checkbox"
                      class="primary-checkbox"
                      id="filter-category__item-6"
                      name="labtop_desktop"
                    />
                    <label for="filter-category__item-6"
                      >AI/딥러닝 PC</label
                    >
                  </li>
                </ul>
              </li>
              <li>
                <input
                  type="checkbox"
                  id="filter-category__item-7"
                  name="i/o_device"
                  class="display-products__filter-category__checkbox primary-checkbox"
                />
                <label for="filter-category__item-7">입출력장치</label>
                <ul
                  class="display-products__filter-category__level-3-wrapper"
                >
                  <li>
                    <input
                      type="checkbox"
                      class="primary-checkbox"
                      id="filter-category__item-8"
                      name="labtop_desktop"
                    />
                    <label for="filter-category__item-8">모니터</label>
                  </li>
                  <li>
                    <input
                      type="checkbox"
                      class="primary-checkbox"
                      id="filter-category__item-9"
                      name="labtop_desktop"
                    />
                    <label for="filter-category__item-9">키보드</label>
                  </li>
                  <li>
                    <input
                      type="checkbox"
                      class="primary-checkbox"
                      id="filter-category__item-10"
                      name="labtop_desktop"
                    />
                    <label for="filter-category__item-10">마우스</label>
                  </li>
                  <li>
                    <input
                      type="checkbox"
                      class="primary-checkbox"
                      id="filter-category__item-11"
                      name="labtop_desktop"
                    />
                    <label for="filter-category__item-11">웹캠</label>
                  </li>
                  <li>
                    <input
                      type="checkbox"
                      class="primary-checkbox"
                      id="filter-category__item-12"
                      name="labtop_desktop"
                    />
                    <label for="filter-category__item-12">프린터</label>
                  </li>
                </ul>
              </li>
              <li>
                <input
                  type="checkbox"
                  id="filter-category__item-13"
                  name="pc_parts"
                  class="display-products__filter-category__checkbox primary-checkbox"
                />
                <label for="filter-category__item-13">PC부품</label>
                <ul
                  class="display-products__filter-category__level-3-wrapper"
                >
                  <li>
                    <input
                      type="checkbox"
                      class="primary-checkbox"
                      id="filter-category__item-14"
                      name="labtop_desktop"
                    />
                    <label for="filter-category__item-14">CPU</label>
                  </li>
                  <li>
                    <input
                      type="checkbox"
                      class="primary-checkbox"
                      id="filter-category__item-15"
                      name="labtop_desktop"
                    />
                    <label for="filter-category__item-15">RAM</label>
                  </li>
                  <li>
                    <input
                      type="checkbox"
                      class="primary-checkbox"
                      id="filter-category__item-16"
                      name="labtop_desktop"
                    />
                    <label for="filter-category__item-16">SSD</label>
                  </li>
                </ul>
              </li>
            </ul>
          </li>
          <li>
            <input
              type="checkbox"
              id="filter-category__item-17"
              name="appliances_tv"
              class="display-products__filter-category__checkbox primary-checkbox"
            />
            <label for="filter-category__item-17">가전&#183;TV</label>
            <ul
              class="display-products__filter-category__level-2-wrapper"
            >
              <li>
                <input
                  type="checkbox"
                  id="filter-category__item-18"
                  name="video/audio_appliances"
                  class="display-products__filter-category__checkbox primary-checkbox"
                />
                <label for="filter-category__item-18"
                  >영상/음향가전</label
                >
                <ul
                  class="display-products__filter-category__level-3-wrapper"
                >
                  <li>
                    <input
                      type="checkbox"
                      class="primary-checkbox"
                      id="filter-category__item-19"
                      name="tv"
                    />
                    <label for="filter-category__item-19">TV</label>
                  </li>
                  <li>
                    <input
                      type="checkbox"
                      class="primary-checkbox"
                      id="filter-category__item-20"
                      name="projector"
                    />
                    <label for="filter-category__item-20">프로젝터</label>
                  </li>
                  <li>
                    <input
                      type="checkbox"
                      class="primary-checkbox"
                      id="filter-category__item-21"
                      name="set-top_box"
                    />
                    <label for="filter-category__item-21">셋톱박스</label>
                  </li>
                  <li>
                    <input
                      type="checkbox"
                      class="primary-checkbox"
                      id="filter-category__item-22"
                      name="amplifier"
                    />
                    <label for="filter-category__item-22">앰프</label>
                  </li>
                </ul>
              </li>
              <li>
                <input
                  type="checkbox"
                  id="filter-category__item-23"
                  name="living/seasonal_appliances"
                  class="display-products__filter-category__checkbox primary-checkbox"
                />
                <label for="filter-category__item-23"
                  >생활/계절가전</label
                >
                <ul
                  class="display-products__filter-category__level-3-wrapper"
                >
                  <li>
                    <input
                      type="checkbox"
                      class="primary-checkbox"
                      id="filter-category__item-24"
                      name="washing_machine"
                    />
                    <label for="filter-category__item-24">세탁기</label>
                  </li>
                  <li>
                    <input
                      type="checkbox"
                      class="primary-checkbox"
                      id="filter-category__item-25"
                      name="dryer"
                    />
                    <label for="filter-category__item-25">건조기</label>
                  </li>
                  <li>
                    <input
                      type="checkbox"
                      class="primary-checkbox"
                      id="filter-category__item-26"
                      name="vacuum_cleaner"
                    />
                    <label for="filter-category__item-26">청소기</label>
                  </li>
                  <li>
                    <input
                      type="checkbox"
                      class="primary-checkbox"
                      id="filter-category__item-27"
                      name="labtop_desktop"
                    />
                    <label for="filter-category__item-27">에어컨</label>
                  </li>
                </ul>
              </li>
              <li>
                <input
                  type="checkbox"
                  id="filter-category__item-28"
                  name="kitchen_appliances"
                  class="display-products__filter-category__checkbox primary-checkbox"
                />
                <label for="filter-category__item-28">주방가전</label>
                <ul
                  class="display-products__filter-category__level-3-wrapper"
                >
                  <li>
                    <input
                      type="checkbox"
                      class="primary-checkbox"
                      id="filter-category__item-29"
                      name="refrigerator"
                    />
                    <label for="filter-category__item-29">냉장고</label>
                  </li>
                  <li>
                    <input
                      type="checkbox"
                      class="primary-checkbox"
                      id="filter-category__item-30"
                      name="kimchi_refrigerator"
                    />
                    <label for="filter-category__item-30"
                      >김치냉장고</label
                    >
                  </li>
                  <li>
                    <input
                      type="checkbox"
                      class="primary-checkbox"
                      id="filter-category__item-31"
                      name="rice_cooker"
                    />
                    <label for="filter-category__item-31">전기밥솥</label>
                  </li>
                </ul>
              </li>
            </ul>
          </li>
          <li>
            <input
              type="checkbox"
              id="filter-category__item-32"
              name="tablet_mobile_game"
              class="display-products__filter-category__checkbox primary-checkbox"
            />
            <label for="filter-category__item-32"
              >태블릿&#183;모바일&#183;게임</label
            >
            <ul
              class="display-products__filter-category__level-2-wrapper"
            >
              <li>
                <input
                  type="checkbox"
                  id="filter-category__item-33"
                  name="tablet/smartphone"
                  class="display-products__filter-category__checkbox primary-checkbox"
                />
                <label for="filter-category__item-33"
                  >태블릿/스마트폰</label
                >
                <ul
                  class="display-products__filter-category__level-3-wrapper"
                >
                  <li>
                    <input
                      type="checkbox"
                      class="primary-checkbox"
                      id="filter-category__item-34"
                      name="samsung"
                    />
                    <label for="filter-category__item-34">삼성</label>
                  </li>
                  <li>
                    <input
                      type="checkbox"
                      class="primary-checkbox"
                      id="filter-category__item-35"
                      name="apple"
                    />
                    <label for="filter-category__item-35">애플</label>
                  </li>
                  <li>
                    <input
                      type="checkbox"
                      class="primary-checkbox"
                      id="filter-category__item-36"
                      name="xiaomi"
                    />
                    <label for="filter-category__item-36">샤오미</label>
                  </li>
                </ul>
              </li>
              <li>
                <input
                  type="checkbox"
                  id="filter-category__item-37"
                  name="peripheral"
                  class="display-products__filter-category__checkbox primary-checkbox"
                />
                <label for="filter-category__item-37">주변기기</label>
                <ul
                  class="display-products__filter-category__level-3-wrapper"
                >
                  <li>
                    <input
                      type="checkbox"
                      class="primary-checkbox"
                      id="filter-category__item-38"
                      name="smartwatch"
                    />
                    <label for="filter-category__item-38"
                      >스마트워치</label
                    >
                  </li>
                  <li>
                    <input
                      type="checkbox"
                      class="primary-checkbox"
                      id="filter-category__item-39"
                      name="mobile_accessory"
                    />
                    <label for="filter-category__item-39"
                      >모바일 악세사리</label
                    >
                  </li>
                  <li>
                    <input
                      type="checkbox"
                      class="primary-checkbox"
                      id="filter-category__item-40"
                      name="power_bank"
                    />
                    <label for="filter-category__item-40"
                      >보조배터리</label
                    >
                  </li>
                </ul>
              </li>
              <li>
                <input
                  type="checkbox"
                  id="filter-category__item-41"
                  name="video_game_console"
                  class="display-products__filter-category__checkbox primary-checkbox"
                />
                <label for="filter-category__item-41">게임기</label>
                <ul
                  class="display-products__filter-category__level-3-wrapper"
                >
                  <li>
                    <input
                      type="checkbox"
                      class="primary-checkbox"
                      id="filter-category__item-42"
                      name="nintendo_switch"
                    />
                    <label for="filter-category__item-42">스위치</label>
                  </li>
                  <li>
                    <input
                      type="checkbox"
                      class="primary-checkbox"
                      id="filter-category__item-43"
                      name="play_station"
                    />
                    <label for="filter-category__item-43"
                      >플레이스테이션</label
                    >
                  </li>
                  <li>
                    <input
                      type="checkbox"
                      class="primary-checkbox"
                      id="filter-category__item-44"
                      name="xbox"
                    />
                    <label for="filter-category__item-44">엑스박스</label>
                  </li>
                </ul>
              </li>
            </ul>
          </li>
        </ul>
      </div>
    </div>
    <div class="display-product__container">
      <p>총 14건</p>
      <div class="display-products__wrapper">
        <div class="display-products__product">
          <a href="productView.do">
            <div class="display-products__skeleton"></div>
            <p>[해운대암소갈비집] 한우 소불고기 전골</p>
            <p>15,900원</p>
          </a>
        </div>
        <div class="display-products__product">
          <a href="productView.do">
            <div class="display-products__skeleton"></div>
            <p>[오쏘몰] 오쏘몰 이뮨 드링크+정제 2박스 (60일분)</p>
            <p>169,000원</p>
          </a>
        </div>
        <div class="display-products__product">
          <a href="productView.do">
            <div class="display-products__skeleton"></div>
            <p>미국산 생 블루베리 2종</p>
            <p>4,990원</p>
          </a>
        </div>
        <div class="display-products__product">
          <a href="productView.do">
            <div class="display-products__skeleton"></div>
            <p>[소반옥] 인기 냉면 2종 (택1)</p>
            <p>8,900원</p>
          </a>
        </div>
        <div class="display-products__product">
          <a href="productView.do">
            <div class="display-products__skeleton"></div>
            <p>[해운대암소갈비집] 한우 소불고기 전골</p>
            <p>15,900원</p>
          </a>
        </div>
        <div class="display-products__product">
          <a href="productView.do">
            <div class="display-products__skeleton"></div>
            <p>[오쏘몰] 오쏘몰 이뮨 드링크+정제 2박스 (60일분)</p>
            <p>169,000원</p>
          </a>
        </div>
        <div class="display-products__product">
          <a href="productView.do">
            <div class="display-products__skeleton"></div>
            <p>미국산 생 블루베리 2종</p>
            <p>4,990원</p>
          </a>
        </div>
        <div class="display-products__product">
          <a href="productView.do">
            <div class="display-products__skeleton"></div>
            <p>[소반옥] 인기 냉면 2종 (택1)</p>
            <p>8,900원</p>
          </a>
        </div>
        <div class="display-products__product">
          <a href="productView.do">
            <div class="display-products__skeleton"></div>
            <p>[해운대암소갈비집] 한우 소불고기 전골</p>
            <p>15,900원</p>
          </a>
        </div>
        <div class="display-products__product">
          <a href="productView.do">
            <div class="display-products__skeleton"></div>
            <p>[오쏘몰] 오쏘몰 이뮨 드링크+정제 2박스 (60일분)</p>
            <p>169,000원</p>
          </a>
        </div>
        <div class="display-products__product">
          <a href="productView.do">
            <div class="display-products__skeleton"></div>
            <p>미국산 생 블루베리 2종</p>
            <p>4,990원</p>
          </a>
        </div>
        <div class="display-products__product">
          <a href="productView.do">
            <div class="display-products__skeleton"></div>
            <p>[소반옥] 인기 냉면 2종 (택1)</p>
            <p>8,900원</p>
          </a>
        </div>
        <div class="display-products__product">
          <a href="productView.do">
            <div class="display-products__skeleton"></div>
            <p>[해운대암소갈비집] 한우 소불고기 전골</p>
            <p>15,900원</p>
          </a>
        </div>
        <div class="display-products__product">
          <a href="productView.do">
            <div class="display-products__skeleton"></div>
            <p>[오쏘몰] 오쏘몰 이뮨 드링크+정제 2박스 (60일분)</p>
            <p>169,000원</p>
          </a>
        </div>
      </div>
    </div>
  </div>
</body>

</html>