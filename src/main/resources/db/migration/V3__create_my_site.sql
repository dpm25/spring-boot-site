DROP TABLE TODO;

CREATE TABLE TODO (ID INT auto_increment,
  TITLE VARCHAR (255) NOT NULL,
  NOTE VARCHAR (255),
  CREATE_DATE DATE NOT NULL,
  DUE_DATE DATE NULL,
  COMPLETE BOOLEAN
);