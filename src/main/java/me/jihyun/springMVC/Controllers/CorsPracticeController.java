package me.jihyun.springMVC.Controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
http://localhost:18080에 대해 아래의 컨트롤러 접근 허용
 */
@CrossOrigin(origins = "http://localhost:18080")
@RestController
public class CorsPracticeController {

    @GetMapping("/hello-cors")
    public String hello() {
        return "Hello";
    }
}
