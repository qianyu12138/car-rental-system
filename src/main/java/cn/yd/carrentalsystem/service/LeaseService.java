package cn.yd.carrentalsystem.service;

import cn.yd.carrentalsystem.po.Lease;
import cn.yd.carrentalsystem.po.LeaseQueryVo;

import java.util.List;

public interface LeaseService {
    List<LeaseQueryVo> findLeaseList(int state);

    void addLease(Lease lease);
}
