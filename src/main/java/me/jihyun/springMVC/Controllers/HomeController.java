package me.jihyun.springMVC.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/index-security")
    public String index() {
        return "index";
    }

    @GetMapping("/hello-security")
    public String hello() {
        return "hello";
    }

    @GetMapping("/my-security")
    public String my() {
        return "my";
    }
}
