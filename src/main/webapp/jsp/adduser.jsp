<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="fm" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'adduser.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  		<fm:form action="${pageContext.request.contextPath }/user/addUser.do" method="post" modelAttribute="user" enctype="multipart/form-data">
  			<table>
  				<tr>
  					<td>用户编号</td>
  					<td><fm:input path="userCode"/> </td>
  					<td><fm:errors path="userCode"  /></td>
  				</tr>
  				<tr>
  					<td>用户姓名</td>
  					<td><fm:input path="userName"/> </td>
  					<td><fm:errors path="userName"  /></td>
  				</tr>
  				<tr>
  					<td>用户密码</td>
  					<td><fm:input path="userPassword"/> </td>
  					<td><fm:errors path="userPassword"  /></td>
  				</tr>
  				<tr>
  					<td>用户性别</td>
  					<td><fm:select path="gender" items="${genders }" ></fm:select></td>
  					<td><fm:errors path="gender"  /></td>
  				</tr>
  				<tr>
  					<td>出生日期</td>
  					<td><input type="date" name="birthday"> </td>
  					<td><fm:errors path="birthday"  /></td>
  				</tr>
  				<tr>
  					<td>用户电话</td>
  					<td><fm:input path="phone"/> </td>
  					<td><fm:errors path="phone"  /></td>
  				</tr>
  				<tr>
  					<td>用户地址</td>
  					<td><fm:input path="address"/> </td>
  					<td><fm:errors path="address"  /></td>
  				</tr>
  				<tr>
  					<td>用户角色</td>
  					<td>
  						<fm:radiobuttons path="userRole" items="${roles }" />
  					</td>
  					<td><fm:errors path="userRole"  /></td>
  				</tr>
  				<tr>
  					<td>用户照片</td>
  					<!-- <td><input type="file" name="photo" /></td> -->
  					<td>
  						<input type="file" name="photos" /><br />
  						<input type="file" name="photos" />
  					</td>
  					<td>${errors }</td>
  				</tr>
  				<tr>
  					<td colspan="3">
  						<input type="submit" value="保存">
  					</td>
  				</tr>
  			</table>
  		</fm:form>
  </body>
</html>
