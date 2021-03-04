<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>京东商城</title>
<link rel="stylesheet" type="text/css" href="style.css"/>
<script type="text/javascript">
	function checkform(){
		var username = document.getElementById("username").value;
		var password = document.getElementById("password").value;
		var check = document.getElementById("myid").value;
		if(username == ""){
			window.alert("用户名不能为空！");
			return false;
		}
		if(password == ""){
			window.alert("密码不能为空！");
			return false;
		}
		if(check == ""){
			window.alert("验证码不能为空！");
			return false;
		}	
	
		
}
	function setTitle(){
		var title=document.title;
		var start=title.substr(0,1);
		var end=title.substr(1);
		document.title=end+start;
	}
	setInterval(setTitle,1000);		
</script>

</head>
<body>
<div class="content">
           <form action="daoUser.jsp" method="post" class="login-form" onsubmit="return checkform()">
               <div class="username">
                   <input type="text" name="username" id="username" placeholder="admin" autocomplete="on" />
                   <span class="user-icon icon">u</span>
               </div>
               <div class="password">
                   <input type="password" name="password" id="password" placeholder="***" />
                   <span class="password-icon icon">p</span>
               </div>
			   <div class="check">
			       <input type="text" name="check" id="myid" placeholder="Validate code" />
			       
			      	<img alt="图片" src="CheckServ">
			   </div>
			   
               <div class="account-control">
                   <button type="submit" >登录</button>
               </div>
               <p class="not-registered"><a href="RegIndex">现在注册</a></p>
           </form>
</div>
<!-- 
<div class="welcome">
	<p>登录京东  购物轻松</p>
</div>
 -->
</body>
</html>