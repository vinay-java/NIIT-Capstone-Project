<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <link rel="stylesheet" href="css/signup.css"></link>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js" charset="utf-8"></script>
<title>admin console</title>
</head>
<body>
<form action="AddProduct" method="post" class="signup-form" spellcheck="false" autocomplete="off">


  <h1>Add Product</h1>


 <select class="category-select" id="inputGroupSelect01"   title="Select Category">
	  <c:forEach items="${categories}" var="category" >
	  
	 				<option value="${category.id}"> ${category.name} </option>
			</c:forEach>			
	  	  </select>

  <div class="txt">
<input type="text" name="productname" >
<span data-placeholder="product Name"></span>
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