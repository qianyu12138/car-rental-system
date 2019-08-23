package cn.yd.carrentalsystem.service.impl;

import cn.yd.carrentalsystem.mapper.CarMapper;
import cn.yd.carrentalsystem.mapper.KindMapper;
import cn.yd.carrentalsystem.po.*;
import cn.yd.carrentalsystem.service.CarService;
import cn.yd.carrentalsystem.utils.CommonUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Transactional
@Service
public class CarServiceImpl implements CarService {

    @Autowired(required = false)
    private CarMapper carMapper;
    @Autowired(required = false)
    private KindMapper kindMapper;

    @Override
    public List<CarCustom> getCarListByQueryVo(QueryVo vo) {
        CarExample carExample = new CarExample();
        CarExample.Criteria criteria = carExample.createCriteria();

        List<Car> cars = null;
        if(vo==null)
            cars = carMapper.selectByExample(carExample);
        else {
            if (!StringUtils.isEmpty(vo.getStartAddress()) && vo.getStartAddress() != "null")
                criteria.andStartaddressLike("%" + vo.getStartAddress() + "%");
            if (!StringUtils.isEmpty(vo.getEndAddress()) && vo.getEndAddress() != "null")
                criteria.andEndaddressLike("%" + vo.getEndAddress() + "%");
            if (vo.getKindIdChoosed() != null)
                criteria.andKidEqualTo(vo.getKindIdChoosed());
            if (!StringUtils.isEmpty(vo.getKeyWord()) && vo.getKeyWord() != "null")
                criteria.andCnameLike("%" + vo.getKeyWord() + "%");
            if (vo.getMaxPrice() != null && vo.getMinPrice() != null)
                criteria.andPriceBetween(new BigDecimal(vo.getMinPrice()), new BigDecimal(vo.getMaxPrice()));
            criteria.andStateEqualTo("1");
            cars = carMapper.selectByExample(carExample);
        }
        List<CarCustom> carCustoms = new ArrayList<>();
        for (Car car:cars
             ) {
            CarCustom carCustom = new CarCustom();
            if(car.getImgs()!=null) {
                String[] imgPathsArr = car.getImgs().split(";");
                List<String> imgPaths = Arrays.asList(imgPathsArr);
                carCustom.setImgPaths(imgPaths);
            }
            CommonUtils.BeantoBean(car, carCustom);
            carCustoms.add(carCustom);
        }

        return carCustoms;
    }

    @Override
    public CarCustom getCarByCid(Integer cid) {
        Car car = carMapper.selectByPrimaryKey(cid);
        CarCustom carCustom = new CarCustom(car);

        Kind kind = kindMapper.selectByPrimaryKey(car.getKid());
        carCustom.setKind(kind);
        return carCustom;
    }


}
