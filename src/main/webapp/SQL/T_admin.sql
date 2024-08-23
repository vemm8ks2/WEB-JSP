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