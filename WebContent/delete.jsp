<%@page import="po.Cart"%>
<%@page import="dao.GoodsDao"%>
<%@page import="po.Goods"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>

<%
	String sid = request.getParameter("id");
	Cart cart=(Cart)session.getAttribute("cart");
	int id = Integer.parseInt(sid);
	Goods goods=GoodsDao.findGoodsById(id);
	session.setAttribute("dele", goods);
	session.setAttribute("cart", cart);
	
%>

<div id="" style="margin: auto;text-align: center;">
			<div id="">
				<img src=<%=goods.getPicname() %> style="height: 200px;">
			</div>
			<div id="">
				<span><%=goods.getName() %></span>
			</div>
			<br>
			<div id="" style="font-size: 20px;">
				<span>确定要删除该商品？</span>
			</div>
			<div id="" style="font-size: 20px;">
				<button type="button"><a href="cdelete.jsp">确定</a></button>
				<button type="button"><a href="cart.jsp">取消</a></button>
			</div>
</div>

</body>
</html>