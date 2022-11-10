DROP TABLE IF EXISTS PRODUCT;

CREATE TABLE PRODUCT(
    oId VARCHAR(30) NOT NULL primary key,
    uId VARCHAR(30) NOT NULL,
    orderDate VARCHAR(255),
    productName VARCHAR(50),
    amount VARCHAR(10) NOT NULL,
    status VARCHAR(10)NOT NULL,
    company VARCHAR(20) NOT NULL,
    companyTel VARCHAR(20) NOT NULL,
    foreign key (uID) references MEMBER(uId)
);

INSERT INTO PRODUCT VALUES ('1','dkschdcks', '2022-01-01', '목도리','22800', '결제완료', 'MUSINSA', '15447199');
INSERT INTO PRODUCT VALUES ('2','dkschdcks', '2022-02-01', '치킨','18000', '결제완료', '요기요', '0234473612');
INSERT INTO PRODUCT VALUES ('3','dkschdcks', '2022-03-01', '지비츠','11390', '구매확정', '오브조이', '07080952476');
INSERT INTO PRODUCT VALUES ('4','dkschdcks', '2022-04-01', '선반책상','104000', '구매확정', '바르젤', '0102982-2238');

INSERT INTO PRODUCT VALUES ('5','yunki-kim', '2022-01-01', '목도리','22800', '결제완료', 'MUSINSA', '15447199');
INSERT INTO PRODUCT VALUES ('6','yunki-kim', '2022-02-01', '치킨','18000', '결제완료', '요기요', '0234473612');
INSERT INTO PRODUCT VALUES ('7','yunki-kim', '2022-03-01', '지비츠','11390', '구매확정', '오브조이', '07080952476');
INSERT INTO PRODUCT VALUES ('8','yunki-kim', '2022-04-01', '선반책상','104000', '구매확정', '바르젤', '0102982-2238');

INSERT INTO PRODUCT VALUES ('9','crossbell8368', '2022-01-01', '목도리','22800', '결제완료', 'MUSINSA', '15447199');
INSERT INTO PRODUCT VALUES ('10','crossbell8368', '2022-02-01', '치킨','18000', '결제완료', '요기요', '0234473612');
INSERT INTO PRODUCT VALUES ('11','crossbell8368', '2022-03-01', '지비츠','11390', '구매확정', '오브조이', '07080952476');
INSERT INTO PRODUCT VALUES ('12','crossbell8368', '2022-04-01', '선반책상','104000', '구매확정', '바르젤', '0102982-2238');

INSERT INTO PRODUCT VALUES ('13','mystagogy', '2022-01-01', '목도리','22800', '결제완료', 'MUSINSA', '15447199');
INSERT INTO PRODUCT VALUES ('14','mystagogy', '2022-02-01', '치킨','18000', '결제완료', '요기요', '0234473612');
INSERT INTO PRODUCT VALUES ('15','mystagogy', '2022-03-01', '지비츠','11390', '구매확정', '오브조이', '07080952476');
INSERT INTO PRODUCT VALUES ('16','mystagogy', '2022-04-01', '선반책상','104000', '구매확정', '바르젤', '0102982-2238');

INSERT INTO PRODUCT VALUES ('17','hamings', '2022-01-01', '목도리','22800', '결제완료', 'MUSINSA', '15447199');
INSERT INTO PRODUCT VALUES ('18','hamings', '2022-02-01', '치킨','18000', '결제완료', '요기요', '0234473612');
INSERT INTO PRODUCT VALUES ('19','hamings', '2022-03-01', '지비츠','11390', '구매확정', '오브조이', '07080952476');
INSERT INTO PRODUCT VALUES ('20','hamings', '2022-04-01', '선반책상','104000', '구매확정', '바르젤', '0102982-2238');

INSERT INTO PRODUCT VALUES ('21','Blooossom', '2022-01-01', '목도리','22800', '결제완료', 'MUSINSA', '15447199');
INSERT INTO PRODUCT VALUES ('22','Blooossom', '2022-02-01', '치킨','18000', '결제완료', '요기요', '0234473612');
INSERT INTO PRODUCT VALUES ('23','Blooossom', '2022-03-01', '지비츠','11390', '구매확정', '오브조이', '07080952476');
INSERT INTO PRODUCT VALUES ('24','Blooossom', '2022-04-01', '선반책상','104000', '구매확정', '바르젤', '0102982-2238');

SELECT * FROM PRODUCT;

DELETE FROM PRODUCT;
