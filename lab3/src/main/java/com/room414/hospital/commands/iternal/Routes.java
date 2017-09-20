package com.room414.hospital.commands.iternal;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Routes {
    public static final String SIGN_IN = "/login";
    public static final String SIGN_UP = "/join";
    public static final String LOGOUT = "/logout";

    public static final String DOCTORS = "/patients";
    public static final String DUTIES = "/doctors";
    public static final String PATIENTS = "/patients";

    public static final String HOME = PATIENTS;
}
