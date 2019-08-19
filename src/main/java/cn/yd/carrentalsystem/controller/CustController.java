package cn.yd.carrentalsystem.controller;

import cn.yd.carrentalsystem.po.Car;
import cn.yd.carrentalsystem.po.Kind;
import cn.yd.carrentalsystem.po.QueryVo;
import cn.yd.carrentalsystem.service.CarService;
import cn.yd.carrentalsystem.service.KindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CustController {

    @Autowired
    private KindService kindService;
    @Autowired
    private CarService carService;


    @RequestMapping("/conditionSubmit")
    public String conditionSubmit(HttpServletRequest request, String deliveryAddress, String pickUpAddress, String startTime, String endTime)
    {
        QueryVo vo = new QueryVo();
        vo.setStartAddress(deliveryAddress);
        vo.setEndAddress(pickUpAddress);
        request.getSession().setAttribute("vo", vo);

        request.getSession().setAttribute("startTime",startTime);
        request.getSession().setAttribute("endTime",endTime);

        return "redirect:/toCarList";
    }

    @RequestMapping("/toCarList")
    public String toCarList(HttpSession session, Model model){

        QueryVo vo = (QueryVo) session.getAttribute("vo");
        System.out.println(vo);
        List<Car> cars = carService.getCarListByQueryVo(vo);

        List<Kind> kinds = kindService.getAllKinds();

        model.addAttribute("queryVo", vo);
        model.addAttribute("kinds", kinds);
        model.addAttribute("cars", cars);
        return "customer/carList";
    }

    @RequestMapping("/addCondition")
    public String addCondition(HttpSession session,QueryVo vo){
        session.setAttribute("vo", vo);
        return "redirect:/toCarList";
    }
}