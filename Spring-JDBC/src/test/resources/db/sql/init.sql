CREATE TABLE LANGCOURSE
(
    ID int PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    NAME varchar(50) NOT NULL,
    LANGUAGE varchar(50)
);

INSERT INTO LANGCOURSE (NAME, LANGUAGE) VALUES ('English A1', 'English');
INSERT INTO LANGCOURSE (NAME, LANGUAGE) VALUES ('English A2', 'English');