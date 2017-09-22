<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<fmt:setLocale value='${sessionScope.locale}'/>
<fmt:setBundle basename="i18n.messages"/>

<html>
<head>
    <jsp:include page="/WEB-INF/views/includes/header.jsp"/>

    <title>Sign Up</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/includes/errors.jsp"/>

<div class="container">
    <div class="row main">
        <div class="panel-heading">
            <div class="panel-title text-center">
                <h2 class="title"><fmt:message key="views.forms.signUp"/></h2>
                <hr/>
            </div>
        </div>
        <div class="main-login main-center">
            <form action="${pageContext.request.contextPath}/site/join" method="post">

                <div class="form-group">
                    <label for="username" class="col-sm-2"><fmt:message key="views.domain.username"/></label>
                    <div class="col-sm-10">
                        <div class="input-group">
                            <input class="form-control" name="username" id="username"
                                   placeholder="<fmt:message key="views.domain.username"/>"
                                   value="<c:out value="${requestScope.model.getUsername()}"/>"/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="password" class="col-sm-2"><fmt:message key="views.domain.password"/></label>
                    <div class="col-sm-10">
                        <div class="input-group">
                            <input class="form-control" name="password" id="password"
                                   placeholder="<fmt:message key="views.domain.password"/>"
                                   value="<c:out value="${requestScope.model.getPassword()}"/>"/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="retryPassword" class="col-sm-2"><fmt:message key="views.domain.retryPassword"/></label>
                    <div class="col-sm-10">
                        <div class="input-group">
                            <input class="form-control" name="retryPassword" id="retryPassword"
                                   placeholder="<fmt:message key="views.domain.retryPassword"/>"
                                   value="<c:out value="${requestScope.model.getRetryPassword()}"/>"/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="firstName" class="col-sm-2"><fmt:message key="views.domain.firstName"/></label>
                    <div class="col-sm-10">
                        <div class="input-group">
                            <input class="form-control" name="firstName" id="firstName"
                                   placeholder="<fmt:message key="views.domain.firstName"/>"
                                   value="<c:out value="${requestScope.model.getFirstName()}"/>"/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="lastName" class="col-sm-2"><fmt:message key="views.domain.lastName"/></label>
                    <div class="col-sm-10">
                        <div class="input-group">
                            <input class="form-control" name="lastName" id="lastName"
                                   placeholder="<fmt:message key="views.domain.lastName"/>"
                                   value="<c:out value="${requestScope.model.getLastName()}" />"/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="secession" class="col-sm-2"><fmt:message key="views.domain.secession"/></label>
                    <div class="col-sm-10">
                        <div class="input-group">
                            <select class="form-control" name="secession" id="secession">
                                <option>Orthopedics</option>
                                <option>Therapy</option>
                                <option>Pediatrics</option>
                                <option>Rehabilitation</option>
                                <option>Gynecology</option>
                            </select>
                        </div>
                    </div>
                </div>

                <input class="btn btn-primary btn-lg btn-block login-button" type="submit"
                       value="<fmt:message key="views.forms.signUp" />">
            </form>
        </div>
    </div>
</div>

<jsp:include page="/WEB-INF/views/includes/footer.jsp"/>
</body>
</html>
