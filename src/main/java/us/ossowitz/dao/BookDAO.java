package us.ossowitz.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import us.ossowitz.models.book.Book;
import us.ossowitz.models.person.Person;

import java.util.List;
import java.util.Optional;

@Component
public class BookDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> index() {
        return jdbcTemplate.query("""
                        SELECT *
                        FROM book
                        """,
                new BeanPropertyRowMapper<>(Book.class));
    }

    public Optional<Book> show(String title) {
        return jdbcTemplate.query("""
                                SELECT *
                                FROM book
                                WHERE title=?
                                """,
                        new Object[]{title},
                        new BeanPropertyRowMapper<>(Book.class))
                .stream()
                .findAny();
    }

    public Optional<Book> show(Integer vendorCode) {
        return jdbcTemplate.query("""
                                SELECT *
                                FROM book
                                WHERE vendorcode=?
                                """,
                new Object[]{vendorCode},
                new BeanPropertyRowMapper<>(Book.class))
                .stream().findAny();
    }

    public Book show(int id) {
        return jdbcTemplate.query("""
                                SELECT *
                                FROM book
                                WHERE id=?
                                """,
                        new Object[]{id},
                        new BeanPropertyRowMapper<>(Book.class))
                .stream()
                .findAny()
                .orElse(null);
    }

    // JOIN'им таблицы Book и Person и получаем человека, которому принадлежит книга с указанным id
//    public Optional<Person> getBookOwner(int id) {
//        return
//    }

    public void save(Book book) {
        jdbcTemplate.update("""
                        INSERT INTO book (title, author, year, vendorcode) 
                        VALUES (?,?,?,?)
                        """,
                book.getTitle(), book.getAuthor(),
                book.getYear(), book.getVendorCode());
    }

    public void update(int id, Book updatedBook) {
        jdbcTemplate.update("""
                        UPDATE book
                        SET title=?, author=?, year=?, vendorcode=?
                        WHERE id=?
                        """,
                updatedBook.getTitle(), updatedBook.getAuthor(),
                updatedBook.getYear(), updatedBook.getVendorCode(),
                id
        );
    }

    public void delete(int id) {
        jdbcTemplate.update("""
                DELETE FROM book
                WHERE id=?
                """, id);
    }
}