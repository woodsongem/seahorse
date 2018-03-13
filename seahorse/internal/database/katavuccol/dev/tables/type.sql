
   CREATE TABLE credentialtype (
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

INSERT INTO katavuccol_dev.credentialtype
(userid, id, createdby, createddate, description, modifiedby, modifieddate, name, status)
VALUES(?, ?, ?, '', '', ?, '', '', '');
