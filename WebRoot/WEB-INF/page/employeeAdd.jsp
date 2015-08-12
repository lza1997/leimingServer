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
	<%String path=request.getContextPath(); %>
	<%=path%>
	<!-- 使用struts中的form标签呢，可以通过下面的方式简化form提交   &ldquo;-->
	<s:form action="manage_add" namespace="/employee" method="post">	
			姓名：<input type="text" name="employee.username"/>
			密码：<input type="password" name="employee.userpass"/>
			性别:男<input type="radio" name="employee.gender" value="MAN" checked="checked"/>
				女<input type="radio" name="employee.gender" value="WOMAN">
			<input type="submit" value="提交"/>
	</s:form>
</body>
</html>