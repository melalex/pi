package com.room414.hospital.filters;

import com.room414.hospital.contexts.ApplicationContext;
import com.room414.hospital.services.LocaleService;
import com.room414.hospital.utils.SessionUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Locale;

public class LocaleFilter implements Filter {
    private LocaleService localeService = ApplicationContext.getInstance().getLocaleService();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;

        if (req.getParameter(SessionUtil.LANG) != null) {
            replaceUserLocale(req);
        }

        if (req.getSession().getAttribute(SessionUtil.LOCALE) == null) {
            setUserLocale(req);
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }

    private void replaceUserLocale(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String langParameter = request.getParameter(SessionUtil.LANG);
        Locale locale = localeService.getLocaleOrDefault(langParameter);

        session.setAttribute(SessionUtil.LOCALE, locale);
    }

    private void setUserLocale(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Locale locale = localeService.getDefault();

        session.setAttribute(SessionUtil.LOCALE, locale);
    }
}