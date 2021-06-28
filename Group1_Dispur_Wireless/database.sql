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
contactNo varchar(12) not null
);

--table plan creation
create table Plan(
planId number(10) primary key,
planName varchar(50) not null,
planType varchar(20) not null,
tariff number(7,2),
validity number(3),
rental varchar(255)
);

--Subscription table creation
create table Subscription(
subId number(3) primary key,
custId varchar(20) references Login(logId),
planId number(10) references Plan(planId),
duration number(2)
);

--insert manager, admin and operator credential
insert into Login values('Manager','Manager');
insert into Login values('Admin','Admin');
insert into Login values('Operator','Operator'); 

--hardcoded data for login and customer for testing purpose
insert into Login values('316','123');
insert into Customer(regId,name,address,email,contactNo) values('316','shamira','kl','shamira@tcs.com','0185674836');
insert into Login values('971','456');
insert into Customer(regId,name,address,email,contactNo) values('971','aizat','prk','aizat@tcs.com','0194273648');
insert into Login values('825','789');
insert into Customer(regId,name,address,email,contactNo) values('825','curtis','kl','curtis@tcs.com','0158293746');
insert into Login values('106','101');
insert into Customer(regId,name,address,email,contactNo) values('106','thanusha','sg','thanusha@tcs.com','0172394658');
insert into Login values('402','112');
insert into Customer(regId,name,address,email,contactNo) values('402','dheera','png','dheera@tcs.com','0129380998');

--hard coded data for plan table for testing purpose
insert into Plan values(12,'MX45','Data',0.30,7,'Yes');
insert into Plan values(34,'MX14','Voice',0.70,30,'No');
insert into Plan values(45,'MX30','Voice',0.10,60,'Yes');
insert into Plan values(94,'MX21','Data',0.40,14,'Yes');

--to display tables content
select * from Customer;
select * from Login;
select * from Customer join Login on Customer.regId = Login.logId;
select * from Plan;
select * from Subscription;

--join plan and customer table with subscribe table
select Subscription.subId, Customer.regId, Customer.name, Subscription.planId, Plan.planName, Plan.planType, Plan.tariff, Plan.validity, Plan.rental, Subscription.duration from ((Subscription join Plan on Subscription.planId=Plan.planId) join Customer on Subscription.custId = Customer.regId) where Customer.regId=316;
select Subscription.planId, Plan.planName, Plan.planType, Plan.tariff, Plan.validity, Plan.rental from Subscription join Plan on Subscription.planId=Plan.planId where Subscription.custId=316;

--drop table Login;
--drop table Customer;
--drop table Plan;
--drop table Subscription;

--delete from Customer;
--delete from Login;