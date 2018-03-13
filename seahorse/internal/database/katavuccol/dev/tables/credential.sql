
   CREATE TABLE credential (
   	id timeuuid,
    userid timeuuid,
    categoryid timeuuid,
    credentialtypeid timeuuid,
    createdby timeuuid,
    createddate timestamp,
    description text,
    modifiedby timeuuid,
    modifieddate timestamp,    
    status text,
    PRIMARY KEY((userid),id)
);
