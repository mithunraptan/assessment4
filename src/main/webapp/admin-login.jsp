<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>admin login page</h1> <br><br>

<%
    String error = (String) request.getAttribute("errorMessage");
    if (error != null) {
%>
    <p style="color:red;"><%= error %></p>
<%
    }
%>
<form action="adminLogin" method="post">
    Username:
    <input type="text" name="userName" required>
    <br><br>

    Password:
    <input type="password" name="password" required>
    <br><br>

    <button type="submit">Login</button>
</form>


</body>
</html>