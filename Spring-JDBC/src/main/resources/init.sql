CREATE TABLE LANGCOURSE
(
    ID int PRIMARY KEY NOT NULL,
    NAME varchar(50) NOT NULL,
    LANGUAGE varchar(50)
);

INSERT INTO LANGCOURSE (ID, NAME, LANGUAGE) VALUES (0, 'English A1', 'English');
INSERT INTO LANGCOURSE (ID, NAME, LANGUAGE) VALUES (1, 'English A2', 'English');