-- 카테고리 Category 테이블
CREATE TABLE T_category(
	category_id NUMBER(9),												-- 카테고리식별자
	category_name VARCHAR2(50) NOT NULL,								-- 카테고리명
	category_parent_fk NUMBER(9),										-- 카테고리부모식별자
	
	PRIMARY KEY(category_id),											-- 기본키
	FOREIGN KEY(category_parent_fk) REFERENCES T_category(category_id)	-- 외래키
);