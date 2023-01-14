
CREATE TABLE users (
 id bigint(20) NOT NULL AUTO_INCREMENT,
 name varchar(100) DEFAULT NULL,
 last_name varchar(100) DEFAULT NULL,
 email varchar(50) DEFAULT NULL,
 phone varchar(11) DEFAULT NULL,
 password varchar(20) DEFAULT NULL,
 age bigint(20) NOT NULL,
PRIMARY KEY (id)
);
