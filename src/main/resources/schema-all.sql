DROP TABLE people IF EXISTS;

CREATE TABLE reference  (
    id BIGINT NOT NULL PRIMARY KEY,
    item_id VARCHAR(10),
    short_desc VARCHAR(20),
    long_desc VARCHAR(50)
);