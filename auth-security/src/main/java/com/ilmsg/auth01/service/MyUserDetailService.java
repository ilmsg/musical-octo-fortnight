package com.ilmsg.auth01.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ilmsg.auth01.model.MyUser;
import com.ilmsg.auth01.repository.MyUserRepository;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private MyUserRepository myUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<MyUser> foundUser = myUserRepository.findByUsername(username);
        if (foundUser.isPresent()) {
            MyUser user = foundUser.get();
            return User
                    .builder()
                    .username(user.getUsername())
                    .password(user.getPassword())
                    .roles(getRoles(user))
                    .build();
        } else {
            throw new UsernameNotFoundException(username);
        }
    }

    private String[] getRoles(MyUser user) {
        if (user.getRole() == null) {
            return new String[] { "USER" };
        }
        return user.getRole().split(",");
    }

}
