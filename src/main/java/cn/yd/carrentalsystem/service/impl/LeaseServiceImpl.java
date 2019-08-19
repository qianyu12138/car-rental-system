package cn.yd.carrentalsystem.service.impl;

import cn.yd.carrentalsystem.mapper.CarMapper;
import cn.yd.carrentalsystem.mapper.LeaseMapper;
import cn.yd.carrentalsystem.po.*;
import cn.yd.carrentalsystem.service.LeaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LeaseServiceImpl implements LeaseService {

    @Autowired
   private   LeaseMapper leaseMapper;
    @Autowired
    private CarMapper carMapper;
    @Override
    public List<LeaseQueryVo> findLeaseList(int state) {
        List<LeaseQueryVo> leaseQueryVos=new ArrayList<>();
        LeaseExample example=new LeaseExample();
        LeaseExample.Criteria criteria=example.createCriteria();
        criteria.andStateEqualTo(state);
        List<Lease>leases=leaseMapper.selectByExample(example);
        for (Lease lease:leases)
        {
         LeaseQueryVo leaseQueryVo=new LeaseQueryVo();
         leaseQueryVo.setLeaseCustom((LeaseCustom) lease);
         leaseQueryVo.setCar(carMapper.selectByPrimaryKey(lease.getCid()));
         leaseQueryVos.add(leaseQueryVo);
        }

        return  leaseQueryVos;
    }
}
