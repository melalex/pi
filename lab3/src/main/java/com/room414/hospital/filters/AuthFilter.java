package com.room414.hospital.filters;

import com.room414.hospital.commands.iternal.Routes;
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

        if (isNotUserLoggedIn(httpRequest) && isNotAuthRequest(httpRequest)) {
            log.debug("Access denied for page: {}", httpRequest.getRequestURI());

            HttpServletResponse httpResponse = ((HttpServletResponse) response);

            router.redirect(Routes.SIGN_IN, httpResponse);

            return;
        }

        log.debug("Access allowed for page: {}", httpRequest.getRequestURI());

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }

    private boolean isNotUserLoggedIn(HttpServletRequest request) {
        return request.getSession().getAttribute(SessionUtil.USER_ATTR) == null;
    }

    private boolean isNotAuthRequest(HttpServletRequest request) {
        return !Routes.SIGN_IN.equals(request.getRequestURI())
                && !Routes.SIGN_UP.equals(request.getRequestURI());
    }
}
