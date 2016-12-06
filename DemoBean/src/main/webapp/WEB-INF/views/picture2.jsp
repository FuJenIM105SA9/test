
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

 <input type="hidden" name = "id" value="${product.id}">
  
    <img src="resources\fileUpload\<c:out value="${product.id}"/>.jpg" width="50%">
    	<a class="btn btn-primary" href="return2?id=${product.id}">返回</a>
</body>
</html>