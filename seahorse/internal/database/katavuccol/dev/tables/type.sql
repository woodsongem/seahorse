CREATE TABLE credentialtype (
    userid timeuuid,
    id timeuuid,
    createdby timeuuid,
    createddate timestamp,
    description text,
    isduplicationallowed boolean,
    issubitemallowed boolean,
    modifiedby timeuuid,
    modifieddate timestamp,
    name text,
    status text,
    PRIMARY KEY (userid, id)
);

INSERT INTO katavuccol_dev.credentialtype
(userid, id, createdby, createddate, description, modifiedby, modifieddate, name, status)
VALUES(?, ?, ?, '', '', ?, '', '', '');
