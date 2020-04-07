<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="../sub_menu.jsp"%>

<article>
<h1>상품등록</h1>  
<!-- [1] 파일을 업로드 하기 위해서는 폼태그를 post 방식으로 전송하고,
인코딩 타입을 multipart/form-data 로 지정해야 한다. -->
<form name="frm" method="post" enctype="multipart/form-data">
<table id="list">
<tr>
  <th>상품분류</th>
  <td colspan="5">
  <select name="kind">
      <option value="1">TOP</option>
      <option value="2">PANTS</option>
      <option value="3">OUTER</option>
      <option value="4">OPS/SKIRT</option>
      <option value="5">JEWELRY</option>
  </select>      
<tr>
  <th>상품명</th>
  <td width="343" colspan="5">
       <input type="text" name="name" size="47" maxlength="100">
  </td>
</tr>
<tr>
  <th>원가[A]</th>
  <td width="70">
    <input type="text" name="price1" size="11" onKeyUp='NumFormat(this)' value="10000">
  </td>
  <th>판매가[B]</th>
  <td width="70">
     <input type="text" name="price2" size="11" onBlur="go_ab()" onKeyUp='NumFormat(this)' value="20000">
  </td>
  <th>[B-A]</th>
    <td width="72">
      <input type="text" name="price3" size="11" readonly onKeyUp='NumFormat(this)'>
    </td>
  </tr>
    
  <tr>
    <th>상세설명</th>
    <td colspan="5">
      <textarea name="content" rows="8" cols="70" >이뻐요</textarea>
    </td>
  </tr>
  <tr>
    <th>상품이미지</th>
    <td width="343" colspan="5">
<!--  [2] 파일 업로드를 하기 위한 input 태그는 타입 속성 값을 file로 지정해야 한다.  -->
      <input type="file" name="upload">
    </td>
  </tr>    
</table>
<input class="btn" type="button" value="등록" onClick="go_save()">           
<input class="btn" type="button" value="취소" onClick="go_mov()">
</form> 
</article>
<%@ include file="../footer.jsp"%>
</body>
</html>