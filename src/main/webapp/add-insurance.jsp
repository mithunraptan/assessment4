<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Insurence</h1>

<form action="addPolicy" method="post">
<h3>Policy name : <input type="text" name="policyName" required></input> </h3> <br>
<h3>Premium/month : <input type="text" name="premiumMonth" required></input> </h3> <br>
<h3>Duration months : <input type="text" name="durationMonth" required></input> </h3> <br>
<button type="submit">Add</button>
</form>


</body>
</html>