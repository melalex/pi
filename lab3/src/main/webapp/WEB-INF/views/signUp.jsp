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
<jsp:include page="/WEB-INF/views/includes/navbar.jsp"/>
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
            <form method="post">

                <div class="form-group">
                    <label for="username" class="col-sm-2"><fmt:message key="views.forms.username"/></label>
                    <div class="col-sm-10">
                        <div class="input-group">
                            <input class="form-control" name="username" id="username"
                                   placeholder="<fmt:message key="views.forms.username"/>"
                                   value="<c:out value="${requestScope.form.getUsername()}"/>"/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="password" class="col-sm-2"><fmt:message key="views.forms.password"/></label>
                    <div class="col-sm-10">
                        <div class="input-group">
                            <input class="form-control" name="password" id="password"
                                   placeholder="<fmt:message key="views.forms.password"/>"
                                   value="<c:out value="${requestScope.form.getPassword()}"/>"/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="retryPassword" class="col-sm-2"><fmt:message key="views.forms.retryPassword"/></label>
                    <div class="col-sm-10">
                        <div class="input-group">
                            <input class="form-control" name="retryPassword" id="retryPassword"
                                   placeholder="<fmt:message key="views.forms.retryPassword"/>"
                                   value="<c:out value="${requestScope.form.getRetryPassword()}"/>"/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="firstName" class="col-sm-2"><fmt:message key="views.forms.firstName"/></label>
                    <div class="col-sm-10">
                        <div class="input-group">
                            <input class="form-control" name="firstName" id="firstName"
                                   placeholder="<fmt:message key="views.forms.firstName"/>"
                                   value="<c:out value="${requestScope.form.getFirstName()}"/>"/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="lastName" class="col-sm-2"><fmt:message key="views.forms.lastName"/></label>
                    <div class="col-sm-10">
                        <div class="input-group">
                            <input class="form-control" name="lastName" id="lastName"
                                   placeholder="<fmt:message key="views.forms.lastName"/>"
                                   value="<c:out value="${requestScope.form.getLastName()}" />"/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="secession" class="col-sm-2"><fmt:message key="views.forms.secession"/></label>
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
