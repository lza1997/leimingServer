<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<script language="javascript" type="text/javascript" 
  	src="${pageContext.request.contextPath}/script/My97DatePicker/WdatePicker.js">
  	</script>
  </head>
  
  <body>
    This is my JSP page. <br>
   <input name="birthday" class="Wdate" type="text" onClick="WdatePicker()"> 
   <font color=red>&lt;- 点我弹出日期控件</font>
  </body>
</html>
