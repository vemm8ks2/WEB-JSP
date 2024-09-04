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

-- 어드민 데이터 삽입
INSERT INTO T_admin VALUES (1, 'africanelephant', 'P@ssw0rd123!', 'African Elephant', 'africanelephant@example.com', '0101234567', SYSDATE, SYSDATE, '10.0.0.1');
INSERT INTO T_admin VALUES (2, 'giraffe', 'SecureP@ss2024', 'Giraffe', 'giraffe@example.com', '0102345678', SYSDATE, SYSDATE, '10.0.0.2');
INSERT INTO T_admin VALUES (3, 'hippopotamus', 'M1cha3l!2024', 'Hippopotamus', 'hippopotamus@example.com', '0103456789', SYSDATE, SYSDATE, '10.0.0.3');
INSERT INTO T_admin VALUES (4, 'komododragon', 'Br0wnP@ssw0rd', 'Komodo Dragon', 'komododragon@example.com', '0104567890', SYSDATE, SYSDATE, '10.0.0.4');
INSERT INTO T_admin VALUES (5, 'beaver', 'W1ls0n#2024', 'North American Beaver', 'beaver@example.com', '0105678901', SYSDATE, SYSDATE, '10.0.0.5');
INSERT INTO T_admin VALUES (6, 'americanelm', 'T@yloR2024!', 'American Elm Tree', 'americanelm@example.com', '0106789012', SYSDATE, SYSDATE, '10.0.0.6');
INSERT INTO T_admin VALUES (7, 'californiaredwood', 'D@ni3l#2024', 'California Redwood', 'californiaredwood@example.com', '0107890123', SYSDATE, SYSDATE, '10.0.0.7');
INSERT INTO T_admin VALUES (8, 'japanesemaple', '0l1v1@2024!', 'Japanese Maple Tree', 'japanesemaple@example.com', '0108901234', SYSDATE, SYSDATE, '10.0.0.8');
INSERT INTO T_admin VALUES (9, 'southernmagnolia', 'R1ch@rd2024!', 'Southern Magnolia', 'southernmagnolia@example.com', '0109012345', SYSDATE, SYSDATE, '10.0.0.9');
INSERT INTO T_admin VALUES (10, 'europeanoak', 'L1nd@W!2024', 'European Oak Tree', 'europeanoak@example.com', '0100123456', SYSDATE, SYSDATE, '10.0.0.10');
