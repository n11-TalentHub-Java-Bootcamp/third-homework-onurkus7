
INSERT INTO CATEGORY( ID, NAME, SPLIT, ID_TOP_CATEGORY)  VALUES (	1	,'Moda',	1	,	null	);
INSERT INTO CATEGORY( ID, NAME, SPLIT, ID_TOP_CATEGORY)  VALUES (	2	,'Elektronik',	1	,	null	);
INSERT INTO CATEGORY( ID, NAME, SPLIT, ID_TOP_CATEGORY)  VALUES (	3	,'Ev & Yaşam',	1	,	null	);
INSERT INTO CATEGORY( ID, NAME, SPLIT, ID_TOP_CATEGORY)  VALUES (	4	,'Elbise',	2	,	1	);
INSERT INTO CATEGORY( ID, NAME, SPLIT, ID_TOP_CATEGORY)  VALUES (	5	,'Gömlek',	2	,	1	);
INSERT INTO CATEGORY( ID, NAME, SPLIT, ID_TOP_CATEGORY)  VALUES (	6	,'Bilgisayar',	2	,	2	);
INSERT INTO CATEGORY( ID, NAME, SPLIT, ID_TOP_CATEGORY)  VALUES (	7	,'Dizüstü Bilgisayar',	3	,	6	);
INSERT INTO CATEGORY( ID, NAME, SPLIT, ID_TOP_CATEGORY)  VALUES (	8	,'Mobilya',	2	,	3	);
INSERT INTO CATEGORY( ID, NAME, SPLIT, ID_TOP_CATEGORY)  VALUES (	9	,'Sehpa',	3	,	8	);

INSERT INTO PRODUCT( ID, NAME, PRICE, REGISTER_DATE, ID_CATEGORY) VALUES (	1	,'Mavi Elbise',	200	, now(), 	4);
INSERT INTO PRODUCT( ID, NAME, PRICE, REGISTER_DATE, ID_CATEGORY) VALUES (	2	,'Kırmızı Elbise',	300	, now(), 	4);
INSERT INTO PRODUCT( ID, NAME, PRICE, REGISTER_DATE, ID_CATEGORY) VALUES (	3	,'Mavi Gömlek',	500	, now(), 	5);
INSERT INTO PRODUCT( ID, NAME, PRICE, REGISTER_DATE, ID_CATEGORY) VALUES (	4	,'Sarı Gömlek',	450	, now(), 	5);
INSERT INTO PRODUCT( ID, NAME, PRICE, REGISTER_DATE, ID_CATEGORY) VALUES (	5	,'HP ',	15000	, now(), 	7);
INSERT INTO PRODUCT( ID, NAME, PRICE, REGISTER_DATE, ID_CATEGORY) VALUES (	6	,'MSI',	20000	, now(), 	7);
INSERT INTO PRODUCT( ID, NAME, PRICE, REGISTER_DATE, ID_CATEGORY) VALUES (	7	,'Orta Sehpa',	600	, now(), 	9);

INSERT INTO USERS( ID, NAME, LAST_NAME, USER_NAME, PHONE_NUMBER, EMAIL) VALUES (	1	,'Onur', 'Kuş','onurkus', 7777,'onurkus@example.com');
INSERT INTO USERS( ID, NAME, LAST_NAME, USER_NAME, PHONE_NUMBER, EMAIL) VALUES (	2	,'Vedat','Bilal','vedetbilal', 5555,'vedetbilal@example.com');
INSERT INTO USERS( ID, NAME, LAST_NAME, USER_NAME, PHONE_NUMBER, EMAIL) VALUES (	3	,'Baki','Bayrak','bakibayrak', 4444,'bakibayrak@example.com');
INSERT INTO USERS( ID, NAME, LAST_NAME, USER_NAME, PHONE_NUMBER, EMAIL) VALUES (	4	,'Batuhan','Kılıç','batuhankilic',3333,'batuhankilic@example.com');
INSERT INTO USERS( ID, NAME, LAST_NAME, USER_NAME, PHONE_NUMBER, EMAIL) VALUES (	5	,'Hüseyin','Öz','huseyinoz', 2222,'huseyinoz@example.com');
INSERT INTO USERS( ID, NAME, LAST_NAME, USER_NAME, PHONE_NUMBER, EMAIL) VALUES (	6	,'Turan','Savaş','turansavas', 6666, 'turansavas@example.com');
INSERT INTO USERS( ID, NAME, LAST_NAME, USER_NAME, PHONE_NUMBER, EMAIL) VALUES (	7	,'Ahmet','Oğuz','ahmetoguz',  9999, 'ahmetoguz@example.com');

INSERT INTO PRODUCT_REVIEW( ID, REVIEW, REVIEW_DATE, ID_PRODUCT, ID_USERS) VALUES (	1	,'Therefore, database queries may be performed during view rendering.',now(), 7,1);
INSERT INTO PRODUCT_REVIEW( ID, REVIEW, REVIEW_DATE, ID_PRODUCT, ID_USERS) VALUES (	2	,'Using JtaPlatform implementation.',now(), 5,2);
INSERT INTO PRODUCT_REVIEW( ID, REVIEW, REVIEW_DATE, ID_PRODUCT, ID_USERS) VALUES (	3	,'Started SpringBootTraningApplication in 5.506 seconds.',now(), 4,3);
INSERT INTO PRODUCT_REVIEW( ID, REVIEW, REVIEW_DATE, ID_PRODUCT, ID_USERS) VALUES (	4	,'tarting SpringBootTraningApplication using Java 11.0.13 on DESKTOP',now(),3,4);
INSERT INTO PRODUCT_REVIEW( ID, REVIEW, REVIEW_DATE, ID_PRODUCT, ID_USERS) VALUES (	5	,'Therefore, database queries may be performed during view rendering.',now(), 2,5);
INSERT INTO PRODUCT_REVIEW( ID, REVIEW, REVIEW_DATE, ID_PRODUCT, ID_USERS) VALUES (	6	,'Therefore, database queries may be performed during view rendering.',now(), 6,6);
INSERT INTO PRODUCT_REVIEW( ID, REVIEW, REVIEW_DATE, ID_PRODUCT, ID_USERS) VALUES (	7	,'Therefore, database queries may be performed during view rendering.',now(),  1,7);
