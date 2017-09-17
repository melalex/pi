package com.room414.hospital.domain.internal;

import com.room414.hospital.domain.Pageable;
import lombok.Value;
import lombok.experimental.Delegate;

import java.io.Serializable;
import java.util.List;

@Value(staticConstructor = "of")
public class Page<T> implements Iterable<T>, Serializable {
    private static final long serialVersionUID = -7765383752912419829L;

    @Delegate
    private List<T> content;

    @Delegate
    private Pageable pageable;
}
