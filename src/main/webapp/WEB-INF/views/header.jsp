<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Style</title>
  <link href="css/shopping.css" rel="stylesheet">  
  <script type="text/javascript" src="js/member.js"></script>
  <script type="text/javascript" src="js/detail.js"></script> 
</head>

<body>
<div id="wrap">
  <header>
    <div id="logo">
      <a href="index">
        <img src="images/logo.jpg" width="180" height="100" alt="style">
      </a>  
    </div>
    
    <nav id="catagory_menu">
     <ul>
       <c:choose>
       <c:when test="${empty sessionScope.loginUser}">
       <li>         
         <a href="login_form" style="width:80px;">LOGIN</a>
         <a href="admin_login_form" style="width:100px;">(ADMIN LOGIN)</a>
	   </li>	       
       <li>/</li>
       <li><a href="contract">JOIN</a></li>
       </c:when>
       <c:otherwise>
       <li style="color:black">
         ${sessionScope.loginUser.name}(${sessionScope.loginUser.id})님 반갑습니다!
       </li>
       <li><a href="logout">LOGOUT</a></li>
       </c:otherwise>       
       </c:choose>
       <li>/</li>
       <li>
         <a href="cart_list">CART</a>
       </li><li>/</li>
       <li>
         <a href="mypage">MY PAGE</a>
       </li><li>/</li>
       <li>
         <a href="qna_list">Q&amp;A(1:1)</a>
       </li>
     </ul>
    </nav>

    <nav id="top_menu">
      <ul>
        <li>
          <a href="category?kind=1">TOP</a>
        </li>  
        <li>
          <a href="category?kind=2">PANTS</a>
        </li>  
        <li>
          <a href="category?kind=3">OUTER</a>
        </li> 
        <li>
          <a href="category?kind=4">OPS/SKIRT</a>
        </li> 
        <li>
          <a href="category?kind=5">JEWELRY</a>
        </li>  
      </ul>
    </nav>
    <div class="clear"></div>
    <hr>
  </header>
