package com.room414.hospital.domain;

public interface Pageable {

    int getPageCount();

    int getEntityCount();

    int getPage();

    int getLimit();

    int getOffset();
}