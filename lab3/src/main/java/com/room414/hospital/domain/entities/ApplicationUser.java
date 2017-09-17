package com.room414.hospital.domain.entities;

import com.room414.hospital.domain.Identifiable;
import lombok.Data;

import java.io.Serializable;

@Data
public class ApplicationUser implements Identifiable<String>, Serializable {
    private static final long serialVersionUID = 4587153584639023991L;

    private String username;
    private String password;

    @Override
    public String getId() {
        return username;
    }
}
