package com.room414.hospital.contexts;

import com.google.common.collect.ImmutableMap;
import com.room414.hospital.services.*;
import com.room414.hospital.services.impl.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Locale;
import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
class ServicesContext {

    @Getter(lazy = true)
    private final DoctorService doctorService = new DoctorServiceImpl();

    @Getter(lazy = true)
    private final DutyService dutyService = new DutyServiceImpl();

    @Getter(lazy = true)
    private final LocaleService localeService = new LocaleServiceImpl();

    @Getter(lazy = true)
    private final PatientService patientService = new PatientServiceImpl();

    @Getter(lazy = true)
    private final UserService userService = new UserServiceImpl();

    @Getter(lazy = true)
    private final Map<String, Locale> supportedLocales = loadSupportedLocales();

    @Getter
    private final Locale defaultLocale = Locale.US;

    private Map<String, Locale> loadSupportedLocales() {
        return ImmutableMap.<String, Locale>builder()
                .put("EN", Locale.US)
                .build();
    }
}
