package cn.yd.carrentalsystem.po;

import java.util.List;

public class CarQueryVo {
	
	private CarCustom carCustom;

	public CarCustom getCarCustom() {
		return carCustom;
	}

	public void setCarCustom(CarCustom carCustom) {
		this.carCustom = carCustom;
	}

	//接收批量商品修改信息
	private List<Car> carList;

	public List<Car> getCarList() {
		return carList;
	}

	public void setCarList(List<Car> carList) {
		this.carList = carList;
	}
	
}
