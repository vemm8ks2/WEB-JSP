-- 장바구니 Cart 테이블
CREATE TABLE T_cart(
	cart_id NUMBER(9),													-- 장바구니식별자
	cart_product_count NUMBER(4) DEFAULT 1 NOT NULL,					-- 상품개수
	cart_customer_fk NUMBER(9),											-- 유저외래키
	cart_product_fk NUMBER(9),											-- 상품외래키
	
	PRIMARY KEY(cart_id),												-- 기본키
	FOREIGN KEY(cart_customer_fk) REFERENCES T_customer(customer_id),	-- 외래키
	FOREIGN KEY(cart_product_fk) REFERENCES T_product(product_id)		-- 외래키
);
