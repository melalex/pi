package com.room414.hospital.filters;

import javax.servlet.*;
import java.io.IOException;

public class CharsEncoderFilter implements Filter {
    private static final String ENCODING = "utf-8";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding(ENCODING);
        response.setCharacterEncoding(ENCODING);

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
