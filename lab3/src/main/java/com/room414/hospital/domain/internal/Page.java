package com.room414.hospital.domain.internal;

import com.room414.hospital.domain.Pageable;
import lombok.Value;
import lombok.experimental.Delegate;

import java.util.List;

@Value
public class Page<T> {

    @Delegate
    private List<T> content;

    @Delegate
    private Pageable pageable;
}
