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
<div>
<div class="head"><span><h1>類別</h1></span></div>
<div class="la1"><a href="movie">電影</a></div>

<div class="la2"><a href="opera">電視劇</a></div>

<div class="la3"><a href="cartoon">卡通動畫</a></div>

<div class="la4"><a href="art">藝術賞析</a></div>

<div class="la5"><a href="music">流行音樂</a></div>
</div>
 <div>
<div class="head"><span><h1>根據片名 搜尋</h1></span></div>    
<div class="row">

	<div class="col-md-3">
<form method="post" action="search" id="searchForm">

<div class="form-group">
<input type="text" name="search" placeholder="輸入關鍵字" required>	
</div>
<div class="form-group">
<button type="submit" class="btn btn-default">搜尋</button>
</div>

</form>
   </div>
    </div><!-- /.container -->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

</body>
</html>