package com.room414.hospital.commands.iternal;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Routes {
    private static final String DISPATCHER_SERVLET_MAPPING = "/site";

    public static final String SIGN_IN = DISPATCHER_SERVLET_MAPPING + "/login";
    public static final String SIGN_UP = DISPATCHER_SERVLET_MAPPING + "/join";
    public static final String LOGOUT = DISPATCHER_SERVLET_MAPPING + "/logout";

    public static final String DOCTORS_LIST = DISPATCHER_SERVLET_MAPPING + "/doctors";
    public static final String DUTIES_LIST = DISPATCHER_SERVLET_MAPPING + "/duties";
    public static final String PATIENTS_LIST = DISPATCHER_SERVLET_MAPPING + "/patients";

    public static final String DOCTOR = DISPATCHER_SERVLET_MAPPING + "/doctor";
    public static final String DUTY = DISPATCHER_SERVLET_MAPPING + "/duty";
    public static final String PATIENT = DISPATCHER_SERVLET_MAPPING + "/patient";

    public static final String CREATE_DUTY = DISPATCHER_SERVLET_MAPPING + "/duty/create";
    public static final String CREATE_PATIENT = DISPATCHER_SERVLET_MAPPING + "/patient/create";

    public static final String HOME = PATIENTS_LIST;
}