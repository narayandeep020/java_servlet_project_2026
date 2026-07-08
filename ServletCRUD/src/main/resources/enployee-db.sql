create schema if not exists servlet_crud;
use  servlet_crud;

CREATE TABLE if not exists  employee (
  emp_id int(10) NOT NULL AUTO_INCREMENT,
  emp_name varchar(100) DEFAULT NULL,
  mail_id varchar(255) DEFAULT NULL,
  pswd varchar(30) DEFAULT NULL,
  country varchar(60) DEFAULT NULL,
  is_deleted char(1) DEFAULT 'N',
  PRIMARY KEY (`emp_id`)
)  AUTO_INCREMENT=100 ;

select * from employee ;