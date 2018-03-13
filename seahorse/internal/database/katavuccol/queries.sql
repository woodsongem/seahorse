select * from category where userid=now()
select * from "type" where userid=now()
select * from credential where userid=now()

select * from usercredential where username='ds';

SELECT userid, id, createdby, createddate, description, modifiedby, modifieddate, name, status
FROM katavuccol_dev.category where id=now() and userid=now();

SELECT userid, id, createdby, createddate, description, modifiedby, modifieddate, name, status
FROM katavuccol_dev."type" where id=now() and userid=now();


SELECT userid, id, createdby, createddate, description, modifiedby, modifieddate, name, status
FROM katavuccol_dev.credentialtype where id=now() and userid=now();


INSERT INTO credential
(userid, id, categoryid, createdby, createddate, description, modifiedby, modifieddate, name, status, typeid)
VALUES(?, ?, ?, ?, '', '', '', '', ?);

INSERT INTO usercredential
(username, id, createdby, createddate,password, productitemid, status)
VALUES('sajanmje', now(), now(), '2018-03-12 23:36:46','Howareyou@90', now(), 'ACTIVE');

select dateof(now()) from "system"."local";
select * from usercredential;
select * from credentialtype;
select * from category;
select * from credential;

INSERT INTO credentialtype
(userid, id, createdby, createddate, description,name, status)
VALUES(c6dc6cc0-266f-11e8-ba08-9d4c8b0b0c54, now(), c6dc6cc0-266f-11e8-ba08-9d4c8b0b0c54,
dateof(now()),'EmailAddress of the application', 'EmailAddress', 'ACTIVE');

INSERT INTO katavuccol_dev.category
(userid, id, createdby, createddate, description,name, status)
VALUES(c6dc6cc0-266f-11e8-ba08-9d4c8b0b0c54,now(),c6dc6cc0-266f-11e8-ba08-9d4c8b0b0c54, 
dateof(now()),'Bank of america','Bank of America','ACTIVE');












