<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<fmt:setLocale value='${sessionScope.locale}'/>
<fmt:setBundle basename="i18n.messages"/>

<html>
<head>
    <jsp:include page="/WEB-INF/views/includes/header.jsp"/>
</head>
<body>
<jsp:include page="/WEB-INF/views/includes/navbar.jsp"/>

<div class="row">
    <div class="col-md-3 col-md-4 text-md-center">
        <h1 class="display-1">505</h1>
        <h1><fmt:message key="views.error.server"/></h1>
    </div>
</div>

<jsp:include page="/WEB-INF/views/includes/footer.jsp"/>
</body>
</html>