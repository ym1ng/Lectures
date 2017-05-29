<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
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
<title></title>
</head>
<body>
	<div class="cl pd-20" style="background-color: #5bacb6">
		<img class="avatar size-XL l" src="${ctx}/static/h-ui/images/user.png">
		<dl style="margin-left: 80px; color: #fff">
			<dt>
				<span class="f-18">${user.realname} </span>
			</dt>
		</dl>
	</div>
	<div class="pd-20">
		<table class="table">
			<tbody>
				<tr>
					<th class="text-r" width="80">性别：</th>
					<td><c:choose>
							<c:when test="${user.realname == '1'}"> 男 </c:when>
							<c:when test="${user.realname == '2'}"> 女 </c:when>
							<c:otherwise> 保密 </c:otherwise>
						</c:choose></td>
				</tr>
				<tr>
					<th class="text-r">手机：</th>
					<td>${user.phone}</td>
				</tr>
				<tr>
					<th class="text-r">邮箱：</th>
					<td>${user.email}</td>
				</tr>
				<tr>
					<th class="text-r">地址：</th>
					<td>${user.address}</td>
				</tr>
				<tr>
					<th class="text-r">注册时间：</th>
					<td><fmt:formatDate value='${user.addtime}'
									pattern='yyyy-MM-dd HH:mm' /></td>
				</tr>
			</tbody>
		</table>
	</div>
	<script type="text/javascript"
		src="${ctx}/lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="${ctx}/static/h-ui/js/H-ui.js"></script>
	<script type="text/javascript"
		src="${ctx}/static/h-ui.admin/js/H-ui.admin.js"></script>
</body>
</html>