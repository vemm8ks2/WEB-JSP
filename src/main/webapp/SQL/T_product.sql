-- 상품 Product 테이블
create table T_product(
	product_id NUMBER(9),										-- 상품식별자
	product_name VARCHAR2(50) not null,							-- 상품명
	product_price NUMBER(9) not null,							-- 상품가격
	product_stock NUMBER(5) not null,							-- 상품재고
	product_image VARCHAR2(1000) not null,						-- 상품이미지
	product_createdAt DATE not null,							-- 상품생성일
	product_updateAt DATE not null,								-- 업데이트일
	product_category_fk NUMBER(9),								-- 카테고리식별자
	
	primary key(product_id),											-- 기본키
	foreign key(product_category_fk) references T_category(category_id)	-- 카테고리외래키
);