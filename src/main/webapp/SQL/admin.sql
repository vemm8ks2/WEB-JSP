CREATE TABLE Admin (
	id NUMBER(9) NOT NULL,
	login_id VARCHAR2(30) NOT NULL,
	password VARCHAR2(256) NOT NULL,
	name VARCHAR2(30) NOT NULL,
	email VARCHAR2(30),
	phone_numbr	VARCHAR2(11) NOT NULL,
	createdAt DATE NOT NULL,
	lastAccessedAt DATE	NOT NULL,
	lastAccessedIP VARCHAR2(16)	NOT NULL
);