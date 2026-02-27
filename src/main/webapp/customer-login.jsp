<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>customer login page</h1>
<form action="customerLogin" method="post">
    Username:
    <input type="text" name="userName" required>
    <br><br>

    Password:
    <input type="password" name="password" required>
    <br><br>

    <button type="submit">Login</button>
</form>

<br><br>

<p>
    New user?
    <a href="signup.jsp">Signup here</a>
</p>
</body>
</html>