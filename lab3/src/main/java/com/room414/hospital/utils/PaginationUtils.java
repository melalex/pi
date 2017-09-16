package com.room414.hospital.utils;

import com.room414.hospital.domain.Pageable;
import com.room414.hospital.domain.internal.DefaultPageable;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PaginationUtils {

    public Pageable withCount(Pageable source, int count) {
        DefaultPageable pageable = DefaultPageable.of(source.getLimit(), source.getOffset());
        pageable.setEntityCount(count);

        return pageable;
    }
}
