package cn.yd.carrentalsystem.service.impl;

import cn.yd.carrentalsystem.mapper.CarMapper;
import cn.yd.carrentalsystem.mapper.LeaseMapper;
import cn.yd.carrentalsystem.po.*;
import cn.yd.carrentalsystem.service.LeaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LeaseServiceImpl implements LeaseService {

    @Value("${Host}")
    private String host;
    @Autowired
   private   LeaseMapper leaseMapper;
    @Autowired
    private CarMapper carMapper;
    @Override
    public List<LeaseQueryVo> findLeaseList(int state) {
        List<LeaseQueryVo> leaseQueryVos=new ArrayList<>();
        LeaseExample example=new LeaseExample();
        LeaseExample.Criteria criteria=example.createCriteria();
        if(state!=0) {
            criteria.andStateEqualTo(state);
        }
        List<Lease>leases=leaseMapper.selectByExample(example);
        for (Lease lease:leases)
        {
         LeaseQueryVo leaseQueryVo=new LeaseQueryVo();

         leaseQueryVo.setLease(lease);
         Car car=carMapper.selectByPrimaryKey(lease.getCid());
         leaseQueryVo.setCar(car);
         leaseQueryVo.setCarfirstimg(host+car.getImgs().split(";")[0]);
         leaseQueryVos.add(leaseQueryVo);
        }

        return  leaseQueryVos;
    }
}
