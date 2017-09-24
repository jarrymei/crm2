<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<title>首页</title>

<meta charset="utf-8">
<title>京唐CRM系统</title>
<%@include file="script.html" %>
  
<style type="text/css">
    .layout-panel-west {
        border-right: 1px solid #c5c5c5;
    }
</style>
</head>

<body>
<!-- <a href="debug.jsp">debug</a>-->
	<div id="master-layout">
		<!--顶部banner区开始-->
		<div
			data-options="region:'north',border:false,bodyCls:'theme-header-layout'">
			<div class="theme-navigate">
				<div class="left">
					<h3>京唐国际客户关系管理系统</h3>
				</div>
				<div class="right">
					<a href="#" class="easyui-menubutton"
						data-options="menu:'#mm1',hasDownArrow:false">消息<span
						class="badge color-orange">15</span></a>

					<div id="mm1" class="theme-navigate-menu-panel"
						style="width:180px;">
						<div>
							站内消息<span class="badge color-success">5</span>
						</div>
						<div>
							公司公告<span class="badge color-important">10</span>
						</div>
						<div>服务消息</div>
						<div class="menu-sep"></div>
						<div>查看历史消息</div>
						<div class="menu-sep"></div>
						<div>清除消息提示</div>
					</div>
					<a href="#" class="easyui-menubutton theme-navigate-user-button"
						data-options="menu:'.theme-navigate-user-panel'">${sessionScope.user.username }</a>

					<div class="theme-navigate-user-panel">
						<dl>
							<dd>
								<img src="static/easyui/themes/insdep/images/portrait86x86.png" width="86" height="86"> 
								<b class="badge-prompt">${sessionScope.user.username }</b> 
								<span>${sessionScope.user.email}</span>

								<p>
									安全等级：<i class="text-success">高</i>
								</p>
							</dd>
							<dt>
								<a class="theme-navigate-user-modify">修改资料</a> 
								<a id="logout" class="theme-navigate-user-logout">注销</a>
							</dt>
						</dl>
					</div>
				</div>
			</div>

		</div>
		<!--顶部banner区结束-->
		<!--左侧系统菜单区开始-->
		<div data-options="region:'west',split:true,border:false" title="系统菜单" style="width:230px; padding:10px 20px;">
			<ul id="menu" class="ztree"></ul>
		</div>
		<!--左侧系统菜单区结束-->
		<!--右侧功能展示区开始-->
		<div id="tabs" data-options="region:'center',border:false,height:800" class="easyui-tabs">
			<div id="tab1" title="个人中心">
				<div class="theme-user-info-panel">
					<div class="left">
						<img src="static/easyui/themes/insdep/images/portrait86x86.png" width="86" height="86">
					</div>
					<div class="right">
						<ul>
							<li class="text-success">￥6,200.00<span>完成合同金额</span></li>
							<li class="text-info">33<span>月度客户数</span></li>
							<li class="text-warning">9820<span>月度任务额</span></li>
							<li>125<span>月度线索数</span></li>
						</ul>
					</div>
					<div class="center">
						<h1>
							${sessionScope.user.username }<span class="badge color-success">已认证</span>
						</h1>

						<h2>
							角色名
						</h2>
						<ul>
							<li><i class="iconfont">&#xe61c;</i> ${sessionScope.user.email}</li>
							<li><i class="iconfont">&#xe65d;</i> ${sessionScope.user.phone}</li>
						</ul>
					</div>
				</div>

				<div id="user-info-more"
					class="easyui-tabs theme-tab-blue-line theme-tab-body-unborder"
					data-options="tools:'#tab-tools',fit:true">
					<div title="待办事项" style="padding:10px"></div>
					<div title="任务列表" style="padding:10px"></div>
					<div title="站内信息" style="padding:10px"></div>
				</div>
			</div>
		</div>
		<!--右侧功能展示区结束-->
		<div id="topWindow" style="overflow: hidden;"></div>
	</div>

	<script type="text/javascript">
		//ztree的设置
		
			/* var zTreeObj,
			setting = {
				view: {
					selectedMulti: false
				},
				callback: {
					onClick: zTreeOnClick
				}
			},
			zTreeNodes = [
				{"name":"网站导航", open:true, children: [
					{ "name":"google", "url":"http://g.cn", "target":"_blank"},
					{ "name":"baidu", "url":"http://baidu.com", "target":"_blank"},
					{ "name":"sina", "url":"http://www.sina.com.cn", "target":"_blank"},
					{"name":"羞羞的网站",open:false, children:[
							{"name":"羞羞1","url":"http://baidu.com"},
							{"name":"羞羞2","url":"http://xxx.com"}

						]}
					],
				 
				}
			];

            $.fn.zTree.init($("#menu"), setting, zTreeNodes);
			
            function zTreeOnClick(event, treeId, treeNode) {
                event.preventDefault();
                alert(treeNode.url + ", " + treeNode.name);
                openTab("#tabs", treeNode.name, treeNode.url);
            }; */

        var setting = {
           		data: {
           			simpleData: {
           				enable: true,
           				idKey: "id",
           				pIdKey: "pId",
           				rootPId: 0
           			}
           		},
				callback: {
					onClick: zTreeOnClick
				}
			};

         function zTreeOnClick(event, treeId, treeNode) {
             event.preventDefault();
             if (treeNode.url) {
	             openTab("#tabs", treeNode.name, treeNode.url);
             }
         };

		
        $(function() {
			$.get("system/${sessionScope.user.id}.do", {}, function(result){
				console.log(result.message)
		        $.fn.zTree.init($("#menu"), setting, result.data);
			})
        })
        
        $("#logout").on("click", function() {
            $.messager.confirm("警告", "您确定要退出登录？", function(r){
				if(r) {

					$.get("system/user/logout.do",{},function(result){
						if (result.success) {
							window.location.href="login.html";
						}
						
					},"json")
				}
            });
        });
	
	    $(function () {
	        /*布局部分*/
	        $('#master-layout').layout({
	            fit: true/*布局框架全屏*/
	        });
	
	        $(".navigate-user-modify").on("click", function () {
	            $('.navigate-user-panel').menu('hide');
	           // $.insdep.window({id: "personal-set-window", href: "user.html", title: "修改资料"});
	        });
	    });
		//打开id="topWindow"的div窗口
		function openTopWindow(options) {
			//为参数设置默认值
			options.width = options.width ? options.width : 600;
			options.height = options.height ? options.height : 400;
			options.title = options.title ? options.title : "  ";
			options.url = options.url ? options.url : "";
			options.close = options.close ? options.close : function() {};
			options.isScrolling=options.isScrolling?options.isScrolling:"no";
			//初始化窗体
			$("#topWindow")
					.window(
							{
								width : options.width,
								height : options.height,
								title : options.title,
								modal : true,
								content : "<iframe width='100%' height='100%' scrolling='"+options.isScrolling+"' frameborder='0' src='"
										+ options.url + "'></iframe>",
								onClose : options.close
							});
		}
		//关闭窗口
		function closeTopWindow() {
			$("#topWindow").window("close");
		}
		//打开标签页的函数
		function openTab(tabsId, title, url) {
			//判断是不是已经存在这个标签页 如果存在选中该标签页
			var exists = $(tabsId).tabs("exists", title);
			if (exists) {
				$(tabsId).tabs("select", title);
			} else {
				//如果不存在打开新的标签页
				$(tabsId)
						.tabs(
								"add",
								{
									"title" : title,
									"closable" : true,
									"content" : 
										"<iframe width='100%' height='100%' scrolling='yes' frameborder='0' src='"+ url + "'></iframe>"
								});
			}
		}

	</script>
</html>
