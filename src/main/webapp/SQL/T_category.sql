-- 카테고리 Category 테이블
CREATE TABLE T_category(
	category_id NUMBER(9),												-- 카테고리식별자
	category_name VARCHAR2(50) NOT NULL,								-- 카테고리명
	category_parent_fk NUMBER(9),										-- 카테고리부모식별자
	
	PRIMARY KEY(category_id),											-- 기본키
	FOREIGN KEY(category_parent_fk) REFERENCES T_category(category_id)	-- 외래키
);

-- 카테고리 데이터 삽입
---- 첫 번째 카테고리
INSERT INTO T_category VALUES(1, '컴퓨터·노트북', '');

INSERT INTO T_category VALUES(2, '노트북/데스크탑', 1);
INSERT INTO T_category VALUES(3, '입출력장치', 1);
INSERT INTO T_category VALUES(4, 'PC부품', 1);

INSERT INTO T_category VALUES(5, '게이밍 노트북', 2);
INSERT INTO T_category VALUES(6, '사무용 노트북', 2);
INSERT INTO T_category VALUES(7, '브랜드 PC', 2);
INSERT INTO T_category VALUES(8, 'AI/딥러닝 PC', 2);

INSERT INTO T_category VALUES(9, '모니터', 3);
INSERT INTO T_category VALUES(10, '키보드', 3);
INSERT INTO T_category VALUES(11, '마우스', 3);
INSERT INTO T_category VALUES(12, '웹캠', 3);
INSERT INTO T_category VALUES(13, '프린터', 3);

INSERT INTO T_category VALUES(14, 'CPU', 4);
INSERT INTO T_category VALUES(15, 'RAM', 4);
INSERT INTO T_category VALUES(16, 'SSD', 4);

---- 두 번째 카테고리
INSERT INTO T_category VALUES(17, '가전·TV', '');

INSERT INTO T_category VALUES(18, '영상/음향가전', 17);
INSERT INTO T_category VALUES(19, '생활/계절가전', 17);
INSERT INTO T_category VALUES(20, '주방가전', 17);

INSERT INTO T_category VALUES(21, 'TV', 18);
INSERT INTO T_category VALUES(22, '프로젝터', 18);
INSERT INTO T_category VALUES(23, '셋톱박스', 18);
INSERT INTO T_category VALUES(24, '사운드바', 18);
INSERT INTO T_category VALUES(25, '앰프', 18);

INSERT INTO T_category VALUES(26, '세탁기', 19);
INSERT INTO T_category VALUES(27, '건조기', 19);
INSERT INTO T_category VALUES(28, '청소기', 19);
INSERT INTO T_category VALUES(29, '에어컨', 19);

INSERT INTO T_category VALUES(30, '냉장고', 20);
INSERT INTO T_category VALUES(31, '김치냉장고', 20);
INSERT INTO T_category VALUES(32, '전기밥솥', 20);

---- 세 번째 카테고리
INSERT INTO T_category VALUES(33, '태블릿·모바일·게임', '');

INSERT INTO T_category VALUES(34, '태블릿/스마트폰', 33);
INSERT INTO T_category VALUES(35, '주변기기', 33);
INSERT INTO T_category VALUES(36, '게임기', 33);

INSERT INTO T_category VALUES(37, '삼성', 34);
INSERT INTO T_category VALUES(38, '애플', 34);
INSERT INTO T_category VALUES(39, '샤오미', 34);

INSERT INTO T_category VALUES(40, '스마트워치', 35);
INSERT INTO T_category VALUES(41, '모바일 악세서리', 35);
INSERT INTO T_category VALUES(42, '보조배터리', 35);

INSERT INTO T_category VALUES(43, '스위치', 36);
INSERT INTO T_category VALUES(44, '플레이스테이션', 36);
INSERT INTO T_category VALUES(45, '엑스박스', 36);
