<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.mytaglib.com/taglib/func" prefix="func" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户列表</title>
    
	<meta name="pragma" content="no-cache">
	<meta name="cache-control" content="no-cache">
	<meta name="expires" content="0">    
	<%@include file="../script.html" %>

  </head>
  
  <body >
    <func:func funcCode="user">删除</func:func>
   	<table id="userList" class="easyui-datagrid"></table>
    <div id="toolbar">
    	<a href="javascript:void(0);" onclick="return add('system/user/edit.do')" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新建</a>
    	<a href="javascript:void(0);" onclick="return del('system/user/edit.do')" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</a>
    	<a href="javascript:void(0);" onclick="return edit('system/user/edit.do');" id="editBtn" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">修改</a>
    	<a href="javascript:void(0);" onclick="return assign('system/user/assign.do')" id="setBtn" class="easyui-linkbutton" data-options="iconCls:'icon-man',plain:true">分配角色</a>
    </div>
    <script type="text/javascript">

    	//新建
    	var add = function(url){
    		parent.openTopWindow({
        		"width":800,
        		"height":500,
				"title":"添加用户",
				"url":url,
				close:function(){
					console.log("close")
					$("#userList").datagrid("reload");
				}
        	})
       	};

       	//修改
       	var edit = function(url){
			var rows = $("#userList").datagrid("getChecked");
			if (rows.length != 1) {
				$.messager.alert("警告", "请选中一行记录", "info");
				return;
			}
			var id = rows[0].user.id;
			parent.openTopWindow({
        		"width":800,
        		"height":500,
				"title":"添加用户",
				"url":url+"?id="+id,
				close:function(){
					$("#userList").datagrid("clearChecked");
					$("#userList").datagrid("reload");
				}
        	})
        };

        //删除
        var del = function(url) {
			var rows = $("#userList").datagrid("getChecked");
			if (rows.length < 1) {
				$.messager.alert("警告", "请选择要删除的记录" , "info");
				return;
			}
			var ids = new Array();
			$.each(rows, function(index, data){
				ids[index] = data.user.id;
			});
			console.log(ids);

			$.post("system/user/delete.do", {"ids":ids.toString()}, function(result){
				if (result.success) {
					var names = result.data;
					if (names.length>0) {
						var msg = "用户"+names+"有子记录无法删除";
						$.messager.alert("警告", msg);
					} else {
						$.messager.alert("警告", result.message);
					}
					$("#userList").datagrid("reload");
				}
			},"json")
        };

        //分配角色
        var assign = function(url){
			var rows = $("#userList").datagrid("getChecked");
			if (rows.length < 1) {
				$.messager.alert("警告","请选需要分配角色的用户");
				return;
			}
			if (rows.length > 1) {
				$.messager.alert("警告","只能同时为一个用户分配角色");
				return;
			}
			var id = rows[0].user.id;
			parent.openTopWindow({
        		"width":800,
        		"height":500,
				"title":"添加用户",
				"url":"system/user/"+id+"/assign.do",
				"isScrolling":"yes",
				close:function(){
					$("#userList").datagrid("clearChecked");
					$("#userList").datagrid("reload");
				}
        	})
        }
    	
    	//加载用户数据
    	$(function(){
    		$("#userList").datagrid({
    			url : "system/user/findByPage.do",
    			pagination : true,
    			toolbar : "#toolbar",
    			fitColumns : true,
    			idField : "id",
    			rownumbers : true,
    			//singleSelect:true,
    			columns : [[
    				{field:"user.id",title:"选择",checkbox:true,formatter:function(value,row,index){
							return row.user.id;
        				}},
    				{field:"user",title:"用户名",sortable:true,width:10,formatter:function(value,row,index){
						return value.username;
    				}},
    				{field:"user.phone",title:"联系电话",width:15,formatter:function(value,row,index){
						return row.user.phone;
    				}},
    				{field:"user.email",title:"电子邮箱",width:20,formatter:function(value,row,index){
						return row.user.email;
    				}},
    				{field:"role",title:"用户角色",width:15,formatter:function(value,row,index){
						if (row.role && row.role.rolename) {
							return row.role.rolename;
						}
       				}},
    				{field:"createUser",title:"创建者",width:10},
    				{field:"user.createtime",title:"创建时间",width:15,formatter:function(value,row,index){
						return row.user.createtime;
    				}},
    				{field:"updateUser",title:"修改者",width:10},
    				{field:"user.updatetime",title:"修改时间",width:15,formatter:function(value,row,index){
						return row.user.updatetime;
    				}},
    				{field:"user.status",title:"用户状态",formatter:function(value,row,index){
    					if(row.user.status == 1){
    						return "可用";
    					}else if(row.user.status == 0){
    						return "禁用";
    					}else if(row.user.status == 2){
    						return "已删除";
    					}else{
    						return "";
    					}
    				}}
    				
    			]],
    			loadFilter:function(data){
    				//data是服务器返回的数据,将服务器端返回的数据转换为datagrid需要的格式
    				return {"total":data.data.totalRows,"rows":data.data.data};
    			}
    		
    		});
    	});
    </script>
  </body>
</html>
