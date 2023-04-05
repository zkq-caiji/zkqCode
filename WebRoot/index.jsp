<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

	<title>登录</title>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
	<style type="text/css">
		<!--
		#Layer1 {
			position:absolute;
			width:610px;
			height:52px;
			z-index:1;
			left: 179px;
			top: 243px;
		}
		-->
	</style>
</head>
<body>

	<!-- 登录body -->
	<div>
		<div>
			<!-- 头部提示信息 -->
			<div >
				<p >练习系统</p>
			</div>
			<!-- 输入框 -->
			
			<form name="login" method="post" action="login?action=login">
				<div>
					<input type="text" id="username" name="username" placeholder="输入用户名" />
				</div>
				<div >
					<input  placeholder="输入用户密码" name="pwd" type="password" id="pwd" />
				</div>
			 	<div >身份:&nbsp;&nbsp;
			 		<select name="status" id="cx" style="width:170px; height:40px;">
			            <option value="admin">管理员</option>
						<option value="teacher">教师</option>
						<option value="student">学生</option>
	         		</select>
	          	</div>
				<div > 
					<input name="login" type="hidden" id="login" value="login">
					<input type="submit" name="Submit" value="登陆" onClick="return check();" style="width:320px; height:40px;">
				</div>
			</form>
			<br/><br/><br/>
			<form name="register" method="post" action="login?action=register">
				<div>
					
					<input type="text" id="username" name="username" placeholder="输入用户名" />
				</div>
				<div >
					
					<input type="password"  name="pwd" id="pwd" placeholder="输入用户密码" />
				</div>
			 	<div >身份:&nbsp;&nbsp;
			 		<select name="status" id="cx" style="width:170px; height:40px;">
						<option value="teacher">教师</option>
						<option value="student">学生</option>
	         		</select>
	          	</div>
	          	<div >
					
					<input type="text"  name="no" placeholder="学号" />
				</div>
				<div >
					
					<input type="text"  name="name" placeholder="姓名" />
				</div>
				<div > 
					<input type="submit" name="Submit" value="注册" onClick="return check();" style="width:320px; height:40px;">
				</div>
			</form>
		</div>
	</div>
	<!-- 登录body  end -->

	<!-- 登录页面底部end -->
   
</body>
</html>