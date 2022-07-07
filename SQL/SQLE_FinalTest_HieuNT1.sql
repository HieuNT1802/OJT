CREATE DATABASE BankDatabase
USE BankDatabase

--A
CREATE TABLE Person (
PersonId INT PRIMARY KEY IDENTITY(1,1)
, Title VARCHAR(5)
, FirstName NVARCHAR (50) Not Null
, LastName NVARCHAR (50) Not Null
, DateOfBirth DATE Not Null
, Email VARCHAR (50) CHECK (Email LIKE '%@%')
, Debt DECIMAl (5,3)
)

CREATE TABLE ContactDetails (
ContactID INT PRIMARY KEY IDENTITY(1,1)
, PersonId INT FOREIGN KEY REFERENCES Person(PersonId)
, ContactType VARCHAR(15)
, PhoneNumber VARCHAR(15)
, [Address] NVARCHAR (2000)
, OfficeTimeOnly BIT
)
 CREATE TABLE CreditCard (
 CreditCardID CHAR(7) Not Null UNIQUE CHECK(LEN(CreditCardID)=7)
 , CardType VARCHAR(30) CHECK (CardType = 'SuperiorCard' or CardType = 'Vista' or CardType = 'Distinguish' or
 CardType = 'ColonailVoice' )
 , CardNumber DECIMAL (10,0) CHECK (LEN(CardNumber)=10) Not Null
 , ExpMonth INT Not Null 
 , ExpYear INT Not Null 
 )
 CREATE TABLE PersonCreditCard (
 PersonId INT FOREIGN KEY REFERENCES Person(PersonId)
 , CreditCardID CHAR(7) FOREIGN KEY REFERENCES CreditCard(CreditCardID)
 , ModifiedDate DATETIME Not Null
 , IsOwner BIT
 , Balance DECIMAL(10,3) 
 )

 --B
 INSERT INTO Person VALUES ('Mr','Nguyen','Trung Hieu','2001-04-06','HieuNt123@gmail.com',0)
 INSERT INTO Person VALUES ('Mrs','Nguyen','Thi Hieu','2000-05-06','HieuNt2@gmail.com',1)
 INSERT INTO Person VALUES ('Mr','Nguyen','Hai Nam','2001-09-06','NamNt123@gmail.com',2)
 INSERT INTO Person VALUES ('Mr','Do','Trung Hieu','2001-05-07','HieuNt10@gmail.com',3)
 INSERT INTO Person VALUES ('Mr','Nguyen','Trung Hieu','2001-04-06','HieuNt123@gmail.com',4)
 INSERT INTO Person VALUES ('Mrs','Nguyen','Van An','2001-04-06','AnNV@gmail.com',50)
 INSERT INTO Person VALUES ('Mrs','Ta','Thi Doan','2001-04-06','DoanDT@gmail.com',6)
 INSERT INTO Person VALUES ('Mr','Nguyen','Van Trung','2002-04-06','Trung123@gmail.com',7)
 INSERT INTO Person VALUES ('Mr','Nguyen','Huu Viet','2001-04-02','Viet@gmail.com',8)
 INSERT INTO Person VALUES ('Mr','Doan','Trung Son','2001-02-01','Son@gmail.com',9)
 INSERT INTO Person VALUES ('Mr','Peter','Parker','2001-09-01','peter@crop.com',10)

 INSERT INTO ContactDetails VALUES (4,'HOME','0974123594','Ha Noi',0 )
 INSERT INTO ContactDetails VALUES (6,'HOME','0974124394','Ha Noi',1 )
 INSERT INTO ContactDetails VALUES (7,'OFFICE','0974123594','Ha Noi',0 )
 INSERT INTO ContactDetails VALUES (8,'HOME','0974123594','Ha Noi',0 )
 INSERT INTO ContactDetails VALUES (9,'OFFICE','0912123594','Ha Noi',1 )
 INSERT INTO ContactDetails VALUES (10,'HOME','0989123594','Ha Noi',0 )
 INSERT INTO ContactDetails VALUES (11,'HOME','0974123594','Ha Noi',1 )
 INSERT INTO ContactDetails VALUES (12,'OFFICE','091233594','Ha Noi',0 )
 INSERT INTO ContactDetails VALUES (13,'HOME','0971233594','Ha Noi',1 )
 INSERT INTO ContactDetails VALUES (14,'HOME','09711233594','Ha Noi',1 )

 INSERT INTO CreditCard VALUES ('A000001','SuperiorCard',1234567891,4,2022)
 INSERT INTO CreditCard VALUES ('A000002','Vista',1234567892,5,2022)
 INSERT INTO CreditCard VALUES ('A000003','Distinguish',1234567893,6,2022)
 INSERT INTO CreditCard VALUES ('A000004','ColonailVoice',1234567894,2,2022)
 INSERT INTO CreditCard VALUES ('A000005','SuperiorCard',1234567895,1,2022)
 INSERT INTO CreditCard VALUES ('A000006','Vista',1234567896,4,2022)
 INSERT INTO CreditCard VALUES ('A000007','SuperiorCard',1234567871,9,2022)
 INSERT INTO CreditCard VALUES ('A000008','Distinguish',1234567823,10,2022)
 INSERT INTO CreditCard VALUES ('A000009','SuperiorCard',1234567801,12,2022)
 INSERT INTO CreditCard VALUES ('A000010','ColonailVoice',1234567860,3,2022)

 INSERT INTO PersonCreditCard VALUES (4,'A000001','2020-03-02',0,120000 )
 INSERT INTO PersonCreditCard VALUES (6,'A000002','2020-05-01',0,130000 )
 INSERT INTO PersonCreditCard VALUES (7,'A000003','2020-04-03',0,140000 )
 INSERT INTO PersonCreditCard VALUES (8,'A000004','2020-09-08',0,110000 )
 INSERT INTO PersonCreditCard VALUES (9,'A000005','2020-10-11',0,134500 )
 INSERT INTO PersonCreditCard VALUES (10,'A000006','2020-12-02',0,190001 )
 INSERT INTO PersonCreditCard VALUES (11,'A000007','2020-10-09',0,124562 )
 INSERT INTO PersonCreditCard VALUES (12,'A000008','2020-04-06',0,145667 )
 INSERT INTO PersonCreditCard VALUES (13,'A000009','2020-02-09',0,123557)


 --C
  SELECT * FROM Person WHERE Debt 
  IN (SELECT TOP(3) Debt FROM Person WHERE Debt > 0 )
 --D
 SELECT  a.PhoneNumber,a.[Address] 
 FROM ContactDetails as a INNER JOIN Person b On a.PersonId=b.PersonId
 WHERE b.Email = 'peter@crop.com'

 --E 
  DECLARE @month INT;
  SELECT @month = ExpMonth 
  FROM CreditCard WHERE CreditCardID = (SELECT CreditCardID FROM PersonCreditCard WHERE PersonId=13)

  -- CHECK @month+6 <13 +Month ELSE YEAR +1 and Month-12
  IF @month+6 <13 
  -- SELECT * FROM CreditCard 
  BEGIN
	UPDATE CreditCard SET ExpMonth=@month+6 WHERE CreditCardID = (SELECT CreditCardID FROM PersonCreditCard 
					WHERE PersonId=13)
  END
  ELSE
	UPDATE CreditCard SET ExpYear = ExpYear+1,   ExpMonth=(@month+6)-12 
  WHERE CreditCardID = (SELECT CreditCardID FROM PersonCreditCard WHERE PersonId=13)

 --F 
 SELECT CONCAT(a.FirstName,' ',a.LastName) as [FullName], SUM(b.Balance) as [Total Balance]
 FROM Person a INNER JOIN PersonCreditCard as b ON a.PersonId=b.PersonId
 GROUP BY a.FirstName,a.LastName,b.Balance
 --Negative
 HAVING b.Balance >0 
 
