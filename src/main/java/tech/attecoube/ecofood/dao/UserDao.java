package tech.attecoube.ecofood.dao;

import tech.attecoube.ecofood.entity.User;

public interface UserDao {

    User findByUserName(String userName);
    
    void save(User user);
    
}
