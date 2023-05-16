package us.ossowitz.springcourse.dao;

import org.springframework.stereotype.Component;
import us.ossowitz.springcourse.models.Children;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component("childDAO")
public class ChildDAO {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Children> index() {
        List<Children> childList = new ArrayList<>();

        try {
            var statement = connection.createStatement();
            var sql = """
                    SELECT *
                    FROM children.child
                    """;
            var resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Children children = new Children();

                children.setId(resultSet.getInt("id"));
                children.setName(resultSet.getString("name"));
                children.setSurname(resultSet.getString("surname"));
                children.setAge(resultSet.getInt("age"));
                children.setEmail(resultSet.getString("email"));

                childList.add(children);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return childList;
    }

    public Children show(int id) {
        Children children = null;
        var sql = """
                SELECT *
                FROM children.child
                WHERE id = ?
                """;
        try {
            var preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            var resultSet = preparedStatement.executeQuery();
            resultSet.next();

            children = new Children();

            children.setId(resultSet.getInt("id"));
            children.setName(resultSet.getString("name"));
            children.setSurname(resultSet.getString("surname"));
            children.setAge(resultSet.getInt("age"));
            children.setEmail(resultSet.getString("email"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return children;
    }

    public void save(Children children) {
        String sql = """
                INSERT INTO children.child
                VALUES (10, ?, ?, ?, ?)
                """;
        try {
            var preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, children.getName());
            preparedStatement.setString(2, children.getSurname());
            preparedStatement.setInt(3, children.getAge());
            preparedStatement.setString(4, children.getEmail());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(int id, Children updatedChildren) {
        String sql = """
                UPDATE children.child
                SET name = ?, surname = ?, age = ?, email = ?
                WHERE id = ?
                """;
        try {
            var preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, updatedChildren.getName());
            preparedStatement.setString(2, updatedChildren.getSurname());
            preparedStatement.setInt(3, updatedChildren.getAge());
            preparedStatement.setString(4, updatedChildren.getEmail());
            preparedStatement.setInt(5, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String sql = """
                DELETE 
                FROM children.child
                WHERE id = ?
                """;
        try {
            var preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
