-- 배송지 shipping_address 테이블
CREATE TABLE T_shipping_address(
	shipping_address_id NUMBER(9),													-- 배송지식별자
	shipping_address_destination VARCHAR2(100) NOT NULL,							-- 주소지
	shipping_address_is_default CHAR(1) NOT NULL,									-- 기본배송지 여부
	shipping_address_customer_fk NUMBER(9),											-- 유저외래키
	
	PRIMARY KEY(shipping_address_id),												-- 기본키
	FOREIGN KEY(shipping_address_customer_fk) REFERENCES T_customer(customer_id)	-- 외래키
	CONSTRAINT check_is_default CHECK(shipping_address_is_default IN('Y', 'N'))
);
