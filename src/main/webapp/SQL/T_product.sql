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

-- 상품 데이터 삽입
INSERT INTO T_product VALUES (1, 'Wireless Mouse', 25000, 100, 'http://example.com/images/tmp.jpg', SYSDATE, '', 11); -- 마우스 (입출력장치)
INSERT INTO T_product VALUES (2, 'Bluetooth Headphones', 75000, 50, 'http://example.com/images/tmp.jpg', SYSDATE, '', 18); -- 사운드바 (영상/음향가전)
INSERT INTO T_product VALUES (3, '4K Ultra HD Monitor', 320000, 20, 'http://example.com/images/tmp.jpg', SYSDATE, '', 9); -- 모니터 (입출력장치)
INSERT INTO T_product VALUES (4, 'Mechanical Keyboard', 120000, 75, 'http://example.com/images/tmp.jpg', SYSDATE, '', 10); -- 키보드 (입출력장치)
INSERT INTO T_product VALUES (5, 'Portable SSD 1TB', 150000, 30, 'http://example.com/images/tmp.jpg', SYSDATE, '', 16); -- SSD (PC부품)
INSERT INTO T_product VALUES (6, 'Gaming Mouse Pad', 15000, 150, 'http://example.com/images/tmp.jpg', SYSDATE, '', 11); -- 마우스 패드 (입출력장치)
INSERT INTO T_product VALUES (7, 'USB-C Hub', 40000, 60, 'http://example.com/images/tmp.jpg', SYSDATE, '', 11); -- USB 허브 (입출력장치)
INSERT INTO T_product VALUES (8, 'Smart Watch', 200000, 40, 'http://example.com/images/tmp.jpg', SYSDATE, '', 40); -- 스마트워치 (주변기기)
INSERT INTO T_product VALUES (9, 'Desk Lamp', 35000, 25, 'http://example.com/images/tmp.jpg', SYSDATE, '', 17); -- 생활/계절가전
INSERT INTO T_product VALUES (10, 'External Hard Drive 2TB', 180000, 15, 'http://example.com/images/tmp.jpg', SYSDATE, '', 16); -- 외장 하드 드라이브 (PC부품)
INSERT INTO T_product VALUES (11, 'Noise-Cancelling Headphones', 90000, 45, 'http://example.com/images/tmp.jpg', SYSDATE, '', 18); -- 사운드바 (영상/음향가전)
INSERT INTO T_product VALUES (12, 'Mechanical Gaming Keyboard', 130000, 65, 'http://example.com/images/tmp.jpg', SYSDATE, '', 10); -- 키보드 (입출력장치)
INSERT INTO T_product VALUES (13, 'Wireless Charging Pad', 30000, 80, 'http://example.com/images/tmp.jpg', SYSDATE, '', 11); -- 무선 충전 패드 (입출력장치)
INSERT INTO T_product VALUES (14, 'USB Flash Drive 64GB', 20000, 100, 'http://example.com/images/tmp.jpg', SYSDATE, '', 11); -- USB 플래시 드라이브 (입출력장치)
INSERT INTO T_product VALUES (15, 'Ergonomic Office Chair', 250000, 10, 'http://example.com/images/tmp.jpg', SYSDATE, '', 17); -- 생활/계절가전
INSERT INTO T_product VALUES (16, 'Bluetooth Speaker', 55000, 55, 'http://example.com/images/tmp.jpg', SYSDATE, '', 18); -- 스피커 (영상/음향가전)
INSERT INTO T_product VALUES (17, 'LED Monitor 27"', 220000, 25, 'http://example.com/images/tmp.jpg', SYSDATE, '', 9); -- 모니터 (입출력장치)
INSERT INTO T_product VALUES (18, 'Laptop Stand', 20000, 40, 'http://example.com/images/tmp.jpg', SYSDATE, '', 1); -- 노트북/데스크탑
INSERT INTO T_product VALUES (19, 'Cable Management Box', 12000, 70, 'http://example.com/images/tmp.jpg', SYSDATE, '', 11); -- 케이블 정리함 (입출력장치)
INSERT INTO T_product VALUES (20, 'Wi-Fi Router', 70000, 35, 'http://example.com/images/tmp.jpg', SYSDATE, '', 17); -- 생활/계절가전
INSERT INTO T_product VALUES (21, 'Webcam 1080p', 45000, 50, 'http://example.com/images/tmp.jpg', SYSDATE, '', 12); -- 웹캠 (입출력장치)
INSERT INTO T_product VALUES (22, 'Smartphone Stand', 15000, 90, 'http://example.com/images/tmp.jpg', SYSDATE, '', 34); -- 스마트폰 스탠드 (태블릿/스마트폰)
INSERT INTO T_product VALUES (23, 'Portable Projector', 300000, 20, 'http://example.com/images/tmp.jpg', SYSDATE, '', 22); -- 프로젝터 (영상/음향가전)
INSERT INTO T_product VALUES (24, 'Desk Organizer', 18000, 65, 'http://example.com/images/tmp.jpg', SYSDATE, '', 1); -- 노트북/데스크탑
INSERT INTO T_product VALUES (25, 'Mini Fridge', 150000, 30, 'http://example.com/images/tmp.jpg', SYSDATE, '', 20); -- 냉장고 (주방가전)
INSERT INTO T_product VALUES (26, 'Touchscreen Monitor', 250000, 15, 'http://example.com/images/tmp.jpg', SYSDATE, '', 9); -- 모니터 (입출력장치)
INSERT INTO T_product VALUES (27, 'Gaming Chair', 300000, 12, 'http://example.com/images/tmp.jpg', SYSDATE, '', 17); -- 생활/계절가전
INSERT INTO T_product VALUES (28, 'Smart Home Hub', 60000, 40, 'http://example.com/images/tmp.jpg', SYSDATE, '', 17); -- 스마트 홈 허브 (생활/계절가전)
INSERT INTO T_product VALUES (29, '4K Action Camera', 180000, 25, 'http://example.com/images/tmp.jpg', SYSDATE, '', 17); -- 생활/계절가전
INSERT INTO T_product VALUES (30, 'Fitness Tracker', 50000, 50, 'http://example.com/images/tmp.jpg', SYSDATE, '', 40); -- 스마트워치 (주변기기)
INSERT INTO T_product VALUES (31, 'Digital Drawing Tablet', 220000, 18, 'http://example.com/images/tmp.jpg', SYSDATE, '', 33); -- 태블릿/스마트폰
INSERT INTO T_product VALUES (32, 'Cordless Drill', 140000, 22, 'http://example.com/images/tmp.jpg', SYSDATE, '', 17); -- 생활/계절가전
INSERT INTO T_product VALUES (33, 'Smart Thermostat', 80000, 28, 'http://example.com/images/tmp.jpg', SYSDATE, '', 17); -- 생활/계절가전
INSERT INTO T_product VALUES (34, 'Air Purifier', 120000, 15, 'http://example.com/images/tmp.jpg', SYSDATE, '', 17); -- 생활/계절가전
INSERT INTO T_product VALUES (35, 'Robotic Vacuum Cleaner', 250000, 10, 'http://example.com/images/tmp.jpg', SYSDATE, '', 17); -- 생활/계절가전
INSERT INTO T_product VALUES (36, 'HDMI Cable 2m', 12000, 60, 'http://example.com/images/tmp.jpg', SYSDATE, '', 11); -- HDMI 케이블 (입출력장치)
INSERT INTO T_product VALUES (37, 'Electric Kettle', 30000, 40, 'http://example.com/images/tmp.jpg', SYSDATE, '', 17); -- 생활/계절가전
INSERT INTO T_product VALUES (38, 'Bluetooth Keyboard', 40000, 75, 'http://example.com/images/tmp.jpg', SYSDATE, '', 10); -- 키보드 (입출력장치)
INSERT INTO T_product VALUES (39, 'Surge Protector', 15000, 55, 'http://example.com/images/tmp.jpg', SYSDATE, '', 11); -- 서지 프로텍터 (입출력장치)
INSERT INTO T_product VALUES (40, 'Digital Camera', 250000, 20, 'http://example.com/images/tmp.jpg', SYSDATE, '', 17); -- 생활/계절가전
