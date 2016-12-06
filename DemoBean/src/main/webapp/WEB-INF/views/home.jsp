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

      </div>
<body>
      <form action="login" method="post" role="form">
			<div class="form-group">
			<label>帳號:</label>
			<input type="text" name="username">
			<p class="help-block">使用者帳號</p>
			</div>
			<div class="form-group">
			<label>密碼:</label>
			<input type="password" name="password">
			<p class="help-block">使用者密碼</p>
			</div>
	  		<button type="submit" class="btn btn-default">登入</button>
	  		<label class="label label-warning">${message} ${account.username}</label>

		</form> 
</body>
</html>