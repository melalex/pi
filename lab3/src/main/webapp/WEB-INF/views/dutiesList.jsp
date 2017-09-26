<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<fmt:setLocale value='${sessionScope.locale}'/>
<fmt:setBundle basename="i18n.messages"/>

<html>
<head>
    <jsp:include page="/WEB-INF/views/includes/header.jsp"/>

    <title><fmt:message key="views.domain.duties"/></title>
</head>
<body>
<jsp:include page="/WEB-INF/views/includes/navbar.jsp"/>
<jsp:include page="/WEB-INF/views/includes/errors.jsp"/>

<div class="container margit-top">
    <div class="text-center">
        <h1 class="title"><fmt:message key="views.domain.duties"/></h1>
        <hr/>
    </div>
    <div class="row">
        <div class="col-md-4">
            <form action="${pageContext.request.contextPath}/site/duties" class="form-inline">
                <label class="sr-only" for="lastName"><fmt:message key="views.domain.lastName"/></label>
                <input type="search" class="form-control mb-2 mr-sm-2 mb-sm-0" id="lastName">

                <button class="btn btn-primary"><fmt:message key="views.action.search"/></button>
            </form>
        </div>

        <div class="col-md-6"></div>

        <div class="col-md-2">
            <a class="btn btn-success search-button" href="${pageContext.request.contextPath}/site/duty/create">
                <fmt:message key="views.action.create"/>
            </a>
        </div>

    </div>

    <c:choose>
        <c:when test="${requestScope.model.getPageable().getEntityCount() > 0}">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th><fmt:message key="views.domain.id"/></th>
                    <th><fmt:message key="views.domain.doctor"/></th>
                    <th><fmt:message key="views.domain.date"/></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="item" items="${requestScope.model.getContent()}">
                    <tr>
                        <td>${item.getId()}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/site/doctor?id=${item.getDoctor().getId()}">${item.getDoctor().getId()}</a>
                        </td>
                        <td>${item.getDate()}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:when>
        <c:otherwise>
            <h1 class="text-center no-result-text"><fmt:message key="views.result.empty"/></h1>
        </c:otherwise>
    </c:choose>

    <jsp:include page="/WEB-INF/views/includes/pager.jsp"/>

</div>

<jsp:include page="/WEB-INF/views/includes/footer.jsp"/>
</body>
</html>
