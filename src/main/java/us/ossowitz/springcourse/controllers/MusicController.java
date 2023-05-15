package us.ossowitz.springcourse.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("track", musicDAO.show(id));
        return "music/show";
    }

    @GetMapping("/new")
    public String newTrack(@ModelAttribute("track") Music track) {
        return "music/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("track") @Valid Music track,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "music/new";
        }

        musicDAO.save(track);
        return "redirect:/music";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("track", musicDAO.show(id));
        return "music/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("track") @Valid Music track, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) {
            return "music/edit";
        }

        musicDAO.update(id, track);
        return "redirect:/music";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        musicDAO.delete(id);
        return "redirect:/music";
    }
}
