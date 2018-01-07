create table product(
id uuid,
productname text,
description text,
createdby text,
createddate timestamp,
modifiedby text,
modifieddate timestamp,
status text,
primary key ((productname),id)
)

