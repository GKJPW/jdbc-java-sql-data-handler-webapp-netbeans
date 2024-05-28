<%-- 
    Document   : ViewUsers
    Created on : May 28, 2024, 9:52:54 AM
    Author     : GKJPW
--%>

<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>User List</title>
</head>
<body>
    <h1>User List</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
        </tr>
        <% 
            ResultSet rs = (ResultSet) request.getAttribute("resultSet");
            while (rs != null && rs.next()) {
        %>
        <tr>
            <td><%= rs.getInt("ID") %></td>
            <td><%= rs.getString("Name") %></td>
            <td><%= rs.getString("Email") %></td>
        </tr>
        <% } %>
    </table>
</body>
</html>

