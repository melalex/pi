<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<fmt:setLocale value='${sessionScope.locale}'/>
<fmt:setBundle basename="i18n.messages"/>

<nav class="navbar navbar-toggleable-md navbar-inverse bg-inverse">
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse"
            data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
            aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <a class="navbar-brand" href="${pageContext.request.contextPath}/site/patients">Hospital</a>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="${pageContext.request.contextPath}/site/patients"><fmt:message key="views.navbar.link.patients"/></a>
                <a class="nav-link" href="${pageContext.request.contextPath}/site/doctors"><fmt:message key="views.navbar.link.doctors"/></a>
                <a class="nav-link" href="${pageContext.request.contextPath}/site/duties"><fmt:message key="views.navbar.link.duties"/></a>
            </li>
        </ul>
    </div>
</nav>
