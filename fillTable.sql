INSERT into user (name) values ('testUser');
insert into accounts (id, quantity , typ ) values(23,10.1,1);
insert into userDic ( user_id , account_id ) values (1,23);
insert into mytransactions ( id , value , date ) values ( 11, 10 , '2020-2-14');
insert into mytransactions ( id , value , date ) values ( 12, 10 , '2020-2-13');
insert into mytransactions ( id , value , date ) values ( 13, 10 , '2020-2-12');
insert into mytransactionsDic (trans_id , acc_id) values ( 13,23 ) ; 
insert into mytransactionsDic (trans_id , acc_id) values ( 12,23 ) ; 
insert into mytransactionsDic (trans_id , acc_id) values ( 11,23 ) ; 
