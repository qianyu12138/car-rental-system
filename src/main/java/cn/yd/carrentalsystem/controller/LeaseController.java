package cn.yd.carrentalsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LeaseController {

    @RequestMapping("/toOrderPreview")
    public String toOrderPreview(Integer cid, Model model){
        model.addAttribute("cid", cid);
        return "customer/orderPreview";
    }
}
