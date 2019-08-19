package cn.yd.carrentalsystem.controller;

import cn.yd.carrentalsystem.po.LeaseQueryVo;
import cn.yd.carrentalsystem.service.LeaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private LeaseService leaseService;

    /**
     *
     *查询订单
     */

    @RequestMapping("/order/findOrderList/{state}")
    public String findOrderList(HttpServletRequest request, @PathVariable("state") int state)
    {
        List<LeaseQueryVo> leases=leaseService.findLeaseList(state);
        request.setAttribute("leases",leases);
        return    "user/order";
    }
}
