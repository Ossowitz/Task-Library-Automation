package us.ossowitz.springcourse.dao;

import org.springframework.stereotype.Component;
import us.ossowitz.springcourse.models.Music;
import us.ossowitz.springcourse.models.implementation.ClassicalMusic;
import us.ossowitz.springcourse.models.implementation.RapMusic;

import java.util.ArrayList;
import java.util.List;

@Component("music")
public class MusicDAO {
    private List<Music> music;
    private int PRIMARY_KEY;

    {
        music = new ArrayList<>();

        music.add(new ClassicalMusic("classicalMusic", ++PRIMARY_KEY));
        music.add(new RapMusic("rockMusic", ++PRIMARY_KEY));
        music.add(new RapMusic("rapMusic", ++PRIMARY_KEY));
    }

    public List<Music> index() {
        return music;
    }

    public Music show(int id) {
        return music.stream().filter(music -> id == music.getId()).findAny().orElse(null);
    }
}
