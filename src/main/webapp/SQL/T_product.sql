-- 상품 Product 테이블
CREATE TABLE T_product(
	product_id NUMBER(9),										-- 상품식별자
	product_name VARCHAR2(50) NOT NULL,							-- 상품명
	product_price NUMBER(9) DEFAULT 0 NOT NULL,					-- 상품가격
	product_stock NUMBER(5) DEFAULT 0 NOT NULL,					-- 상품재고
	product_image VARCHAR2(1000) NOT NULL,						-- 상품이미지
	product_createdAt DATE NOT NULL,							-- 상품생성일
	product_updateAt DATE,										-- 업데이트일
	product_category_fk NUMBER(9),								-- 카테고리식별자
	
	PRIMARY KEY(product_id),											-- 기본키
	FOREIGN KEY(product_category_fk) REFERENCES T_category(category_id)	-- 카테고리외래키
);