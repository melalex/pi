<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<fmt:setLocale value='${sessionScope.locale}'/>
<fmt:setBundle basename="i18n.messages"/>

<html>
<head>
    <jsp:include page="/WEB-INF/views/includes/header.jsp"/>

    <title><fmt:message key="views.domain.patients"/></title>
</head>
<body>
<jsp:include page="/WEB-INF/views/includes/navbar.jsp"/>
<jsp:include page="/WEB-INF/views/includes/errors.jsp"/>

<div class="container margit-top">
    <div class="text-center">
        <h1><fmt:message key="views.domain.patients"/></h1>
        <hr/>
        <a class="btn btn-success" href="${pageContext.request.contextPath}/site/patient/create">
            <fmt:message key="views.action.create"/>
        </a>
    </div>

    <c:choose>
        <c:when test="${requestScope.model.getPageable().getEntityCount() > 0}">
            <table class="table table-hover margit-top">
                <thead>
                <tr>
                    <th><fmt:message key="views.domain.id"/></th>
                    <th><fmt:message key="views.domain.fullName"/></th>
                    <th><fmt:message key="views.domain.doctor"/></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="item" items="${requestScope.model.getContent()}">
                    <tr>
                        <td><c:out value='${item.getId()}'/></td>
                        <td>
                            <a href="${pageContext.request.contextPath}/site/patient?id=${item.getId()}">
                                <c:out value='${item.getFullName()}'/>
                            </a>
                        </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/site/doctor?id=${item.getDoctor().getId()}">
                                <c:out value='${item.getDoctor().getId()}'/>
                            </a>
                        </td>
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
