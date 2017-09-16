package com.room414.hospital.domain.entities;

import com.room414.hospital.domain.Identifiable;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
public class Doctor implements Identifiable<String> {
    private ApplicationUser applicationUser;
    private String firstName;
    private String lastName;
    private Secession secession;

    @Override
    public String getId() {
        return applicationUser != null ? applicationUser.getUsername() : StringUtils.EMPTY;
    }
}
