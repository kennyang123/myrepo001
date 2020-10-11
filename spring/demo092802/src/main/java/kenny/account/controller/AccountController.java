package kenny.account.controller;

import kenny.account.domain.Account;
import kenny.account.domain.User;
import kenny.account.domain.User02;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.resource.HttpResource;

import java.util.Date;

/**
 * @author 杨小平
 * @date 2020/9/29 6:03
 * @description TODO
 */
@Controller("accountController")
@RequestMapping("/account")
public class AccountController {
    @RequestMapping("/saveAccount")
    public String saveAccount(Account account){
        System.out.println("saveAccount:"+account);
        return "success";
    }
    @RequestMapping("/findAccountById01")
    public String findAccountById01(int id){
        System.out.println("findAccountById01:"+id);
        return "success";
    }
    @RequestMapping(value = "/findAccountById02",headers={"Accept-Language=zh-CN,zh;q=0.9"})
    public String findAccountById02(int id){
        System.out.println("findAccountById02:"+id);
        return "success";
    }
    @RequestMapping("/saveAccount02")
    public String saveAccount(User user){
        System.out.println("saveAccount02:"+user);
        return "success";
    }
    @RequestMapping(value = "/findAccountById03")
    public String saveAccount(User02 user){
        System.out.println("findAccountById03:"+user);
        return "success";
    }
/*    @RequestMapping("/getAccount")
    public ModelAndView getAccount(Account account){
        ModelAndView mv = new ModelAndView();
        mv.addObject("name",account.getName());
        mv.addObject("money",account.getMoney());
        mv.setViewName("accountInfo");
        return mv;
    }*/
}