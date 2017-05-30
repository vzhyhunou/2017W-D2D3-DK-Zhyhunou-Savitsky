CREATE TABLE LANGCOURSE
(
    ID int PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    NAME varchar(50),
    LANGUAGE varchar(50),
    PRICE DOUBLE
);

CREATE TABLE TOPIC
(
    ID int PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    NAME varchar(50),
    DESCRIPTION varchar(50),
    COURSEID int,
    CONSTRAINT TOPIC_LANGCOURSE_ID_FK FOREIGN KEY (COURSEID) REFERENCES LANGCOURSE (ID)
);

/*INSERT INTO LANGCOURSE (ID, NAME, LANGUAGE, PRICE) VALUES (1, 'English A1', 'English', 189.9);
INSERT INTO LANGCOURSE (ID, NAME, LANGUAGE, PRICE) VALUES (2, 'English A2', 'English', 123.6);*/

INSERT INTO LANGCOURSE (NAME, LANGUAGE, PRICE) VALUES ('English A1', 'English', 189.9);
INSERT INTO LANGCOURSE (NAME, LANGUAGE, PRICE) VALUES ('English A2', 'English', 123.6);

INSERT INTO TOPIC (NAME, DESCRIPTION, COURSEID) VALUES ('2nd Chapter', 'Written language', 1);