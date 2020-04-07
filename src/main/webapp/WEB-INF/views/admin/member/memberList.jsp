<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="../sub_menu.jsp"%>
<script type="text/javascript">
  function go_search()
  {
     document.frm.action="admin_member_list";
     document.frm.submit();
  }
</script>

<article>
<h1>회원리스트</h1>  
<form name="frm" method="post">
<table style="float:right; ">
  <tr>
  <td> 
  회원 이름
  <input type="text" name="key">
  <input class="btn" type="button" value="검색" onclick="go_search()">
  </td>
  </tr>
</table>  
<br>
<table id="orderList">
  <tr>
    <th> 아이디(탈퇴여부) </th>    <th> 이름 </th>
    <th> 이메일 </th>             <th> 우편번호 </th>  
    <th> 주소 </th>  <th> 전화 </th>  <th> 가입일 </th>
  </tr>
  <c:forEach items="${userMemberList}" var="userMemberVO">  
  <tr>
    <td>${userMemberVO.id} 
    <c:choose>
      <c:when test='${userMemberVO.useyn=="y"}'>
        <input type="checkbox" name="useyn" disabled="disabled">
      </c:when>
      <c:otherwise>
        <input type="checkbox" name="useyn" 
checked="checked" disabled="disabled">
      </c:otherwise>
    </c:choose>
    </td>
    <td> ${userMemberVO.name} </td>
    <td> ${userMemberVO.email} </td> 
    <td> ${userMemberVO.zip_num} </td>
    <td> ${userMemberVO.address} </td>
    <td> ${userMemberVO.phone} </td> 
    <td> <fmt:formatDate value="${userMemberVO.indate}"/></td>
  </tr>
  </c:forEach>
</table>
</form>
</article>
<%@ include file="../footer.jsp"%>
</body>
</html>