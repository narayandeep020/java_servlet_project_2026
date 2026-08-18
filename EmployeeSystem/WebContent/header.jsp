<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee System</title>

<style type="text/css">

        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
        }

        /* Header styling */
        header {
            background-color: #333;
            padding: 15px 30px; 
            color: white; 
            text-align: center;
            
        }

       nav {
            list-style: none;
            padding: 10px; 
            color: white; 
            text-align: center;
            
            
        }

        ul li {
            margin-right: 25px;
            list-style-type: none;
            display: inline;
           
            
        }

        ul li a {
            text-decoration: none;
            color: #fff;
            font-size: 16px;
            transition: color 0.3s ease;
        }

        ul li a:hover {
            color: #ff9800; /* orange hover effect */
        }

</style>

</head>
<body>
    <header>
    <h1>Welcome to Employee System</h1>
        <nav>
            <ul>
                <li><a href="home.jsp">Home</a></li>
                <li><a href="about.jsp">About</a></li>
                <li><a href="adminDash.jsp">Admin</a></li>
                <li><a href="empDash.jsp">Employee</a></li>
                <li><a href="adminLogoutServet">Logout</a></li>
            </ul>
        </nav>
    </header>

<div class="content">