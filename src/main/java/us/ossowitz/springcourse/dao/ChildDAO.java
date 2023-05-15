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
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Children> index() {
        List<Children> childList = new ArrayList<>();

        String sql = """
                SELECT *
                FROM children.children.child
                """;
        try {
            var preparedStatement = connection.prepareStatement(sql);
            var resultSet = preparedStatement.executeQuery();

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
}
