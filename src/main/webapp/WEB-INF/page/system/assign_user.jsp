<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>为用户分配角色</title>
    
	<meta name="pragma" content="no-cache">
	<meta name="cache-control" content="no-cache">
	<meta name="expires" content="0">    
	<%@include file="../script.html" %>

  </head>
  
  <body>
    <!-- 把所有的角色查询出来展示到这个位置 -->
    <table id="dataList"></table>
    <div style="text-align: center;margin-top:10px;">
    	<a  class="easyui-linkbutton" id="assignBtn" data-options="iconCls:'icon-man'">分配</a>
    </div>
    <script type="text/javascript">
    	$(function(){

    		$("#assignBtn").on("click", function(){
				var rows = $("#dataList").datagrid("getChecked");
				console.log(rows)
				var roleIds = new Array();
				$.each(rows, function(index, data){
					roleIds[index] = data.id;
				})
				$.post("system/role/assignRole.do", {"id":"${id}", "roleIds":roleIds.toString()}, function(result){
					if(result.success) {
						$.messager.alert("警告", result.message);
						parent.closeTopWindow();
					}
				}, "json")
   			})
    	
    		//加载所有角色
    		$("#dataList").datagrid({
    			url : "system/role/getRoleList.do",
    			fitColumns : true,
    			idField : "id",
    			rownumbers : true,
    			columns : [[
    				{field:"id",title:"选择",checkbox:true},
    				{field:"rolename",title:"角色名",sortable:true,width:10},
    				{field:"rolenote",title:"角色描述",width:10},
    				{field:"status",title:"角色状态",formatter:function(value,rowData,index){
    					if(value == 1){
    						return "可用";
    					}else if(value == 0){
    						return "禁用";
    					}else if(value == 2){
    						return "已删除";
    					}else{
    						return "";
    					}
    				}}
    			]],
    			loadFilter:function(data){
    				//data是服务器返回的数据,将服务器端返回的数据转换为datagrid需要的格式
    				return {"rows":data.data};
    			},
    			//当前表格中所有的数据加载完毕之后
    			onLoadSuccess : function(){
    				//根据用户的id获取这个用户对应的角色信息
    				$.get("system/role/${id}/role.do", {}, function(data){
   						//判断用户是否已经有了角色，如果有，就将对应角色在表格中选中
   						if(data && data.success && data.data.length>0){
   							$.each(data.data,function(index,obj){
   								$("#dataList").datagrid("selectRecord",obj.id);
   							});
   						}
   					},"json");
    			}
    			
    		});
    	});
    </script>
  </body>
</html>
