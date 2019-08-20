package cn.yd.carrentalsystem.po;

public class LeaseCustom extends Lease{
    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
