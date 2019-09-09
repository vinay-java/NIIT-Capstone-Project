<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/header.css" rel="stylesheet"></link>
</head>
<body>
<%!
String username=null;
%>

<div class="header">
  <a href="home.jsp" class="logo">Mobile Store</a>
  <div class="header-right">
    <a class="active" href="home.jsp">Home</a>
    <a href="#about">categories</a>
    <a href="#contact">products</a>
    <a href="#about">About us</a>
    <a href="">Cart(0)</a>
   <div class="dropdown">
  <button  class="dropbtn"><%
		       
               username= (String)session.getAttribute("true");
               if(username!=null)
               {
            	   out.print("Hii , "+username);
               }
              
            %></button>
  <div id="myDropdown" class="dropdown-content">
    <a href="UpdateUser.jsp">Update data</a>
    <a href="LogOutUserServlet">Log Out</a>
    <a href="DeleteUserServlet">Delete A/C</a>
  </div>
</div>
     
  </div>
</div>
</body>
</html>