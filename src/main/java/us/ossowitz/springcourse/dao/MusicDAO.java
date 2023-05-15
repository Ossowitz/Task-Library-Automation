package us.ossowitz.springcourse.dao;

import org.springframework.stereotype.Component;
import us.ossowitz.springcourse.models.Music;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component("musicDAO")
public class MusicDAO {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";

    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Music> index() {
        List<Music> music = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM musicdb.music";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                Music track = new Music();

                track.setId(resultSet.getInt("id"));
                track.setTitle(resultSet.getString("title"));
                track.setVendorCode(resultSet.getInt("vendorCode"));
                track.setFeedback(resultSet.getString("feedback"));

                music.add(track);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return music;
    }

    public Music show(int id) {
        return null;
//        return musicList.stream().filter(track -> id == track.getId()).findAny().orElse(null);
    }

    public void save(Music track) {
        String SQL = """
                INSERT INTO musicdb.music
                VALUES (1, ?, ?, ?)
                """;
        try {
            var preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, track.getTitle());
            preparedStatement.setInt(2, track.getVendorCode());
            preparedStatement.setString(3, track.getFeedback());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(int id, Music track) {
        Music trackToBeUpdated = show(id);

        trackToBeUpdated.setTitle(track.getTitle());
        trackToBeUpdated.setVendorCode(track.getVendorCode());
        trackToBeUpdated.setFeedback(track.getFeedback());
    }

    public void delete(int id) {
//        musicList.removeIf(track -> id == track.getId());
    }

}
