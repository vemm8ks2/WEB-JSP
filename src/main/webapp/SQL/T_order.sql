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

-- 주문 데이터 삽입
INSERT INTO T_order VALUES (1, 'John Doe', '01012345678', '1234 Elm Street, Springfield, IL, USA', '발송대기', SYSDATE, NULL, 15);
INSERT INTO T_order VALUES (2, 'Jane Smith', '01023456789', '56 Avenue des Champs-Élysées, Paris, France', '배송중', SYSDATE - 2, NULL, 22);
INSERT INTO T_order VALUES (3, 'Kumar Patel', '01034567890', 'Flat 5B, 3rd Cross, Bangalore, India', '배송완료', SYSDATE - 5, SYSDATE - 1, 7);
INSERT INTO T_order VALUES (4, 'Maria Garcia', '01045678901', 'Rua das Flores, 234, Lisbon, Portugal', '주문취소', SYSDATE - 3, NULL, 29);
INSERT INTO T_order VALUES (5, 'Liam O''Connor', '01056789012', '101 Queen Street, Auckland, New Zealand', '발송대기', SYSDATE - 1, NULL, 13);
INSERT INTO T_order VALUES (6, 'Aisha Khan', '01067890123', '456 Main Road, Cairo, Egypt', '배송중', SYSDATE - 4, NULL, 3);
INSERT INTO T_order VALUES (7, 'Lucas Müller', '01078901234', '789 Königstraße, Berlin, Germany', '배송완료', SYSDATE - 6, SYSDATE - 2, 8);
INSERT INTO T_order VALUES (8, 'Sofia Rossi', '01089012345', '12 Via del Corso, Rome, Italy', '주문취소', SYSDATE - 2, NULL, 18);
INSERT INTO T_order VALUES (9, 'Jin Park', '01090123456', '34-2, Gangnam-gu, Seoul, South Korea', '발송대기', SYSDATE - 3, NULL, 9);
INSERT INTO T_order VALUES (10, 'Emma Johnson', '01001234567', '101 Oxford Street, London, UK', '배송중', SYSDATE - 7, NULL, 25);
INSERT INTO T_order VALUES (11, 'Carlos Sánchez', '01012345679', '678 Avenida de América, Madrid, Spain', '배송완료', SYSDATE - 8, SYSDATE - 3, 5);
INSERT INTO T_order VALUES (12, 'Olivia Martinez', '01023456780', '1234 King Street, Toronto, Canada', '주문취소', SYSDATE - 4, NULL, 6);
INSERT INTO T_order VALUES (13, 'Noah Brown', '01034567891', '89 Jalan Raya, Jakarta, Indonesia', '발송대기', SYSDATE - 2, NULL, 17);
INSERT INTO T_order VALUES (14, 'Lily Wilson', '01045678902', '67 Rua da Consolação, São Paulo, Brazil', '배송중', SYSDATE - 5, NULL, 20);
INSERT INTO T_order VALUES (15, 'Mia Lee', '01056789023', '43-2, Nanjing Road, Shanghai, China', '배송완료', SYSDATE - 10, SYSDATE - 4, 12);
INSERT INTO T_order VALUES (16, 'Ethan Wang', '01067890134', '987 Nanjing East Road, Taipei, Taiwan', '주문취소', SYSDATE - 6, NULL, 21);
INSERT INTO T_order VALUES (17, 'Aria Smith', '01078901245', '12 Queen Street, Sydney, Australia', '발송대기', SYSDATE - 1, NULL, 26);
INSERT INTO T_order VALUES (18, 'Oliver Scott', '01089012356', '23 Roppongi, Tokyo, Japan', '배송중', SYSDATE - 8, NULL, 19);
INSERT INTO T_order VALUES (19, 'Isabella Garcia', '01090123467', '45 Fifth Avenue, New York, USA', '배송완료', SYSDATE - 9, SYSDATE - 5, 2);
INSERT INTO T_order VALUES (20, 'William Green', '01001234578', '123 Rue de Rivoli, Paris, France', '주문취소', SYSDATE - 2, NULL, 14);
INSERT INTO T_order VALUES (21, 'Sophia Lee', '01012345680', '789 Bourbon Street, New Orleans, USA', '발송대기', SYSDATE - 4, NULL, 30);
INSERT INTO T_order VALUES (22, 'James Wilson', '01023456781', '456 Pritchard Road, Auckland, New Zealand', '배송중', SYSDATE - 6, NULL, 23);
INSERT INTO T_order VALUES (23, 'Emma Williams', '01034567892', '32 Schillerstraße, Munich, Germany', '배송완료', SYSDATE - 7, SYSDATE - 2, 27);
INSERT INTO T_order VALUES (24, 'Benjamin Brown', '01045678903', '67 Gran Via, Barcelona, Spain', '주문취소', SYSDATE - 3, NULL, 4);
INSERT INTO T_order VALUES (25, 'Mia Taylor', '01056789034', '1230 George Street, Sydney, Australia', '발송대기', SYSDATE - 5, NULL, 10);
INSERT INTO T_order VALUES (26, 'Lucas Martin', '01067890145', '432 High Street, London, UK', '배송중', SYSDATE - 7, NULL, 11);
INSERT INTO T_order VALUES (27, 'Chloe Anderson', '01078901256', '9 Rue du Faubourg Saint-Honoré, Paris, France', '배송완료', SYSDATE - 9, SYSDATE - 3, 16);
INSERT INTO T_order VALUES (28, 'Ethan Thomas', '01089012367', '567 Canal Street, New York, USA', '주문취소', SYSDATE - 4, NULL, 28);
INSERT INTO T_order VALUES (29, 'Harper Jackson', '01090123478', '1234 Queen Street, Toronto, Canada', '발송대기', SYSDATE - 2, NULL, 24);
INSERT INTO T_order VALUES (30, 'Liam Garcia', '01001234579', '789 George Street, Sydney, Australia', '배송중', SYSDATE - 6, NULL, 30);
INSERT INTO T_order VALUES (31, 'Ava Rodriguez', '01012345681', '2345 Main Street, Los Angeles, USA', '배송완료', SYSDATE - 8, SYSDATE - 4, 22);
INSERT INTO T_order VALUES (32, 'Mason Lee', '01023456782', '345 Orchard Road, Singapore', '주문취소', SYSDATE - 3, NULL, 13);
INSERT INTO T_order VALUES (33, 'Sophie Martin', '01034567893', '789 Deansgate, Manchester, UK', '발송대기', SYSDATE - 1, NULL, 6);
INSERT INTO T_order VALUES (34, 'Logan White', '01045678904', '12 Bay Street, Sydney, Australia', '배송중', SYSDATE - 5, NULL, 9);
INSERT INTO T_order VALUES (35, 'Mia Thompson', '01056789045', '345 Yonge Street, Toronto, Canada', '배송완료', SYSDATE - 7, SYSDATE - 2, 15);
INSERT INTO T_order VALUES (36, 'Ella Hall', '01067890156', '789 Ratchadamri Road, Bangkok, Thailand', '주문취소', SYSDATE - 4, NULL, 20);
INSERT INTO T_order VALUES (37, 'Noah Robinson', '01078901267', '23 Raffles Place, Singapore', '발송대기', SYSDATE - 2, NULL, 12);
INSERT INTO T_order VALUES (38, 'Avery Johnson', '01089012378', '456 Queen Street, Melbourne, Australia', '배송중', SYSDATE - 6, NULL, 18);
INSERT INTO T_order VALUES (39, 'Jackson Clark', '01090123489', '12 Wall Street, New York, USA', '배송완료', SYSDATE - 9, SYSDATE - 3, 7);
INSERT INTO T_order VALUES (40, 'Zoe Davis', '01001234580', '789 Rue du Bac, Paris, France', '주문취소', SYSDATE - 5, NULL, 8);
INSERT INTO T_order VALUES (41, 'Mia Lewis', '01012345682', '567 Orchard Road, Singapore', '발송대기', SYSDATE - 1, NULL, 16);
INSERT INTO T_order VALUES (42, 'Oliver King', '01023456783', '123 Bond Street, London, UK', '배송중', SYSDATE - 4, NULL, 25);
INSERT INTO T_order VALUES (43, 'Harper Wright', '01034567894', '78 Kings Road, Melbourne, Australia', '배송완료', SYSDATE - 7, SYSDATE - 3, 21);
INSERT INTO T_order VALUES (44, 'Benjamin Miller', '01045678905', '234 Oxford Street, London, UK', '주문취소', SYSDATE - 2, NULL, 28);
INSERT INTO T_order VALUES (45, 'Evelyn Nelson', '01056789056', '345 King''s Road, Hong Kong', '발송대기', SYSDATE - 3, NULL, 30);
INSERT INTO T_order VALUES (46, 'Jackson Young', '01067890167', '456 High Street, Dublin, Ireland', '배송중', SYSDATE - 6, NULL, 11);
INSERT INTO T_order VALUES (47, 'Aria Scott', '01078901278', '12 Bond Street, New York, USA', '배송완료', SYSDATE - 8, SYSDATE - 4, 19);
INSERT INTO T_order VALUES (48, 'Eli Adams', '01089012389', '34 Leopold Street, Johannesburg, South Africa', '주문취소', SYSDATE - 2, NULL, 24);
INSERT INTO T_order VALUES (49, 'Amelia Baker', '01090123490', '1230 Newbury Street, Boston, USA', '발송대기', SYSDATE - 1, NULL, 9);
INSERT INTO T_order VALUES (50, 'Mason Carter', '01001234581', '567 Port Road, Perth, Australia', '배송중', SYSDATE - 5, NULL, 5);
