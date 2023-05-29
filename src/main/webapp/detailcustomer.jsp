<%--
  Created by IntelliJ IDEA.
  User: trantruong193
  Date: 12/10/2022
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <tr>
            <td>Customer Id</td>
            <td>${c.cusId}</td>
        </tr>
        <tr>
            <td>Customer Name</td>
            <td>${c.cusName}</td>
        </tr>
        <tr>
            <td>Gender</td>
            <td>${c.gender?"Male":"Female"}</td>
        </tr>
        <tr>
            <td>Birthday</td>
            <td>${c.birthday}</td>
        </tr>
        <tr>
            <td>Address</td>
            <td>${c.address}</td>
        </tr>
        <tr>
            <td>Email</td>
            <td>${c.email}</td>
        </tr>
        <tr>
            <td>Telephone</td>
            <td>${c.telephone}</td>
        </tr>
    </table>
    <br>
<a href="UpdateCustomer?cusId=${c.cusId}">Update This Customer</a>
</body>
</html>
