CREATE DATABASE children;

CREATE SCHEMA children;

CREATE TABLE child
(
    id      INT,
    name    VARCHAR,
    surname VARCHAR,
    age     INT,
    email   VARCHAR
);

INSERT INTO child (id, name, surname, age, email)
VALUES (1, 'Ivan', 'Ivanov', 8, 'ivanov@gmail.com'),
       (2, 'Petr', 'Petrov', 10, 'petrov@mail.ru'),
       (3, 'Sveta', 'Svetikova', 6, 'svetikova@yandex.ru'),
       (4, 'Ilya', 'Tikhomirov', 19, 'i.tikhomirow@gmail.com'),
       (5, 'John', 'Smith', 12, 'john@hmail.com');

SELECT *
FROM child
ORDER BY id;