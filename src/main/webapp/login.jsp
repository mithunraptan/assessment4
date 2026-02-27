<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

<h2>Welcome! Please choose your login role</h2>

<h3>Admin :  <a href="admin-login.jsp"> Click here </a></h3>
<h3>Customer : <a href="customer-login.jsp"> Click here </a></h3>

















































<%-- 
<%
    String error = (String) request.getAttribute("errorMessage");
    if (error != null) {
%>
    <p style="color:red;"><%= error %></p>
<%
    }
%>

<form action="login" method="post">
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
</html> --%>