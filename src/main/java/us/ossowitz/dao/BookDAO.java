package us.ossowitz.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import us.ossowitz.models.book.Book;

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
                        FROM library_automation.book
                        """,
                new BeanPropertyRowMapper<>(Book.class));
    }

    public Optional<Book> show(String title) {
        return jdbcTemplate.query("""
                                SELECT *
                                FROM library_automation.book
                                WHERE title=?
                                """,
                        new Object[]{title},
                        new BeanPropertyRowMapper<>(Book.class))
                .stream()
                .findAny();
    }

    public Book show(int id) {
        return jdbcTemplate.query("""
                                SELECT *
                                FROM library_automation.book
                                WHERE id=?
                                """,
                        new Object[]{id},
                        new BeanPropertyRowMapper<>(Book.class))
                .stream()
                .findAny()
                .orElse(null);
    }

    public void save(Book book) {
        jdbcTemplate.update("""
                        INSERT INTO library_automation.book (person_id, title, author, year, vendorcode) 
                        VALUES (?,?,?,?,?)
                        """,
                book.getPersonId(), book.getTitle(),
                book.getAuthor(), book.getYear(),
                book.getVendorCode());
    }

    public void update(Book updatedBook) {
        jdbcTemplate.update("""
                        UPDATE library_automation.book
                        SET person_id=?, title=?, author=?, year=?, vendorcode=?
                        """,
                updatedBook.getPersonId(), updatedBook.getTitle(),
                updatedBook.getAuthor(), updatedBook.getYear(),
                updatedBook.getVendorCode()
        );
    }

    public void delete(int id) {
        jdbcTemplate.update("""
                DELETE FROM library_automation.book
                WHERE id=?
                """, id);
    }
}