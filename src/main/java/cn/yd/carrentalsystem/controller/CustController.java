package cn.yd.carrentalsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CustController {

    @RequestMapping("/customer/toCarList")
    public String toCarList(HttpServletRequest request, String deliveryAddress, String pickUpAddress, String startTime, String endTime)
    {
        request.getSession().setAttribute("deliveryAddress",deliveryAddress);
        request.getSession().setAttribute("pickUpAddress",pickUpAddress);
        request.getSession().setAttribute("startTime",startTime);
        request.getSession().setAttribute("endTime",endTime);

        return "customer/carList";

    }
}
