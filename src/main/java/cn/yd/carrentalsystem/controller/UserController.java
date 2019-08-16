package cn.yd.carrentalsystem.controller;

import cn.yd.carrentalsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user/regist")
    public  String Regist(String phone,String password)
    {

        return "html/user/login";
    }



    @ResponseBody
    @RequestMapping("/user/getUserExist/{name}")
    public String getUserExist(@PathVariable("name") String username){
        boolean isExist = userService.getUserExist(username);

        return "{\"isExist\":"+isExist+"}";
    }
}
