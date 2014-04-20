
CREATE TABLE PERSON_CONTACT_TYPE(
    ID VARCHAR(20) NOT NULL
    , DESCRIPTION VARCHAR(512)
    , PRIMARY KEY (ID)
);

CREATE TABLE PERSON_CONTACT_STATE(
    ID VARCHAR(20) NOT NULL
    , DESCRIPTION VARCHAR(512)
    , PRIMARY KEY (ID)
);

CREATE TABLE PERSON(
    ID INT NOT NULL AUTO_INCREMENT
    , FIRST_NAME VARCHAR(512) NOT NULL
    , SECOND_NAME VARCHAR(512)
    , LAST_NAME VARCHAR(512)
    , CONTACT_TYPE_ID VARCHAR(20) NOT NULL
    , PRIMARY KEY (ID)
    , CONSTRAINT FK_PERSON_1 FOREIGN KEY (CONTACT_TYPE_ID) REFERENCES PERSON_CONTACT_TYPE(ID)
);

CREATE TABLE PERSON_CONTACT(
    ID INT NOT NULL AUTO_INCREMENT
    , PERSON_ID INT NOT NULL
    , TYPE_ID VARCHAR(20) NOT NULL
    , STATE_ID VARCHAR(20) NOT NULL
    , CONTACT VARCHAR(512) NOT NULL
    , MAIN INT DEFAULT 0
    , PRIMARY KEY (ID)
    , CONSTRAINT FK_PERSON_CONTACT_1 FOREIGN KEY (PERSON_ID) REFERENCES PERSON(ID)
    , CONSTRAINT FK_PERSON_CONTACT_2 FOREIGN KEY (TYPE_ID) REFERENCES PERSON_CONTACT_TYPE(ID)
    , CONSTRAINT FK_PERSON_CONTACT_3 FOREIGN KEY (STATE_ID) REFERENCES PERSON_CONTACT_STATE(ID)
);
