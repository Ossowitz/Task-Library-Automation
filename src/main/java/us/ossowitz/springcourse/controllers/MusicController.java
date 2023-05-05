package us.ossowitz.springcourse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import us.ossowitz.springcourse.dao.MusicDAO;
import us.ossowitz.springcourse.models.Music;

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

    @GetMapping("/new")
    public String newMusic(@ModelAttribute("track") Music music) {
        return "music/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("track") Music music){
        musicDAO.save(music);
        return "redirect:/music";
    }
}
