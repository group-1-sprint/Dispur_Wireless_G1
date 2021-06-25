--login table creation
create table Login(
logId varchar(20) primary key,
password varchar(20) not null
);

--table customer creation
create table Customer(
regId varchar(20) references Login(logId),
name varchar(20) not null,
address varchar(255) not null,
email varchar(30) not null,
contactNo varchar(12)
--status varchar(10) default 'Inactive'
);

--insert manager, admin and operator credentioal
insert into Login values('Manager','Manager');
insert into Login values('Admin','Admin');
insert into Login values('Operator','Operator'); 

insert into Login values('316','lol');
insert into Customer(regId,name,address,email,contactNo) values('316','shamira','kl','s@t.com','238');
insert into Login values('971','lel');
insert into Customer(regId,name,address,email,contactNo) values('971','aizat','prk','a@b.com','2412');
insert into Login values('825','lil');
insert into Customer(regId,name,address,email,contactNo) values('825','curtis','kl','c@t.com','523');
insert into Login values('106','lal');
insert into Customer(regId,name,address,email,contactNo) values('106','thanusha','sg','s@t.com','15124');
insert into Login values('402','lul');
insert into Customer(regId,name,address,email,contactNo) values('402','dheera','png','c@t.com','15123');

--table plan creation
create table Plan(
planId number(10) primary key,
planName varchar(50) not null,
planType varchar(20) not null,
tariff number(7,2),
validity number(3),
rental varchar(255)
);

insert into Plan values(12,'MX45','30GB','0.5','30','');
insert into Plan values(34,'MX44','33GB','0.4','7','No');
insert into Plan values(45,'MX430','130GB','0.1','1','');
insert into Plan values(94,'MX421','230GB','0.9','14','Yes');

--table creation
create table Subscription(
subId number(3) primary key,
custId varchar(20) references Login(logId),
planId number(10) references Plan(planId),
duration number(1) check(duration >= 0 and duration <=3)
);

select * from Customer;
select * from Login;
select * from Customer join Login on Customer.regId = Login.logId;
select * from Plan;
select * from Subscription;

drop table Login;
drop table Customer;
drop table Plan;
drop table Subscription;

delete from Customer;
delete from Login;