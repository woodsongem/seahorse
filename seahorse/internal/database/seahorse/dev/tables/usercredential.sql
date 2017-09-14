create table usercredential(
id uuid,
username text,
password text,
status text,
productitemid uuid,
createdby text,
createddate timestamp,
modifiedby text,
modifieddate timestamp,
primary key ((username,password),id)
)

create index usercredential_productitemid on seahorse_dev.usercredential(productitemid)



