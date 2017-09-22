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
<jsp:include page="/WEB-INF/views/includes/errors.jsp"/>

<div class="container">
    <div class="row main">
        <div class="panel-heading">
            <div class="panel-title text-center">
                <h1 class="title"><fmt:message key="views.forms.signIn"/></h1>
                <hr/>
            </div>
        </div>
        <div class="main-login main-center">
            <form action="${pageContext.request.contextPath}/site/login" accept-charset="UTF-8" method="post">

                <div class="form-group">
                    <label for="username" class="col-sm-2">
                        <fmt:message key="views.domain.username"/>
                    </label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <input class="form-control" name="username" id="username"
                                   placeholder="<fmt:message key="views.domain.username" />"
                                   value="<c:out value="${requestScope.model.getUsername()}" />"/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="password" class="col-sm-2">
                        <fmt:message key="views.domain.password"/>
                    </label>
                    <div class="cols-sm-10">
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
        </div>
    </div>
</div>


<jsp:include page="/WEB-INF/views/includes/footer.jsp"/>
</body>
</html>
