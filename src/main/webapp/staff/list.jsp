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
    <title>List staff information</title>
</head>
<style>
    table tr td {
        border:2px solid black;
    }
</style>
<body>
    <h1>Employees</h1>
    <p>
        <a href="<c:url value= 'employees?action=create'/>">Create new staff</a>
    </p>
    <table style="">
        <tr>
            <td>Staff code</td>
            <td>Name</td>
            <td>ID card</td>
            <td>Phone number</td>
            <td>Address</td>
            <td>Email</td>
            <td>Note</td>
            <td>Edit</td>
            <td>Delete</td>
        </tr>
        <c:forEach items="${requestScope['employees']}" var="staff">
            <tr>
                <td>${staff.getStaff_code()}</td>
                <td><a href="<c:url value="/employees?action=view&id=${staff.getId()}"/>">${staff.getStaff_name()}</a></td>
                <td>${staff.getId_card()}</td>
                <td>${staff.getPhone_number()}</td>
                <td>${staff.getAddress()}</td>
                <td>${staff.getEmail()}</td>
                <td>${staff.getNote()}</td>
                <td><a href="<c:url value="/employees?action=edit&id=${staff.getId()}"/>">edit</a></td>
                <td><a href="<c:url value="/employees?action=delete&id=${staff.getId()}"/>">delete</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
