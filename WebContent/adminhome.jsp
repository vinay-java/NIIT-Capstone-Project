<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>admin console</title>
<link rel="stylesheet" href="css/adminhome.css"></link>
</head>
<body>
<form class="login-form">
 <h1>Admin Console</h1>

 <div class="card-body">
        <h5 class="card-title">Category</h5>
        <p class="card-text">Customize the category </p>
      	<button class="login-button" onclick="location.href='category.jsp';" formaction="GetAllCategory"  > Manage Categories </button>
 </div>

 <div class="card-body">
        <h5 class="card-title">Customer</h5>
        <p class="card-text">Customize the customers </p>
      
        <button class="login-button" formaction="customers.jsp" > View Customers </button>
              
 </div>
 
 <div class="card-body">
        <h5 class="card-title">Sales</h5>
        <p class="card-text">Track the the sales records </p>
      
      	<button class="login-button" formaction="sales.jsp" > View Sales </button>
              
      </div>
      
      
  
<div class="card-body">
        <h5 class="card-title">Product</h5>
        <p class="card-text">Customize the products</p>
 </div>
         
         <div class="dropdown">
  <button  class="dropbtn">Manage Products</button>
  <div id="myDropdown" class="dropdown-content">
    <a href="addproduct.jsp">Add Product</a>
    <a href="displayproducts.jsp">Display Products</a>

  </div>
</div>












</form>


</body>
</html>