create table productitem(
id uuid,
productid uuid,
productitemname text,
description text,
createdby text,
createddate timestamp,
modifiedby text,
modifieddate timestamp,
status text,
primary key (productitemname,status,id)
)

