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

  <form action="Admin" method="post" class="login-form" spellcheck="false" autocomplete="off">
      
     <%!
                String successmsg = null;
                String errorloginmsg = null;
              %>
       
  <h1>Admin Login</h1>

 <div class="txt">
<input type="number" name="uid" >
<span data-placeholder="Admin Id"></span>
</div>


<div class="txt">
<input type="password" name="upass">
<span data-placeholder="Password"></span>
</div>

 <%
               successmsg = (String)request.getAttribute("true");
               if(successmsg!=null)
               out.println("<h3 style=\"text-align:center\">"+successmsg+"</h3>");
               
               errorloginmsg=(String)request.getAttribute("false");
               if(errorloginmsg!=null)
               out.println("<h3 style=\"text-align:center\">"+errorloginmsg+"</h3>");
            %>

<input type="submit" value="Login" class="login-button">

  <div class="bottom-text">Admin is already registered</div>
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