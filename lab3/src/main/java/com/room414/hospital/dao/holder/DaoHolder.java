package com.room414.hospital.dao.holder;

public class DaoHolder {
    private static DaoHolder ourInstance = new DaoHolder();

    public static DaoHolder getInstance() {
        return ourInstance;
    }

    private DaoHolder() {
    }
}
