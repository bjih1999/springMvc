package me.jihyun.springMVC.Controllers;

import me.jihyun.springMVC.Models.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    /*
    HttpMessageConverters
        HTTP 요청 본문을 객체로 변경하거나, 객체를 HTTP 응답 본문으로 변경할 때 사용.
        ex) {"username":"jihyun", "password":"123"} <-> User
            - @RequestBody
            - @ResponseBody

        ps. @RestController를 사용하는 경우 함수 헤더의 @ResponseBody 생략 가능
            @Contoller를 사용할 때, @RepsonseBody를 사용하지 않으면, return 값의 view를 찾으려고 시도함(View Resolver)
    */

    @PostMapping("/user/create")
    public /*@ResponseBody*/ User Create(@RequestBody User user) {
        return user;
    }

}
