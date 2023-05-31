package us.ossowitz.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import us.ossowitz.models.person.Person;

import java.util.List;
import java.util.Optional;

@Component
public class PersonDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() {
        return jdbcTemplate.query("""
                        SELECT *
                        FROM library_automation.person
                        """,
                new BeanPropertyRowMapper<>(Person.class));
    }

    public Person show(int id) {
        return jdbcTemplate.query("""
                                SELECT *
                                FROM library_automation.person
                                WHERE id=?
                                """,
                        new Object[]{id},
                        new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny().orElse(null);
    }

    public Optional<Person> show(String email) {
        return jdbcTemplate.query("""
                                SELECT *
                                FROM library_automation.person
                                WHERE email=?
                                                                """,
                        new Object[]{email},
                        new BeanPropertyRowMapper<>(Person.class))
                .stream()
                .findAny();
    }

    public void save(Person person) {
        jdbcTemplate.update("""
                        INSERT INTO library_automation.person (name, age, email, address, phone_number, perk)
                        VALUES (?,?,?,?,?,?)
                        """,
                person.getName(), person.getAge(),
                person.getEmail(), person.getAddress(),
                person.getPhoneNumber(), person.getPerk().name());
    }

    public void update(int id, Person updatedPerson) {
        jdbcTemplate.update("""
                        UPDATE library_automation.person
                        SET name=?, age=?, email=?, address=?, phone_number=?, perk=?
                        WHERE id=?
                        """,
                updatedPerson.getName(), updatedPerson.getAge(),
                updatedPerson.getEmail(), updatedPerson.getAddress(),
                updatedPerson.getPhoneNumber(), updatedPerson.getPerk().name(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("""
                DELETE FROM library_automation.person
                WHERE id=?
                """, id);
    }
}
