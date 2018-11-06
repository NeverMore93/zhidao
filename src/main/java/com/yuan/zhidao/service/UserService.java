package com.yuan.zhidao.service;

import com.yuan.zhidao.entity.User;
import org.springframework.security.provisioning.UserDetailsManager;

public interface UserService extends UserDetailsManager {

    public User addUser(User user);
}
