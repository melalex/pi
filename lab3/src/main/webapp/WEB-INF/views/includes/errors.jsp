<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<fmt:setLocale value='${sessionScope.locale}' />
<fmt:setBundle basename="i18n.messages"/>

<c:forEach var="errorMessage" items="${requestScope.errors}">
    <div class="alert alert-danger" role="alert">
        <strong><fmt:message key="views.error"/></strong> <fmt:message key="${errorMessage}"/>
    </div>
</c:forEach>
