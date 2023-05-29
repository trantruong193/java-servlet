<%--
  Created by IntelliJ IDEA.
  User: trantruong193
  Date: 10/10/2022
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
    <style>
        .center{
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
        }
    </style>
</head>
<body>
    <div class="center">
        <h1>List Customer</h1>
        <c:if test="${not empty success}">
            <h3 style="color: green">${success}</h3>
        </c:if>
        <c:if test="${not empty err}">
            <h3 style="color: red">${err}</h3>
        </c:if>
        <table border="1" style="text-align: center">
            <tr>
                <th>Customer ID</th>
                <th>Customer Name</th>
                <th>Gender</th>
                <th>Birthday</th>
                <th>Address</th>
                <th>Email</th>
                <th>Telephone</th>
                <th>Detail</th>
                <th>Delete</th>
            </tr>
            <c:forEach items="${list}" var="c">
                <tr>
                    <td>${c.cusId}</td>
                    <td>${c.cusName}</td>
                    <td>${c.gender?"Male":"Female"}</td>
                    <td><fmt:formatDate value="${c.birthday}" pattern="dd-MM-YYYY"></fmt:formatDate></td>
                    <td>${c.address}</td>
                    <td>${c.email}</td>
                    <td>${c.telephone}</td>
                    <td><a href="DetailCustomer?cusId=${c.cusId}">Detail Customer</a></td>
                    <td><a href="DeleteCustomer?cusId=${c.cusId}" onclick="return confirm('Sure?')">Delete Customer</a></td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <a href="insertCustomer.jsp">Add Customer</a>
    </div>

</body>
</html>
