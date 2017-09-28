<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<fmt:setLocale value='${sessionScope.locale}'/>
<fmt:setBundle basename="i18n.messages"/>

<html>
<head>
    <jsp:include page="/WEB-INF/views/includes/header.jsp"/>

    <title>Sign In</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/includes/navbar.jsp"/>
<jsp:include page="/WEB-INF/views/includes/errors.jsp"/>

<div class="container margit-top">
    <div class="text-center">
        <h1 class="title"><fmt:message key="views.forms.signIn"/></h1>
        <hr/>
    </div>

    <div class="row main">
        <div class="main-login main-center">
            <form action="${pageContext.request.contextPath}/site/login" accept-charset="UTF-8" method="post">

                <div class="form-group">
                    <label for="username">
                        <fmt:message key="views.domain.username"/>
                    </label>
                    <div>
                        <div class="input-group">
                            <input class="form-control" name="username" id="username"
                                   placeholder="<fmt:message key="views.domain.username" />"
                                   value="<c:out value="${requestScope.model.getUsername()}" />"/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="password">
                        <fmt:message key="views.domain.password"/>
                    </label>
                    <div>
                        <div class="input-group">
                            <input type="password"
                                   class="form-control"
                                   name="password"
                                   id="password"
                                   placeholder="<fmt:message key="views.domain.password" />"/>
                        </div>
                    </div>
                </div>

                <input class="btn btn-primary btn-lg btn-block login-button" type="submit"
                       value="<fmt:message key="views.forms.signIn"/>">
            </form>
            <a href="${pageContext.request.contextPath}/site/join"><fmt:message key="views.forms.signUp"/></a>
        </div>
    </div>
</div>

<jsp:include page="/WEB-INF/views/includes/footer.jsp"/>
</body>
</html>
