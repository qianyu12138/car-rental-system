package cn.yd.carrentalsystem.controller;

import cn.yd.carrentalsystem.po.User;
import cn.yd.carrentalsystem.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/regist")
    public String Regist(String phone, String password) {
        boolean isExist = userService.getUserExist(phone);
        if (!isExist && !StringUtils.isEmpty(phone) && !StringUtils.isEmpty(password)) {
            userService.regist(phone, password);
        }
        return "{\"status\":1}";
    }

    @RequestMapping("toRegist")
    public String toRegist() {
        return "regist";
    }

    @RequestMapping("/user/toLogin")
    public String toLogin() {
        return "html/user/login";
    }

    @RequestMapping("/user/login")
    public String login(HttpServletRequest request, String phone, String password) {
        User user = userService.login(phone, password);
        if (user == null) {
            request.setAttribute("er", "账号或密码错误");
            return "login";
        }
        request.getSession().setAttribute("user", user);
        return "index";
    }

    @ResponseBody
    @RequestMapping("/user/getUserExist/{name}")
    public String getUserExist(@PathVariable("name") String username) {
        boolean isExist = userService.getUserExist(username);

        return "{\"isExist\":" + isExist + "}";
    }
}
