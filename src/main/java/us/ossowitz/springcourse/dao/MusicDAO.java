package us.ossowitz.springcourse.dao;

import org.springframework.stereotype.Component;
import us.ossowitz.springcourse.models.Music;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component("musicDAO")
public class MusicDAO {
    private static int PRIMARY_KEY;
    private List<Music> musicList;

    {
        musicList = new ArrayList<>();


        musicList.add(new Music(1, "classicalMusic", 100, "tom@gmail.com"));
        musicList.add(new Music(2, "rockMusic", 200, "bob@gmail.com"));
        musicList.add(new Music(3, "rapMusic", 300, "john@gmail.com"));
    }

//    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
//    private static final String USERNAME = "postgres";
//    private static final String PASSWORD = "postgres";
//
//    private static Connection connection;
//
//    static {
//        try {
//            Class.forName("org.postgresql.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    public List<Music> index() {
        return musicList;
//        List<Music> music = new ArrayList<>();
//
//        try {
//            Statement statement = connection.createStatement();
//            String SQL = "SELECT * FROM musicdb.music";
//            ResultSet resultSet = statement.executeQuery(SQL);
//
//            while (resultSet.next()) {
//                Music track = new Music();
//
//                track.setId(resultSet.getInt("id"));
//                track.setTitle(resultSet.getString("title"));
//                track.setVendorCode(resultSet.getInt("vendorCode"));
//                track.setFeedback(resultSet.getString("feedback"));
//
//                music.add(track);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return music;
    }

    public Music show(int id) {
        return null;
//        return musicList.stream().filter(track -> id == track.getId()).findAny().orElse(null);
    }

    public void save(Music track) {
//        try {
//            Statement statement = connection.createStatement();
//            String SQL = "INSERT INTO musicdb.music VALUES('" + track.getTitle() + "'," + track.getVendorCode()
//                         + ",'" + track.getFeedback() + "')";
//            statement.executeUpdate(SQL);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        track.setId(++PRIMARY_KEY);
        musicList.add(track);
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
