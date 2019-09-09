<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link rel="stylesheet" href="css/category.css"></link>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js" charset="utf-8"></script>

  <title>Add Category</title>
</head>
<body >

  <form action="AddCategory" method="get" class="login-form" spellcheck="false" autocomplete="off">
      

       
  <h1>Add Category</h1>


<div class="txt">
<input type="number" name="categoryid">
<span data-placeholder="Category ID"></span>
</div>


  <div class="txt">
<input type="text" name="categoryname" >
<span data-placeholder="Category Name"></span>
</div>


 

<input type="submit" value="Add Category" class="login-button">

<div class="bottom-text">Admin Console ? <a href="adminhome.jsp">back</a>

</div>


</form>


 <form   class="category-form" spellcheck="false" autocomplete="off">
     
  <h1>All Categories</h1>


 <table class="table">
 
  <thead>
    <tr>
      <th scope="col">Category Id</th>
      <th scope="col">Category Name</th>
      <th scope="col">Task</th>
    </tr>
  </thead>
  
  <tbody>
  <c:forEach items="${categories}" var="category"> 
    <tr>
      <td>${category.id}</td>
      <td>${category.name}</td>
      <td>
      	<input type="submit" formaction="DeleteCategory?id=${category.id}" class="delete-button" value="Delete">
      </td>
    </tr>
   </c:forEach>
  </tbody>

</table>


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