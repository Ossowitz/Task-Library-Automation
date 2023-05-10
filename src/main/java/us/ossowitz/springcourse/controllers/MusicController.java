package us.ossowitz.springcourse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import us.ossowitz.springcourse.dao.MusicDAO;

@Controller
@RequestMapping("/music")
public class MusicController {
    private final MusicDAO musicDAO;

    @Autowired
    public MusicController(MusicDAO musicDAO) {
        this.musicDAO = musicDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("music", musicDAO.index());
        return "music/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("track", musicDAO.show(id));
        return "music/show";
    }


}
