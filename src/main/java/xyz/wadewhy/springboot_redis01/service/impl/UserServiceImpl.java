package xyz.wadewhy.springboot_redis01.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.wadewhy.springboot_redis01.dao.UserDao;
import xyz.wadewhy.springboot_redis01.pojo.User;
import xyz.wadewhy.springboot_redis01.service.UserService;

import java.util.List;

/*/**
 * @Author 钟子豪
 * @Date 2020/3/26
 * @description 
 No such property: code for class: Script1
 * @Return 
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public User save(User user) {
        return userDao.save(user);
    }

    @Override
    public User findById(String id) {
        return userDao.findById(id);
    }

    public void delete(User user) {
        userDao.delete(user);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
}
