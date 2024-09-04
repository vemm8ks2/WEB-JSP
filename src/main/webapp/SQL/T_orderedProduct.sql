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

-- OrderedProduct 데이터 삽입
INSERT INTO T_ordered_product VALUES (1, 3, 1, 5);  -- 주문 ID 1에서 제품 ID 5를 3개 주문
INSERT INTO T_ordered_product VALUES (2, 2, 1, 12); -- 주문 ID 1에서 제품 ID 12를 2개 주문
INSERT INTO T_ordered_product VALUES (3, 10, 1, 20); -- 주문 ID 1에서 제품 ID 20을 10개 주문
INSERT INTO T_ordered_product VALUES (4, 4, 1, 8);  -- 주문 ID 1에서 제품 ID 8을 4개 주문
INSERT INTO T_ordered_product VALUES (5, 5, 1, 25); -- 주문 ID 1에서 제품 ID 25를 5개 주문
INSERT INTO T_ordered_product VALUES (6, 2, 1, 14); -- 주문 ID 1에서 제품 ID 14를 2개 주문
INSERT INTO T_ordered_product VALUES (7, 3, 2, 30); -- 주문 ID 2에서 제품 ID 30을 3개 주문
INSERT INTO T_ordered_product VALUES (8, 1, 3, 11); -- 주문 ID 3에서 제품 ID 11을 1개 주문
INSERT INTO T_ordered_product VALUES (9, 6, 3, 22); -- 주문 ID 3에서 제품 ID 22를 6개 주문
INSERT INTO T_ordered_product VALUES (10, 4, 3, 7); -- 주문 ID 3에서 제품 ID 7을 4개 주문
INSERT INTO T_ordered_product VALUES (11, 5, 3, 13);-- 주문 ID 3에서 제품 ID 13을 5개 주문
INSERT INTO T_ordered_product VALUES (12, 2, 3, 9); -- 주문 ID 3에서 제품 ID 9를 2개 주문
INSERT INTO T_ordered_product VALUES (13, 3, 3, 28);-- 주문 ID 3에서 제품 ID 28을 3개 주문
INSERT INTO T_ordered_product VALUES (14, 4, 3, 15);-- 주문 ID 3에서 제품 ID 15를 4개 주문
INSERT INTO T_ordered_product VALUES (15, 11, 4, 18);-- 주문 ID 4에서 제품 ID 18을 11개 주문
INSERT INTO T_ordered_product VALUES (16, 6, 4, 10);-- 주문 ID 4에서 제품 ID 10을 6개 주문
INSERT INTO T_ordered_product VALUES (17, 2, 4, 21);-- 주문 ID 4에서 제품 ID 21을 2개 주문
INSERT INTO T_ordered_product VALUES (18, 3, 5, 3); -- 주문 ID 5에서 제품 ID 3를 3개 주문
INSERT INTO T_ordered_product VALUES (19, 7, 5, 16);-- 주문 ID 5에서 제품 ID 16을 7개 주문
INSERT INTO T_ordered_product VALUES (20, 1, 5, 4);-- 주문 ID 5에서 제품 ID 4를 1개 주문
INSERT INTO T_ordered_product VALUES (21, 5, 6, 27); -- 주문 ID 6에서 제품 ID 27을 5개 주문
INSERT INTO T_ordered_product VALUES (22, 4, 6, 6);-- 주문 ID 6에서 제품 ID 6을 4개 주문
INSERT INTO T_ordered_product VALUES (23, 3, 6, 23); -- 주문 ID 6에서 제품 ID 23을 3개 주문
INSERT INTO T_ordered_product VALUES (24, 20, 6, 19); -- 주문 ID 6에서 제품 ID 19를 20개 주문
INSERT INTO T_ordered_product VALUES (25, 6, 6, 31); -- 주문 ID 6에서 제품 ID 31을 6개 주문
INSERT INTO T_ordered_product VALUES (26, 12, 6, 2);-- 주문 ID 6에서 제품 ID 2를 12개 주문
INSERT INTO T_ordered_product VALUES (27, 7, 6, 26); -- 주문 ID 6에서 제품 ID 26을 7개 주문
INSERT INTO T_ordered_product VALUES (28, 4, 6, 24); -- 주문 ID 6에서 제품 ID 24를 4개 주문
INSERT INTO T_ordered_product VALUES (29, 2, 6, 29); -- 주문 ID 6에서 제품 ID 29를 2개 주문
INSERT INTO T_ordered_product VALUES (30, 5, 7, 17); -- 주문 ID 7에서 제품 ID 17을 5개 주문
INSERT INTO T_ordered_product VALUES (31, 3, 8, 32); -- 주문 ID 8에서 제품 ID 32를 3개 주문
INSERT INTO T_ordered_product VALUES (32, 6, 9, 1);-- 주문 ID 9에서 제품 ID 1을 6개 주문
INSERT INTO T_ordered_product VALUES (33, 4, 10, 33); -- 주문 ID 10에서 제품 ID 33을 4개 주문
INSERT INTO T_ordered_product VALUES (34, 2, 10, 34); -- 주문 ID 10에서 제품 ID 34를 2개 주문
INSERT INTO T_ordered_product VALUES (35, 5, 10, 35); -- 주문 ID 10에서 제품 ID 35를 5개 주문
INSERT INTO T_ordered_product VALUES (36, 3, 10, 36); -- 주문 ID 10에서 제품 ID 36을 3개 주문
INSERT INTO T_ordered_product VALUES (37, 4, 10, 37); -- 주문 ID 10에서 제품 ID 37을 4개 주문
INSERT INTO T_ordered_product VALUES (38, 2, 10, 38); -- 주문 ID 10에서 제품 ID 38을 2개 주문
INSERT INTO T_ordered_product VALUES (39, 6, 10, 39); -- 주문 ID 10에서 제품 ID 39를 6개 주문
INSERT INTO T_ordered_product VALUES (40, 5, 10, 40); -- 주문 ID 10에서 제품 ID 40을 5개 주문
INSERT INTO T_ordered_product VALUES (41, 3, 10, 22); -- 주문 ID 10에서 제품 ID 22를 3개 주문
INSERT INTO T_ordered_product VALUES (42, 2, 11, 23); -- 주문 ID 11에서 제품 ID 23을 2개 주문
INSERT INTO T_ordered_product VALUES (43, 4, 11, 24); -- 주문 ID 11에서 제품 ID 24를 4개 주문
INSERT INTO T_ordered_product VALUES (44, 6, 11, 25); -- 주문 ID 11에서 제품 ID 25를 6개 주문
INSERT INTO T_ordered_product VALUES (45, 5, 11, 26); -- 주문 ID 11에서 제품 ID 26을 5개 주문
INSERT INTO T_ordered_product VALUES (46, 2, 11, 27); -- 주문 ID 11에서 제품 ID 27을 2개 주문
INSERT INTO T_ordered_product VALUES (47, 3, 12, 28); -- 주문 ID 12에서 제품 ID 28을 3개 주문
INSERT INTO T_ordered_product VALUES (48, 7, 12, 29); -- 주문 ID 12에서 제품 ID 29를 7개 주문
INSERT INTO T_ordered_product VALUES (49, 13, 13, 30); -- 주문 ID 13에서 제품 ID 30을 13개 주문
INSERT INTO T_ordered_product VALUES (50, 5, 13, 31); -- 주문 ID 13에서 제품 ID 31을 5개 주문
INSERT INTO T_ordered_product VALUES (51, 3, 14, 6);  -- 주문 ID 14에서 제품 ID 6을 3개 주문
INSERT INTO T_ordered_product VALUES (52, 4, 14, 19); -- 주문 ID 14에서 제품 ID 19를 4개 주문
INSERT INTO T_ordered_product VALUES (53, 2, 14, 13); -- 주문 ID 14에서 제품 ID 13을 2개 주문
INSERT INTO T_ordered_product VALUES (54, 5, 14, 9);  -- 주문 ID 14에서 제품 ID 9를 5개 주문
INSERT INTO T_ordered_product VALUES (55, 3, 14, 15); -- 주문 ID 14에서 제품 ID 15를 3개 주문
INSERT INTO T_ordered_product VALUES (56, 1, 14, 22); -- 주문 ID 14에서 제품 ID 22를 1개 주문
INSERT INTO T_ordered_product VALUES (57, 6, 17, 18); -- 주문 ID 17에서 제품 ID 18을 6개 주문
INSERT INTO T_ordered_product VALUES (58, 4, 17, 34); -- 주문 ID 17에서 제품 ID 34를 4개 주문
INSERT INTO T_ordered_product VALUES (59, 2, 17, 10); -- 주문 ID 17에서 제품 ID 10을 2개 주문
INSERT INTO T_ordered_product VALUES (60, 7, 17, 20); -- 주문 ID 17에서 제품 ID 20을 7개 주문
INSERT INTO T_ordered_product VALUES (61, 3, 17, 12); -- 주문 ID 17에서 제품 ID 12를 3개 주문
INSERT INTO T_ordered_product VALUES (62, 5, 17, 27); -- 주문 ID 17에서 제품 ID 27을 5개 주문
INSERT INTO T_ordered_product VALUES (63, 4, 17, 7);  -- 주문 ID 17에서 제품 ID 7을 4개 주문
INSERT INTO T_ordered_product VALUES (64, 2, 18, 28); -- 주문 ID 18에서 제품 ID 28을 2개 주문
INSERT INTO T_ordered_product VALUES (65, 6, 18, 5);  -- 주문 ID 18에서 제품 ID 5를 6개 주문
INSERT INTO T_ordered_product VALUES (66, 1, 19, 31); -- 주문 ID 19에서 제품 ID 31을 1개 주문
INSERT INTO T_ordered_product VALUES (67, 3, 20, 24); -- 주문 ID 20에서 제품 ID 24를 3개 주문
INSERT INTO T_ordered_product VALUES (68, 7, 20, 26); -- 주문 ID 20에서 제품 ID 26을 7개 주문
INSERT INTO T_ordered_product VALUES (69, 2, 20, 30);-- 주문 ID 20에서 제품 ID 30을 2개 주문
INSERT INTO T_ordered_product VALUES (70, 4, 21, 36);-- 주문 ID 21에서 제품 ID 36을 4개 주문
INSERT INTO T_ordered_product VALUES (71, 3, 22, 11);-- 주문 ID 22에서 제품 ID 11을 3개 주문
INSERT INTO T_ordered_product VALUES (72, 6, 23, 21);-- 주문 ID 23에서 제품 ID 21을 6개 주문
INSERT INTO T_ordered_product VALUES (73, 5, 24, 13);-- 주문 ID 24에서 제품 ID 13을 5개 주문
INSERT INTO T_ordered_product VALUES (74, 2, 25, 35);-- 주문 ID 25에서 제품 ID 35를 2개 주문
INSERT INTO T_ordered_product VALUES (75, 4, 25, 17);-- 주문 ID 25에서 제품 ID 17을 4개 주문
INSERT INTO T_ordered_product VALUES (76, 16, 26, 39);-- 주문 ID 26에서 제품 ID 39를 16개 주문
INSERT INTO T_ordered_product VALUES (77, 7, 27, 14);-- 주문 ID 27에서 제품 ID 14를 7개 주문
INSERT INTO T_ordered_product VALUES (78, 3, 27, 25);-- 주문 ID 27에서 제품 ID 25를 3개 주문
INSERT INTO T_ordered_product VALUES (79, 6, 27, 8); -- 주문 ID 27에서 제품 ID 8을 6개 주문
INSERT INTO T_ordered_product VALUES (80, 4, 27, 23);-- 주문 ID 27에서 제품 ID 23을 4개 주문
INSERT INTO T_ordered_product VALUES (81, 2, 28, 2); -- 주문 ID 28에서 제품 ID 2를 2개 주문
INSERT INTO T_ordered_product VALUES (82, 5, 28, 26);-- 주문 ID 28에서 제품 ID 26을 5개 주문
INSERT INTO T_ordered_product VALUES (83, 3, 29, 3); -- 주문 ID 29에서 제품 ID 3을 3개 주문
INSERT INTO T_ordered_product VALUES (84, 4, 30, 4); -- 주문 ID 30에서 제품 ID 4를 4개 주문
INSERT INTO T_ordered_product VALUES (85, 6, 30, 7); -- 주문 ID 30에서 제품 ID 7을 6개 주문
INSERT INTO T_ordered_product VALUES (86, 2, 30, 20);-- 주문 ID 30에서 제품 ID 20을 2개 주문
INSERT INTO T_ordered_product VALUES (87, 7, 30, 9); -- 주문 ID 30에서 제품 ID 9을 7개 주문
INSERT INTO T_ordered_product VALUES (88, 5, 30, 12);-- 주문 ID 30에서 제품 ID 12를 5개 주문
INSERT INTO T_ordered_product VALUES (89, 4, 30, 6); -- 주문 ID 30에서 제품 ID 6을 4개 주문
INSERT INTO T_ordered_product VALUES (90, 3, 31, 33);-- 주문 ID 31에서 제품 ID 33을 3개 주문
INSERT INTO T_ordered_product VALUES (91, 2, 31, 19);-- 주문 ID 31에서 제품 ID 19를 2개 주문
INSERT INTO T_ordered_product VALUES (92, 6, 32, 25);-- 주문 ID 32에서 제품 ID 25를 6개 주문
INSERT INTO T_ordered_product VALUES (93, 7, 32, 11);-- 주문 ID 32에서 제품 ID 11을 7개 주문
INSERT INTO T_ordered_product VALUES (94, 3, 33, 32);-- 주문 ID 33에서 제품 ID 32를 3개 주문
INSERT INTO T_ordered_product VALUES (95, 4, 34, 28);-- 주문 ID 34에서 제품 ID 28을 4개 주문
INSERT INTO T_ordered_product VALUES (96, 5, 34, 30);-- 주문 ID 34에서 제품 ID 30을 5개 주문
INSERT INTO T_ordered_product VALUES (97, 2, 34, 18);-- 주문 ID 34에서 제품 ID 18을 2개 주문
INSERT INTO T_ordered_product VALUES (98, 6, 35, 40);-- 주문 ID 35에서 제품 ID 40을 6개 주문
INSERT INTO T_ordered_product VALUES (99, 3, 35, 8); -- 주문 ID 35에서 제품 ID 8을 3개 주문
INSERT INTO T_ordered_product VALUES (100, 7, 35, 37); -- 주문 ID 35에서 제품 ID 37을 7개 주문
