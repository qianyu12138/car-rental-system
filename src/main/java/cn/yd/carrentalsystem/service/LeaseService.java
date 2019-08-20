package cn.yd.carrentalsystem.service;

import cn.yd.carrentalsystem.po.Lease;
import cn.yd.carrentalsystem.po.LeaseQueryVo;
import cn.yd.carrentalsystem.po.PageBean;

import java.util.List;

public interface LeaseService {
    PageBean<LeaseQueryVo> findLeaseList(int state,int pc,int ps);

    void addLease(Lease lease);
}
