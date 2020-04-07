<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@ include file="../header.jsp" %>   
<%@ include file="sub_img.html"%> 
<%@ include file="sub_menu.html" %>   
  <article>
    <h2>Join Us</h2>
    <form id="join" action="join" method="post" name="formm">
     <div id="join_form">
      <fieldset>
        <legend>Basic Info</legend>
        <ul>
        	<li>
		        <label>User ID</label>
		        <input type="text" name="id" size="12">
		        <input type="hidden" name="reid">
		        <input type="button" value="중복 체크"  class="dup" onclick="idcheck()"><br>
		    </li>
		    <li>
		        <label>Password</label> 
		        <input type="password"  name="pwd"><br> 
		    </li>
		    <li>
		        <label>Password Check</label> 
		        <input type="password"  name="pwdCheck"><br> 
		    </li>
		    <li>
		        <label>Name</label>
		        <input type="text" name="name"><br> 
		    </li>
		    <li>
		        <label>E-Mail</label>
		        <input type="text" name="email"><br>
		    </li>
       </ul> 
      </fieldset>
      <fieldset>
		<legend>Optional</legend>
			<ul id="adress">
				<li>
			        <label>Zip Code</label> 
			        <input type="text" name="zip_num" size="10" >      
			        <input type="button" value="주소 찾기" class="dup" onclick="post_zip()"><br>
			    </li>
			    <li>
			        <label>Address</label> 
			        <input type="text" name="addr1" size="40">
			        <input type="text" name="addr2" size="25"> <br>
			    </li>
			    <li>
			        <label>Phone Number</label> 
			        <input type="text" name="phone"><br>
			    </li>
			</ul>
      </fieldset>
     </div>
      <div class="clear"></div>
      <div id="buttons">
        <input type="button" value="회원가입" class="submit" onclick="go_save()"> 
        <input type="reset"  value="취소"     class="cancel">
      </div>
    </form>
  </article>
<%@ include file="../footer.jsp" %>
  