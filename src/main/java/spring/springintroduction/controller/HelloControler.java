package spring.springintroduction.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloControler {
    @GetMapping("greeting") // 8080/greeting 으로 맵핑
    public String hello(Model model) {
        model.addAttribute("data", "HEE JIN");
        return "hello";  // go to hello.html
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello2";
    }
}
