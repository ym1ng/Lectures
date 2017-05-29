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

	<div class="page-container">
		<div class="cl pd-5 bg-1 bk-gray mt-20">
			<span class="l"><a href="javascript:;" onclick="exportExcel()"
				class="btn btn-success radius"><i class="Hui-iconfont">&#xe644;</i>
					导出数据</a></span> <span class="r">报名人数：<strong>${enrolllist.size()}</strong>
				条
			</span>
		</div>
		<div class="mt-20">
			<table
				class="table table-border table-bordered table-hover table-bg table-sort">
				<thead>
					<tr class="text-c">
						<th width="80">ID</th>
						<th width="100">姓名</th>
						<th width="40">性别</th>
						<th width="90">手机</th>
						<th width="150">邮箱</th>
						<th width="150">地址</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${enrolllist}" var="item">
						<tr class="text-c">
							<td>${item.user.userid}</td>
							<td>${item.user.realname}</td>
							<td><c:if test="${item.user.sex =='1'}">男</c:if> <c:if
									test="${item.user.sex =='2'}">女</c:if> <c:if
									test="${item.user.sex =='3'}">保密</c:if></td>
							<td>${item.user.phone}</td>
							<td>${item.user.email}</td>
							<td class="text-l">${item.user.address}</td>
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
	<script>  
function exportExcel(){  
     location.href="${ctx}/user/excel/export" 
   }  
</script>
</body>
</html>
