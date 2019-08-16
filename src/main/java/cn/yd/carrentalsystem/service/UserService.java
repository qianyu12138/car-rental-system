package cn.yd.carrentalsystem.service;

public interface UserService {
    boolean getUserExist(String username);

    void regist(String phone, String password);
}
