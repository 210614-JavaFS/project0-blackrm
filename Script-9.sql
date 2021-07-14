insert into bankuser(username, pwd, role) values ('rose', 'black', 'ADMIN')
insert into bankuser(username, pwd, role) values ('helen', 'black', 'ADMIN')
insert into bankuser(username, pwd, role) values ('john', 'black', 'EMPLOYEE')
insert into bankuser(username, pwd, role) values ('clint', 'black', 'EMPLOYEE')
insert into bankuser(username, pwd, role) values ('rick', 'black', 'CUSTOMER')
insert into bankuser(username, pwd, role) values ('tuxedo', 'black', 'CUSTOMER')

insert into bankcustomer (name, username, join_date) values ('rick black', 'rick', '2021-07-11')
insert into bankcustomer (name, username, join_date) values ('tuxedo black', 'tuxedo', '2021-07-11')
insert into bankcustomer (name, username, join_date) values ('tom hanks', 'tom', '2021-07-14')

insert into bankemployee (name, username, passcode) values ('john black', 'john', 1234)
insert into bankemployee (name, username, passcode) values ('clint black', 'clint', 2345)

select * from bankemployee b 

alter table bankaccount 
alter column approved type varchar(8)

select * from bankuser b 

select * from bankaccount b 

select * from bankcustomer b 
select * from bankaccount b2 

ALTER TABLE banktransaction ALTER COLUMN trans_date DROP NOT NULL

select * from banktransaction b 
