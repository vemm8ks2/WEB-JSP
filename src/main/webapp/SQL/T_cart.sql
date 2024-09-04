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

-- 카트 데이터 삽입
INSERT INTO T_cart VALUES (1, 3, 12, 25);
INSERT INTO T_cart VALUES (2, 1, 8, 33);
INSERT INTO T_cart VALUES (3, 4, 1, 7);
INSERT INTO T_cart VALUES (4, 2, 29, 19);
INSERT INTO T_cart VALUES (5, 5, 1, 40);
INSERT INTO T_cart VALUES (6, 3, 18, 11);
INSERT INTO T_cart VALUES (7, 1, 7, 5);
INSERT INTO T_cart VALUES (8, 2, 20, 27);
INSERT INTO T_cart VALUES (9, 4, 9, 38);
INSERT INTO T_cart VALUES (10, 3, 6, 14);
INSERT INTO T_cart VALUES (11, 2, 2, 9);
INSERT INTO T_cart VALUES (12, 1, 30, 22);
INSERT INTO T_cart VALUES (13, 5, 13, 31);
INSERT INTO T_cart VALUES (14, 4, 10, 8);
INSERT INTO T_cart VALUES (15, 3, 16, 35);
INSERT INTO T_cart VALUES (16, 2, 30, 20);
INSERT INTO T_cart VALUES (17, 4, 27, 18);
INSERT INTO T_cart VALUES (18, 1, 10, 24);
INSERT INTO T_cart VALUES (19, 3, 23, 40);
INSERT INTO T_cart VALUES (20, 5, 4, 2);
INSERT INTO T_cart VALUES (21, 2, 28, 15);
INSERT INTO T_cart VALUES (22, 1, 17, 29);
INSERT INTO T_cart VALUES (23, 4, 12, 32);
INSERT INTO T_cart VALUES (24, 3, 5, 10);
INSERT INTO T_cart VALUES (25, 2, 2, 36);
INSERT INTO T_cart VALUES (26, 5, 14, 1);
INSERT INTO T_cart VALUES (27, 1, 2, 7);
INSERT INTO T_cart VALUES (28, 4, 2, 28);
INSERT INTO T_cart VALUES (29, 3, 29, 23);
INSERT INTO T_cart VALUES (30, 2, 29, 39);
