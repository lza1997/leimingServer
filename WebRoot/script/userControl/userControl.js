$(function(){
	$('#dlg_save_user').dialog({
	    onClose:function(){
	    	$('#isFuckUpdate').val(0);
	    }
	});
	
	$("#dlg_save_user").dialog('close');
	//关闭时$('#isFuckUpdate').val(0);
});

//全局变量baseUrl：系统路径
var obj=window.location;//地址对象
var baseUrl=obj.protocol+"//"+obj.host+hostUrl;

function fillGird_user(type){
	$('#mainGrid').datagrid({
	    url:baseUrl+"/userControl_getListJson",
		width:'100%',
		height:'100%',
		title:"用户管理",
		pageSize:20,
		pageList:[10,20],
		striped:true,
		loadMsg:"数据加载中请稍后……",
		fitColumns:true,
		pagination:true,
		autoRowHeight:true,
		rownumbers:true,
		nowrap:false,
	    columns:[[
	        {field:"",checkbox:true},
	        {field:'userName',title:'手机号码',width:100},
	        {field:'userPermission',title:'类型权限',width:300,
	        	formatter: function(value,row,index){
	        		if(value==""||undefined==value){
	        			return;
	        		}
	        		//根据获得的英文转中文
	        		var ups=value.split(",");
	        		var upsDes="";
	        		for ( var up in ups) {
	        			switch(ups[up]){
		        			case "accounting":
		        				upsDes+= "会计,";
		        				break;
		        			case "computer":
		        				upsDes+= "计算机,";
		        				break;
		        			case "teacher":
		        				upsDes+= "教师资格,";
		        				break;
		        			case "exam":
		        				upsDes+= "三级心里咨询师,";
		        				break;
		        			case "examb":
		        				upsDes+= "三级人力资源管理师,";
		        				break;
		        			case "examc":
		        				upsDes+= "三级秘书资格证,";
		        				break;
		        			case "examd":
		        				upsDes+= "高级育婴师,";
		        				break;
		        			case "exame":
		        				upsDes+= "公共营养师,";
		        				break;
		        			case "examf":
		        				upsDes+= "物流师,";
		        				break;
		        			default:
		        				upsDes+= "";
		        		}
					}
	        		//取出有可能的最后一个逗号
        			if(upsDes.substr(upsDes.length-1)==","){
        				upsDes=upsDes.substring(0,upsDes.length-1);
        			}
        			return upsDes;
				}
	        }
	    ]],
	    toolbar:[{
	    	text:'增加',
	    	iconCls:'icon-add',
	    	handler:function(){
	    		clearForm_user();//先清空可能有的数据
	    		$('#isFuckUpdate').val(0);
	    		$("#userName").attr("readonly",false);
	    		$('#dlg_save_user').dialog('open');
	    	}
	    },{
		    text:'修改',
		    iconCls:'icon-edit',
		    handler:function(){
		    	var rows = $("#mainGrid").datagrid("getSelections");
		    	if(rows.length<1){
		    		$.messager.alert("消息提示", "请选择一条记录！","warning");
		    		return false;
		    	}else if(rows.length>1){
		    		$.messager.alert("消息提示", "只能选择一条记录！","warning");
		    		return false;
		    	}
		    	var userName= rows[0].userName;
		    	if(userName){
		    		$.ajax({
			    		type : "POST",
			    		url : baseUrl+"/userControl_getOne",
			    		data:{userName:userName},
			    		success : function(data) {
			    			$("#userName").val(data.userName);
			    			$("#userName").attr("readonly",true);
			    			//checkbox回显
			    			var upss=data.userPermission.split(",");
			    			var checkBoxAll=$("input[type='checkbox'][name='userPermission']");
			    			for (var int = 0; int < upss.length; int++) {
								$.each(checkBoxAll,function(j,checkbox){
									 var checkValue=$(checkbox).val();
									 if(upss[int]==checkValue){
										 $(checkbox).attr("checked",true);
									 }
								});
							}
			    			$('#isFuckUpdate').val(1);
			    			$('#dlg_save_user').dialog('open');
			    		}
			    	});
		    	}
		    }
	    },{
	    	text:'删除',
		    iconCls:'icon-remove',
		    handler:function(){
		    	var rows = $("#mainGrid").datagrid("getSelections");
		    	if(rows.length<1){
		    		$.messager.alert("消息提示", "请选择一条记录！","warning");
		    		return false;
		    	}
		    	var affirm=$.messager.confirm("消息提示", "您确认删除吗？此操作不可回退！",function(r){
		    		if(r){
		    			var ids="";
			    		for (var int = 0; int < rows.length; int++) {
			    			ids+=rows[int].userName+",";
						}
			    		//casual find a if sentence to limit ajax request
			    		if(ids.length>0){
			    			$.ajax({
					    		type : "POST",
					    		url : baseUrl+"/userControl_delete",
					    		data:{userNames:ids},
					    		success : function(data) {
					    			if(data.state==1){
					    				$.messager.alert("消息提示", "成功！");
				    					$('#mainGrid').datagrid("reload");
									}else{
										$.messager.alert("消息提示", "抱歉，数据异常请重试！","warning");
									}
					    		}
					    	})
			    		}
		    		}
		    	});
		    }
	    }]
	});
}

