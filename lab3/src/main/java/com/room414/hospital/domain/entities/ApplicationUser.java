package com.room414.hospital.domain.entities;

import com.room414.hospital.domain.Identifiable;
import lombok.Data;

@Data
public class ApplicationUser implements Identifiable<String> {
    private String username;
    private String password;

    @Override
    public String getId() {
        return username;
    }
}
