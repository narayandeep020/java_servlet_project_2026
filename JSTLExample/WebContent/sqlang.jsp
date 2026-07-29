<%@ page import="java.io.*,java.util.*,java.sql.*"%>  
<%@ page import="javax.servlet.http.*,javax.servlet.*" %> 
<%@ page import="java.util.Date,java.text.*" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SQL Tag Example</title>
</head>
<body>

<h3>sql:setDataSource Tag / sql:query Tag</h3>
<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"  
     url="jdbc:mysql://localhost/test_db"  
     user="*****"  password="*****"/>  
  
<sql:query dataSource="${db}" var="rs">  
SELECT * from students;  
</sql:query>  
   
<table border="2" width="100%">  
<tr>  
<th>Student ID</th>  
<th>Student Name</th>  
<th>RollNo</th>  
<th>Address</th>
<th>City</th>  
</tr>  
<c:forEach var="table" items="${rs.rows}">  
<tr>  
<td><c:out value="${table.student_id}"/></td>  
<td><c:out value="${table.stu_Name}"/></td>  
<td><c:out value="${table.roll_no}"/></td>  
<td><c:out value="${table.Address}"/></td> 
<td><c:out value="${table.city}"></c:out></td> 
</tr>  
</c:forEach>  
</table>  
  
<h3>sql:update Tag</h3>
<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"  
     url="jdbc:mysql://localhost/test_db"  
     user="*****"  password="*****"/>  
  
<sql:update dataSource="${db}" var="count">  
INSERT INTO students(student_id, stu_Name, roll_no, Address, city)  VALUES (211, 'Farheen', '19087', 'Madhya Pradehs', 'Katni');  
</sql:update> 
  
<sql:query dataSource="${db}" var="rs">  
SELECT * from students;  
</sql:query>  
   
<table border="2" width="100%">  
<tr>  
<th>Student ID</th>  
<th>Student Name</th>  
<th>RollNo</th>  
<th>Address</th>
<th>City</th>
  
</tr>  
<c:forEach var="table" items="${rs.rows}">  
<tr>  
<td><c:out value="${table.student_id}"/></td>  
<td><c:out value="${table.stu_Name}"/></td>  
<td><c:out value="${table.roll_no}"/></td>  
<td><c:out value="${table.Address}"/></td> 
<td><c:out value="${table.city}"></c:out></td> 
</tr>  
</c:forEach>  
</table> 

<h3>sql:param Tag</h3>
<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"  
     url="jdbc:mysql://localhost/test_db"  
     user="*****"  password="*****"/>  
  
<c:set var="StudentId" value="204"/>  
<sql:update dataSource="${db}" var="count">  
DELETE FROM students WHERE student_id = ?  
 <sql:param value="${StudentId}" />  
</sql:update>  

<sql:query dataSource="${db}" var="rs">  
SELECT * from students;  
</sql:query> 
   
<table border="2" width="100%">  
<tr>  
<th>Student ID</th>  
<th>Student Name</th>  
<th>RollNo</th>  
<th>Address</th>
<th>City</th>  
</tr>  
<c:forEach var="table" items="${rs.rows}">  
<tr>  
<td><c:out value="${table.student_id}"/></td>  
<td><c:out value="${table.stu_Name}"/></td>  
<td><c:out value="${table.roll_no}"/></td>  
<td><c:out value="${table.Address}"/></td> 
<td><c:out value="${table.city}"></c:out></td> 
</tr>  
</c:forEach>  
</table>  


 <h3>sql:dateParam tag</h3>
 <sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"  
     url="jdbc:mysql://localhost/test_db"  
     user="*****"  password="*****"/>  
  
<%  
Date DoB = new Date("2000/08/16");  
int studentId = 205;  
%>  
<sql:update dataSource="${db}" var="count">  
   UPDATE students SET Dob = ? WHERE Id = ?  
   <sql:dateParam value="<%=DoB%>" type="DATE" />  
   <sql:param value="<%=studentId%>" />  
</sql:update>  

<sql:query dataSource="${db}" var="rs">  
SELECT * from students;  
</sql:query> 
   
<table border="2" width="100%">  
<tr>  
<th>Student ID</th>  
<th>Student Name</th>  
<th>RollNo</th>  
<th>Address</th>
<th>City</th>
<th>Dob</th>  
</tr>  
<c:forEach var="table" items="${rs.rows}">  
<tr>  
<td><c:out value="${table.student_id}"/></td>  
<td><c:out value="${table.stu_Name}"/></td>  
<td><c:out value="${table.roll_no}"/></td>  
<td><c:out value="${table.Address}"/></td> 
<td><c:out value="${table.city}"></c:out></td> 
<td><c:out value="${table.Dob}"/></td>
</tr>  
</c:forEach>  
</table>  
 
 
<h3>sql:transaction tag</h3> 
<%  
Date dob = new Date("2000/10/16");  
int stuId = 151;  
%>
<sql:transaction dataSource="${db}">   
   <sql:update var="count">  
      UPDATE student SET stu_Name = 'Suraj' WHERE Id = 208  
   </sql:update>  
   <sql:update var="count">  
      UPDATE student SET Address= 'Saifi' WHERE Id = 206  
   </sql:update>  
   <sql:update var="count">  
     INSERT INTO Student   
     VALUES (254,'Supriya', 19088, 'Bihar', 'Patna', '1995/10/6');  
   </sql:update>  
</sql:transaction>
</body>
</html>