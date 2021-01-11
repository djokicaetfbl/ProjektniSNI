
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Log In</title>
	</head>
	<body>
		<h1 style="background-color:powderblue; text-align: center;">Log In</h1>
		
		<form action="j_security_check" method="POST" style="text-align: center;">
		<label style="text-align: left;">Korisni&#269;ko ime</label></label><br /> <input type="text" name="j_username"> <br />
		<label style="text-align: left;">Lozinka</label> <br /> <input type="password" name="j_password"> <br /> <br />
		<input type="submit" id="login" value="Log In" style="background-color: #4CAF50; font-size: 20px; border-radius: 6px; width: 180px;">
		<h3><%=session.getAttribute("notification")!=null?session.getAttribute("notification").toString():""%></h3> <br />
		</form>
	</body>
</html>