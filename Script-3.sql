create table bankaccount (
	id serial primary key not null,
	balance float not null,
	customer_id integer references bankcustomer(id) not null,
	approved int
)

create table bankcustomer (
	id serial primary key not null,
	name varchar(40) not null,
	username varchar(20) references bankuser(username) unique not null,
	join_date date
)

create table bankemployee (
	id serial primary key not null,
	name varchar(40) not null,
	username varchar(20) references bankuser(username) unique not null,
	passcode int not null
)

create table banktransaction (
	id serial primary key not null,
	trans_date date not null,
	amount float not null,
	trans_type varchar(10) not null,
	account_id integer references bankaccount(id) not null,
	customer_id integer references bankcustomer(id) not null
)

create table banktransfer (
	id serial primary key not null,
	customer_id integer references bankcustomer(id) not null,
	amount float not null,
	start_account integer not null,
	dest_account integer not null
)

create table bankuser (
	id serial primary key not null,
	username varchar(20) unique not null,
	pwd varchar(20) not null,
	role varchar(8) not null
)