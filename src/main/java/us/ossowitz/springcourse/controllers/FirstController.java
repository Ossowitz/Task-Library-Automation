package us.ossowitz.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/calculator")
    public String helloPage(@RequestParam(value = "a", required = false) int a,
                            @RequestParam(value = "b", required = false) int b,
                            @RequestParam(value = "action", required = false) String action,
                            Model model) {

        double result = switch (action) {
            case "multiplication" -> a * b;
            case "division" -> a / (double) b;
            case "subtraction" -> a + b;
            case "addition" -> a - b;
            default -> 0;
        };

        model.addAttribute("result", result);

        return "first/calculator";
    }
}
