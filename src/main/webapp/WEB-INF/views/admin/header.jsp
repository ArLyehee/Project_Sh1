<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Page</title>
<link rel="stylesheet" href="css/admin.css">
<script type="text/javascript" src="js/product.js"></script>

</head>
<body onload="go_ab()">
	<div id="wrap">
		<header>			
			<div id="logo">
				<a href="admin_login_form"> 
					<img style="width:800px"  src="admin/images/bar.jpg">
        			<img src="admin/images/text.jpg">
				</a>
			</div>

			<input class="btn" type="button"  value="logout"  style="float: right;"
			   onClick="location.href='admin_logout'">			
		</header>
		<div class="clear"></div>