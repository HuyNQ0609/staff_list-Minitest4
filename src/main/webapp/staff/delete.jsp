<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 3/3/2023
  Time: 3:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Deleting staff information</title>
</head>
<body>
<h1>Delete staff information</h1>
<p>
    <a href="/employees">Back to staff list</a>
</p>
<form method="post">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>Staff information</legend>
        <table>
            <tr>
                <td>Staff code: </td>
                <td>${requestScope["staff"].getStaff_code()}</td>
            </tr>
            <tr>
                <td>Name: </td>
                <td>${requestScope["staff"].getStaff_name()}</td>
            </tr>

            <tr>
                <td>ID card: </td>
                <td>${requestScope["staff"].getId_card()}</td>
            </tr>
            <tr>
                <td>Phone number: </td>
                <td>${requestScope["staff"].getPhone_number()}</td>
            </tr>
            <tr>
                <td>Address: </td>
                <td>${requestScope["staff"].getAddress()}</td>
            </tr>
            <tr>
                <td>Email: </td>
                <td>${requestScope["staff"].getEmail()}</td>
            </tr>
            <tr>
                <td>Note: </td>
                <td>${requestScope["staff"].getNote()}</td>
            </tr>
            <tr>
                <td><input type="submit" value="Delete staff"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
