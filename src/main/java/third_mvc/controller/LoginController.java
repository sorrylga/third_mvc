package third_mvc.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 陆
 * @Date: 2021/08/13/21:08
 * @Description:
 */
@Controller
public class LoginController {

//    @RequestParam("name") String name, @RequestParam("password") String passworrd, Model model
    @RequestMapping("/user/login")
//    @ResponseBody
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password,
                        Model model,
                        HttpSession session){
        if (!StringUtils.isEmpty(email) && "123".equals(password)){
            session.setAttribute("loginEmail",email);
            session.setAttribute("loginPwd",password);
            //            使用重定向
            return "redirect:/index.html";
        }else {//登陆失败
            model.addAttribute("msg","您输入的邮箱或密码不正确！");
            return "login";
        }
//测试之前是否正常跳转
//        return "ok";
    }


}
