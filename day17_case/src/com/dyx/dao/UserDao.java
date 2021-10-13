package com.dyx.dao;

import com.dyx.domain.User;

import java.util.List;

/**
 * 用户操作的DAO
 */
public interface UserDao {

    public List<User> findAll();
    public User findUserByUsernameAndPassword(String username,String password);
    public void add(User user);
    public void deleteUser(int id);
    public User findUserById(int id);
    public void updateUser(User user);
}
