<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %> 

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formatting Tag Example</title>
</head>
<body>

<h3>fmt:parseNumber Tag</h3>
<c:set var="Amount" value="786.970" />  
  
    <fmt:parseNumber var="j" type="number" value="${Amount}" />  
    <p><i>Actual Amount is:</i>  <c:out value="${j}" /></p>  
  
    <fmt:parseNumber var="j" integerOnly="true" type="number" value="${Amount}" />  
    <p><i>Integer Amount is:</i>  <c:out value="${j}" /></p> 
 
 
 <h3>fmt:timeZone Tag</h3>
 <c:set var="now" value="<%=new java.util.Date()%>" /> 
 
<p>Default Server Time:</p>
<fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="long"/>

<hr/>

<p>Time in Asia/Kolkata:</p>
<fmt:timeZone value="Asia/Kolkata">
    <fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="long"/>
</fmt:timeZone>

<p>Time in America/New_York:</p>
<fmt:timeZone value="America/New_York">
    <fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="long"/>
</fmt:timeZone>


<h3>fmt:formatNumber Tag</h3>
<c:set var="Amount" value="9850.14115" />
<p> Formatted Number-1:  
<fmt:formatNumber value="${Amount}" type="currency" /></p>  
<p>Formatted Number-2:  
<fmt:formatNumber type="number" groupingUsed="true" value="${Amount}" /></p>  
<p>Formatted Number-3:  
<fmt:formatNumber type="number" maxIntegerDigits="3" value="${Amount}" /></p>  
<p>Formatted Number-4:  
<fmt:formatNumber type="number" maxFractionDigits="6" value="${Amount}" /></p>  
<p>Formatted Number-5:  
<fmt:formatNumber type="percent" maxIntegerDigits="4" value="${Amount}" /></p>  
<p>Formatted Number-6:  
<fmt:formatNumber type="number" pattern="###.###$" value="${Amount}" /></p>  


<h3>fmt:parseDate Tag</h3>
<c:set var="date" value="12-08-2016" />  
  
<fmt:parseDate value="${date}" var="parsedDate"  pattern="dd-MM-yyyy" />  
<p><c:out value="${parsedDate}" /></p>


<h3>fmt:bundle Tag</h3>
<fmt:bundle basename="com.deep.Simple" prefix="colour.">  
   <fmt:message key="Violet"/><br/>  
   <fmt:message key="Indigo"/><br/>  
  <fmt:message key="Blue"/><br/> 
</fmt:bundle> 

<h3>fmt:setTimeZone Tag</h3>
<c:set var="date" value="<%=new java.util.Date()%>" />
<p><b>Date and Time in Indian Standard Time(IST) Zone:</b> <fmt:formatDate value="${date}"  
             type="both" timeStyle="long" dateStyle="long" /></p>
             
 <fmt:setTimeZone value="GMT-10" />  
<p><b>Date and Time in GMT-10 time Zone: </b><fmt:formatDate value="${date}"  
             type="both" timeStyle="long" dateStyle="long" /></p>
             
<h3>fmt:setBundle and fmt:message Tag</h3>
<fmt:setBundle basename="com.deep.Message" var="lang"/>  
<fmt:message key="vegetable.Potato" bundle="${lang}"/><br/>  
   <fmt:message key="vegetable.Tomato" bundle="${lang}"/><br/>  
  <fmt:message key="vegetable.Carrot" bundle="${lang}"/><br/>  
  
  
<h3>fmt:formatDate Tag</h3>
<h2>Different Formats of the Date</h2>  
<c:set var="Date" value="<%=new java.util.Date()%>" />  
<p>  
Formatted Time :  
<fmt:formatDate type="time" value="${Date}" />  
</p>  
<p>  
Formatted Date :  
<fmt:formatDate type="date" value="${Date}" />  
</p>  
<p>  
Formatted Date and Time :  
<fmt:formatDate type="both" value="${Date}" />  
</p>  
<p>  
Formatted Date and Time in short style :  
<fmt:formatDate type="both" dateStyle="short" timeStyle="short"  
value="${Date}" />  
</p>  
<p>  
Formatted Date and Time in medium style :  
<fmt:formatDate type="both" dateStyle="medium" timeStyle="medium"  
value="${Date}" />  
</p>  
<p>  
Formatted Date and Time in long style :  
<fmt:formatDate type="both" dateStyle="long" timeStyle="long"  
value="${Date}" />  
</p>  
</body>
</html>