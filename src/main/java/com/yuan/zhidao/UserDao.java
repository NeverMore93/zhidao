package com.yuan.zhidao;



import com.yuan.zhidao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Component
public interface UserDao extends JpaRepository<User, Long> {

    <S extends User> Optional<User>  saveAndFlush(UserDetails userDetails);

    <S extends User> Optional<User> findUserByUsername(String username);

    <S extends User> Optional<User> findUserByUsernameOrEmail(String username, String email);
}
