-- 유저 User 테이블
create table T_customer(
	customer_id NUMBER(9),							-- 유저식별자
	customer_login_id VARCHAR2(30) not null,		-- 유저아이디
	customer_password VARCHAR2(256) not null,		-- 유저비밀번호
	customer_name VARCHAR2(30) not null,			-- 유저이름
	customer_email VARCHAR2(30),					-- 유저이메일
	customer_phone_number VARCHAR2(11) not null,	-- 유저연락처
	customer_gender CHAR(1),						-- 유저성별
	customer_birth 	DATE,							-- 유저생일
	customer_created_at DATE not null,				-- 회원가입일
	customer_updated_at DATE,						-- 업데이트일
	
	primary key(customer_id)						-- 기본키
);