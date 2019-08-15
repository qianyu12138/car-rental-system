package cn.yd.carrentalsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @RequestMapping("/user/regist")
    public  String Regist(String phone,String password)
    {

        return "login";
    }

}
