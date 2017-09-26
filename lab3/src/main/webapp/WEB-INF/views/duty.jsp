<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<fmt:setLocale value='${sessionScope.locale}'/>
<fmt:setBundle basename="i18n.messages"/>

<html>
<head>
    <jsp:include page="/WEB-INF/views/includes/header.jsp"/>

    <title>Duty</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/includes/navbar.jsp"/>
<jsp:include page="/WEB-INF/views/includes/errors.jsp"/>

<div class="container margit-top">
    <div class="text-center">
        <h1 class="title"><fmt:message key="views.domain.duty"/></h1>
        <hr/>
    </div>

    <div class="row main">
        <div class="main-login main-center">
            <form action="${pageContext.request.contextPath}/site/duty" accept-charset="UTF-8" method="post">

                <div class="form-group">
                    <label for="doctor">
                        <fmt:message key="views.domain.username"/>
                    </label>
                    <div>
                        <div class="input-group">
                            <input class="form-control" name="doctor" id="doctor"
                                   placeholder="<fmt:message key="views.domain.doctor"/>"
                                   value="<c:out value="${sessionScope.user.getId()}"/>"/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="date">
                        <fmt:message key="views.domain.date"/>
                    </label>
                    <div>
                        <div class="input-group">
                            <input type="date"
                                   class="form-control"
                                   name="date"
                                   id="date"
                                   placeholder="<c:out value="${requestScope.model.getDate()}" />"/>
                        </div>
                    </div>
                </div>

                <input class="btn btn-primary btn-lg btn-block login-button" type="submit"
                       value="<fmt:message key="views.action.create"/>">
            </form>
        </div>
    </div>
</div>

<jsp:include page="/WEB-INF/views/includes/footer.jsp"/>
</body>
</html>
