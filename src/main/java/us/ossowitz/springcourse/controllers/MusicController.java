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
    private MusicDAO musicDAO;

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
    public String show(Model model, @PathVariable("id") int id) {
        model.addAttribute("track", musicDAO.show(id));
        return "music/show";
    }

    @GetMapping("/new")
    public String newMusic(@ModelAttribute("track") Music track) {
        return "music/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("track") Music track) {
        musicDAO.save(track);
        return "redirect:/music";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("track", musicDAO.show(id));
        return "music/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("track") Music track, @PathVariable("id") int id) {
        musicDAO.update(id, track);
        return "redirect:/music";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        musicDAO.delete(id);
        return "redirect:/music";
    }
}
