package com.room414.hospital.domain.entities;

import com.room414.hospital.domain.Identifiable;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

@Data
public class Doctor implements Identifiable<String>, Serializable {
    private static final long serialVersionUID = -1922082435646778044L;

    private ApplicationUser applicationUser;
    private String firstName;
    private String lastName;
    private Secession secession;

    @Override
    public String getId() {
        return applicationUser != null ? applicationUser.getUsername() : StringUtils.EMPTY;
    }
}
