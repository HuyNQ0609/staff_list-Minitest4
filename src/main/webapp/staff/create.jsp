<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 3/3/2023
  Time: 3:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create new staff</title>
    <style>
        .message {
            color: green;
        }
    </style>
</head>
<body>
    <h1>Create new Staff</h1>
    <p>
        <c:if test = "${requestScope['message'] != null}">
            <span class="message">${requestScope['message']}</span>
        </c:if>
    </p>
    <p>
        <a href="/employees">Back to staff list</a>
    </p>
    <form method="post">
        <fieldset>
            <legend>Staff information</legend>
            <table>
                <tr>
                    <td>Staff code: </td>
                    <td><input type="text" name="staff_code" id="staff_code" placeholder="Enter staff code"/></td>
                </tr>
                <tr>
                    <td>Name: </td>
                    <td><input type="text" name="name" id="name" placeholder="Enter staff name"/></td>
                </tr>
                <tr>
                    <td>ID card: </td>
                    <td><input type="text" name="id_card" id="id_card" placeholder="Enter ID card"/></td>
                </tr>
                <tr>
                    <td>Phone number: </td>
                    <td><input type="text" name="phone_number" id="phone_number" placeholder="Enter phone number"/></td>
                </tr>
                <tr>
                    <td>Address: </td>
                    <td><input type="text" name="address" id="address" placeholder="Enter address"/></td>
                </tr>
                <tr>
                    <td>Email: </td>
                    <td><input type="text" name="email" id="email" placeholder="Enter email"/></td>
                </tr>
                <tr>
                    <td>Note: </td>
                    <td><input type="text" name="note" id="note" placeholder="Enter note"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Create staff"></td>
                </tr>
            </table>
        </fieldset>
    </form>
</body>
</html>
