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
<title>用户管理</title>
</head>
<body>
	<nav class="breadcrumb">
		<i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>
		用户中心 <span class="c-gray en">&gt;</span> 用户管理 <a
			class="btn btn-success radius r"
			style="line-height: 1.6em; margin-top: 3px"
			href="javascript:location.replace(location.href);" title="刷新"><i
			class="Hui-iconfont">&#xe68f;</i></a>
	</nav>
	<div class="page-container">
		<div class="text-c">
			<form action="${ctx}/user/select">
				日期范围： <input type="text"
					onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}'})"
					name="datemin" id="datemin" class="input-text Wdate"
					style="width: 120px;"> - <input type="text"
					onfocus="WdatePicker({minDate:'#F{$dp.$D(\'datemin\')}',maxDate:'%y-%M-%d'})"
					name="datemax" id="datemax" class="input-text Wdate"
					style="width: 120px;">
				<button type="submit" class="btn btn-success radius" id="" name="">
					<i class="Hui-iconfont">&#xe665;</i> 搜索
				</button>
			</form>
		</div>
		<div class="cl pd-5 bg-1 bk-gray mt-20">
			<span class="l"><a href="javascript:;" onclick="exportExcel()"
				class="btn btn-success radius"><i class="Hui-iconfont">&#xe644;</i>
					导出数据</a> <a href="javascript:;"
				onclick="member_add('添加用户','${ctx}/user/add','','510')"
				class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i>
					添加用户</a></span> <span class="r">共有数据：<strong>${userlist.size()}</strong>
				条
			</span>
		</div>
		<div class="mt-20">
			<table
				class="table table-border table-bordered table-hover table-bg table-sort">
				<thead>
					<tr class="text-c">
						<th width="25"><input type="checkbox" name="" value=""></th>
						<th width="80">ID</th>
						<th width="100">用户名</th>
						<th width="40">性别</th>
						<th width="90">院系</th>
						<th width="90">手机</th>
						<th width="150">邮箱</th>
						<th width="150">地址</th>
						<th width="130">加入时间</th>
						<th width="100">操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${userlist}" var="item">
						<tr class="text-c">
							<td><input type="checkbox" value="1" name=""></td>
							<td>${item.userid}</td>
							<td><u style="cursor: pointer" class="text-primary"
								onclick="member_show('${item.realname}','${ctx}/user/show?userid='+${item.userid},'360','400')">${item.realname}</u></td>
							<td><c:if test="${item.sex =='1'}">男</c:if> <c:if
									test="${item.sex =='2'}">女</c:if> <c:if
									test="${item.sex =='3'}">保密</c:if></td>
							<td>${item.colleges.collegesname}</td>
							<td>${item.phone}</td>
							<td>${item.email}</td>
							<td class="text-l">${item.address}</td>
							<td><fmt:formatDate value='${ item.addtime}'
									pattern='yyyy-MM-dd HH:mm:ss' /></td>
							<td class="td-manage"><a title="编辑" href="javascript:;"
								onclick="member_edit('编辑用户','${ctx}/user/edit?userid='+${item.userid},'','510')"
								class="ml-5" style="text-decoration: none"><i
									class="Hui-iconfont">&#xe6df;</i></a> <a title="重置密码"
								style="text-decoration: none" class="ml-5"
								onClick="reset_password(this,${item.userid})"
								href="javascript:;"><i class="Hui-iconfont">&#xe63f;</i></a> <a
								title="删除" href="javascript:;"
								onclick="member_del(this,${item.userid})" class="ml-5"
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
					"aTargets" : [ 0, 8, 9 ]
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
		/*用户-添加*/
		function member_add(title, url, w, h) {
			layer_show(title, url, w, h);
		}
		/*用户-查看*/
		function member_show(title, url, w, h) {
			layer_show(title, url, w, h);
		}
		/*用户-编辑*/
		function member_edit(title, url, w, h) {
			layer_show(title, url, w, h);
		}
		/*密码-修改*/
		function reset_password(obj, id) {
			layer
					.confirm(
							'确认要重置吗？ ',
							function(index) {
								$
										.ajax({
											type : "GET",
											url : "${ctx}/user/reset_password?userid= "
													+ id,
											dataType : "json",
											success : function(data) {
												layer.msg('已重置!', {
													icon : 1,
													time : 1000
												});
											}
										});
							});
		}
		/*用户-删除*/
		function member_del(obj, id) {
			layer.confirm('确认要删除吗？', function(index) {
				$.ajax({
					type : "GET",
					url : "${ctx}/user/detele?userid= "
							+ id,
					dataType : "json",
					success : function(data) {
						$(obj).parents("tr").remove();
						layer.msg('已删除!', {
							icon : 1,
							time : 1000
						})
					}
				});
				$(".table-sort").dataTable().fnDraw(false)

			});
			
		}
	</script>
	<script>  
function exportExcel(){  
     location.href="${ctx}/user/excel/export" 
   }  
</script>
</body>
</html>
