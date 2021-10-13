package com.dyx.service.impl;

import com.dyx.dao.UserDao;
import com.dyx.dao.impl.UserDaoImpl;
import com.dyx.domain.User;
import com.dyx.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao dao = new UserDaoImpl();
    @Override
    public List<User> findAll() {

        //调用 dao 层
        return dao.findAll();
    }

    @Override
    public User login(User user) {
        return dao.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public void addUser(User user) {
        dao.add(user);
    }

    @Override
    public void deleteUser(int id) {
        dao.deleteUser(id);
    }

    @Override
    public User findUserById(int id) {
        return dao.findUserById(id);
    }

    @Override
    public void updateUser(User user) {
        dao.updateUser(user);
    }
}
