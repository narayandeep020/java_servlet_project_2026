<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>  

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>XML Tag Example</title>
</head>
<body>

<h3>x:out Tag</h3>  
<c:set var="vegetable">  
<vegetables>  
    <vegetable>  
      <name>onion</name>  
      <price>40/kg</price>  
    </vegetable>  
    <vegetable>  
      <name>Potato</name>  
      <price>30/kg</price>  
    </vegetable>    
</vegetables>  
</c:set>  
 <x:parse xml="${vegetable}" var="output"/>  
<b>Name of the vegetable is</b>:  
<x:out select="$output/vegetables/vegetable[1]/name" /><br>  
<b>Price of the Potato is</b>:  
<x:out select="$output/vegetables/vegetable[2]/price" />

<h3>x:parse Tag</h3>
<c:set var="bookInfo">
<books>  
<book>  
  <name>Three mistakes of my life</name>  
  <author>Chetan Bhagat</author>  
  <price>200</price>  
</book>  
<book>  
  <name>Tomorrow land</name>  
  <author>NUHA</author>  
  <price>2000</price>  
</book>  
</books>  
</c:set>
<x:parse xml="${bookInfo}" var="output"/>  
<p>First Book title: <x:out select="$output/books/book[1]/name" /></p>  
<p>First Book price: <x:out select="$output/books/book[1]/price" /></p>  
<p>Second Book title: <x:out select="$output/books/book[2]/name" /></p>  
<p>Second Book price: <x:out select="$output/books/book[2]/price" /></p> 


<h3>x:set Tag</h3>
<c:set var="book">  
<books>  
<book>  
  <name>Three mistakes of my life</name>  
  <author>Chetan Bhagat</author>  
  <price>200</price>  
</book>  
<book>  
  <name>Tomorrow land</name>  
  <author>Brad Bird</author>  
  <price>2000</price>  
</book>  
</books>  
</c:set>  
<x:parse xml="${book}" var="output"/>  
<x:set var="fragment" select="$output/books/book[2]/price"/>  
<b>The price of the Tomorrow land book</b>:  
<x:out select="$fragment" /> 


<h3>x:choose, x:when and x:otherwise Tag</h3>
<c:set var="xmltext">  
<books>  
<book>  
  <name>Three mistakes of my life</name>  
  <author>Chetan Bhagat</author>  
  <price>200</price>  
</book>  
<book>  
  <name>Tomorrow land</name>  
  <author>Brad Bird</author>  
  <price>2000</price>  
</book>  
</books>  
</c:set>  

<x:parse xml="${xmltext}" var="output"/>  
<x:choose>  
   <x:when select="$output//book/author = 'Chetan bhagat'">  
      Book is written by Chetan bhagat  
   </x:when>  
   <x:when select="$output//book/author = 'Brad Bird'">  
      Book is written by Brad Bird  
   </x:when>  
   <x:otherwise>  
      The author is unknown...  
   </x:otherwise>  
</x:choose>


<h3>x:if Tag</h3>
<c:set var="vegetables">  
<vegetables>  
    <vegetable>  
      <name>onion</name>  
      <price>40</price>  
    </vegetable>    
 <vegetable>  
      <name>Tomato</name>  
      <price>90</price>  
    </vegetable>  
</vegetables>
</c:set>  
<x:parse xml="${vegetables}" var="output"/>  
<x:if select="$output/vegetables/vegetable/price < 100">  
   Vegetables prices are very low.  
</x:if> 


<h3>x:transform Tag</h3>
<?xml version="1.0" encoding="UTF-8"?> 
<c:set var="xmlData">
<company>  
<emp>  
<name>Rajan Singh</name>  
<designation>Bussiness Developer</designation>  
<age>40</age>  
</emp>  
<emp>  
<name>Supriya Gaur</name>  
<designation>HR Executive</designation>  
<age>22</age>  
</emp>  
</company>
</c:set>
<c:set var="xslData">
<xsl:stylesheet version="1.0" 
       xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
 
<xsl:template match="/">  
<html> 
<body>  
<h2>Company's Employee detail</h2>  
<table border="2">  
<tr>  
<th align="left">Name</th>  
<th align="left">Designation</th>  
<th align="left">Age</th>  
</tr>  
<xsl:for-each select="company/emp">  
<tr>  
<td><xsl:value-of select="name"/></td>  
<td><xsl:value-of select="designation"/></td>  
<td><xsl:value-of select="age"/></td>  
</tr>  
</xsl:for-each>  
</table>  
</body>  
</html>  
</xsl:template>  
</xsl:stylesheet>
</c:set>
<x:transform xml="${xmlData}" xslt="${xslData}" /> 

<h3>x:param Tag</h3> 

</body>
</html>