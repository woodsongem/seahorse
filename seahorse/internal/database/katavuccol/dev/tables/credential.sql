CREATE TABLE credential (
    userid timeuuid,
    id timeuuid,
    categoryid timeuuid,
    createdby timeuuid,
    createddate timestamp,
    credentialtypeid timeuuid,
    description text,
    encryptkey text,
    modifiedby timeuuid,
    modifieddate timestamp,
    parentid uuid,
    status text,
    userencryptkey text,
    value text,
    PRIMARY KEY (userid, id)
);
