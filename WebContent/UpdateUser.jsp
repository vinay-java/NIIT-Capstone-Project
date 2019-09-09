<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link rel="stylesheet" href="css/updateuser.css"></link>
  <title>Update Form</title>
</head>
<body >

  <form action="UpdateServlet" method="get" class="signup-form" spellcheck="false" autocomplete="off">

 <%! 
                String failuresmsg = null;
                String username=null;
                String password=null;
                long contact;
                String address=null;
                
              %>

  <h1>Update Data</h1>
<%
username=(String)session.getAttribute("true");
password=(String)session.getAttribute("password");
contact=(Long)session.getAttribute("contact");
address=(String)session.getAttribute("address");

%>

  <div class="txt">
<input type="text" name="username" value="<%out.println(username);%>" >
</div>

<div class="txt">
<input type="text" name="password" value="<%out.println(password);%>">
</div>

<div class="txt">
<input type="text" name="contact" value="<%out.println(contact);%>">
</div>

<div class="txt">
<input type="text" name="address" value="<%out.println(address);%>">
</div>

<%

failuresmsg= (String)request.getAttribute("false");
if(failuresmsg!=null)
out.println("<h3 style=\"text-align:center\">"+failuresmsg+"</h3>");

%>
<input type="submit" value="Update" class="signup-button">

<div class="bottom-text">home page <a href="home.jsp">home</a>
</div>

</form>


</body>

</html>
