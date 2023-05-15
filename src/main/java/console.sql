CREATE TABLE music
(
    id         SERIAL PRIMARY KEY,
    title      VARCHAR
        CONSTRAINT title CHECK (char_length(title) >= 2 AND char_length(title) <= 30) UNIQUE NOT NULL,
    vendorCode INT CHECK (vendorCode > 0) UNIQUE                                             NOT NULL,
    feedback   VARCHAR                                                                       NOT NULL
);

INSERT INTO music (title, vendorCode, feedback)
VALUES ('classicalMusic', 150, 'tom@gmail.com'),
       ('rockMusic', 200, 'bob@gmail.com'),
       ('rapMusic', 300, 'john@gmail.com');