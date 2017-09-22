<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <jsp:include page="/WEB-INF/views/includes/header.jsp"/>

    <title>${requestScope.model.username}</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/includes/navbar.jsp"/>
<jsp:include page="/WEB-INF/views/includes/errors.jsp"/>

<div class="container">
    <div class="row">
        <label class="col-md-3"><fmt:message key="views.domain.username"/></label>
        <label class="col-md-9">${requestScope.model.getId()}</label>
    </div>

    <div class="row">
        <label class="col-md-3"><fmt:message key="views.domain.firstName"/></label>
        <label class="col-md-9">${requestScope.model.getFirstName()}</label>
    </div>

    <div class="row">
        <label class="col-md-3"><fmt:message key="views.domain.lastName"/></label>
        <label class="col-md-9">${requestScope.model.getLastName()}</label>
    </div>

    <div class="row">
        <label class="col-md-3"><fmt:message key="views.domain.secession"/></label>
        <label class="col-md-9">${requestScope.model.getSecession()}</label>
    </div>
</div>

<jsp:include page="/WEB-INF/views/includes/footer.jsp"/>
</body>
</html>
