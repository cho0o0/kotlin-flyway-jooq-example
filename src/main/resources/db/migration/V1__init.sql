CREATE TABLE users (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  email varchar(100) NOT NULL UNIQUE,
  deleted boolean NOT NULL default false,
  PRIMARY KEY (id),
)