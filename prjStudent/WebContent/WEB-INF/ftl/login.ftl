<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="${rc.contextPath}/css/style.css" rel="stylesheet" />
<script src="js/script.js"></script>
<script src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
<script type="text/javascript">
	$("document").ready(function(){
		$("#submit").click(function(){
			var username = $("#username").val();
			var msg = '';
			var password= $("#password").val();			
			if(password.length==0){
			msg = "Password can not be blank";			
			}			
			if(username.length==0){
				msg = "User Name can not be blank"						
			}		
			if(msg.length!=0){
			$("#errormsg").html(msg);
			return false;	
		}
			});

		$("#reset").click(function(){
			$("#errormsg").html('');
			});
		
		});

	</script>
</head>
<body>
	<div id="loginContainer">
		<h3 align="center">Login</h3>
		<hr />
		<form action="${rc.contextPath}/j_spring_security_check" method="post">
			<table>
				<tr>
					<td>UserName:</td>
					<td><input type="text" name="j_username" id="username" />
					</td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="j_password" id="password" />
					</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td id="margin5"><input type="submit" value="Submit"
						id="submit" />&nbsp;&nbsp;<input type="reset" value="Reset"
						id="reset" />
					</td>
				</tr>
				<tr>
					<td colspan="2"><div id="errormsg"></div>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>