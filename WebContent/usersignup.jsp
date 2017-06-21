<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Signup</title>
</head>
<body>
	<form action="UserSignupServlet" method="post">
		First Name<input type="text" name="fname"><br/>
		Last Name<input type="text" name="lname"><br/>
		Mobile Number<input type="text" name="mno"><br/>
		Email ID<input type="text" name="emailid"><br/>
		User Name<input type="text" name="username"><br/>
		Password<input type="password" name="password"><br/>
		<input type="submit" value="Sign Up"/>	
	
	
	</form>
	

</body>
</html>