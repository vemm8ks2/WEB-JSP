-- 배송지 shipping_address 테이블
create table T_shipping_address(
	shipping_address_id NUMBER(9),													-- 배송지식별자
	shipping_address_destination VARCHAR2(100) not null,									-- 주소지
	shipping_address_is_default CHAR(1) not null,									-- 기본배송지 여부
	shipping_address_customer_fk NUMBER(9),											-- 유저외래키
	
	primary key(shipping_address_id),												-- 기본키
	foreign key(shipping_address_customer_fk) references T_customer(customer_id)		-- 외래키
);
