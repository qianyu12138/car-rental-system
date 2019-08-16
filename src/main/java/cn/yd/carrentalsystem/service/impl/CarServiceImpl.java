package cn.yd.carrentalsystem.service.impl;

import cn.yd.carrentalsystem.mapper.CarMapper;
import cn.yd.carrentalsystem.po.Car;
import cn.yd.carrentalsystem.po.CarExample;
import cn.yd.carrentalsystem.po.QueryVo;
import cn.yd.carrentalsystem.service.CarService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Transactional
@Service
public class CarServiceImpl implements CarService {

    @Autowired(required = false)
    private CarMapper carMapper;
    @Override
    public List<Car> getCarListByQueryVo(QueryVo vo) {
        CarExample carExample = new CarExample();
        CarExample.Criteria criteria = carExample.createCriteria();
        if(!StringUtils.isEmpty(vo.getStartAddress())&&vo.getStartAddress()!="null")
            criteria.andStartaddressLike("%"+vo.getStartAddress()+"%");
        if(!StringUtils.isEmpty(vo.getEndAddress())&&vo.getEndAddress()!="null")
            criteria.andEndaddressLike("%"+vo.getEndAddress()+"%");
        if(vo.getKindIdChoosed()!=null)
            criteria.andKidEqualTo(vo.getKindIdChoosed());
        if(!StringUtils.isEmpty(vo.getKeyWord())&&vo.getKeyWord()!="null")
            criteria.andCnameLike("%"+vo.getKeyWord()+"%");
        if(vo.getMaxPrice()!=null&&vo.getMinPrice()!=null)
            criteria.andPriceBetween(new BigDecimal(vo.getMaxPrice()), new BigDecimal(vo.getMinPrice()));
        criteria.andStateEqualTo("1");
        List<Car> cars = carMapper.selectByExample(carExample);
        return cars;
    }
}
