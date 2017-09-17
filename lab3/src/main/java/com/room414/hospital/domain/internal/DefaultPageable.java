package com.room414.hospital.domain.internal;

import com.room414.hospital.domain.Pageable;
import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;

@Data(staticConstructor = "of")
public class DefaultPageable implements Pageable, Serializable {
    private static final long serialVersionUID = 3274327579533485420L;

    @NonNull
    private int limit;

    @NonNull
    private int page;

    private int entityCount;

    @Override
    public int getPageCount() {
        return Math.round((float) entityCount / limit);
    }

    @Override
    public int getOffset() {
        return (page - 1) * limit;
    }
}