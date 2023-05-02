package us.ossowitz.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("exit")
public class SecondController {

    @GetMapping
    public String calcPhone() {

        return "exit";
    }
}
