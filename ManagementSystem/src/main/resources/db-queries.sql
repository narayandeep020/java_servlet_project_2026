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

CREATE TABLE if not exists  admin (
  admin_id int(10) NOT NULL AUTO_INCREMENT,
  admin_name varchar(100) DEFAULT NULL,
  mail_id varchar(255) DEFAULT NULL,
  admin_pass varchar(30) DEFAULT NULL,
  country varchar(60) DEFAULT NULL,
  is_deleted char(1) DEFAULT 'N',
  PRIMARY KEY (admin_id)
)  AUTO_INCREMENT=200 ;

select * from admin_detail ;


CREATE TABLE if not exists  guest (
  guest_id int(10) NOT NULL AUTO_INCREMENT,
  guest_name varchar(100) DEFAULT NULL,
  guest_mail varchar(255) DEFAULT NULL,
  guest_pswd varchar(30) DEFAULT NULL,
  country varchar(60) DEFAULT NULL,
  is_deleted char(1) DEFAULT 'N',
  PRIMARY KEY (`guest_id`)
)  AUTO_INCREMENT=300 ;

select * from guest;

insert into guest (guest_name,guest_mail,guest_pswd,country)
values('prakash patil','prakashbook@gmail.com','patil23','UK');

--for about us table
CREATE TABLE if not exists  aboutUs (
    infoId INT PRIMARY KEY AUTO_INCREMENT,
    section_title VARCHAR(100) NOT NULL,
    description TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) AUTO_INCREMENT=1;


select * from aboutus;

INSERT INTO aboutUs (section_title, description)
VALUES 
('Profile', 'DevCode is a comprehensive educational portal that empowers learners across domains—spanning computer science, school-level subjects, commerce, essential software tools and technical services.'),
('Mission', 'To empower learners across domains by providing accessible, high-quality educational content that bridges the gap between theory and practical application—helping them excel in academics, careers, and beyond.'),
('Vision', 'To be the most comprehensive, inclusive, and trusted learning platform—enabling individuals from all walks of life to access knowledge, gain confidence, and succeed in their educational and career journeys.'),
('Our Story', 'Founded in 2025, Our founder Devendra Singraul is a visionary entrepreneur and esteemed computer science expert. Fueled by his unwavering passion for coding and education, laid the very bedrock upon which DevCode stands today, and his indomitable spirit has been instrumental in its remarkable growth and resounding success.');
