package com.rq.service;

import com.rq.bean.User;
import com.rq.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
@Service
public class UserDaoImpl implements UserDao {

    @Autowired
    UserMapper userMapper;
    @Override
    public User Login(User user) {
        return userMapper.Login(user);
    }

    @Override
    public List<User> getUserlist(User user) throws Exception {
        return userMapper.getUserlist(user);
    }

    @Override
    public boolean RegisterUser(User user) throws Exception {
        return userMapper.RegisterUser(user);
    }

    @Override
    public List<User> selectByWhere(String name) throws Exception {
        return userMapper.selectByWhere(name);
    }

    @Override
    public User getUserByid(Integer id) throws Exception {
        return userMapper.getUserByid(id);
    }

    @Override
    public boolean updateUser(User user) throws Exception {
        return userMapper.updateUser(user);
    }

    @Override
    public boolean modifyPs(User user) throws Exception {
        return userMapper.modifyPs(user);
    }

    @Override
    public boolean deleteUserByid(Integer id) throws Exception {
        return userMapper.deleteUserByid(id);
    }

    @Override
    public boolean checkPassword(User user) throws Exception {
        return false;
    }

    @Override
    public User updatehead(User user) {
        return userMapper.updatehead(user);
    }
}