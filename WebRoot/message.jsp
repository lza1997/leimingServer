<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/SSH/employee/manage_addUI">继续添加</a>
	<h1><font color="red">添加成功</font></h1>
	<hr>
	用户列表：<br>
	<c:forEach items="${employees}"  var="employee">
		${employee.username},${employee.userpass}
	</c:forEach>
</body>
</html>