package us.ossowitz.springcourse.dao;

import org.springframework.stereotype.Component;
import us.ossowitz.springcourse.models.Music;

import java.util.ArrayList;
import java.util.List;

@Component("musicDAO")
public class MusicDAO {
    private List<Music> musicList;
    private static int PRIMARY_KEY;

    {
        musicList = new ArrayList<>();

        musicList.add(new Music(++PRIMARY_KEY, "classicalMusic", 100, "76myxomor76@gmail.com"));
        musicList.add(new Music(++PRIMARY_KEY, "rockMusic", 200, "looper@mail.ru"));
        musicList.add(new Music(++PRIMARY_KEY, "rapMusic", 300, "kaler@yandex.ru"));
    }

    public List<Music> index() {
        return musicList;
    }

    public Music show(int id) {
        return musicList.stream().filter(track -> id == track.getId()).findAny().orElse(null);
    }

}
