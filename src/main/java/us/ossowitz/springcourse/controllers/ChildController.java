package us.ossowitz.springcourse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import us.ossowitz.springcourse.dao.ChildDAO;

@Controller
@RequestMapping("/child")
public class ChildController {
    private ChildDAO childDAO;

    @Autowired()
    public ChildController(ChildDAO childDAO) {
        this.childDAO = childDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("child", childDAO.index());
        return "child/index";
    }
}
