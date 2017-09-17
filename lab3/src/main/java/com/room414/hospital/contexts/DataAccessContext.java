package com.room414.hospital.contexts;

import com.room414.hospital.dao.ApplicationUserDao;
import com.room414.hospital.dao.DoctorDao;
import com.room414.hospital.dao.DutyDao;
import com.room414.hospital.dao.PatientDao;
import com.room414.hospital.dao.impl.ApplicationUserDaoImpl;
import com.room414.hospital.dao.impl.DoctorDaoImpl;
import com.room414.hospital.dao.impl.DutyDaoImpl;
import com.room414.hospital.dao.impl.PatientDaoImpl;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
class DataAccessContext {

    @Getter(lazy = true)
    private final ApplicationUserDao applicationUserDao = new ApplicationUserDaoImpl();

    @Getter(lazy = true)
    private final DoctorDao doctorDao = new DoctorDaoImpl();

    @Getter(lazy = true)
    private final DutyDao dutyDao = new DutyDaoImpl();

    @Getter(lazy = true)
    private final PatientDao patientDao = new PatientDaoImpl();
}
