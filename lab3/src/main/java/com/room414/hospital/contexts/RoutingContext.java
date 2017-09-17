package com.room414.hospital.contexts;

import com.room414.hospital.routing.Router;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
class RoutingContext {

    @Getter
    private Router router;
}
