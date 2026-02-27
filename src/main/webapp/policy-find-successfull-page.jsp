<%@page import="com.training.entity.InsurancePolicy"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>policy found</h1>

<%
  InsurancePolicy isp = (InsurancePolicy)request.getAttribute("insurancePolicy");
%>
<h3>Name: <%= isp.getPolicyName() %> </h3> 
<h3>Duration Month: <%= isp.getDurationMonth() %> </h3> 
<h3>Premium / Month : <%=isp.getPremiumMonth() %></h3>

<a href="insurance-add-delete-find.jsp"> go to controller page </a>







</body>
</html>