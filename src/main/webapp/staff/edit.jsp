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
    <title>Editing staff information</title>
</head>
<body>
<h1>Edit staff information</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
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
                <td><input type="text" name="staff_code" id="staff_code" placeholder="Enter staff code"
                            value="${requestScope['staff'].getStaff_code()}"/></td>
            </tr>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="name" id="name" placeholder="Enter staff name"
                            value="${requestScope['staff'].getStaff_name()}"/></td>
            </tr>
            <tr>
                <td>ID card: </td>
                <td><input type="text" name="id_card" id="id_card" placeholder="Enter ID card"
                            value="${requestScope['staff'].getId_card()}"/></td>
            </tr>
            <tr>
                <td>Phone number</td>
                <td><input type="text" name="phone_number" id="phone_number" placeholder="Enter phone number"
                            value="${requestScope['staff'].getPhone_number()}"/></td>
            </tr>
            <tr>
                <td>Address: </td>
                <td><input type="text" name="address" id="address" placeholder="Enter address"
                            value="${requestScope['staff'].getAddress()}"/></td>
            </tr>
            <tr>
                <td>Email: </td>
                <td><input type="text" name="email" id="email" placeholder="Enter email"
                            value="${requestScope['staff'].getEmail()}"/></td>
            </tr>
            <tr>
                <td>Note: </td>
                <td><input type="text" name="note" id="note" placeholder="Enter note"
                            value="${requestScope['staff'].getNote()}"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Update staff"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
