-- 주문하다 Order_product 테이블
create table T_orderedProduct(
	orderedProduct_id NUMBER(9),												--주문하다식별자
	orderedProduct_qunatity NUMBER(4) not null,									-- 주문수량
	orderedProduct_order_Fk NUMBER(9),										    -- 주문외래키
	orderedProduct_product_Fk NUMBER(9),										-- 상품외래키
	
	primary key(orderedProduct_id),												-- 기본키
	foreign key(orderedProduct_order_Fk) references T_order(order_id),          -- 주문외래
	foreign key(orderedProduct_product_Fk) references T_product(product_id) 	-- 상품외래키
);