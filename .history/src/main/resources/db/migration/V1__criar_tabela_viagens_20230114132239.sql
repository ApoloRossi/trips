
CREATE TABLE trips (
 id bigint(20) NOT NULL AUTO_INCREMENT,
 name varchar(100) DEFAULT NULL,
 description varchar(100) DEFAULT NULL,
 value DOUBLE DEFAULT NULL,
 phone varchar(11) DEFAULT NULL,
 password varchar(20) DEFAULT NULL,
 age bigint(20) NOT NULL,
PRIMARY KEY (id)
);
