package cn.yd.carrentalsystem.po;

public class LeaseQueryVo {
    private LeaseCustom leaseCustom;

    public LeaseCustom getLeaseCustom() {
        return leaseCustom;
    }

    public void setLeaseCustom(LeaseCustom leaseCustom) {
        this.leaseCustom = leaseCustom;
    }
    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car)
    {
        this.car = car;
    }
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
