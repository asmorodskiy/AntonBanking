create database antonbanking;
use antonbanking;
create table user (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,name VARCHAR(100));
create table userDic ( user_id INT , account_id INT );
create table accounts (id INT NOT NULL  PRIMARY KEY,quantity DOUBLE,typ INT);
create table mytransactions ( id INT NOT NULL  PRIMARY KEY,value DOUBLE,date TIMESTAMP);
create table mytransactionsDic ( trans_id INT , acc_id INT );

