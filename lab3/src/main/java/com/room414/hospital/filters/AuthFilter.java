package com.room414.hospital.filters;

import com.room414.hospital.contexts.ApplicationContext;
import com.room414.hospital.routing.Router;
import com.room414.hospital.utils.SessionUtil;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class AuthFilter implements Filter {
    private final Router router = ApplicationContext.getInstance().getRouter();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;

        if (!isUserLoggedIn(httpRequest)) {
            HttpServletResponse httpResponse = ((HttpServletResponse) response);
            router.route("/login").execute(httpRequest, httpResponse);
            log.info("Access denied for page: {}", httpRequest.getRequestURI());
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }

    private boolean isUserLoggedIn(HttpServletRequest request) {
        return request.getSession().getAttribute(SessionUtil.USER_ATTR) != null;
    }
}
