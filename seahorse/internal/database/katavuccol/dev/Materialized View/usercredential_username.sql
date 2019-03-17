CREATE MATERIALIZED VIEW katavuccol_dev.usercredential_username AS
    SELECT username, id, createdby, createddate, modifiedby, modifieddate, "password", productitemid, status
    FROM katavuccol_dev.usercredential
    WHERE username IS NOT NULL AND id IS NOT NULL
    PRIMARY KEY (username, id)
    WITH CLUSTERING ORDER BY (id ASC)
    AND   caching = { 'keys' : 'ALL', 'rows_per_partition' : 100 }
    AND comment = 'Based on table usercredential'
   