DROP TABLE IF EXISTS PAYMENT;

CREATE TABLE PAYMENT(
    oId varchar(20) NOT NULL PRIMARY KEY,
    orderType varchar(10) NOT NULL,
    orderDate VARCHAR(255) NOT NULL,
    amount varchar(10) NOT NULL,
    get_npoint varchar(10),
    use_npoint varchar(10)
);

INSERT INTO Payment values (1, 'Card', '2022-01-01', '22800', '228', '0');
INSERT INTO Payment values (2, 'Account', '2022-02-01', '18000', '180', '1234');
INSERT INTO Payment values (3, 'Account', '2022-03-01', '11390', '113', NULL);
INSERT INTO Payment values (4, 'Account', '2022-04-01', '104000', '1040', '2222');

INSERT INTO Payment values (5, 'Card', '2022-01-01', '22800', '228', '0');
INSERT INTO Payment values (6, 'Account', '2022-02-01', '18000', '180', '1234');
INSERT INTO Payment values (7, 'Account', '2022-03-01', '11390', '113', NULL);
INSERT INTO Payment values (8, 'Account', '2022-04-01', '104000', '1040', '2222');

INSERT INTO Payment values (9, 'Card', '2022-01-01', '22800', '228', '0');
INSERT INTO Payment values (10, 'Account', '2022-02-01', '18000', '180', '1234');
INSERT INTO Payment values (11, 'Account', '2022-03-01', '11390', '113', NULL);
INSERT INTO Payment values (12, 'Account', '2022-04-01', '104000', '1040', '2222');

INSERT INTO Payment values (13, 'Card', '2022-01-01', '22800', '228', '0');
INSERT INTO Payment values (14, 'Account', '2022-02-01', '18000', '180', '1234');
INSERT INTO Payment values (15, 'Account', '2022-03-01', '11390', '113', NULL);
INSERT INTO Payment values (16, 'Account', '2022-04-01', '104000', '1040', '2222');

INSERT INTO Payment values (17, 'Card', '2022-01-01', '22800', '228', '0');
INSERT INTO Payment values (18, 'Account', '2022-02-01', '18000', '180', '1234');
INSERT INTO Payment values (19, 'Account', '2022-03-01', '11390', '113', NULL);
INSERT INTO Payment values (20, 'Account', '2022-04-01', '104000', '1040', '2222');

INSERT INTO Payment values (21, 'Card', '2022-01-01', '22800', '228', '0');
INSERT INTO Payment values (22, 'Account', '2022-02-01', '18000', '180', '1234');
INSERT INTO Payment values (23, 'Account', '2022-03-01', '11390', '113', NULL);
INSERT INTO Payment values (24, 'Account', '2022-04-01', '104000', '1040', '2222');

SELECT * FROM PAYMENT;

DELETE FROM PAYMENT;
