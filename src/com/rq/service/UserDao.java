package com.rq.service;

import com.rq.bean.User;

import java.util.List;

public interface UserDao {

    public User Login(User user);

    public List<User> getUserlist(User user) throws Exception;

    public boolean RegisterUser(User user) throws Exception;

    public List<User> selectByWhere(String name) throws Exception;

    public User getUserByid(Integer id) throws Exception;

    public boolean updateUser(User user) throws Exception;

    public boolean modifyPs(User user) throws Exception;

    public boolean deleteUserByid(Integer id) throws Exception;

    public boolean checkPassword(User user) throws Exception;
    public  User updatehead(User user);
}
