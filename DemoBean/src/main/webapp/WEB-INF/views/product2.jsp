
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
 	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    

    <title>產品管理</title>
</head>
<body>
	<%@include file="navbar2.jspf" %>
    <div class="container theme-showcase" role="main">
    
      <div class="jumbotron" >    
       <h1>JACKIE CHEN 3C產品購買系統</h1>
  
     

        <p class="lead">請根據類別挑選產品</p>
      </div>

      <form type=POST action=shoppingcart.jsp>
	<div class="container">
		<div class="row">
			<br>
			<div class="col-md-12">
	
					  	
				<table class="table">
				  	<tr>
				  		<th>編號</th>
				  		<th>類別</th>
				  		<th>名稱</th>
				  		<th>描述</th>
				  		
				  		<th>定價</th>
		
				  		<th>庫存量</th>
				  		<th>圖片</th>
				  		<th>加入购物车</th>
				  	</tr>
				  	<c:forEach items="${productList}" var="product">
					  	<tr>
					  		<td>${product.id}</td>
					  		<td>${product.category}</td>
					  	     <td>${product.name}</td>
					  		<td>${product.desc}</td>
					  		<td>${product.price}</td>
				
					  		<td>${product.inventory}</td>
					  		<td>  <a class="btn btn-primary" href="viewpic?id=${product.id}">圖片</a></td>
					  		<td>
					  	<a class="btn btn-default" href="shoppingcart?id=${product.id}">add</a>
					  		</td>
					  		
					  		 	
					  	</tr>
					  
					<a class="btn btn-default" href="showcart?id=${product.id}">shoppingcart</a>
				  	</c:forEach>
				</table>

			</div>
		</div>
	</div>
	

    </div><!-- /.container -->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

</body>
</html>