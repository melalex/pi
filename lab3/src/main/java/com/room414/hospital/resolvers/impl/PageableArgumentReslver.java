package com.room414.hospital.resolvers.impl;

import com.room414.hospital.anotations.Resolver;
import com.room414.hospital.domain.Pageable;
import com.room414.hospital.domain.internal.DefaultPageable;
import com.room414.hospital.resolvers.ArgumentResolver;
import com.room414.hospital.utils.ResolverUtils;

import javax.servlet.http.HttpServletRequest;

@Resolver(Pageable.class)
public class PageableArgumentReslver implements ArgumentResolver<Pageable> {
    private static final String LIMIT_PARAM = "limit";
    private static final String PAGE_PARAM = "page";

    private static final int DEFAULT_LIMIT = 20;
    private static final int DEFAULT_PAGE = 1;

    @Override
    public Pageable resolve(HttpServletRequest request) {
        int limit = ResolverUtils.parseInteger(request.getParameter(LIMIT_PARAM), DEFAULT_LIMIT);
        int page = ResolverUtils.parseInteger(request.getParameter(PAGE_PARAM), DEFAULT_PAGE);

        return DefaultPageable.of(limit, page);
    }
}
