
   CREATE TABLE category (
   	id timeuuid,
    userid timeuuid,
    createdby timeuuid,
    createddate timestamp,
    description text,
    modifiedby timeuuid,
    modifieddate timestamp,
    name text,
    status text,
    PRIMARY KEY((userid),id)
);