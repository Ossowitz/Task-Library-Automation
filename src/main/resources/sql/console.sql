DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS person;

CREATE TABLE person
(
    id           INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name         VARCHAR            NOT NULL CHECK ( length(name) > 2 AND length(name) < 30 ),
    age          INT CHECK ( age > 0 ),
    email        VARCHAR UNIQUE     NOT NULL,
    address      VARCHAR            NOT NULL,
    phone_number VARCHAR(11) UNIQUE NOT NULL,
    perk         VARCHAR(10)        NOT NULL
);

CREATE TABLE book
(
    id          INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    person_id   INT          REFERENCES person (id) ON DELETE SET NULL,
    title       VARCHAR(128) NOT NULL UNIQUE CHECK (length(title) > 2 AND length(title) < 30),
    author      VARCHAR(128) NOT NULL,
    year        INT          NOT NULL CHECK (year > 0),
    vendor_code INT          NOT NULL UNIQUE CHECK (char_length(vendor_code::text) = 6),
    taken_at    TIMESTAMP
);