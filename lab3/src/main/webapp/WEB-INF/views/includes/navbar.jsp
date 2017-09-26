<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<fmt:setLocale value='${sessionScope.locale}'/>
<fmt:setBundle basename="i18n.messages"/>

<nav class="navbar navbar-toggleable-sm navbar-inverse bg-inverse">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/site/patients">Hospital</a>

    <ul class="nav navbar-nav mr-auto">
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/site/patients">
                <fmt:message key="views.navbar.link.patients"/>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/site/doctors">
                <fmt:message key="views.navbar.link.doctors"/>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/site/duties">
                <fmt:message key="views.navbar.link.duties"/>
            </a>
        </li>
    </ul>

    <ul>
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/site/logout">
                <fmt:message key="views.navbar.link.logout"/>
            </a>
        </li>
    </ul>
</nav>