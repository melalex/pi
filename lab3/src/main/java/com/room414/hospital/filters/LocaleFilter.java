package com.room414.hospital.filters;

import com.room414.hospital.contexts.ApplicationContext;
import com.room414.hospital.services.LocaleService;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Locale;

public class LocaleFilter implements Filter {
    private final static String LANG = "lang";
    private final static String LOCALE = "locale";

    private LocaleService localeService = ApplicationContext.getInstance().getLocaleService();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;

        if (req.getParameter(LANG) != null) {
            replaceUserLocale(req);
        }

        if (req.getSession().getAttribute(LOCALE) == null) {
            setUserLocale(req);
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }

    private void replaceUserLocale(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String langParameter = request.getParameter(LANG);
        Locale locale = localeService.getLocaleOrDefault(langParameter);
        session.setAttribute(LOCALE, locale);
    }

    private void setUserLocale(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Locale locale = localeService.getDefault();
        session.setAttribute(LOCALE, locale);
    }
}