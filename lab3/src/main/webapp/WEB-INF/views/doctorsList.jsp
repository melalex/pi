<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<fmt:setLocale value='${sessionScope.locale}'/>
<fmt:setBundle basename="i18n.messages"/>

<html>
<head>
    <jsp:include page="/WEB-INF/views/includes/header.jsp"/>

    <title><fmt:message key="views.domain.doctors"/></title>
</head>
<body>
<jsp:include page="/WEB-INF/views/includes/navbar.jsp"/>
<jsp:include page="/WEB-INF/views/includes/errors.jsp"/>

<div class="content">
    <h1><fmt:message key="views.domain.doctors"/></h1>

    <div class="row">
        <div class="col-md-6">
            <form action="${pageContext.request.contextPath}/site/doctors" class="form-inline">
                <label class="sr-only" for="date"><fmt:message key="views.domain.duties"/></label>
                <input type="date" class="form-control mb-2 mr-sm-2 mb-sm-0" id="date">

                <label class="sr-only" for="secession"><fmt:message key="views.domain.secession"/></label>
                <select class="form-control" name="secession" id="secession">
                    <option>Orthopedics</option>
                    <option>Therapy</option>
                    <option>Pediatrics</option>
                    <option>Rehabilitation</option>
                    <option>Gynecology</option>
                </select>

                <button class="btn btn-primary"><fmt:message key="views.action.search"/></button>
            </form>
        </div>
    </div>

    <c:choose>
        <c:when test="${requestScope.model.getPageable().getEntityCount() > 0}">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th><fmt:message key="views.domain.username"/></th>
                    <th><fmt:message key="views.domain.firstName"/></th>
                    <th><fmt:message key="views.domain.lastName"/></th>
                    <th><fmt:message key="views.domain.secession"/></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="item" items="${requestScope.model.getContent()}">
                    <tr>
                        <td><a href="${pageContext.request.contextPath}/site/doctor?id=${item.getId()}">${item.getId()}</a></td>
                        <td>${item.getFirstName()}</td>
                        <td>${item.getLastName()}</td>
                        <td>${item.getSecession()}</td>
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
