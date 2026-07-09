create schema if not exists ImageUpload_db;
use ImageUpload_db;

 CREATE TABLE users_img ( 
 id int(11) NOT NULL AUTO_INCREMENT, 
first_name varchar(45) DEFAULT NULL, 
last_name varchar(45) DEFAULT NULL, 
photo mediumblob, 
PRIMARY KEY (`id`) 
) auto_increment = 100;

select * from users_img;