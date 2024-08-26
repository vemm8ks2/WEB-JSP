CREATE TABLE T_admin (
	admin_id NUMBER(9) NOT NULL,
	admin_login_id VARCHAR2(30) NOT NULL,
	admin_password VARCHAR2(256) NOT NULL,
	admin_name VARCHAR2(30) NOT NULL,
	admin_email VARCHAR2(30),
	admin_phone_numbr VARCHAR2(11) NOT NULL,
	admin_created_at DATE NOT NULL,
	admin_last_accessed_at DATE	NOT NULL,
	admin_last_accessed_ip VARCHAR2(16)	NOT NULL
);

-- 유저 User 테이블
CREATE TABLE T_customer(
	customer_id NUMBER(9),							-- 유저식별자
	customer_login_id VARCHAR2(30) NOT NULL,		-- 유저아이디
	customer_password VARCHAR2(256) NOT NULL,		-- 유저비밀번호
	customer_name VARCHAR2(30) NOT NULL,			-- 유저이름
	customer_email VARCHAR2(30),					-- 유저이메일
	customer_phone_number VARCHAR2(11) NOT NULL,	-- 유저연락처
	customer_gender VARCHAR2(20),					-- 유저성별
	customer_birth 	DATE,							-- 유저생일
	customer_created_at DATE NOT NULL,				-- 회원가입일
	customer_updated_at DATE,						-- 업데이트일
	
	PRIMARY KEY(customer_id)						-- 기본키
);

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

-- 카테고리 Category 테이블
CREATE TABLE T_category(
	category_id NUMBER(9),												-- 카테고리식별자
	category_name VARCHAR2(50) NOT NULL,								-- 카테고리명
	category_parent_fk NUMBER(9),										-- 카테고리부모식별자
	
	PRIMARY KEY(category_id),											-- 기본키
	FOREIGN KEY(category_parent_fk) REFERENCES T_category(category_id)	-- 외래키
);

-- 상품 Product 테이블
CREATE TABLE T_product(
	product_id NUMBER(9),										-- 상품식별자
	product_name VARCHAR2(50) NOT NULL,							-- 상품명
	product_price NUMBER(9) DEFAULT 0 NOT NULL,					-- 상품가격
	product_stock NUMBER(5) DEFAULT 0 NOT NULL,					-- 상품재고
	product_image VARCHAR2(1000) NOT NULL,						-- 상품이미지
	product_created_at DATE NOT NULL,							-- 상품생성일
	product_updated_at DATE,										-- 업데이트일
	product_category_fk NUMBER(9),								-- 카테고리식별자
	
	PRIMARY KEY(product_id),											-- 기본키
	FOREIGN KEY(product_category_fk) REFERENCES T_category(category_id)	-- 카테고리외래키
);

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

-- 배송지 shipping_address 테이블
CREATE TABLE T_shipping_address(
	shipping_address_id NUMBER(9),													-- 배송지식별자
	shipping_address_destination VARCHAR2(100) NOT NULL,							-- 주소지
	shipping_address_is_default CHAR(1) NOT NULL,									-- 기본배송지 여부
	shipping_address_customer_fk NUMBER(9),											-- 유저외래키
	
	PRIMARY KEY(shipping_address_id),												-- 기본키
	FOREIGN KEY(shipping_address_customer_fk) REFERENCES T_customer(customer_id),	-- 외래키
	CONSTRAINT check_is_default CHECK(shipping_address_is_default IN('Y', 'N'))     -- 제약조건
);
