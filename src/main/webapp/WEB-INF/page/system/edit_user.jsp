<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">

<title>编辑用户</title>

<meta name="pragma" content="no-cache">
<meta name="cache-control" content="no-cache">
<meta name="expires" content="0">
<%@include file="../script.html"%>
</head>

<body >
	<section class="info-section">
		<form id="form" method="post">
			<table>
				<tr>
					<td class="text-title">用户名：</td>
					<td class="text-content">
						<input type="hidden" name="id" value="${requestScope.user.id }"> 
						<input type="text" name="username" value="${requestScope.user.username }" 
							class="easyui-textbox theme-textbox-radius" data-options="required:true,validType:['length[6,20]'<c:if test="${empty requestScope.user }">,'validateUserName'</c:if>]" 
							<c:if test="${not empty requestScope.user}">readonly="readonly"</c:if>>
					</td>
				</tr>

				<tr style="display:${empty requestScope.user ? 'table-row' : 'none'};">
					<td class="text-title">密码：</td>
					<td class="text-content">
						<input type="password" name="password" value="${requestScope.user.password }"
							class="easyui-textbox theme-textbox-radius" data-options="required:true,validType:'length[6,20]'">
					</td>
				</tr>

				<tr>
					<td class="text-title">联系电话：</td>
					<td class="text-content">
						<input type="text" name="phone" value="${requestScope.user.phone }"
							class="easyui-textbox theme-textbox-radius" data-options="required:true">
					</td>
				</tr>
				<tr>
					<td class="text-title">电子邮箱：</td>
					<td class="text-content">
						<input type="text" name="email" value="${requestScope.user.email }"
							class="easyui-textbox theme-textbox-radius" data-options="required:true,validType:'email'"></td>
				</tr>
				<tr>
					<td class="text-title">排序编号：</td>
					<td class="text-content">
						<input type="text" name="sortnum" value="${requestScope.user.sortnum }"
							class="easyui-textbox theme-textbox-radius" data-options="required:true">
					</td>
				</tr>
				<tr>
					<td class="text-title">用户状态：</td>
					<td class="text-content">
						<select name="status" class="easyui-combobox theme-textbox-radius">
							<option value="1" ${requestScope.user.status eq 1 ? "selected" : "" }>可用</option>
							<option value="0" ${requestScope.user.status eq 0 ? "selected" : "" }>禁用</option>
							<option value="2" ${requestScope.user.status eq 2 ? "selected" : "" }>已删除</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="text-title">描述信息：</td>
					<td class="text-content">
						<textarea class="theme-textbox-radius" rows="5"  cols="20" name="usernote">${requestScope.user.usernote }</textarea></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: center;margin-top: 10px;">
						<a href="javascript:void(0);" id="saveBtn" class="easyui-linkbutton button-primary">保存</a> 
						<a href="javascript:void(0);" id="resetBtn" class="easyui-linkbutton button-danger">重置</a>
					</td>
				</tr>
				</table>
		</form>
	</section>
	<script type="text/javascript">
		$.extend($.fn.validatebox.defaults.rules, {
			validateUserName: {
				validator: function(value,param){
				    var statue = false;
				    var username = $("input[name='username']").val();
			    	$.ajax({
						type:"get",
						url:"system/user/"+ username +"/validateUserName.do",
						dataType:"json",
						async:false,
						success:function(result){
							statue = result.success;
						}
					});
					return statue;
				},
				message: '用户名已存在'
		    }
		});
		
		//重置
		$("#resetBtn").on("click", function(){
			$("#form").form("clear");
		
		});
		
		//保存
		$("#saveBtn").on("click", function(){
			var statue = $("#form").form("validate");
			console.log(statue);
			//发送ajax请求保存用户信息
			if (statue) {
				$.post("system/user/saveOrUpdate.do", $("#form").serialize(), function(result){
					if (result.success) {
						parent.closeTopWindow();
					}
				},"json")
			}
		});

	</script>
</body>
</html>
				