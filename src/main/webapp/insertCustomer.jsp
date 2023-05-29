<%--
  Created by IntelliJ IDEA.
  User: trantruong193
  Date: 10/10/2022
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>${err}</h3>
    <form action="InsertCustomer" method="get">
        <table>
            <tr>
                <td>Customer Id</td>
                <td><input type="text" name="cusId"></td>
            </tr>
            <tr>
                <td>Customer Name</td>
                <td><input type="text" name="cusName"></td>
            </tr>
            <tr>
                <td>Gender</td>
                <td><input type="radio" name="gender" value="true">Male
                    <input type="radio" name="gender" value="false">Female
                </td>
            </tr>
            <tr>
                <td>Birthday</td>
                <td><input type="date" name="birthday"></td>
            </tr>
            <tr>
                <td>Address</td>
                <td><textarea name="address"></textarea></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><input type="email" name="email"></td>
            </tr>
            <tr>
                <td>Telephone</td>
                <td><input type="text" name="telephone"></td>
            </tr>
            <tr>
                <td><input type="submit" value="Insert"></td>
                <td><input type="reset" value="Resert"></td>
            </tr>
        </table>
    </form>
</body>
</html>
