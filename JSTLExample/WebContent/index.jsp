 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Tag Example</title>
</head>
<body>
<h2>SQL Tag</h2>
<a href="sqlang.jsp">sql_tag</a>
<br/>
<h2>XML Tag</h2>
<a href="container.jsp">xml_tag</a>
<br/>
<h2>Formatting Tag</h2>
<a href="formt.jsp">formatting_tag</a>
<br/>
<h2>Function Tag</h2>
<a href="func.jsp">function_tag</a>
<br/>
<h3>c:out Tag</h3>
<c:out value="${'Welcome to javaTpoint'}"/>
<br/>

<h3>c:import Tag</h3>
<c:import var="data" url="http://www.tpointtech.com/jsp-tutorial"/>  
<c:out value="${data}"/>
<br/>

<h3>c:set Tag</h3>
<c:set var="Income" scope="session" value="${4000*4}"/>  
<c:out value="${Income}"/> 
<br/>

<h3>c:remove Tag</h3>
<c:set var="income" scope="session" value="${4000*4}"/>  
<p>Before Remove Value is: <c:out value="${income}"/></p>  
<c:remove var="income"/> 
<p>After Remove Value is: <c:out value="${income}"/></p>


<h3>c:catch Tag</h3>
<c:catch var ="catchtheException">  
   <% int x = 2/0;%> 
   </c:catch>  
     
<c:if test = "${catchtheException != null}">  
   <p>The type of exception is : ${catchtheException} <br />  
   There is an exception: ${catchtheException.message}</p>  
</c:if>


<h3>c: if Tag</h3>
<c:set var="income" scope="session" value="${4000*4}"/>  
<c:if test="${income > 8000}">  
   <p>My income is: <c:out value="${income}"/><p>
</c:if>

<h3>c:choose, c:when and c:otherwise Tag</h3>
<c:set var="income" scope="session" value="${4000*4}"/> 
<p>Your income is: <c:out value="${income }"/></p>
<c:choose>
<c:when test="${income <= 1000 }">Income is not good</c:when>
<c:when test="${income >10000 }">Income is very good.</c:when>
<c:otherwise>Income is undetermined...</c:otherwise>
</c:choose>

<h3>c: forEach Tag</h3>
<c:forEach var="j" begin="1" end="3">  
   Item <c:out value="${j}"/><p>  
</c:forEach>

<h3>c:forToken Tag</h3>
<c:forTokens items="Shiva-Saytam-Deep" delims="-" var="name">  
   <c:out value="${name}"/><p>  
</c:forTokens>  

<h3>c:param Tag</h3>
<c:url value="/index.jsp" var="completeURL">  
 <c:param name="trackingId" value="786"/>  
 <c:param name="user" value="Nakul"/>  
</c:url>  
${completeURL}  

<h3>c:redirect Tag</h3>
<%--   <c:set var="url" value="0" scope="request"/>   --%>
<%--   <c:if test="${url<1}">   --%>
<%--      <c:redirect url="http://tpointtech.com"/>   --%>
<%--   </c:if>   --%>
<%--   <c:if test="${url>1}">   --%>
<%--      <c:redirect url="http://instagram.com"/>   --%>
<%--   </c:if> --%>
  
  <h3>c:url Tag</h3>
<%--   <c:url value="/RegisterDao.jsp"/> --%>
  
  
</body>
</html>