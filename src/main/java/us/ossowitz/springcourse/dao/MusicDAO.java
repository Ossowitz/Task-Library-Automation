package us.ossowitz.springcourse.dao;

import org.springframework.stereotype.Component;
import us.ossowitz.springcourse.models.Music;

import java.util.ArrayList;
import java.util.List;

@Component
public class MusicDAO {
    private List<Music> musicList;
    private int PRIMARY_KEY;

    {
        musicList = new ArrayList<>();

        musicList.add(new Music(++PRIMARY_KEY, "classicalMusic"));
        musicList.add(new Music(++PRIMARY_KEY, "rockMusic"));
        musicList.add(new Music(++PRIMARY_KEY, "rapMusic"));
    }

    public List<Music> index() {
        return musicList;
    }

    public Music show(int id) {
        return musicList.stream().filter(track -> id == track.getId()).findAny().orElse(null);
    }

    public void save(Music music) {
        music.setId(++PRIMARY_KEY);
        musicList.add(music);
    }

    public void update(int id, Music musicUpdated) {
        Music musicToBeUpdated = show(id);
        musicToBeUpdated.setName(musicUpdated.getName());
    }

    public void delete(int id) {
        musicList.removeIf(track -> id == track.getId());
    }
}
