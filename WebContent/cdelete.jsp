<%@page import="po.Goods"%>
<%@page import="po.Cart"%>
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
	Cart cart=(Cart)session.getAttribute("cart");
	Goods goods=(Goods)session.getAttribute("dele");
	if(cart == null ){
		System.out.print("it is kong ");
		System.out.print("Goods: "+goods);
	}else{
		if(cart.removeGoods(goods)){
			out.println("<script type=\"text/javascript\">");
			out.println("alert(\"删除成功\");");
			out.println("</script>");
			System.out.print("删除成功 ");
			request.getRequestDispatcher("CartSer?action=show").forward(request, response);
		}else{
			out.println("<script type=\"text/javascript\">");
			out.println("alert(\"删除失败\");");
			out.println("</script>");
			System.out.print("删除失败 ");
			request.getRequestDispatcher("CartSer?action=show").forward(request, response);
		}
	}
	
%>
</body>
</html>