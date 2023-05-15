package us.ossowitz.springcourse.dao;

import org.springframework.stereotype.Component;
import us.ossowitz.springcourse.models.Children;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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



        return null;
    }
}
