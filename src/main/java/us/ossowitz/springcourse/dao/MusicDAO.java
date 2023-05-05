package us.ossowitz.springcourse.dao;

import org.springframework.stereotype.Component;
import us.ossowitz.springcourse.models.Music;

import java.util.ArrayList;
import java.util.List;

@Component
public class MusicDAO {
    private List<Music> music;
    private int PRIMARY_KEY;

    {
        music = new ArrayList<>();

        music.add(new Music("classicalMusic", ++PRIMARY_KEY));
        music.add(new Music("rockMusic", ++PRIMARY_KEY));
        music.add(new Music("rapMusic", ++PRIMARY_KEY));
    }

    public List<Music> index() {
        return music;
    }

    public Music show(int id) {
        return music.stream().filter(music -> id == music.getId()).findAny().orElse(null);
    }

    public void save(Music track) {
        track.setId(++PRIMARY_KEY);
        music.add(track);
    }
}
