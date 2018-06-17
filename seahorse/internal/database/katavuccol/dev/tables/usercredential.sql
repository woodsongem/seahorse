CREATE TABLE usercredential (
    id uuid,
    createdby timeuuid,
    createddate timestamp,
    modifiedby timeuuid,
    modifieddate timestamp,
    "password" text,
    productitemid uuid,
    status text,
    username text,
    PRIMARY KEY (id)
);

