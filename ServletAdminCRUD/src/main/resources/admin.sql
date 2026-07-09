create schema if not exists servlet_crud;
use  servlet_crud;

CREATE TABLE if not exists  admin (
  admin_id int(10) NOT NULL AUTO_INCREMENT,
  admin_name varchar(100) DEFAULT NULL,
  admin_email varchar(255) DEFAULT NULL,
  admin_pswd varchar(30) DEFAULT NULL,
  country varchar(60) DEFAULT NULL,
  is_deleted char(1) DEFAULT 'N',
  PRIMARY KEY (`admin_id`)
)  AUTO_INCREMENT=100 ;

select * from admin;
