package cn.yd.carrentalsystem.controller;

import cn.yd.carrentalsystem.po.Kind;
import cn.yd.carrentalsystem.po.QueryVo;
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

    @RequestMapping("/conditionSubmit")
    public String conditionSubmit(HttpServletRequest request, String deliveryAddress, String pickUpAddress, String startTime, String endTime)
    {
        request.getSession().setAttribute("deliveryAddress",deliveryAddress);
        request.getSession().setAttribute("pickUpAddress",pickUpAddress);
        request.getSession().setAttribute("startTime",startTime);
        request.getSession().setAttribute("endTime",endTime);

        return "redirect:/toCarList";
    }

    @RequestMapping("/toCarList")
    public String toCarList(HttpSession session, Model model){
        String startAddress = (String) session.getAttribute("deliveryAddress");
        String endAddress = (String) session.getAttribute("pickUpAddress");

        Integer kindIdChoosed = (Integer) session.getAttribute("kindIdChoosed");
        String keyWord = (String) session.getAttribute("keyword");
        Integer maxPrice = (Integer) session.getAttribute("maxPrice");
        Integer minPrice = (Integer) session.getAttribute("minPrice");

        List<Kind> kinds = kindService.getAllKinds();

        QueryVo vo = new QueryVo(startAddress,endAddress,kindIdChoosed,keyWord,maxPrice,minPrice);
        model.addAttribute("queryVo", vo);
        model.addAttribute("kinds", kinds);
        System.out.println(vo);
        return "customer/carList";
    }

}
