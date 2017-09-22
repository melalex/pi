package com.room414.hospital.commands.iternal;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Views {
    private static final String VIEWS_LOCATION = "/WEB-INF/views/";

    public static final String SIGN_IN = VIEWS_LOCATION + "signIn.jsp";
    public static final String SIGN_UP = VIEWS_LOCATION + "signUp.jsp";

    public static final String DOCTORS_LIST = VIEWS_LOCATION + "doctorsList.jsp";
    public static final String DUTIES_LIST = VIEWS_LOCATION + "dutiesList.jsp";
    public static final String PATIENTS_LIST = VIEWS_LOCATION + "patientsList.jsp";

    public static final String DOCTOR = VIEWS_LOCATION + "doctor.jsp";
    public static final String DUTY = VIEWS_LOCATION + "duty.jsp";
    public static final String PATIENT = VIEWS_LOCATION + "patient.jsp";

    public static final String HOME = PATIENTS_LIST;
}
