<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<form action="RegisteServlet" method="post">
			<!-- 账号： <input type="text" name="username" />
			密码：<input type="password" name="password" /> 
			确认密码：<input type="password" name="psw_comfirm" /> 
				<input type="submit" value="注册" />
				<input type="reset" value="重置" /> -->
		<tr>
			<td>账号：</td>
			<td><input type="text" name="username" /></td>
		</tr>
		<tr>
			<td>密码：</td>
			<td><input type="password" name="password" /> </td>
		</tr>
		<tr>
			<td>确认密码：</td>
			<td><input type="password" name="psw_comfirm" /> </td>
		</tr>
		<tr>
			<td><input type="submit" value="注册" /></td>
			<td><input type="reset" value="重置" /></td>
		</tr>
			</form>
	</table>
</body>
</html>