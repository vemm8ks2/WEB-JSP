-- 주문하다 Order_product 테이블
CREATE TABLE T_ordered_product(
	ordered_product_id NUMBER(9),												--주문하다식별자
	ordered_product_qunatity NUMBER(4) NOT NULL,								-- 주문수량
	ordered_product_order_fk NUMBER(9),										    -- 주문외래키
	ordered_product_product_fk NUMBER(9),										-- 상품외래키
	
	PRIMARY KEY(ordered_product_id),											-- 기본키
	FOREIGN KEY(ordered_product_order_fk) REFERENCES T_order(order_id),         -- 주문외래
	FOREIGN KEY(ordered_product_product_fk) REFERENCES T_product(product_id) 	-- 상품외래키
);