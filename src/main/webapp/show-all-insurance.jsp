<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    %>
<%@ page import="com.training.util.JPAUtil" %>
<%@ page import="javax.persistence.EntityManager" %>
<%@ page import="java.util.List" %>
<%@page import="com.training.entity.InsurancePolicy"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>here we will show all the insurace in tabular form</h1>
	<table border="1">
		<thead>
			<tr>
			<td>Policy Name</td>
			<td>Policy Premium</td>
			<td>Policy duration/month</td>
			</tr>
		
		</thead>
<%
		EntityManager em = JPAUtil.getEntityManager();
		List<InsurancePolicy> listOfPolicy = em.createQuery("From InsurancePolicy", InsurancePolicy.class).getResultList();
		if(listOfPolicy!=null){
			for(InsurancePolicy policies : listOfPolicy){
				
			
%>

		<tbody>
		<tr>
		<td><%=policies.getPolicyName() %></td>
		<td><%=policies.getPremiumMonth() %></td>
		<td><%=policies.getDurationMonth() %></td>
		
		</tr>
		</tbody>
	


<%}} %>
	</table>

</body>
</html>