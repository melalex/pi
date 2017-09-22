<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<c:set var="pageCount" scope="request" value="${requestScope.model.getPageable().getPageCount()}"/>
<c:set var="page" scope="request" value="${requestScope.model.getPageable().getPage()}"/>

<c:if test="${pageCount > 1}">
    <nav aria-label="Page navigation" class="justify-content-center">
        <ul id="pagination" class="pagination">

            <c:choose>
                <c:when test="${page == 1}">
                    <li class="disabled">
                        <a href="#" aria-label="Previous">
                            <span>&laquo;</span>
                        </a>
                    </li>
                </c:when>
                <c:otherwise>
                    <li>
                        <a href="${pageContext.request.requestURI}?page=${page - 1}&${pageContext.request.queryString}"
                           aria-label="Previous">
                            <span>&laquo;</span>
                        </a>
                    </li>
                </c:otherwise>
            </c:choose>

            <c:choose>
                <c:when test="${pageCount < 10}">
                    <c:forEach var="i" begin="1" end="${pageCount}">
                        <c:choose>
                            <c:when test="${i == page}">
                                <li class="active">
                                    <span>${i}</span>
                                </li>
                            </c:when>
                            <c:otherwise>
                                <li>
                                    <a href="${pageContext.request.requestURI}?page=${i}&${pageContext.request.queryString}">
                                            ${i}<span class="sr-only">(current)</span>
                                    </a>
                                </li>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </c:when>
                <c:when test="${page < 5}">
                    <c:forEach var="i" begin="1" end="5">
                        <c:choose>
                            <c:when test="${i == page}">
                                <li class="active">
                                    <span>${i}</span>
                                </li>
                            </c:when>
                            <c:otherwise>
                                <li>
                                    <a href="${pageContext.request.requestURI}?page=${i}&${pageContext.request.queryString}">
                                            ${i}<span class="sr-only">(current)</span>
                                    </a>
                                </li>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    <li class="disabled"><span>...</span></li>
                    <c:forEach var="i" begin="${pageCount - 5}" end="${pageCount}">
                        <li>
                            <a href="${pageContext.request.requestURI}?page=${i}&${pageContext.request.queryString}">
                                    ${i}<span class="sr-only">(current)</span>
                            </a>
                        </li>
                    </c:forEach>
                </c:when>
                <c:when test="${page > (pageCount - 4)}">
                    <c:forEach var="i" begin="1" end="$5">
                        <li>
                            <a href="${pageContext.request.requestURI}?page=${i}&${pageContext.request.queryString}">
                                    ${i}<span class="sr-only">(current)</span>
                            </a>
                        </li>
                    </c:forEach>
                    <li class="disabled"><span>...</span></li>
                    <c:forEach var="i" begin="${pageCount - 5}" end="${pageCount}">
                        <c:choose>
                            <c:when test="${i == page}">
                                <li class="active">
                                    <span>${i}</span>
                                </li>
                            </c:when>
                            <c:otherwise>
                                <li>
                                    <a href="${pageContext.request.requestURI}?page=${i}&${pageContext.request.queryString}">
                                            ${i}<span class="sr-only">(current)</span>
                                    </a>
                                </li>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <li>
                        <a href="${pageContext.request.requestURI}?page=1&${pageContext.request.queryString}">
                            1<span class="sr-only">(current)</span>
                        </a>
                    </li>
                    <li>
                        <a href="${pageContext.request.requestURI}?page=2&${pageContext.request.queryString}">
                            2<span class="sr-only">(current)</span>
                        </a>
                    </li>
                    <li class="disabled"><span>...</span></li>
                    <li>
                        <a href="${pageContext.request.requestURI}?page=${page - 1}&${pageContext.request.queryString}">
                                ${page - 1}<span class="sr-only">(current)</span>
                        </a>
                    </li>
                    <li class="active"><span>${page}</span></li>
                    <li>
                        <a href="${pageContext.request.requestURI}?page=${page + 1}&${pageContext.request.queryString}">
                                ${page + 1}<span class="sr-only">(current)</span>
                        </a>
                    </li>
                    <li class="disabled"><span>...</span></li>
                    <li>
                        <a href="${pageContext.request.requestURI}?page=${pageCount - 1}&${pageContext.request.queryString}">
                                ${pageCount - 1}<span class="sr-only">(current)</span>
                        </a>
                    </li>
                    <li>
                        <a href="${pageContext.request.requestURI}?page=${pageCount}&${pageContext.request.queryString}">
                                ${pageCount}<span class="sr-only">(current)</span>
                        </a>
                    </li>
                </c:otherwise>
            </c:choose>

            <c:choose>
                <c:when test="${page == pageCount}">
                    <li class="disabled">
                        <a href="#" aria-label="Previous">
                            <span>&laquo;</span>
                        </a>
                    </li>
                </c:when>
                <c:otherwise>
                    <li>
                        <a href="${pageContext.request.requestURI}?page=${page + 1}&${pageContext.request.queryString}"
                           aria-label="Next">
                            <span>&raquo;</span>
                        </a>
                    </li>
                </c:otherwise>
            </c:choose>

        </ul>
    </nav>

</c:if>