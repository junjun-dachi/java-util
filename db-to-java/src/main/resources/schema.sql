CREATE SCHEMA IF NOT EXISTS TEST;

CREATE TABLE TEST.USER
(
	ID NUMBER(19) NOT NULL,
	NAME VARCHAR2(50) NOT NULL
);

ALTER TABLE TEST.USER ADD PRIMARY KEY (ID);

CREATE TABLE TEST.ROLE
(
ID NUMBER(19) NOT NULL,
NAME VARCHAR2(50) NOT NULL,
FK_USER_ID NUMBER(19) NOT NULL
);

ALTER TABLE TEST.ROLE ADD PRIMARY KEY (ID);

ALTER TABLE TEST.ROLE
    ADD CONSTRAINT ROLE_USER_FK FOREIGN KEY (FK_USER_ID) 
    REFERENCES TEST.USER ;
