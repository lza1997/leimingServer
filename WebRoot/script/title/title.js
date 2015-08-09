$(function(){
	$("#dlg_save").dialog('close');
});

//全局变量baseUrl：系统路径
var obj=window.location;//地址对象
var baseUrl=obj.protocol+"//"+obj.host+hostUrl;

function fillGird(type){
	$('#mainGrid').datagrid({
	    url:baseUrl+"/title_getListJson",
	    queryParams: {
			type: type
		},
		width:'100%',
		height:'100%',
		title:"题目管理",
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
	        {field:'id',checkbox:true},
	        {field:'title',title:'题目',width:100},
	        {field:'content',title:'答案',width:300},
	        {field:'type',title:'类型',width:50,
	        	formatter: function(value,row,index){
	        		switch(value){
	        			case "accounting":
	        				return "会计";
	        				break;
	        			case "computer":
	        				return "计算机";
	        				break;
	        			case "teacher":
	        				return "教师资格";
	        				break;
	        			case "exam":
	        				return "三级心里咨询师";
	        				break;
	        			case "examb":
	        				return "三级人力资源管理师";
	        				break;
	        			case "examc":
	        				return "三级秘书资格证";
	        				break;
	        			case "examd":
	        				return "高级育婴师";
	        				break;
	        			case "exame":
	        				return "公共营养师";
	        				break;
	        			case "examf":
	        				return "物流师";
	        				break;
	        			default:
	        				return "未分类";
	        		}
				}
	        }
	    ]],
	    toolbar:[{
	    	text:'增加',
	    	iconCls:'icon-add',
	    	handler:function(){
	    		$('#dlg_save').dialog('open');
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
		    	var id= rows[0].id;
		    	if(id){
		    		$.ajax({
			    		type : "POST",
			    		url : baseUrl+"/title_getOne",
			    		data:{id:id},
			    		success : function(data) {
			    			clearForm();//先清空可能有的数据
			    			$("#id").val(data.id);
			    			$("#type").val(data.type);
			    			$("#title").val(data.title);
			    			$("#content").val(data.content);
			    			$('#dlg_save').dialog('open');
			    		}
			    	});
		    	}
		    }
	    }]
	});
}

/**
 * 保存，新增或修改的
 */
function dlg_save(){
	var type=$("#type").val();
	var title=$("#title").val();
	var content=$("#content").val();
	if(type==""){
		$.messager.alert("消息提示", "类型不能为空！","warning");
		return false;
	}else if (title=="") {
		$.messager.alert("消息提示", "标题不能为空！","warning");
		return false;
	}else if (content=="") {
		$.messager.alert("消息提示", "内容不能为空！","warning");
		return false;
	}else{
		$.ajax({
			type : "POST",
			url : baseUrl+"/title_addOne",
			data:{
				type:type,
				title:title,
				content:content
			},
			success : function(data) {
				if(data.state==1){
					if(confirm("成功")){
						$('#dlg_save').dialog('close');
					}
				}else{
					$.messager.alert("消息提示", "抱歉，数据异常请重试！","warning");
				}
			}
		});
	}
}

/**
 * 更新
 */
function dlg_update(){
	var id=$("#id").val();
	var type=$("#type").val();
	var title=$("#title").val();
	var content=$("#content").val();
	if(type==""){
		$.messager.alert("消息提示", "类型不能为空！","warning");
		return false;
	}else if (title=="") {
		$.messager.alert("消息提示", "标题不能为空！","warning");
		return false;
	}else if (content=="") {
		$.messager.alert("消息提示", "内容不能为空！","warning");
		return false;
	}else{
		$.ajax({
			type : "POST",
			url : baseUrl+"/title_updateOne",
			data:{
				id:id,
				type:type,
				title:title,
				content:content
			},
			success : function(data) {
				if(data.state==1){
					if(confirm("成功")){
						$('#dlg_save').dialog('close');
					}
				}else{
					$.messager.alert("消息提示", "抱歉，数据异常请重试！","warning");
				}
			}
		});
	}
}

/**
 * 重置
 */
function clearForm(){
	$('#ff').form('clear');
}

