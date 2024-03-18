package com.ilmsg.auth01.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ilmsg.auth01.model.MyUser;

public interface MyUserRepository extends JpaRepository<MyUser, Long> {
    Optional<MyUser> findByUsername(String username);
}
