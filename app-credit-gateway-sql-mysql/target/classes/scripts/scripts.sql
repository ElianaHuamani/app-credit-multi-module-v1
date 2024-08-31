--DROP DATABASE credit;
--CREATE DATABASE credit;
--use credit
--show tables
--SHOW DATABASES
--select schema_name as database_name
--from information_schema.schemata
--order by schema_name;

CREATE TABLE credit.Solicitude (
    SolicitudeId int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    Name varchar(250),
    LastName varchar(250),
    TypeDocument varchar(3),
    DocumentNumber varchar(15),
	Email varchar(100),
    Phone varchar(10),
    Amount int,
	DisbursementDate date,
	Terms int,
    Tea decimal(15,2),
	TermAmount decimal(15,2),
	TotalAmount decimal(35,2),
    EndDate date,
	Status varchar(2)
);

CREATE TABLE credit.SolicitudeDetail (
	SolicitudeDetailId int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    SolicitudeId int,
	TermNumber int,
	PaymentDate date,
	Principal decimal(35,2),
	Amortization decimal(35,2),
	Interest decimal(35,2),
	TermAmount decimal(35,2),
	Itf decimal(35,2),
	TermAmountTotal decimal(35,2)
);


select * from credit.Solicitude;
--drop table seg.Solicitude;
--truncate table seg.Solicitude;

insert into credit.Solicitude (Name,LastName, TypeDocument, DocumentNumber, Amount, Email, Phone, Status)
values ("Eliana", "Huamani", "DNI", "44000124", 1500, "elianan@tekton.com", "999999999", "A",'2023-08-25');
