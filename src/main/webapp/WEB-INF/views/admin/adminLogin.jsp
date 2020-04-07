<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Style Admin</title>
<link rel="stylesheet" href="css/admin.css">
<script type="text/javascript">
function admin_check()
{
  if(document.frm.id.value==""){
      alert("아이디를 입력하세요.");
      return false;
  }else if(document.frm.pwd.value==""){
     alert("비밀번호를 입력하세요.");
      return false;
    }
    return true;  
}
</script>
</head>
<body>
  <div id="wrap">
    <header>      
      <div id="logo">
        <img src="admin/images/bar.jpg" style="float:left">
      </div>      
    </header>
    <div class="clear"></div>
    <article>
      <div id="loginform">
      <form name="frm" method="post" action="admin_login">
      <table>
        <tr>
          <td> 아 이 디 </td>
          <td> <input type="text" name="id" size="10"></td>
        </tr>
        <tr>
          <td> 비밀번호 </td>
          <td> 
            <input type="password" name="pwd" size="10">
          </td>
        </tr>
        <tr align="center" >
          <td  colspan="2">
            <input class="btn" type="submit" value="업무 로그인" onclick="return admin_check()">
            <input type="button" value="홈으로" class="btn"onclick="location.href='index'"><br><br>
            <h4 style="color:red">${message}</h4>
          </td>
        </tr>
      </table>
      </form>
      </div>
    </article>
<%@ include file="footer.jsp" %>  

