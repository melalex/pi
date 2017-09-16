package com.room414.hospital.dao;

import com.room414.hospital.domain.entities.ApplicationUser;

import java.util.Optional;

public interface ApplicationUserDao {

    void create(ApplicationUser applicationUser);

    Optional<ApplicationUser> findByUsernameAndPassword(String username, String password);
}
