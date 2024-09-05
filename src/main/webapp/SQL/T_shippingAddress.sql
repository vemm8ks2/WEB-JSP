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

-- 배송지 데이터 삽입
INSERT INTO T_shipping_address VALUES (1, '123 Elm Street, New York, USA', 'Y', 1);   -- 유저 1
INSERT INTO T_shipping_address VALUES (2, '456 Oak Avenue, Toronto, Canada', 'N', 1);  -- 유저 1
INSERT INTO T_shipping_address VALUES (3, '789 Pine Road, London, UK', 'Y', 2);        -- 유저 2
INSERT INTO T_shipping_address VALUES (4, '101 Maple Lane, Berlin, Germany', 'N', 2);   -- 유저 2
INSERT INTO T_shipping_address VALUES (5, '202 Birch Blvd, Sydney, Australia', 'N', 2); -- 유저 2
INSERT INTO T_shipping_address VALUES (6, '303 Cedar Street, Tokyo, Japan', 'Y', 2);    -- 유저 2
INSERT INTO T_shipping_address VALUES (7, '404 Willow Way, Paris, France', 'N', 3);     -- 유저 3
INSERT INTO T_shipping_address VALUES (8, '505 Ash Drive, Rome, Italy', 'Y', 4);        -- 유저 4
INSERT INTO T_shipping_address VALUES (9, '606 Cherry Circle, Madrid, Spain', 'N', 5);  -- 유저 5
INSERT INTO T_shipping_address VALUES (10, '707 Redwood Path, São Paulo, Brazil', 'Y', 6); -- 유저 6
INSERT INTO T_shipping_address VALUES (11, '808 Spruce Court, Cape Town, South Africa', 'Y', 6); -- 유저 6
INSERT INTO T_shipping_address VALUES (12, '909 Fir Terrace, Seoul, South Korea', 'Y', 7); -- 유저 7
INSERT INTO T_shipping_address VALUES (13, '010 Willow Avenue, Moscow, Russia', 'N', 7); -- 유저 7
INSERT INTO T_shipping_address VALUES (14, '121 Maple Road, Istanbul, Turkey', 'Y', 8);   -- 유저 8
INSERT INTO T_shipping_address VALUES (15, '232 Pine Street, Dubai, UAE', 'N', 9);       -- 유저 9
INSERT INTO T_shipping_address VALUES (16, '343 Oak Drive, Mumbai, India', 'Y', 10);     -- 유저 10
INSERT INTO T_shipping_address VALUES (17, '454 Elm Court, Bangkok, Thailand', 'N', 11);  -- 유저 11
INSERT INTO T_shipping_address VALUES (18, '565 Birch Street, Jakarta, Indonesia', 'Y', 12); -- 유저 12
INSERT INTO T_shipping_address VALUES (19, '676 Cedar Lane, Kuala Lumpur, Malaysia', 'N', 12); -- 유저 12
INSERT INTO T_shipping_address VALUES (20, '787 Cherry Way, Singapore', 'Y', 13);       -- 유저 13
INSERT INTO T_shipping_address VALUES (21, '898 Maple Path, Vienna, Austria', 'N', 14); -- 유저 14
INSERT INTO T_shipping_address VALUES (22, '909 Oak Terrace, Athens, Greece', 'Y', 14); -- 유저 14
INSERT INTO T_shipping_address VALUES (23, '101 Pine Blvd, Prague, Czech Republic', 'N', 15); -- 유저 15
INSERT INTO T_shipping_address VALUES (24, '212 Willow Street, Warsaw, Poland', 'Y', 16); -- 유저 16
INSERT INTO T_shipping_address VALUES (25, '323 Elm Drive, Stockholm, Sweden', 'N', 17); -- 유저 17
INSERT INTO T_shipping_address VALUES (26, '434 Cedar Court, Copenhagen, Denmark', 'N', 17); -- 유저 17
INSERT INTO T_shipping_address VALUES (27, '545 Fir Lane, Oslo, Norway', 'Y', 17);     -- 유저 17
INSERT INTO T_shipping_address VALUES (28, '656 Maple Way, Helsinki, Finland', 'N', 17); -- 유저 17
INSERT INTO T_shipping_address VALUES (29, '767 Birch Street, Bucharest, Romania', 'Y', 18); -- 유저 18
INSERT INTO T_shipping_address VALUES (30, '878 Oak Avenue, Budapest, Hungary', 'N', 18); -- 유저 18
INSERT INTO T_shipping_address VALUES (31, '989 Pine Path, Lisbon, Portugal', 'Y', 19); -- 유저 19
INSERT INTO T_shipping_address VALUES (32, '100 Elm Drive, Dublin, Ireland', 'N', 20);  -- 유저 20
INSERT INTO T_shipping_address VALUES (33, '111 Maple Terrace, San Francisco, USA', 'Y', 21); -- 유저 21
INSERT INTO T_shipping_address VALUES (34, '122 Willow Avenue, Los Angeles, USA', 'N', 22); -- 유저 22
INSERT INTO T_shipping_address VALUES (35, '133 Oak Street, Chicago, USA', 'Y', 23);    -- 유저 23
INSERT INTO T_shipping_address VALUES (36, '144 Pine Court, Seattle, USA', 'N', 23);    -- 유저 23
INSERT INTO T_shipping_address VALUES (37, '155 Cedar Lane, Austin, USA', 'Y', 23);    -- 유저 23
INSERT INTO T_shipping_address VALUES (38, '166 Birch Drive, Denver, USA', 'N', 24);    -- 유저 24
INSERT INTO T_shipping_address VALUES (39, '177 Cherry Path, Miami, USA', 'Y', 24);    -- 유저 24
INSERT INTO T_shipping_address VALUES (40, '188 Maple Street, Houston, USA', 'N', 25);  -- 유저 25
INSERT INTO T_shipping_address VALUES (41, '199 Oak Avenue, Toronto, Canada', 'Y', 25); -- 유저 25
INSERT INTO T_shipping_address VALUES (42, '200 Pine Lane, Vancouver, Canada', 'N', 25); -- 유저 25
INSERT INTO T_shipping_address VALUES (43, '211 Willow Drive, Montreal, Canada', 'Y', 25); -- 유저 25
INSERT INTO T_shipping_address VALUES (44, '222 Elm Way, Calgary, Canada', 'N', 26);     -- 유저 26
INSERT INTO T_shipping_address VALUES (45, '233 Cedar Court, Ottawa, Canada', 'Y', 27); -- 유저 27
INSERT INTO T_shipping_address VALUES (46, '244 Birch Avenue, Edmonton, Canada', 'N', 28); -- 유저 28
INSERT INTO T_shipping_address VALUES (47, '255 Pine Drive, Quebec City, Canada', 'Y', 29); -- 유저 29
INSERT INTO T_shipping_address VALUES (48, '266 Maple Street, Winnipeg, Canada', 'N', 29); -- 유저 29
INSERT INTO T_shipping_address VALUES (49, '277 Oak Path, Halifax, Canada', 'Y', 30);   -- 유저 30
INSERT INTO T_shipping_address VALUES (50, '288 Willow Terrace, St. John''s, Canada', 'N', 30); -- 유저 30