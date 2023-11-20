package spring.springintroduction.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloControler {
    @GetMapping("greeting") // 8080/greeting 으로 맵핑
    public String hello(Model model) {
        model.addAttribute("data", "HEE JIN");
        return "hello";  // go to hello.html

    }
}
