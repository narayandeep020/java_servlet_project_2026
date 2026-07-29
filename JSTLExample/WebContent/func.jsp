<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Function Tag Example</title>
</head>
<body>

<h3>fn:contains Tag</h3>
<c:set var="String" value="Welcome to javatpoint"/>  
  
<c:if test="${fn:contains(String, 'javatpoint')}">  
   <p>Found javatpoint string<p>  
</c:if>  
  
<c:if test="${fn:contains(String, 'JAVATPOINT')}">  
   <p>Found JAVATPOINT string<p>  
</c:if>


<h3>fn:containsIgnoreCase Tag</h3>
<c:set var="String" value="Welcome to javatpoint"/>  
  
<c:if test="${fn:containsIgnoreCase(String, 'javatpoint')}">  
   <p>Found javatpoint string<p>  
</c:if>  
  
<c:if test="${fn:containsIgnoreCase(String, 'JAVATPOINT')}">  
   <p>Found JAVATPOINT string<p>  
</c:if>


<h3>fn:endsWith Tag</h3>
<c:set var="String" value="Welcome to JSP programming"/>  
  
<c:if test="${fn:endsWith(String, 'programming')}">  
   <p>String ends with programming<p>  
</c:if>  
  
<c:if test="${fn:endsWith(String, 'JSP')}">  
   <p>String ends with JSP<p>  
</c:if>  


<h3>fn:escapeXml Tag</h3>
<c:set var="string1" value="It is first String."/>  
<c:set var="string2" value="It is <xyz>second String.</xyz>"/>  
  
<p>With escapeXml() Function:</p>  
<p>string-1 : ${fn:escapeXml(string1)}</p>  
<p>string-2 : ${fn:escapeXml(string2)}</p>  
  
<p>Without escapeXml() Function:</p>  
<p>string-1 : ${string1}</p>  
<p>string-2 : ${string2}</p>  


<h3>fn:indexOf Tag</h3> 
<c:set var="string1" value="It is first String."></c:set>
<c:set var="string2" value="It is <xyz>second string.<xyz>"></c:set>

<p>Index-1:${fn:indexOf(string1,"first")}</p>
<p>Index-2:${fn:indexOf(string2,"second")}</p>

<h3>fn:trim Tag and fn:length Tag</h3> 
<c:set var="str1" value="Welcome to JSP        programming         "/>  
<p>String-1 Length is : ${fn:length(str1)}</p>  
  
<c:set var="str2" value="${fn:trim(str1)}" />  
<p>String-2 Length is : ${fn:length(str2)}</p>  
<p>Final value of string is : ${str2}</p>  


<h3>fn:startWith Tag</h3>
<c:set var="msg" value="The Example of JSTL fn:startsWith() Function"/>  
The string starts with "The": ${fn:startsWith(msg, 'The')}  
<br>The string starts with "Example": ${fn:startsWith(msg, 'Example')} 


<h3>fn:split Tag</h3>
<c:set var="str1" value="Welcome-to-JSP-Programming."/>  
<c:set var="str2" value="${fn:split(str1, '-')}" />  
<c:set var="str3" value="${fn:join(str2, ' ')}" />  
  
<p>String-3 : ${str3}</p>  
<c:set var="str4" value="${fn:split(str3, ' ')}" />  
<c:set var="str5" value="${fn:join(str4, '-')}" />    
<p>String-5 : ${str5}</p>  


<h3>fn:toLowerCase Tag and fn:toUpperCase</h3>
<c:set var="string" value="Welcome to JSP Programming"/>  
${fn:toLowerCase("HELLO,")}  
${fn:toLowerCase(string)}
<br/>
${fn:toUpperCase(string)}


<h3>fn:substring Tag</h3>
<c:set var="string" value="This is the first string."/> 
<p>Actual String: ${string}</p> 
substring: ${fn:substring(string, 5, 17)}


<h3>fn:substringAfter Tag</h3>
<c:set var="string" value="Nakul Jain"/>
<p>Actual String: ${string}</p>   
substringAfter: ${fn:substringAfter(string, "Nakul")} 



<h3>fn:substringBefore Tag</h3>
<c:set var="string" value="Hi, This is JAVATPOINT.COM developed by SONOO JAISWAL."/>
<p>Actual String: ${string}</p>   
substringBefore: ${fn:substringBefore(string, "developed")}



<h3>fn:replace Tag</h3> 
<c:set var="author" value="Ramesh Kumar"/>  
<c:set var="string" value="pqr xyz abc PQR"/> 
Before replace: ${author} ${string}
<br/> 
After replace: ${fn:replace(author, "Ramesh", "Deep")} ${fn:replace(string, "pqr", "hello")}  
</body>
</html>