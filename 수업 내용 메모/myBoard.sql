/* DROP 부분 */
DROP TABLE fileT CASCADE CONSTRAINTS;
DROP SEQUENCE file_num;
DROP TABLE memberT CASCADE CONSTRAINTS;
DROP SEQUENCE mem_num;
DROP TABLE boardT;

/* CREATE 부분 */
CREATE TABLE fileT (
    file_num NUMBER NOT NULL,
    file_name VARCHAR2(200) NOT NULL,
    CONSTRAINT fileT_PK PRIMARY KEY (file_num, file_name)
);

CREATE SEQUENCE file_num START WITH 1 INCREMENT BY 1 
    MAXVALUE 100000000 MINVALUE 1 NOCYCLE;

CREATE TABLE memberT (
    mem_num NUMBER NOT NULL,
    email VARCHAR2(60) NOT NULL,
    nickname VARCHAR2(60) NOT NULL,
    pwd VARCHAR2(60) NOT NULL,    
    gender VARCHAR2(10) NOT NULL,
    phone NUMBER NOT NULL,
    file_num NUMBER NULL,
    file_name VARCHAR2(200) NULL,
    
    CONSTRAINT memberT_PK PRIMARY KEY (mem_num, email, nickname),
    CONSTRAINT memberT_FK FOREIGN KEY (file_num, file_name) REFERENCES fileT (file_num, file_name) 
    ON DELETE CASCADE
);

CREATE SEQUENCE mem_num START WITH 1 INCREMENT BY 1
    MAXVALUE 100000000 MINVALUE 1 NOCYCLE;

CREATE TABLE boardT (
    board_num NUMBER NOT NULL,
    title VARCHAR2(100) NOT NULL,
    contents VARCHAR2(1000) NULL,
    mem_num NUMBER NOT NULL,
    email VARCHAR2(60) NOT NULL,
    nickname VARCHAR2(60) NOT NULL, 
    file_num NUMBER NULL,
    file_name VARCHAR2(200) NULL,
    
    CONSTRAINT boardT_PK PRIMARY KEY (board_num),
    CONSTRAINT boardT_fileT_FK FOREIGN KEY (file_num, file_name)
    REFERENCES fileT (file_num, file_name) ON DELETE CASCADE,
    CONSTRAINT boardT_memberT FOREIGN KEY (mem_num, email, nickname)
    REFERENCES memberT (mem_num, email, nickname) ON DELETE CASCADE
);

CREATE SEQUENCE  board_num START WITH 1 INCREMENT BY 1
    MAXVALUE 100000000 MINVALUE 1 NOCYCLE;

