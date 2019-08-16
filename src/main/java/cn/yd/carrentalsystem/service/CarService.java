package cn.yd.carrentalsystem.service;

import cn.yd.carrentalsystem.po.Car;
import cn.yd.carrentalsystem.po.QueryVo;

import java.util.List;

public interface CarService {
    List<Car> getCarListByQueryVo(QueryVo vo);
}
