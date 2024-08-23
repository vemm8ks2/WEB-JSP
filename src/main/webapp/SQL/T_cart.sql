-- 장바구니 Cart 테이블
create table T_cart(
	cart_id NUMBER(9),													-- 장바구니식별자
	cart_product_count NUMBER(4) not null,								-- 상품개수
	cart_customer_Fk NUMBER(9),											-- 유저외래키
	cart_product_Fk NUMBER(9),											-- 상품외래키
	
	primary key(cart_id),												-- 기본키
	foreign key(cart_customer_Fk) references T_customer(customer_id),	-- 외래키
	foreign key(cart_product_Fk) references T_product(product_id)		-- 외래키
);
