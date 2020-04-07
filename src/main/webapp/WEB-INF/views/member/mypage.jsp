<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<div align="center">
<h2>회원 정보</h2>
<form action="updateUser" method="post" name="frm">
  <div id="mypage">
	<table>
		<tr>
			<th>ID</th>
			<td><input type="text" name="id" value="${loginUser.id}" readonly="readonly"></td>
		</tr>
		<tr>
			<th>회원 이름</th>
			<td><input type="text" name="name" value="${loginUser.name}"size="10" readonly="readonly"></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><input type="text" name="email" value="${loginUser.email}"></td>
		</tr>
		<tr>
			<th>주소</th>
			<td><input type="text" name="address" value="${loginUser.address}" size="80"></td>
		</tr>
		<tr>
			<th>세부 주소</th>
			<td><input type="text" name="address2" value="${loginUser.address2}"></td>
		<td>
		<tr>
			<th>전화번호</th>
			<td><input type="text" name="phone" value="${loginUser.phone}"></td>
		</tr>
	</table>
	<br><br>
	</div>
	<input type="submit" value="수정하기" class="submit">
	<input type="button" value="홈으로" class="cancel"onclick="location.href='index'">
</form>
