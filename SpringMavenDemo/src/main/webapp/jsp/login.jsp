<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="authlogin.do" method="post">
		<table>
			<tr>
				<td colspan="2">Login</td>
			</tr>
			<tr>
				<td>User Name:</td>
				<td><input type="text" id="username" name="username"></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><input type="password" id="password" name="password">
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" id="submit"></td>
				<td><input type="reset" value="Reset" id="reset"></td>
			</tr>
		</table>
	</form>
</body>
</html>