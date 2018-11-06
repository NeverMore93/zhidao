package com.yuan.zhidao.service;


import com.yuan.zhidao.dao.UserDao;
import com.yuan.zhidao.entity.User;
import com.yuan.zhidao.exceptions.UserException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
@Slf4j
public class UserServiceImpl implements UserService {

    @Resource(name = "userDao")
    private UserDao userDao;

    @Override
    public void createUser(UserDetails user) {

    }

    public User addUser(User user){
        return userDao.saveAndFlush(user).orElseThrow(()->new UserException("Create User Failure"));
    }

    @Override
    public void updateUser(UserDetails user) {

    }

    @Override
    public void deleteUser(String username) {

    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {

    }

    @Override
    public boolean userExists(String username) {
        return false;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         User user = userDao.findUserByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User:"+username+" not found!"));
         return (UserDetails)user;
    }
}
