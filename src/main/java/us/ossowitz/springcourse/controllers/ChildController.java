package us.ossowitz.springcourse.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import us.ossowitz.springcourse.dao.ChildDAO;
import us.ossowitz.springcourse.models.Children;
import us.ossowitz.springcourse.util.ChildValidator;

@Controller
@RequestMapping("/child")
public class ChildController {

    private final ChildDAO childDAO;
    private final ChildValidator childValidator;

    @Autowired()
    public ChildController(ChildDAO childDAO, ChildValidator childValidator) {
        this.childDAO = childDAO;
        this.childValidator = childValidator;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("child", childDAO.index());
        return "child/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("children", childDAO.show(id));
        return "child/show";
    }

    @GetMapping("/new")
    public String newChildren(@ModelAttribute("children") Children children) {
        return "child/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("children") @Valid Children children,
                         BindingResult bindingResult) {
        childValidator.validate(children, bindingResult);

        if (bindingResult.hasErrors())
            return "child/new";

        childDAO.save(children);
        return "redirect:/child";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("children", childDAO.show(id));
        return "child/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("children") @Valid Children children,
                         BindingResult bindingResult, @PathVariable("id") int id) {
        childValidator.validate(children, bindingResult);

        if (bindingResult.hasErrors())
            return "child/edit";

        childDAO.update(id, children);
        return "redirect:/child";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        childDAO.delete(id);
        return "redirect:/child";
    }
}
