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
    <script type="text/javascript" src="<%=request.getContextPath()%>/script/easyUI1.4.3/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript">var hostUrl="<%=request.getContextPath()%>";</script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/script/title/title.js"></script>
</head>
<body class="easyui-layout">
    <div data-options="region:'north',border:false" style="height:100px;background-image:url(<%=request.getContextPath()%>/images/framehome/northBg.jpg);background-repeat: repeat-x" >
        <div style="height:75px;"><br/><span style="font-size:35px;letter-spacing:6px;">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp雷鸣雷鸣雷鸣雷鸣<br/>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp雷鸣平台</span></div>
        <div style="height:23px;text-align:right;">当前登录用户：${admin.loginName},<a href="<%=request.getContextPath()%>/admin_logout">注销</a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</div>
    </div>
    <div data-options="region:'west',split:true,title:'*导航菜单*'" style="width:150px;">
        <div class="easyui-accordion" data-options="fit:true,border:false">
            <div title="题目管理">
                <a href="javascript:fillGird('');"><p>全部类型</p></a>
                <a href="javascript:fillGird('computer');"><p>计算机</p></a>
                <a href="javascript:fillGird('teacher');"><p>教师资格</p></a>
                <a href="javascript:fillGird('accounting');"><p>会计</p></a>
                <a href="javascript:fillGird('exam');"><p>三级心理咨询师</p></a>
                <a href="javascript:fillGird('examb');"><p>三级人力资源管理师</p></a>
                <a href="javascript:fillGird('examc');"><p>三级秘书资格证</p></a>
                <a href="javascript:fillGird('examd');"><p>高级育婴师</p></a>
                <a href="javascript:fillGird('exame');"><p>公共营养师</p></a>
                <a href="javascript:fillGird('examf');"><p>物流师</p></a>
                <a href="javascript:fillGird('examg');"><p>企业培训师</p></a>
                <a href="javascript:fillGird('examh');"><p>理财规划师</p></a>
            </div>
        </div>
    </div>
    <div data-options="region:'south',border:false" style="height:50px;background-image:url(<%=request.getContextPath()%>/images/framehome/northBg.jpg);background-repeat: repeat-x;padding:10px;">
        <div class="easyui-layout" data-options="fit:'true'" style="text-align:center">版权所有：雷鸣</div>
    </div>
    <div data-options="region:'center',title:' '">
        <div class="easyui-datagrid" id="mainGrid">
        </div>
        <div id="dlg_save" class="easyui-dialog" title="增加/修改" style="width:700px;height:500px;padding:10px" 
            data-options="iconCls:'icon-save',
                onResize:function(){$(this).dialog('center');}">
	        <form id="ff" class="easyui-form" method="post">
	            <input type="hidden" name="id" id="id"/>
	            <table>
	                <tr>
	                    <td>分类:</td>
	                    <td>
	                       <select class="easyui-combobox" name="type" id="type">
	                           <option value="">请选择..</option>
	                           <option value="computer">计算机</option>
	                           <option value="teacher">教师资格</option>
	                           <option value="exam">三级心里咨询师</option>
	                           <option value="examb">三级人力资源管理师</option>
	                           <option value="examc">三级秘书资格证</option>
	                           <option value="examd">高级育婴师</option>
	                           <option value="exame">公共营养师</option>
	                           <option value="examf">物流师</option>
	                       </select>
	                    </td>
	                </tr>
	                <tr>
	                   <td>题目：</td>
	                   <td><input class="easyui-textbox" type="text" name="title" id="title" data-options="required:true"></input></td>
	                </tr>
	                <tr>
	                   <td>答案：</td>
                       <td><input class="easyui-textbox" type="text" name="content" id="content" data-options="required:true"></input></td>
	                </tr>
	            </table>
	        </form>
	        <div style="text-align:center;padding:5px">
	            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="dlg_saveOrUpdate()">提交</a>
	            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">重置</a>
	        </div>
        </div>
    </div>
</body>
</html>