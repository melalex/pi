package com.room414.hospital.dao.query;

@FunctionalInterface
public interface BuildCallback<T> {

    T onBuild(String sql, Object... params);
}
