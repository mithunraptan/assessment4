<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.training.util.JPAUtil" %>
<%@ page import="javax.persistence.EntityManager" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="java.util.List" %>
<%@ page import="com.training.entity.InsurancePolicy" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Dashboard</title>
</head>
<body>

<h1>Customer Insurance Dashboard</h1>

<form action="logoutCustomer" method="post" style="float:right;">
    <button type="submit">Logout</button>
</form>


<%
    HttpSession sessionObj = request.getSession(false);
    String username = (String) sessionObj.getAttribute("userName");

    EntityManager em = JPAUtil.getEntityManager();

    // Purchased policies
    List<InsurancePolicy> purchasedPolicies =
        em.createQuery(
            "SELECT p FROM InsurancePolicy p WHERE p.user.name = :name",
            InsurancePolicy.class)
          .setParameter("name", username)
          .getResultList();

    // Available policies
    List<InsurancePolicy> availablePolicies =
        em.createQuery(
            "SELECT p FROM InsurancePolicy p WHERE p.user IS NULL",
            InsurancePolicy.class)
          .getResultList();
%>

<!--PURCHASED-->

<h2>Your Purchased Policies</h2>

<table border="1">
<thead>
<tr>
    <th>Policy Name</th>
    <th>Premium</th>
    <th>Duration</th>
</tr>
</thead>

<tbody>
<%
if(purchasedPolicies != null && !purchasedPolicies.isEmpty()){
    for(InsurancePolicy p : purchasedPolicies){
%>
<tr>
    <td><%= p.getPolicyName() %></td>
    <td><%= p.getPremiumMonth() %></td>
    <td><%= p.getDurationMonth() %></td>
    <td>
    <a href="customerDeletePolicy?id=<%= p.getId() %>">
            <button>Delete Policy</button>
        </a>
   	</td>
    
</tr>
<%
    }
}else{
%>
<tr>
    <td colspan="3">No policies purchased yet</td>
</tr>
<%
}
%>
</tbody>
</table>


<br><br>

<!--AVAILABLE-->

<h2>Buy More Policies</h2>

<table border="1">
<thead>
<tr>
    <th>Policy Name</th>
    <th>Premium</th>
    <th>Duration</th>
    <th>Action</th>
</tr>
</thead>

<tbody>
<%
for(InsurancePolicy p : availablePolicies){
%>

<tr>
    <td><%= p.getPolicyName() %></td>
    <td><%= p.getPremiumMonth() %></td>
    <td><%= p.getDurationMonth() %></td>

    <td>
        <a href="buyPolicy?id=<%= p.getId() %>">
            <button>Add Policy</button>
        </a>
    </td>
</tr>

<%
}
%>
</tbody>
</table>

</body>
</html>