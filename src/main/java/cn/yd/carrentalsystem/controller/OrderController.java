package cn.yd.carrentalsystem.controller;

import cn.yd.carrentalsystem.po.LeaseQueryVo;
import cn.yd.carrentalsystem.po.PageBean;
import cn.yd.carrentalsystem.service.LeaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private LeaseService leaseService;
    @Autowired
    private CarService carService;
    /**
     *
     *查询订单
     */

    @RequestMapping("/order/findOrderList/{state}")
    public String findOrderList(HttpServletRequest request, @PathVariable("state") int state, @RequestParam(value = "pc",required=true,defaultValue ="1") Integer pc)
    {
        Integer ps=4;
        PageBean<LeaseQueryVo> pageBean=leaseService.findLeaseList(state,pc,ps);
        request.setAttribute("pageBean",pageBean);
        return    "user/order";
    }

    @RequestMapping("/order/toOrderPreview")
    public String toOrderPreview(Integer cid, Model model){
        //用户状态校验
        CarCustom carCustom = carService.getCarByCid(cid);
        model.addAttribute("carCustom", carCustom);
        return "customer/orderPreview";
    }

    @RequestMapping("/order/makeLease")
    public String makeLease(Integer cid, String receiveaddress, String returnaddress, String receivetime,
                            String returntime, String contactphone, HttpSession session) throws ParseException {
        Lease lease = new Lease();
        lease.setCid(cid);
        lease.setCreatetime(new Date());
        lease.setUid(((User)session.getAttribute("user")).getUid());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        lease.setReceivetime(format.parse(receivetime));
        lease.setReturntime(format.parse(returntime));
        lease.setReceiveaddress(receiveaddress);
        lease.setReturnaddress(returnaddress);
        lease.setState(1);
        lease.setContactphone(contactphone);

        leaseService.addLease(lease);

        return "redirect:/order/findOrderList/0";
    }
}
