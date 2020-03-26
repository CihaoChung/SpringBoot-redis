package xyz.wadewhy.springboot_redis01.service;



import xyz.wadewhy.springboot_redis01.pojo.User;

import java.util.List;

public interface UserService {
    User save(User user);

    User findById(String id);

    void delete(User user);

    List<User> findAll();
}
