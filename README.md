# Техническая задача:

- [x] Перевести местную библиотеку на цифровой учёт книг.
- [x] Предоставить переписанную версию проекта с использованием Hibernate и Spring Data JPA
- [ ] Переписать файл README.md

## Перенос местной библиотеки на цифровой учёт книг.

### Вам необходимо реализовать веб-приложение, в котором библиотекари должны иметь возможность регистрировать читателей, выдавать им книги и освобождать книги (после того, как читатель возвращает книгу обратно в библиотеку).

## Сущности:

1. **Человек** (поля: ФИО (UNIQUE), год рождения, уникальный адрес электронной почты, домашний
   адрес (Страна, город, район), мобильный номер телефона, привилегия).
2. **Книга** (поля: название, автор, год, код издательства).

Отношение между сущностями: **Один ко многим**. <br/>
У человека может быть множество книг. Книга может принадлежать только одному человеку.

В БД должно быть две таблицы: *Person* и *Book*. Для всех таблиц настройте автоматическую генерацию *id*.

## Необходимый функционал:

1. Страницы добавления, изменения и удаления человека.
2. Страницы добавления, изменения и удаления книги.
3. Страница со списком всех людей (люди кликабельные - при клике осуществляется переход на страницу человека).
4. Страница со списком всех книг (книги кликабельные - при клике осуществляется переход на страницу книги).
5. Страница человека, на котором показаны значения его полей и список книг, которые он взял. Если человек не взял ни
   одной книги, вместо списка должен быть текст «Человек пока не взял ни одной книги».
6. Страница книги, на которой показаны значения полей этой книги и имя человека, который взял эту книгу. Если эта книга
   не была не взята никем, должен быть текст «Эта книга свободна».
7. На странице книги, если книга взята человеком, рядом с его именем должна быть кнопка «Освободить книгу». Эта кнопка
   нажимается библиотекарем тогда, когда читатель возвращает эту книгу обратное в библиотеку. После нажатия на эту
   кнопку, книга снова становится свободна и пропадает из списка книг человека.
8. На странице книги, если книга свободна, должен быть выпадающий список. со всеми людьми и кнопка «Назначить книгу».
   Эта кнопка нажимается библиотекарем тогда, когда читатель хочет забрать эту книгу домой. После нажатия на эту кнопку,
   книга должна начать принадлежать выбранному человеку и должна появиться в его списке книг.
9. Все поля должны валидироваться.
