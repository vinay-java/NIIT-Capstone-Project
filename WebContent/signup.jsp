<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link rel="stylesheet" href="css/signup.css"></link>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js" charset="utf-8"></script>
  <title>Signup Form</title>
</head>
<body >

  <form action="SignupServlet" method="post" class="signup-form" spellcheck="false" autocomplete="off">

 <%!
                String failuresmsg = null;
 				String successmsg=null;
              %>

  <h1>User Signup</h1>

  <div class="txt">
<input type="text" name="username" >
<span data-placeholder="Fullname"></span>
</div>

<div class="txt">
<input type="password" name="password">
<span data-placeholder="Password"></span>
</div>

<div class="txt">
<input type="text" name="email">
<span data-placeholder="Email"></span>
</div>

<div class="txt">
<input type="text" name="contact">
<span data-placeholder="Contact Number"></span>
</div>

<div class="txt">
<input type="text" name="address">
<span data-placeholder="Address"></span>
</div>

<%
               failuresmsg= (String)request.getAttribute("false");
               if(failuresmsg!=null)
               out.println("<h3 style=\"text-align:center\">"+failuresmsg+"</h3>");
               successmsg= (String)request.getAttribute("true");
               if(successmsg!=null)
               out.println("<h3 style=\"text-align:center\">"+successmsg+"</h3>");
            %>

<input type="submit" value="Signup" class="signup-button">

<div class="bottom-text">Already a User ? <a href="index.jsp">Login</a>
</div>

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
