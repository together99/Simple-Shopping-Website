<%@page import="dao.GoodsDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,po.Goods,dao.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
			#num{
				width: 30px;
				height: 20px;
			}
			#sub{
				height: 25px;
			}
			#plus{
				height: 25px;
			}
</style>
<script type="text/javascript" src="js/lhgcore.js"></script>
<script type="text/javascript" src="js/lhgdialog.js"></script>
<script type="text/javascript">
			var num = 1;
			function Sub(){
				num=document.getElementById("num").value;
				num--;
				if(num < 0){
					num = 0;
				}
				var innum=document.getElementById("num");
				innum.value=num;
			}
			function Plus(){
				num=document.getElementById("num").value;
				num++;
				if(num < 0){
					num = 0;
				}
				var innum=document.getElementById("num");
				innum.value=num;
			}
			function selflog_show(id){
				var num=document.getElementById("num").value;
				
				J.dialog.get({
					id:'haoyue_creat',
					title:'购物成功',
					width:600,
					height:400,
					link:'../CartSer?id='+id+'&num='+num+'&action=add',
					cover:true
				});
			}
</script>
</head>
<body>
<% 
	Goods item = GoodsDao.findGoodsById(Integer.parseInt(request.getParameter("id"))); 
	int userId=(int)session.getAttribute("userId");
	session.setAttribute("userId", userId);
%> 
	<div id="" style="background-color: aqua;text-align: center;font-size: 40px;float: none;">
			商品详情
	</div>
		<hr >
		<div id="" style="width: 880px;float: left;">
			<table border="0" cellspacing="0" cellpadding="0" style="margin: auto;">
				<tr>
					<td rowspan="4"><img src="<%=item.getPicname() %>" style="height: 350px;"></td>
					<td>&nbsp;&nbsp;</td>
					<td>
						<div id="" style="background-color: aqua;font-size: 30px;">
							<%=item.getName() %>
						</div>
					</td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;</td>
					<td>
						<div id="" style="background-color: aqua;font-size: 30px;">
							发货地：<%=item.getCity() %>
						</div>
					</td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;</td>
					<td>
						<div id="" style="background-color: aqua;font-size: 30px;color: red;">
							闪购价：￥<%=item.getPrice() %>
						</div>
					</td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;</td>
					<td>
						<div id="" style="background-color: aqua;font-size: 30px;">
							库存：<%=item.getScoke() %>件
						</div>
					</td>
				</tr>
			</table>
			<div class="" style="text-align: center;margin-bottom: 15px;">
				<span style="font-size: 25px;">购买数量：</span>
				<input type="button" name="" id="sub" value="-" onclick="Sub()"/>
				<input type="text" name="num" id="num" value="1" />
				<input type="button" name="" id="plus" value="+" onclick="Plus()"/>
			</div>
			
			<div id="" style="text-align: center;">
				<a href="javascript:selflog_show(<%= item.getId()%>)"><img src="images/in_cart.png" ></a>
				&nbsp;&nbsp;&nbsp;
				<a href="CartSer?action=show"><img src="images/view_cart.jpg" ></a>
			</div>
		</div>
<!--  
		<div id="" style="float: left; margin-left: 200px;margin-top: 50px;border: rgb(7,188,252) 2px solid;">
			<div id="" style="text-align: center;">
				&nbsp;&nbsp;最近浏览商品&nbsp;&nbsp;
			</div>
			<hr >
         
          <% 
             
              //从客户端获得Cookies集合 
              
              //遍历这个Cookies集合"ListViewCookie"
             
              //加上刚刚浏览的这个商品的id
              
              //如果浏览记录超过100条，清零.
              
             //写回到cookie中
             Cookie[] cookies=request.getCookies();
          	int n=0;
			if(cookies != null) {
				for(Cookie co:cookies) {
					String name=co.getName();
					String value=co.getValue();
					System.out.println("name:"+name);
					System.out.println("value:"+value);
					if(!"JSESSIONID".equals(name)){
						n++;
						int id=Integer.parseInt(value);
						Goods one = GoodsDao.findGoodsById(id);
			%>
			<div id="" style="text-align: center;margin-bottom: 40px;">
				<div id="">
					<a href="goodsDetail.jsp?id=<%=one.getId() %>"><img src=<%=one.getPicname() %> style="width: 300px;"></a>
				</div>
				<div id="">
					<%=one.getName() %>
				</div>
				<div id="" style="color: red;">
					闪购价:￥<%=one.getPrice() %>
				</div>
			</div>
			
			<% 
					}
				
				}
			}
			if(n == 0){
				out.println("***** 这里空空如也 *****");
			}
				
		
			
			String sid=String.valueOf(item.getId());
			Cookie cookie=new Cookie(sid, sid);
			//设置时间 单位 秒
			cookie.setMaxAge(180);
			//写回到客户端
			response.addCookie(cookie);
          %>
    </div>  
-->   
</body>
</html>