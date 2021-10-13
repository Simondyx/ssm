package com.dyx.service;

import com.dyx.domain.User;

import java.util.List;

public interface UserService {

    /**
     * 查询所有联系人信息
     * @return
     */
    public List<User> findAll();
    public User login(User user);

    /**
     * 保存新增 user
     * @param user
     */
    public void addUser(User user);

    /**
     * 删除选中 user
     * @param id
     */
    public void deleteUser(int id);

    /**
     * 根据id 查询 返回对应 user
     * @param id
     * @return
     */
    public User findUserById(int id);

    /**
     * 更新 User
     * @param user
     */
    public void updateUser(User user);
}
