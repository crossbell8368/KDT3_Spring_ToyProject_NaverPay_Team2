DROP TABLE PROD;

CREATE TABLE PROD(
    USER_ID			VARCHAR(255),
    ORDER_NO		INT,
    ORDER_DATE		VARCHAR(255),
    PROD_MANUF		VARCHAR(255),
    PROD_INFO		VARCHAR(255),
    PROD_COST		VARCHAR(255),
    PROD_CNT		INT,
    PROD_SELLER		VARCHAR(255),
    PROD_SELLNUM	VARCHAR(255),
    PROD_STATUS		INT,
    PROD_REVIEW		INT,
    PRIMARY KEY (ORDER_NO)
);

INSERT INTO PROD VALUES	('PENELOPE', 1, '2010-02-15', 'American Samoa',	'A Epic Drama of a Feminist And a Mad Scientist who must Battle a Teacher in The Canadian Rockies', '2.99', 2 ,'SMITH', '010-3333-5568', 1, 1);
INSERT INTO PROD VALUES	('NICK', 2,	'2011-03-16', 'Angola',	'A Astounding Epistle of a Database Administrator And a Explorer who must Find a Car in Ancient China', '0.99', 4, 'JOHNSON', '010-7223-5589', 2, 1);
INSERT INTO PROD VALUES	('ED', 3, '2012-04-17',	'Anguilla',	'A Astounding Reflection of a Lumberjack And a Car who must Sink a Lumberjack in A Baloon Factory', '5.99', 6, 'WILLIAMS', '283-0338-4290', 0, 1);
INSERT INTO PROD VALUES	('JENNIFER', 4,	'2013-05-18', 'Argentina', 'A Fanciful Documentary of a Frisbee And a Lumberjack who must Chase a Monkey in A Shark Tank', '0.99', 34, 'JONES', '386-3528-6649', 2, 1);
INSERT INTO PROD VALUES	('JOHNNY', 5, '2014-06-19',	'Armenia', 'A Fast-Paced Documentary of a Pastry Chef And a Dentist who must Pursue a Forensic Psychologist in The Gulf of Mexico', '9.99', 12, 'BROWN', '484-7719-0408', 3, 1);
INSERT INTO PROD VALUES	('BETTE', 6, '2015-07-20', 'Australia',	'A Intrepid Panorama of a Robot And a Boy who must Escape a Sumo Wrestler in Ancient China', '4.99', 9, 'DAVIS', '708-1400-3527', 1, 0);
INSERT INTO PROD VALUES	('GRACE', 7, '2016-08-21', 'Austria', 'A Touching Saga of a Hunter And a Butler who must Discover a Butler in A Jet Boat', '4.99', 120, 'MILLER', '106-5564-8674', 2, 1);
INSERT INTO PROD VALUES	('MATTHEW', 8, '2017-09-22', 'Azerbaijan', 'A Epic Tale of a Moose And a Girl who must Confront a Monkey in Ancient India', '0.99', 3, 'WILSON', '804-5262-6434', 0, 1);
INSERT INTO PROD VALUES	('JOE', 9, '2018-10-23', 'Bahrain',	'A Thoughtful Panorama of a Database Administrator And a Mad Scientist who must Outgun a Mad Scientist in A Jet Boat', '3.99', 77, 'MOORE', '765-7122-0373', 2, 1);
INSERT INTO PROD VALUES	('CHRISTIAN', 10, '2019-11-24',	'Bangladesh', 'A Action-Packed Tale of a Man And a Lumberjack who must Reach a Feminist in Ancient China', '5.99', 8, 'TAYLOR', '652-8228-5970', 1, 1);

SELECT * FROM PROD;