<%--
  Created by IntelliJ IDEA.
  User: trantruong193
  Date: 12/10/2022
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>${err}</h3>
<form action="PreUpdate" method="get">
    <table>
        <tr>
            <td>Customer Id</td>
            <td><input type="text" name="cusId" value="${c.cusId}"></td>
        </tr>
        <tr>
            <td>Customer Name</td>
            <td><input type="text" name="cusName" value="${c.cusName}"></td>
        </tr>
        <tr>
            <td>Gender</td>
            <td><input type="radio" name="gender" value="true" ${c.gender?"checked":""}>Male
                <input type="radio" name="gender" value="false" ${!c.gender?"checked":""}>Female
            </td>
        </tr>
        <tr>
            <td>Birthday</td>
            <td>
                <input type="date" name="birthday"  value='<fmt:formatDate value="${c.birthday}" pattern="yyyy-MM-dd"/>'/></td>
            </td>
        </tr>
        <tr>
            <td>Address</td>
            <td><textarea name="address">${c.address}</textarea></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="email" name="email" value="${c.email}"></td>
        </tr>
        <tr>
            <td>Telephone</td>
            <td><input type="text" name="telephone" value="${c.telephone}"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Insert"></td>
            <td><input type="reset" value="Resert"></td>
        </tr>
    </table>
</form>
</body>
</html>
