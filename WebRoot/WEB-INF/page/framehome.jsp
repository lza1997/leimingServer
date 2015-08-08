<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>欢迎</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/script/easyUI1.4.3/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/script/easyUI1.4.3/themes/icon.css">
    <script type="text/javascript" src="<%=request.getContextPath()%>/script/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/script/easyUI1.4.3/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/script/title/title.js"></script>
</head>
<body class="easyui-layout">
    <div data-options="region:'north',border:false" style="height:100px;background-image:url(<%=request.getContextPath()%>/images/framehome/northBg.jpg);background-repeat: repeat-x" >
        <div style="height:75px;"><br/><span style="font-size:35px;letter-spacing:6px;">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp雷鸣雷鸣雷鸣雷鸣<br/>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp雷鸣平台</span></div>
        <div style="height:23px;text-align:right;">当前登录用户：${admin.loginName},<a href="${pageContext.request.contextPath}/user_logout.action">注销</a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</div>
    </div>
    <div data-options="region:'west',split:true,title:'*导航菜单*'" style="width:150px;">
        <div class="easyui-accordion" data-options="fit:true,border:false">
            <div title="题目管理">
                <a href="javacript:fillGird();"><p>全部类型</p></a>
                <a href="javacript:fillGird('computer');"><p>计算机</p></a>
                <a href="javacript:fillGird('teacher');"><p>教师资格</p></a>
                <a href="javacript:fillGird('accounting');"><p>会计</p></a>
                <a href="javacript:fillGird('exam');"><p>三级心理咨询师</p></a>
                <a href="javacript:fillGird('examb');"><p>三级人力资源管理师</p></a>
                <a href="javacript:fillGird('examc');"><p>三级秘书资格证</p></a>
                <a href="javacript:fillGird('examd');"><p>高级育婴师</p></a>
                <a href="javacript:fillGird('exame');"><p>公共营养师</p></a>
                <a href="javacript:fillGird('examf');"><p>物流师</p></a>
                <a href="javacript:fillGird('examg');"><p>企业培训师</p></a>
                <a href="javacript:fillGird('examh');"><p>理财规划师</p></a>
            </div>
        </div>
    </div>
    <div data-options="region:'south',border:false" style="height:50px;background-image:url(<%=request.getContextPath()%>/images/framehome/northBg.jpg);background-repeat: repeat-x;padding:10px;">
        <div class="easyui-layout" data-options="fit:'true'" style="text-align:center">版权所有：雷鸣</div>
    </div>
    <div data-options="region:'center',title:' '">
        <table class="easyui-datagrid" id="mainGrid" data-options="singleSelect:false,fit:true,fitColumns:true">
            <thead>
                <tr>
                    <th data-options="field:'itemid'" width="80">Item ID</th>
                    <th data-options="field:'productid'" width="100">Product ID</th>
                    <th data-options="field:'listprice',align:'right'" width="80">List Price</th>
                    <th data-options="field:'unitcost',align:'right'" width="80">Unit Cost</th>
                    <th data-options="field:'attr1'" width="150">Attribute</th>
                    <th data-options="field:'status',align:'center'" width="50">Status</th>
                </tr>
            </thead>
        </table>
    </div>
</body>
</html>