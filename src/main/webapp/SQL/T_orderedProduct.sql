-- 주문하다 Order_product 테이블
create table T_ordered_product(
	ordered_product_id NUMBER(9),												--주문하다식별자
	ordered_product_qunatity NUMBER(4) not null,									-- 주문수량
	ordered_product_order_Fk NUMBER(9),										    -- 주문외래키
	ordered_product_product_Fk NUMBER(9),										-- 상품외래키
	
	primary key(ordered_product_id),												-- 기본키
	foreign key(ordered_product_order_fk) references T_order(order_id),          -- 주문외래
	foreign key(ordered_product_product_fk) references T_product(product_id) 	-- 상품외래키
);