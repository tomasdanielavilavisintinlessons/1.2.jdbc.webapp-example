<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Users</h2>
<ul>
<% for(String user : (List<String>) request.getAttribute("users")) {%>
<li><%= user %></li>
<% } %>
</ul>
</body>
</html>