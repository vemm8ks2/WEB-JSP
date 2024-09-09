-- 유저 Customer 테이블
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

-- 유저 데이터 삽입
INSERT INTO T_customer VALUES (1, 'jdoe', 'password123', 'Javan Rhino', 'javanrhino@example.com', '01012345678', 'M', TO_DATE('1990-05-15', 'YYYY-MM-DD'), SYSDATE, '');
INSERT INTO T_customer VALUES (2, 'asmith', 'secureP@ssw0rd', 'Amur Leopard', 'amurleopard@example.com', '01023456789', 'F', TO_DATE('1985-08-22', 'YYYY-MM-DD'), SYSDATE, '');
INSERT INTO T_customer VALUES (3, 'bjones', 'myp@ssw0rd', 'Vaquita', 'vaquita@example.com', '01034567890', 'M', TO_DATE('1992-11-30', 'YYYY-MM-DD'), SYSDATE, '');
INSERT INTO T_customer VALUES (4, 'cwhite', 'passw0rd!', 'Kakapo', 'kakapo@example.com', '01045678901', 'F', TO_DATE('1988-03-10', 'YYYY-MM-DD'), SYSDATE, '');
INSERT INTO T_customer VALUES (5, 'dblack', '1234abcd', 'Saola', 'saola@example.com', '01056789012', 'M', TO_DATE('1995-07-25', 'YYYY-MM-DD'), SYSDATE, '');
INSERT INTO T_customer VALUES (6, 'egreen', 'password2024', 'Sumatran Orangutan', 'sumatranorangutan@example.com', '01067890123', 'F', TO_DATE('1991-01-12', 'YYYY-MM-DD'), SYSDATE, '');
INSERT INTO T_customer VALUES (7, 'fwhite', 'simplepass', 'Northern Bald Ibis', 'northernbaldibis@example.com', '01078901234', 'M', TO_DATE('1989-12-08', 'YYYY-MM-DD'), SYSDATE, '');
INSERT INTO T_customer VALUES (8, 'gblack', 'p@ssw0rd!', 'Yangtze Giant Softshell Turtle', 'yangtzegiants@example.com', '01089012345', 'F', TO_DATE('1994-09-19', 'YYYY-MM-DD'), SYSDATE, '');
INSERT INTO T_customer VALUES (9, 'hgray', 'qwerty123', 'Psychedelic Rock Gecko', 'psychedelicrockgecko@example.com', '01090123456', 'M', TO_DATE('1987-06-30', 'YYYY-MM-DD'), SYSDATE, '');
INSERT INTO T_customer VALUES (10, 'ijones', '1234abcd!', 'Mountain Gorilla', 'mountaingorilla@example.com', '01001234567', 'F', TO_DATE('1993-03-15', 'YYYY-MM-DD'), SYSDATE, '');
INSERT INTO T_customer VALUES (11, 'kgreen', 'greenpass1', 'Wollemi Pine', 'wollemi@example.com', '01012345671', 'F', TO_DATE('1983-11-30', 'YYYY-MM-DD'), SYSDATE, '');
INSERT INTO T_customer VALUES (12, 'lblue', 'blue1234', 'Rafflesia arnoldii', 'rafflesia@example.com', '01023456782', 'M', TO_DATE('1990-07-22', 'YYYY-MM-DD'), SYSDATE, '');
INSERT INTO T_customer VALUES (13, 'mgray', 'gray2024', 'Baobab', 'baobab@example.com', '01034567893', 'F', TO_DATE('1985-04-15', 'YYYY-MM-DD'), SYSDATE, '');
INSERT INTO T_customer VALUES (14, 'nblack', 'blackpass', 'Amorphophallus titanium', 'amorphophallus@example.com', '01045678904', 'M', TO_DATE('1992-01-18', 'YYYY-MM-DD'), SYSDATE, '');
INSERT INTO T_customer VALUES (15, 'obrown', 'brownpass', 'Cycad', 'cycad@example.com', '01056789015', 'F', TO_DATE('1988-10-04', 'YYYY-MM-DD'), SYSDATE, '');
INSERT INTO T_customer VALUES (16, 'pwhite', 'white2024', 'Hoodia gordonii', 'hoodia@example.com', '01067890126', 'M', TO_DATE('1993-05-17', 'YYYY-MM-DD'), SYSDATE, '');
INSERT INTO T_customer VALUES (17, 'qgreen', 'greenpass2024', 'Welwitschia', 'welwitschia@example.com', '01078901237', 'F', TO_DATE('1987-08-25', 'YYYY-MM-DD'), SYSDATE, '');
INSERT INTO T_customer VALUES (18, 'rblue', 'blue2024', 'Titan Arum', 'titanarum@example.com', '01089012348', 'M', TO_DATE('1994-03-05', 'YYYY-MM-DD'), SYSDATE, '');
INSERT INTO T_customer VALUES (19, 'sgray', 'graypass1', 'Jellyfish Tree', 'jellyfishtree@example.com', '01090123459', 'F', TO_DATE('1991-06-12', 'YYYY-MM-DD'), SYSDATE, '');
INSERT INTO T_customer VALUES (20, 'tblack', 'black2024', 'African Violet', 'africanviolet@example.com', '01001234580', 'M', TO_DATE('1995-09-09', 'YYYY-MM-DD'), SYSDATE, '');
INSERT INTO T_customer VALUES (21, 'ubrown', 'brown2024', 'Encephalartos woodii', 'encephalartos@example.com', '01012345682', 'F', TO_DATE('1982-02-26', 'YYYY-MM-DD'), SYSDATE, '');
INSERT INTO T_customer VALUES (22, 'vgreen', 'greenpass2025', 'Edelweiss', 'edelweiss@example.com', '01023456783', 'M', TO_DATE('1992-04-10', 'YYYY-MM-DD'), SYSDATE, '');
INSERT INTO T_customer VALUES (23, 'wgray', 'gray1234', 'Saguaro Cactus', 'saguaro@example.com', '01034567894', 'F', TO_DATE('1986-11-21', 'YYYY-MM-DD'), SYSDATE, '');
INSERT INTO T_customer VALUES (24, 'xblack', 'blackpass2024', 'Ghost Orchid', 'ghostorchid@example.com', '01045678905', 'M', TO_DATE('1989-12-30', 'YYYY-MM-DD'), SYSDATE, '');
INSERT INTO T_customer VALUES (25, 'yblue', 'blue2025', 'Monkey Puzzle Tree', 'monkeypuzzletree@example.com', '01056789016', 'F', TO_DATE('1984-05-15', 'YYYY-MM-DD'), SYSDATE, '');
INSERT INTO T_customer VALUES (26, 'zgreen', 'greenpass2025', 'Rafflesia consueloae', 'rafflesia2@example.com', '01067890127', 'M', TO_DATE('1990-09-12', 'YYYY-MM-DD'), SYSDATE, '');
INSERT INTO T_customer VALUES (27, 'aorange', 'orange2024', 'Dwarf Umbrella Tree', 'dwarfumbrellatree@example.com', '01078901238', 'F', TO_DATE('1987-07-19', 'YYYY-MM-DD'), SYSDATE, '');
INSERT INTO T_customer VALUES (28, 'bblack', 'black2025', 'Dodo Tree', 'dodotree@example.com', '01089012349', 'M', TO_DATE('1993-12-25', 'YYYY-MM-DD'), SYSDATE, '');
INSERT INTO T_customer VALUES (29, 'cgray', 'graypass2025', 'Titanopsis calcarea', 'titanopsis@example.com', '01090123460', 'F', TO_DATE('1991-11-11', 'YYYY-MM-DD'), SYSDATE, '');
INSERT INTO T_customer VALUES (30, 'dblue', 'bluepass2024', 'Creeping Fig', 'creepingfig@example.com', '01001234581', 'M', TO_DATE('1986-10-08', 'YYYY-MM-DD'), SYSDATE, '');