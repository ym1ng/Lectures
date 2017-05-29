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
		讲座管理 <span class="c-gray en">&gt;</span> 讲座信息 <a
			class="btn btn-success radius r"
			style="line-height: 1.6em; margin-top: 3px"
			href="javascript:location.replace(location.href);" title="刷新"><i
			class="Hui-iconfont">&#xe68f;</i></a>
	</nav>
	<div class="page-container">
		<div class="text-c">
		<form action="${ctx}/lectures/select">
			日期范围： <input type="text"
				onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}'})"
				name="datemin" id="datemin" class="input-text Wdate" style="width: 120px;">
			- <input type="text"
				onfocus="WdatePicker({minDate:'#F{$dp.$D(\'datemin\')}',maxDate:'%y-%M-%d'})"
				name="datemax"  id="datemax" class="input-text Wdate" style="width: 120px;">
			<button type="submit" class="btn btn-success radius" id="" name="">
				<i class="Hui-iconfont">&#xe665;</i> 搜索
			</button>
			</form>
		</div>
		<div class="cl pd-5 bg-1 bk-gray mt-20">
			<span class="l"><a href="javascript:;" onclick="exportExcel()"
				class="btn btn-success radius"><i class="Hui-iconfont">&#xe644;</i>
					导出数据</a> <a href="javascript:;"  data-title="添加讲座"
				onclick="lectures_add('添加讲座','${ctx}/lectures/add','','510')"	
		onclick="Hui_admin_tab(this)"	class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i>
					添加讲座</a></span> <span class="r">共有数据：<strong>${lectureslist.size()}</strong>
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
						<th width="100">讲座名</th>
						<th width="40">讲座类型</th>
						<th width="130">讲座时间</th>
						<th width="90">面向院系</th>
						<th width="90">报名模式</th>
						<th width="100">剩余报名人数</th>
						<th width="100">游览次数</th>
						<th width="130">发布时间</th>
						<th width="100">操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${lectureslist}" var="item">
						<tr class="text-c">
							<td><input type="checkbox" value="1" name=""></td>
							<td>${item.lecturesid}</td>
							<td><u style="cursor: pointer" class="text-primary"
								onclick="lectures_show('${item.lecturesname}','${ctx}/lectures/show?lecturesid='+${item.lecturesid},'360','400')">${item.lecturesname}</u></td>
							<td>${item.lecturesType.lecturestypename}</td>
							<td><fmt:formatDate value='${item.lecturestime}'
									pattern='yyyy-MM-dd HH:mm'/></td>
							<td>${item.colleges.collegesname}</td>
							<td><c:if test="${item.registrationtype=='1'}">不限人数报名</c:if>
								<c:if test="${item.registrationtype=='2'}">限人数报名</c:if></td>
							<td>${item.enrollnumber}</td>
							<td>${item.papeview}</td>
							<td><fmt:formatDate value='${ item.addtime}'
									pattern='yyyy-MM-dd HH:mm:ss' /></td>
							<td class="td-manage"><a title="编辑" href="javascript:;"
								onclick="lectures_edit('编辑讲座','${ctx}/lectures/edit?lecturesid='+${item.lecturesid})"
								class="ml-5" style="text-decoration: none"><i
									class="Hui-iconfont">&#xe6df;</i></a><a title="删除"
								href="javascript:;"
								onclick="lectures_del(this,${item.lecturesid})" class="ml-5"
								style="text-decoration: none"><i class="Hui-iconfont">&#xe6e2;</i></a>
								<a title="生成二维码" href="javascript:;"
								onclick="lectures_edit('生成二维码','${ctx}/lectures/getQ?id=${item.lecturesid}', '350','400')"
								class="ml-5" style="text-decoration: none"><i
									class="Hui-iconfont">&#xe695;</i></a>  <a title="查看报名名单" href="javascript:;"
								onclick="lectures_edit('报名名单','${ctx}/lectures/showenroll?lecturesid=${item.lecturesid}', '500','500')"
								class="ml-5" style="text-decoration: none"><i
									class="Hui-iconfont">&#xe695;</i></a>  <a title="查看签到名单" href="javascript:;"
								onclick="lectures_edit('签到名单','${ctx}/lectures/showsignin?lecturesid=${item.lecturesid}', '500','500')"
								class="ml-5" style="text-decoration: none"><i
									class="Hui-iconfont">&#xe695;</i></a></td>

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

		function lectures_add(title, url, w, h) {
			var index = layer.open({
				type: 2,
				title: title,
				content: url
			});
			layer.full(index);
		}
	
		function lectures_show(title, url, w, h) {
			layer_show(title, url, w, h);
		}
	
		function lectures_edit(title, url, w, h) {
			var index = layer.open({
				type: 2,
				title: title,
				content: url
			});
			layer.full(index);
		}

	
		function lectures_del(obj, id) {
			layer.confirm('确认要删除吗？', function(index) {
				$.ajax({
					type : "GET",
					url : "${ctx}/lectures/detele?lecturesid= "
							+ id,
					dataType : "json",
					success : function(data) {
						$(obj).parents("tr").remove();
						layer.msg('已删除!', {
							icon : 1,
							time : 1000
						});
					}
				});
			

			});
			
		}
	function exportExcel(){  
		     location.href="${ctx}/lectures/excel/export" 
		   } 
	</script>
	
	
</body>
</html>
