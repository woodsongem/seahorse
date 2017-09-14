CREATE TABLE seahorse_dev.ch_application (
    decision text,
    id uuid,
    address set<frozen<seahorse_dev.address>>,
    createdby text,
    createddate timestamp,
    dateofbirth date,
    deathdate date,
    decisioncomments text,
    firstname text,
    gender text,
    lastname text,
    marriagedate date,
    middlename text,
    modifiedby text,
    modifieddate timestamp,
    nationalidentifier set<frozen<seahorse_dev.nationalidentifier>>,
    phone set<frozen<seahorse_dev.phone>>,
    userid uuid,
    PRIMARY KEY ((lastname,dateofbirth),id)
) WITH read_repair_chance = 0.0
   AND dclocal_read_repair_chance = 0.1
   AND gc_grace_seconds = 864000
   AND bloom_filter_fp_chance = 0.01
   AND caching = { 'keys' : 'ALL', 'rows_per_partition' : 'NONE' }
   AND comment = ''
   AND compaction = { 'class' : 'org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy', 'max_threshold' : 32, 'min_threshold' : 4 }
   AND compression = { 'chunk_length_in_kb' : 64, 'class' : 'org.apache.cassandra.io.compress.LZ4Compressor' }
   AND default_time_to_live = 0
   AND speculative_retry = '99PERCENTILE'
   AND min_index_interval = 128
   AND max_index_interval = 2048
   AND crc_check_chance = 1.0;

   
   
CREATE INDEX ch_application_firstname ON seahorse_dev.ch_application (firstname);
CREATE INDEX ch_application_decision ON seahorse_dev.ch_application (decision);
CREATE INDEX ch_application_dateofbirth ON seahorse_dev.ch_application (dateofbirth);
create index ch_application_userid on seahorse_dev.ch_application(userid);