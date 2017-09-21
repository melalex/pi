package com.room414.hospital.commands.iternal;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Routes {
    public static final String SIGN_IN = "/login";
    public static final String SIGN_UP = "/join";
    public static final String LOGOUT = "/logout";

    public static final String DOCTORS_LIST = "/doctors";
    public static final String DUTIES_LIST = "/duties";
    public static final String PATIENTS_LIST = "/patients";

    public static final String DOCTOR = "/doctor";
    public static final String DUTY = "/duty";
    public static final String PATIENT = "/patient";

    public static final String CREATE_DOCTOR = "/doctor/create";
    public static final String CREATE_DUTY = "/duty/create";
    public static final String CREATE_PATIENT = "/patient/create";

    public static final String HOME = PATIENTS_LIST;
}