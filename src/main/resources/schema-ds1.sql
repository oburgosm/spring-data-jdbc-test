CREATE TABLE PERSON(
  id long GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  firstname VARCHAR2(50) NOT NULL,
  LASTNAME VARCHAR2(50) NOT NULL);