/**
 * 保存，新增或修改的
 */
function dlg_saveOrUpdate_user(){
	var idT=$("#isFuckUpdate").val();
	if(idT==1){//修改
		dlg_update_user();
	}else{//新增save
		var userName=$("#userName").val();
		var userPermissions=$("input[type='checkbox'][name='userPermission']:checked");
		if(userName==""){
			$.messager.alert("消息提示", "手机号码不能为空！","warning");
			return false;
		}else if(!/\d{11}/.test(userName)){
			$.messager.alert("消息提示", "请输入11位手机号码！","warning");
			return false;
		}else if(userPermissions.length==0){
			$.messager.alert("消息提示", "权限类型不能为空！","warning");
			return false;
		}else{
			var allVals="";
			for (var int = 0; int < userPermissions.length; int++) {
				allVals+=userPermissions[int].value+",";
			}
			if (true) {
				$.ajax({
					type : "POST",
					url : baseUrl+"/userControl_addOne",
					data:{
						userName:userName,
						userPermission:allVals
					},
					success : function(data) {
						if(data.state==1){
							$.messager.alert("消息提示", "成功！");
							$('#dlg_save_user').dialog('close');
							$('#mainGrid').datagrid("reload");
						}else if(data.state==3){
							$.messager.alert("消息提示", "此电话号码已经被使用！","warning");
						}else{
							$.messager.alert("消息提示", "抱歉，数据异常请重试！","warning");
						}
					}
				});
			}
		}
	}
}

/**
 * 更新
 */
function dlg_update_user(){
	var userPermissions=$("input[type='checkbox'][name='userPermission']:checked");
	if(userPermissions.length==0){
		$.messager.alert("消息提示", "权限类型不能为空！","warning");
		return false;
	}else{
		var allVals="";
		for (var int = 0; int < userPermissions.length; int++) {
			allVals+=userPermissions[int].value+",";
		}
		if (true) {
			$.ajax({
				type : "POST",
				url : baseUrl+"/userControl_udpateOne",
				data:{
					userName:$("#userName").val(),
					userPermission:allVals
				},
				success : function(data) {
					if(data.state==1){
						$.messager.alert("消息提示", "成功！");
						$('#isFuckUpdate').val(0);
						$('#dlg_save_user').dialog('close');
						$('#mainGrid').datagrid("reload");
					}else{
						$.messager.alert("消息提示", "抱歉，数据异常请重试！","warning");
					}
				}
			});
		}
	}
}

/**
 * 重置
 */
function clearForm_user(){
	$('#ff_user').form('clear');
}

