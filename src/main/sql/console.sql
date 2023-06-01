CREATE TABLE person
(
    id           INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name         VARCHAR        NOT NULL CHECK (length(name) > 2 AND length(name) < 30),
    age          INT CHECK (age > 0),
    email        VARCHAR UNIQUE NOT NULL,
    address      VARCHAR        NOT NULL,
    phone_number VARCHAR(11),
    perk         VARCHAR(10)    NOT NULL
);

INSERT INTO person (name, age, email, address, phone_number, perk)
VALUES ('Тихомиров Илья Алексеевич', 19, '76myxomor76@gmail.com', 'Россия, СПб, Красносельский', '89214489228',
        'STAFF'),
       ('Рэдли Брайан', 20, 'kolmogorov.un@gmail.com', 'Россия, Ленинградская, Всеволожский', '89219205851', 'VIP'),
       ('Иванов Иван', 51, 'tor@yandex.ru', 'Украина, Чернигов, Новозаводской', '89219217278', 'READERSHIP'),
       ('Алексеев Алексей Алексеевич', 32, 'redshift@mail.ru', 'Беларусь, Минск, Малиновка', '89214759632', 'MENTOR'),
       ('Петров Пётр Петрович', 16, 'position@gmail.com', 'Россия, Москва, Химки', '89214415684', 'VIP'),
       ('Фёдоров Мирон', 39, 'world@gmail.com', 'Украина, Киев, Подольский', '89215556248', 'READERSHIP'),
       ('Тарцай Эрвин Эдмундович', 13, 'tarsway@mail.ru', 'Венгрия, Будапешт, Чепель', '89214563211', 'READERSHIP'),
       ('Лехвеслайхо Дональд', 63, 'lis@gmail.com', 'США, Алабама, Бирмингем', '89211015601', 'READERSHIP'),
       ('Дональд Кнут', 52, 'knuth@gmail.com', 'США, Кентукки, Луисвилл', '89214652130', 'MENTOR'),
       ('Джон Вирт', 54, 'virtualBox@mail.com', 'Мексика, Дуранго, Дуранго', '89214756523', 'VIP');

CREATE TABLE book
(
    id         INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    person_id  INT REFERENCES person (id),
    title      VARCHAR(128) NOT NULL UNIQUE CHECK (length(title) > 2 AND length(title) < 30),
    author     VARCHAR(128) NOT NULL,
    year       INT          NOT NULL CHECK (year > 0),
    vendorCode INT          NOT NULL UNIQUE CHECK (char_length(vendorCode::text) = 6)
);

INSERT INTO book (person_id, title, author, year, vendorCode)
VALUES (1, 'Spring in Action', 'Craig Wallace', 2018, 123456),
       (1, 'Java Concurrency in Practise', 'Brian Getz', 2006, 654321),
       (2, 'Groovy in Action', 'Dierk Konig', 2015, 789456),
       (2, 'Grokking Machine Learning', 'Luis G. Serrano', 2021, 456187),
       (3, 'Java Testing with Spock', 'Luke Daley', 2016, 154783),
       (4, 'Flutter in Action', 'Eric Windmill', 2020, 456721),
       (5, 'JUnit Recipes', 'Scott Stirling', 2004, 125748),
       (6, 'RxJava for Android Developers', 'Timo Tuominen', 2019, 452357),
       (6, 'RabbitMQ in Depth', 'Gavin M. Roy', 2017, 451328),
       (7, 'The Joy of Kotlin', 'Pierre-Yves Saumont', 2019, 527961),
       (7, 'Apache Pulsar in Action', 'David Kjerrumgaard', 2021, 145255),
       (8, 'Microservices Security', 'Nuwan Dias', 2020, 111234),
       (null, 'R in Action', 'Robert I. Kabacoff', 2022, 222368),
       (null, 'Spring Microservices', 'John Carnell', 2021, 124666),
       (10, 'Testing JavaScript', 'Lucas da Costa', 2021, 233651),
       (null, 'Software Telemetry', 'Jamie Riedesel', 2021, 144785);