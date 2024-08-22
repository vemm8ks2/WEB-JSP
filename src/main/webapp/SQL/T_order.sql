-- 주문 Order 테이블
create table T_order(
	order_id NUMBER(9),											-- 주문식별자 
	order_receiver_name VARCHAR2(30) not null,					-- 수취인이름
	order_receiver_phone VARCHAR2(11) not null,					-- 수취인연락처
	order_recipient_addr VARCHAR2(100) not null,				-- 수취인 주소
	order_status VARCHAR2(20) not null,							-- 주문상태
	order_created_at DATE not null,								-- 주문일
	order_delivered_at DATE not null,							-- 배송완료일
	order_customer_Fk NUMBER(9),									-- 유저외래키
	
	primary key(order_id),										-- 기본키
	foreign key(order_customer_Fk) references T_customer(customer_id)	-- 외래키
);