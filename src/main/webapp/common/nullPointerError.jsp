<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기본 에러 화면</title>
</head>
<body>
<tabel style="width:100%; border:1">
	<tr><td align="center" bgcolor="orange"><b>기본 에러 화면입니다.</b></td></tr>
</tabel>
<br>
<table style="width: 100%; border:1">
<tr>
	<td align="center">
	<br><br><br><br><br>
	Message:${exception.message}
	<br><br><br><br><br>
	</td>
</tr>
</table>
</body>
</html>