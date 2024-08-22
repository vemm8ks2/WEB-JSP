-- 카테고리 Category 테이블
create table T_category(
	category_id NUMBER(9),												-- 카테고리식별자
	category_name VARCHAR2(50) not null,								-- 카테고리명
	category_parent_fk NUMBER(9),										-- 카테고리부모식별자
	
	primary key(category_id),											-- 기본키
	foreign key(category_parent_fk) references T_category(category_id)	-- 외래키
);