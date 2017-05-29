<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<LINK rel="Bookmark" href="/favicon.ico">
<LINK rel="Shortcut Icon" href="/favicon.ico" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<script type="text/javascript" src="lib/PIE_IE678.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css"
	href="${ctx}/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css"
	href="${ctx}/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css"
	href="${ctx}/lib/Hui-iconfont/1.0.7/iconfont.css" />
<link rel="stylesheet" type="text/css"
	href="${ctx}/lib/icheck/icheck.css" />
<link rel="stylesheet" type="text/css"
	href="${ctx}/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css"
	href="${ctx}/static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title></title>
</head>
<body>
	<nav class="breadcrumb">
		<i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>
		讲座管理 <span class="c-gray en">&gt;</span> 讲座类型管理 <a
			class="btn btn-success radius r"
			style="line-height: 1.6em; margin-top: 3px"
			href="javascript:location.replace(location.href);" title="刷新"><i
			class="Hui-iconfont">&#xe68f;</i></a>
	</nav>
	<div class="page-container">
		<div class="cl pd-5 bg-1 bk-gray">
			<span class="l"> <a class="btn btn-primary radius" href="javascript:;"
				onclick="lecturesType_add('添加讲座类型','${ctx}/lecturesType/add','800')"><i
					class="Hui-iconfont">&#xe600;</i> 添加讲座类型</a>
			</span> <span class="r">共有数据：<strong>${lecturesTypelist.size()}</strong> 条
			</span>
		</div>
		<table class="table table-border table-bordered table-hover table-bg table-sort">
			<thead>
				<tr>
					<th scope="col" colspan="6">讲座类型管理</th>
				</tr>
				<tr class="text-c">
					<th width="25"><input type="checkbox" value="" name=""></th>
					<th width="40">ID</th>
					<th width="200">讲座类型名称</th>
					<th width="300">描述</th>
					<th width="70">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${lecturesTypelist}" var="item">
					<tr class="text-c">
						<td><input type="checkbox" value="" name=""></td>
						<td>${item.lecturestypeid}</td>
						<td>${item.lecturestypename }</td>
						<td>${item.description}</td>
						<td class="f-14"><a title="编辑" href="javascript:;"
							onclick="lecturesType_edit('讲座类型编辑','${ctx}/lecturesType/edit?lecturestypeid=${item.lecturestypeid}','${item.lecturestypeid}')"
							style="text-decoration: none"><i class="Hui-iconfont">&#xe6df;</i></a>
							<a title="删除" href="javascript:;"
							onclick="lecturesType_del(this,${item.lecturestypeid})" class="ml-5"
							style="text-decoration: none"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script type="text/javascript"
		src="${ctx}/lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="${ctx}/lib/layer/2.1/layer.js"></script>
	<script type="text/javascript" src="${ctx}/lib/laypage/1.2/laypage.js"></script>
	<script type="text/javascript"
		src="${ctx}/lib/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript"
		src="${ctx}/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="${ctx}/static/h-ui/js/H-ui.js"></script>
	<script type="text/javascript"
		src="${ctx}/static/h-ui.admin/js/H-ui.admin.js"></script>
	<script type="text/javascript">
	   function lecturesType_add(title,url,w,h){
			
	         layer_show(title,url,w,h);
	   }
		function lecturesType_edit(title, url, id, w, h) {
			layer_show(title, url, w, h);
		}
		function lecturesType_del(obj, id) {
			layer.confirm('角色删除须谨慎，确认要删除吗？', function(index) {
				 $.ajax({
		             type: "GET",
		             url: "${ctx}/lecturesType/detele?lecturestypeid= "+id,
		             dataType: "json",
		             success: function(data){
		            	 $(obj).parents("tr").remove();
		 				layer.msg('已删除!', {
		 					icon : 1,
		 					time : 1000
		 				});
		             }
		         });
			});
		}
		</script>
		</body>
		</html>
	