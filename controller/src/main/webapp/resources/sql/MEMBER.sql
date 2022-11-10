DROP TABLE IF EXISTS MEMBER;

CREATE TABLE MEMBER (
    uId VARCHAR(30) NOT NULL,
    uPw VARCHAR(30) NOT NULL,
    uEmail VARCHAR(50) NOT NULL,
    uPhoneNumber VARCHAR(50),
    PRIMARY KEY (uId)
);

Insert into MEMBER values ('dkschdcks','dkschdcks1234','dkschdcks@gmail.com','010-0000-0000');
Insert into MEMBER values ('yunki-kim','yunki-kim1234','yunki-kim@gmail.com','010-0000-0000');
Insert into MEMBER values ('crossbell8368','crossbell83681234','crossbell8368@gmail.com','010-0000-0000');
Insert into MEMBER values ('mystagogy','mystagogy1234','mystagogy@gmail.com','010-0000-0000');
Insert into MEMBER values ('hamings','hamings1234','hamings@gmail.com','010-0000-0000');
Insert into MEMBER values ('Blooossom','Blooossom1234','Blooossom@gmail.com','010-0000-0000');

SELECT * FROM MEMBER;

DELETE FROM MEMBER;
