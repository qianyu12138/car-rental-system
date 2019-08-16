package cn.yd.carrentalsystem.service.impl;

import cn.yd.carrentalsystem.mapper.UserMapper;
import cn.yd.carrentalsystem.po.User;
import cn.yd.carrentalsystem.po.UserExample;
import cn.yd.carrentalsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean getUserExist(String username) {

        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andPhoneEqualTo(username);
        List<User> users = userMapper.selectByExample(userExample);
        return users.size()>0;
    }

    @Override
    public User login(String phone, String password) {
        List<User> users=new ArrayList<>();

        if (getUserExist(phone))
       {
           UserExample userExample = new UserExample();
           UserExample.Criteria criteria = userExample.createCriteria();
           criteria.andPasswordEqualTo(password);
           users=userMapper.selectByExample(userExample);

       }
        if (users.size()==0)
        {
            return null;
        }
        return users.get(0);
    }

    @Override
    public void regist(String phone, String password) {
        User user = new User();
        user.setPhone(phone);
        user.setPassword(password);
        userMapper.insert(user);
    }
}
