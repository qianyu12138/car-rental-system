package cn.yd.carrentalsystem.service.impl;

import cn.yd.carrentalsystem.mapper.CarMapper;
import cn.yd.carrentalsystem.mapper.LeaseMapper;
import cn.yd.carrentalsystem.po.*;
import cn.yd.carrentalsystem.service.LeaseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.yd.carrentalsystem.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class LeaseServiceImpl implements LeaseService {

    @Value("${Host}")
    private String host;
    @Autowired(required = false)
    private LeaseMapper leaseMapper;
    @Autowired(required = false)
    private CarMapper carMapper;
    @Override
    public PageBean<LeaseQueryVo> findLeaseList(int state,int pc,int ps) {
        PageBean<LeaseQueryVo> pageBean=new PageBean<LeaseQueryVo>();
        List<LeaseQueryVo> leaseQueryVos=new ArrayList<>();
        PageHelper.startPage(pc,ps);
        LeaseExample example=new LeaseExample();
        example.setOrderByClause("lid desc");
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

        pageBean.setResultList(leaseQueryVos);
        PageInfo<LeaseQueryVo> info=new PageInfo<LeaseQueryVo>(leaseQueryVos);
        pageBean.setPageInfo(info);
        int count=leaseMapper.countByExample(example);
        pageBean.getPageInfo().setTotal(count);
        pageBean.getPageInfo().setPages(((count-1)/ps)+1);
        pageBean.getPageInfo().setPageNum(pc);
         int[] nums=new int[pageBean.getPageInfo().getPages()];
         for (int i=0;i<nums.length;i++)
         {
             nums[i]=i+1;
         }
         pageBean.getPageInfo().setNavigatepageNums(nums);
        pageBean.setUrl(""+state);
        return  pageBean;
    }

    @Override
    public void addLease(Lease lease) {
        Long dateInterval = lease.getReturntime().getTime()-lease.getReceivetime().getTime();
        double day = Math.ceil(dateInterval / (24 * 60 * 60 * 1000));
        Car car = carMapper.selectByPrimaryKey(lease.getCid());
        BigDecimal totalPrice = new BigDecimal(day).multiply(car.getPrice());
        lease.setTotalprice(totalPrice);
        leaseMapper.insert(lease);
    }

    @Override
    public Lease findLeaseByLid(Integer lid) {
        Lease lease = leaseMapper.selectByPrimaryKey(lid);
        return lease;
    }

    @Override
    public LeaseCustom findLeaseCustomByLid(Integer lid) {
        Lease lease = leaseMapper.selectByPrimaryKey(lid);
        Car car = carMapper.selectByPrimaryKey(lease.getCid());
        LeaseCustom leaseCustom = new LeaseCustom();
        CommonUtils.BeantoBean(lease, leaseCustom);
        leaseCustom.setCar(car);
        return leaseCustom;
    }
}
