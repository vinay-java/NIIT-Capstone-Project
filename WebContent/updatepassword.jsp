<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link rel="stylesheet" href="css/index.css"></link>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js" charset="utf-8"></script>
  <title>Login Form</title>
</head>
<body >

  <form action="UpdatePassword" method="post" class="login-form" spellcheck="false" autocomplete="off">
         
     <%!
                String errorchng = null;
              %>
  <h1>Change Password</h1>

  <div class="txt">
<input type="text" name="uemail" >
<span data-placeholder="Email"></span>
</div>

<div class="txt">
<input type="password" name="newupass">
<span data-placeholder="New Password"></span>
</div>
 <%
              
               errorchng=(String)request.getAttribute("false");
               if(errorchng!=null)
               out.println("<h3 style=\"text-align:center\">"+errorchng+"</h3>");
            %>

<input type="submit" value="Update" class="login-button">

<div class="bottom-text">Login Page ? <a href="index.jsp">Login</a></div>


</form>

<script type="text/javascript">
$(".txt input").on("focus",function(){
  $(this).addClass("focus");
});

$(".txt input").on("blur",function(){
  if($(this).val()=="")
  $(this).removeClass("focus");
});
</script>
</body>

</html>