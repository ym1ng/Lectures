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
		讲座管理 <span class="c-gray en">&gt;</span> 签到管理 <a
			class="btn btn-success radius r"
			style="line-height: 1.6em; margin-top: 3px"
			href="javascript:location.replace(location.href);" title="刷新"><i
			class="Hui-iconfont">&#xe68f;</i></a>
	</nav>
	<div class="page-container">
		<div class="text-c">
		<form action="${ctx}/signin/select">
			日期范围： <input type="text"
				onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}'})"
					name="datemin" 	id="datemin" class="input-text Wdate" style="width: 120px;">
			- <input type="text"
				onfocus="WdatePicker({minDate:'#F{$dp.$D(\'datemin\')}',maxDate:'%y-%M-%d'})"
					name="datemax"	id="datemax" class="input-text Wdate" style="width: 120px;">
			<button type="submit" class="btn btn-success radius" id="" name="">
				<i class="Hui-iconfont">&#xe665;</i> 搜索
			</button>
			</form>
		</div>
		<div class="cl pd-5 bg-1 bk-gray mt-20">
			<span class="l"> <a class="btn btn-primary radius"
				href="javascript:;"
				onclick="signin_add('添加签到信息','${ctx}/signin/add','800')"><i
					class="Hui-iconfont">&#xe600;</i> 添加签到信息</a>
			</span> <span class="r">共有数据：<strong>${signinlist.size()}</strong> 条
			</span>
		</div>
		<div class="mt-20">
			<table
				class="table table-border table-bordered table-hover table-bg table-sort">
				<thead>
					<tr>
						<th scope="col" colspan="8">签到管理</th>
					</tr>
					<tr class="text-c">
						<th width="25"><input type="checkbox" value="" name=""></th>
						<th width="40">ID</th>
						<th width="70">讲座编号</th>
						<th width="200">讲座名称</th>
						<th width="70">用户编号</th>
						<th width="200">用户姓名</th>
						<th width="200">签到时间</th>
						<th width="100">操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${signinlist}" var="item">
						<tr class="text-c">
							<td><input type="checkbox" value="" name=""></td>
							<td>${item.signinid}</td>
							<td>${item.lecturesid }</td>
							<td>${item.lectures.lecturesname }</td>
							<td>${item.userid}</td>
							<td>${item.user.realname}</td>
							<td><fmt:formatDate value='${item.signintime}'
									pattern='yyyy-MM-dd HH:mm:ss' /></td>
							<td class="f-14"><a title="编辑" href="javascript:;"
								onclick="signin_edit('签到编辑','${ctx}/signin/edit?signinid=${item.signinid}','${item.signinid}')"
								style="text-decoration: none"><i class="Hui-iconfont">&#xe6df;</i></a>
								<a title="删除" href="javascript:;"
								onclick="enroll_del(this,${item.signinid})" class="ml-5"
								style="text-decoration: none"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
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
	$(function() {
		$('.table-sort').dataTable({
			"aaSorting" : [ [ 1, "desc" ] ],//默认第几个排序
			"bStateSave" : true,//状态保存
			"aoColumnDefs" : [
			//{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
			{
				"orderable" : false,
				"aTargets" : [ 0, 7]
			} // 制定列不参与排序
			]
		});
		$('.table-sort tbody').on('click', 'tr', function() {
			if ($(this).hasClass('selected')) {
				$(this).removeClass('selected');
			} else {
				table.$('tr.selected').removeClass('selected');
				$(this).addClass('selected');
			}
		});
	});
	   function signin_add(title,url,w,h){
			
	         layer_show(title,url,w,h);
	   }
		
		function signin_edit(title, url, id, w, h) {
			layer_show(title, url, w, h);
		}
	
		function signin_del(obj, id) {
			layer.confirm('删除须谨慎，确认要删除吗？', function(index) {
				 $.ajax({
		             type: "GET",
		             url: "${ctx}/signin/detele?enrollid= "+id,
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
