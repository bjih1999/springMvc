package me.jihyun.springMVC.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActuatorController {

    @GetMapping("hello-actuator")
    public String hello() {
         return "hello";
    }
}
