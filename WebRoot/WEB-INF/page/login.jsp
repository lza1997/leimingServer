<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=request.getContextPath()%>/script/jquery-1.9.1.min.js"></script>
<title>登陆</title>
	<script type="text/javascript">
	   $(function(){
		   $("#sb").click(function(){
			   var loginName= $("#loginName").val().trim();
			   var password=$("#password").val().trim();
			   if(loginName==""||password==""){
				   alert("请输入账号和密码");
				   return false;
			   }else{
				   $.post("<%=request.getContextPath()%>/admin_loginSubmit",
	                   {loginName:loginName,password:password},
	                   function(data){
	                	   if(data==undefined){alert("账号或密码错误");}else{location.href=data;}
	                   });
			   }
		   });
		   
	   });
	</script>
</head>
<body>
    <form>
       <input type="text" id="loginName" name="loginName"/>
       <input type="password" id="password" name="password"/>
       <input type="button" id="sb" value="登录"/>
    </form>
</body>
</html>