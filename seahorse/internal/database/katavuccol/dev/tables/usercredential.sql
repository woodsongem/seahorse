create table usercredential(
id uuid,
username text,
password text,
status text,
productitemid uuid,
createdby timeuuid,
createddate timestamp,
modifiedby timeuuid,
modifieddate timestamp,
primary key ((username),id)
)

