package com.room414.hospital.utils;

import com.room414.hospital.domain.entities.ApplicationUser;
import com.room414.hospital.domain.entities.Doctor;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ConversionUtil {

    public Doctor toDoctor(String username) {
        Doctor doctor = new Doctor();
        ApplicationUser user = new ApplicationUser();

        user.setUsername(username);
        doctor.setApplicationUser(user);

        return doctor;
    }
}
