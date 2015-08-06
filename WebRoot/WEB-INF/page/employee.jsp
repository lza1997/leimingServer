<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>员工列表</title>
</head>
<body>
	ONGL:
	<!-- 通过ONGL的方式获取request范围内的值 -->
	<s:iterator value="#request.employees">
		<!-- 当获取到值的时候，就会将该值放到了ValueStack中，这样就可以通过下面的方式进行访问了
			如果没有写value的话会将获得的对象toString（）输出
		 -->
		<s:property value="username"/>,<s:property value="userpass"/>
	</s:iterator>
	<hr>
	JSTL/EL:
	<c:forEach items="${employees}"  var="employee">
		${employee.username},${employee.userpass}
	</c:forEach>
</body>
</html>