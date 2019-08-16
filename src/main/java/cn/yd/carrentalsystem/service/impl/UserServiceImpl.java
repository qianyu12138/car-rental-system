package cn.yd.carrentalsystem.service.impl;

import cn.yd.carrentalsystem.mapper.UserMapper;
import cn.yd.carrentalsystem.po.User;
import cn.yd.carrentalsystem.po.UserExample;
import cn.yd.carrentalsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
