package us.ossowitz.springcourse.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import us.ossowitz.springcourse.models.Children;

import java.util.List;
import java.util.Optional;

@Component("childDAO")
public class ChildDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ChildDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Children> index() {
        return jdbcTemplate.query("SELECT * FROM children.child", new BeanPropertyRowMapper<>(Children.class));
    }

    public Optional<Children> show(String email) {
        return jdbcTemplate.query("SELECT * FROM children.child WHERE email=?", new Object[]{email},
                new BeanPropertyRowMapper<>(Children.class)).stream().findAny();
    }

    public Children show(int id) {
        return jdbcTemplate.query("SELECT * FROM children.child WHERE id=?", new Object[]{id},
                        new BeanPropertyRowMapper<>(Children.class))
                .stream().findAny().orElse(null);
    }

    public void save(Children children) {
        jdbcTemplate.update("INSERT INTO children.child VALUES (?, ?, ?, ?, ?)",
                children.getId(), children.getName(), children.getSurname(), children.getAge(), children.getEmail());
    }

    public void update(int id, Children updatedChildren) {
        jdbcTemplate.update("UPDATE children.child SET name=?, surname=?, age=?, email=? WHERE id=?",
                updatedChildren.getName(), updatedChildren.getSurname(), updatedChildren.getAge(), updatedChildren.getEmail());
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM children.child WHERE id = ?", id);
    }
}
