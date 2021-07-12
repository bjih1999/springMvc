package me.jihyun.springMVC.Controllers;

import me.jihyun.springMVC.Errors.AppError;
import me.jihyun.springMVC.Exceptions.SampleException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionPracticeController {
    @GetMapping("/exception")
    public String error() {
        throw new SampleException();
    }

    /*
    해당 컨트롤러 클래스에서 예외가 발생하였을 경우
    아래의 핸들러가 처리함
     */
    @ExceptionHandler(SampleException.class)
    public @ResponseBody
    AppError sampleError(SampleException e) {
        AppError appError = new AppError();
        appError.setMessage("error.app.key");
        appError.setReason("IDK IDK IDK");

        return appError;
    }
}
