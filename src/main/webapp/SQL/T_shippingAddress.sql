-- 배송지 shipping_address 테이블
create table T_shippingAddress(
	shippingAddress_id NUMBER(9),													-- 배송지식별자
	shippingAddress_address VARCHAR2(100) not null,									-- 주소지
	shippingAddress_id_default CHAR(1) not null,									-- 기본배송지 여부
	shippingAddress_customer_Fk NUMBER(9),											-- 유저외래키
	
	primary key(shippingAddress_id),												-- 기본키
	foreign key(shippingAddress_customer_Fk) references T_customer(customer_id)		-- 외래키
);