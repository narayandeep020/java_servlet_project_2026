<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jsp:include page="header.jsp" />

    <h2>About Sections</h2>
    <c:if test="${not empty aboutList}">
        <c:forEach var="about" items="${aboutList}">
            <h3>${about.sectionTitle}</h3>
            <p>${about.description}</p>
            <small>
                Created: <fmt:formatDate value="${about.createAt}" pattern="dd-MM-yyyy HH:mm" />
                | Updated: <fmt:formatDate value="${about.updateAt}" pattern="dd-MM-yyyy HH:mm" />
            </small>
            <hr/>
        </c:forEach>
    </c:if>
    <c:if test="${empty aboutList}">
        <p>No About sections found.</p>
    </c:if>

<jsp:include page="footer.jsp" />
