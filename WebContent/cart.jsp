<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="po.*,dao.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="" style="background-color: pink;text-align: center;">
			<span style="font-size: 40px;">我的购物车</span>
		</div>
		<hr >
		<div id="" style="margin: auto;text-align: center;">
			<table border="1" cellspacing="0" cellpadding="0" style="text-align: center;margin: auto;">
				<tr>
					<td>商品</td>
					<td>商品名称</td>
					<td>&nbsp;&nbsp;商品单价&nbsp;&nbsp;</td>
					<td>&nbsp;&nbsp;商品价格&nbsp;&nbsp;</td>
					<td>&nbsp;&nbsp;购买数量&nbsp;&nbsp;</td>
					<td>&nbsp;&nbsp;操作&nbsp;&nbsp;</td>
				</tr>
<%
if(session.getAttribute("cart") == null) {
	Cart cart=new Cart();
	session.setAttribute("cart", cart);
}
	Cart cart=(Cart) session.getAttribute("cart");
	session.setAttribute("cart", cart);
	int userId=(int)session.getAttribute("userId");
	session.setAttribute("userId", userId);
	if(cart == null){
		out.println("购物车为空");
	}else{
		HashMap<Goods, Integer> cgoods=cart.getCGoods();
		double totalPrice=cart.getTotalPrice();
		for(Goods key:cgoods.keySet()) {
%>
<tr>
		<td>
			<div id="" style="text-align: center;">
				<img src=<%=key.getPicname() %> style="height: 200px;">
			</div>
		</td>
		<td><%=key.getName() %></td>
		<td>￥<%=key.getPrice() %></td>
		<td>￥<%=key.getPrice()*cgoods.get(key) %></td>
		<td><%=cgoods.get(key) %>件</td>
		<td><a href="CartSer?action=delete&id=<%=key.getId() %>">删除</a></td>
</tr>
<% 
			
		}
		
	}
	
%>
	</table>
	<div id="" style="margin: auto;color: red;font-size: 30px;">
		总价：￥<%=cart.getTotalPrice() %>
	</div>
<!-- 
	<div id="" style="margin: auto;color: red;font-size: 25px;margin-top: 20px;">
		<a href="showgoods.jsp">返回商品首页</a>
		<a href="OrderSev?operation=submitOrders">加入订单</a>
		<a href="OrderSev?operation=showUserOrders">查看订单</a>
	</div>
 -->
		</div>
	
</body>


</html>