<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Management System</title>
<style>
        header {
         background-color: #333; 
         color: white; 
         padding: 15px; 
         text-align: center; 
         }
        footer { 
        background-color: #f1f1f1; 
        padding: 10px; text-align: center; 
        position: fixed; 
        bottom: 0; 
        width: 100%; 
        }
        nav a {
         color: white; 
         margin: 0 10px; 
         text-decoration: none; 
         }
        .content {
         padding: 20px; 
         margin-bottom: 60px; 
         }
    </style>
</head>
<body>
<header>
    <h1>Welcome to Employee System</h1>
    <nav>
        <a href="home.jsp">Home</a> | 
        <a href="admin.jsp">Admin</a> | 
        <a href="employee.jsp">Employee</a> | 
        <a href="guest.jsp">Guest</a> | 
        <a href="about">About Us</a> | 
        <a href="logoutServlet">Logout</a>
    </nav>
</header>
<div class="content">