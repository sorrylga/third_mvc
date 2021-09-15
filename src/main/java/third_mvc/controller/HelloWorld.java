package third_mvc.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 陆
 * @Date: 2021/08/11/11:15
 * @Description:
 */
@RestController
public class HelloWorld {

    @GetMapping("/hello")
    public String hello(){
        return "hello world!";
    }
}
