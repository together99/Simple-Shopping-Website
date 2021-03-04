<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="user1" class="po.User"></jsp:useBean>
<jsp:setProperty property="*" name="user1"/>
<%request.setAttribute("user", user1); %>

<%
	RequestDispatcher requestDispatcher = request.getRequestDispatcher("Login");//servlet
	requestDispatcher.forward(request, response); 
%>
</body>
</html>