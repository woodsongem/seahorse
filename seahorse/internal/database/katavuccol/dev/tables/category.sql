<<<<<<< HEAD

=======
>>>>>>> master
CREATE TABLE category (
    userid timeuuid,
    id timeuuid,
    createdby timeuuid,
    createddate timestamp,
    description text,
    modifiedby timeuuid,
    modifieddate timestamp,
    name text,
    status text,
    PRIMARY KEY (userid, id)
);
