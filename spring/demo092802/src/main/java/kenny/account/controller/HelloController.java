package kenny.account.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 杨小平
 * @date 2020/9/28 17:47
 * @description TODO
 */
@Controller(value = "helloController")
public class HelloController {
    @RequestMapping("/hello")
    public String sayHello(){
        System.out.println("这是第一个页面");
        return "success";
    }

}