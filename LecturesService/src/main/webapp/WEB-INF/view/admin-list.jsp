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
<title>管理员列表</title>
</head>
<body>
	<nav class="breadcrumb">
		<i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>
		管理员管理 <span class="c-gray en">&gt;</span> 管理员列表 <a
			class="btn btn-success radius r"
			style="line-height: 1.6em; margin-top: 3px"
			href="javascript:location.replace(location.href);" title="刷新"><i
			class="Hui-iconfont">&#xe68f;</i></a>
	</nav>
	<div class="page-container">
		<div class="text-c">
			<form action="${ctx}/admin_select">

				日期范围： <input type="text"
					onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}'})"
					name="datemin" id="datemin" class="input-text Wdate"
					style="width: 120px;"> - <input type="text"
					onfocus="WdatePicker({minDate:'#F{$dp.$D(\'datemin\')}',maxDate:'%y-%M-%d'})"
					name="datemax" id="datemax" class="input-text Wdate"
					style="width: 120px;"> 
				<button type="submit" class="btn btn-success" id="select_admin"
					name="">
					<i class="Hui-iconfont">&#xe665;</i> 搜索
				</button>
			</form>

		</div>
		<div class="cl pd-5 bg-1 bk-gray mt-20">
			<span class="l"><a href="javascript:;" onclick="datadel()"
				class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i>
					批量删除</a> <a href="javascript:;"
				onclick="admin_add('添加管理员','${ctx}/admin_add','800','500')"
				class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i>
					添加管理员</a></span> <span class="r">共有数据：<strong>${list.size()}</strong> 条
			</span>
		</div>
		<table
			class="table table-border table-bordered table-hover table-bg table-sort">
			<thead>
				<tr class="text-c">
					<th width="25"><input type="checkbox" name="" value=""></th>
					<th width="40">ID</th>
					<th width="150">登录名</th>
					<th width="90">手机</th>
					<th width="150">邮箱</th>
					<th width="150">角色</th>
					<th width="130">加入时间</th>
					<th width="100">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="item">
					<tr class="text-c">
						<td><input type="checkbox" value="1" name=""></td>
						<td>${ item.managerid}</td>
						<td>${ item.username}</td>
						<td>${ item.mobile}</td>
						<td>${ item.email}</td>
						<td>${ item.role.rolename}</td>
						<td><fmt:formatDate value='${ item.addtime}'
								pattern='yyyy-MM-dd HH:mm:ss' /></td>
						<td class="td-manage"><a title="编辑" href="javascript:;"
							onclick="admin_edit('管理员编辑','${ctx}/admin_edit?managerid=${item.managerid}','1','800','500')"
							class="ml-5" style="text-decoration: none"><i
								class="Hui-iconfont">&#xe6df;</i></a> <a title="删除"
							href="javascript:;" onclick="admin_del(this,${item.managerid})"
							class="ml-5" style="text-decoration: none"><i
								class="Hui-iconfont">&#xe6e2;</i></a></td>
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
		/*
		 参数解释：
		 title	标题
		 url		请求的url
		 id		需要操作的数据id
		 w		弹出层宽度（缺省调默认值）
		 h		弹出层高度（缺省调默认值）
		 */
		 $(function(){
				$('.table-sort').dataTable({
					"aaSorting": [[ 1, "asc" ]],//默认第几个排序
					"bStateSave": true,//状态保存
					"aoColumnDefs": [
				/* 	  {"bVisible": false, "aTargets": [ 3 ]},//控制列的隐藏显示 */
					  {"orderable":false,"aTargets":[0,6,7]}// 制定列不参与排序
					]
				});
			});
		 
		/*管理员-增加*/
		function admin_add(title, url, w, h) {
			layer_show(title, url, w, h);
		}
		/*管理员-删除*/
		function admin_del(obj, id) {
			layer.confirm('确认要删除吗？', function(index) {
/* 			location.href= "http://localhost:8080/test_zym/admin_detele?managerid= "+id; */
			 $.ajax({
             type: "GET",
             url: "${ctx}/admin_detele?managerid= "+id,
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
		/*管理员-编辑*/
		function admin_edit(title, url, id, w, h) {
			
			layer_show(title, url, w, h);
		}
		
/* 		$('#select_admin').click(		
		  function() {
				window.location.href = "";		
		}); */
		
	</script>
</body>
</html>
