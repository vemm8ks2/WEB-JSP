-- 주문 Order 테이블
CREATE TABLE T_order(
	order_id NUMBER(9),													-- 주문식별자 
	order_receiver_name VARCHAR2(30) NOT NULL,							-- 수취인이름
	order_receiver_phone VARCHAR2(11) NOT NULL,							-- 수취인연락처
	order_recipient_addr VARCHAR2(100) NOT NULL,						-- 수취인 주소
	order_status VARCHAR2(20) NOT NULL,									-- 주문상태
	order_created_at DATE NOT NULL,										-- 주문일
	order_delivered_at DATE,											-- 배송완료일
	order_customer_fk NUMBER(9),										-- 유저외래키
	
	PRIMARY KEY(order_id),												-- 기본키
	FOREIGN KEY(order_customer_fk) REFERENCES T_customer(customer_id)	-- 외래키
);