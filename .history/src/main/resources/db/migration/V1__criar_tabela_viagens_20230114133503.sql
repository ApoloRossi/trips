
CREATE TABLE trips (
 id bigint(20) NOT NULL AUTO_INCREMENT,
 name varchar(100) DEFAULT NULL,
 description varchar(100) DEFAULT NULL,
 value decimal(10,2) DEFAULT NULL,
 date_init varchar(11) DEFAULT NULL,
 date_end varchar(20) DEFAULT NULL,
 available_vacancies bigint(20) NOT NULL,
 city varchar(100) DEFAULT NULL,
 cityState varchar(100) DEFAULT NULL
PRIMARY KEY (id)
);
