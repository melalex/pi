package com.room414.hospital.commands.iternal;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Views {
    private static final String VIEWS_LOCATION = "/WEB-INF/views/";

    public static final String ERROR = VIEWS_LOCATION + "errors/internalServerError.jsp";
    public static final String NOT_FOUND = VIEWS_LOCATION + "errors/notFound.jsp";

    public static final String SIGN_IN = VIEWS_LOCATION + "signIn.jsp";
    public static final String SIGN_UP = VIEWS_LOCATION + "signUp.jsp";

    public static final String DOCTORS_LIST = VIEWS_LOCATION + "";
    public static final String DUTIES_LIST = VIEWS_LOCATION + "";
    public static final String PATIENTS_LIST = VIEWS_LOCATION + "";

    public static final String DOCTOR = VIEWS_LOCATION + "";
    public static final String DUTY = VIEWS_LOCATION + "";
    public static final String PATIENT = VIEWS_LOCATION + "";

    public static final String HOME = PATIENTS_LIST;
}
