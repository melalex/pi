package com.room414.hospital.dao;

import com.room414.hospital.domain.entities.User;

import java.util.Optional;

public interface UserDao {

    void create(User user);

    Optional<User> findByUsernameAndPassword(String username, String password);
}
