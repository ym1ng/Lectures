<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<LINK rel="Bookmark" href="/favicon.ico">
<LINK rel="Shortcut Icon" href="/favicon.ico" />
<!--[if lt IE 9]>
<script type="text/javascript" src="http://lib.h-ui.net/html5.js"></script>
<script type="text/javascript" src="http://lib.h-ui.net/respond.min.js"></script>
<script type="text/javascript" src="http://lib.h-ui.net/PIE_IE678.js"></script>
<![endif]-->

<!--[if IE 6]>
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<!--/meta 作为公共模版分离出去-->
<title></title>
</head>
<body>
	<article class="page-container">
	<form action="" method="post" class="form form-horizontal"
		enctype="multipart/form-data" id="form-member-add">
		<input type="hidden" id="userid" name="userid" value="${user.userid}" />
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>用户名：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${user.username }"
					placeholder="" id="username" name="username">
			</div>
		</div>
		<c:if test="${user.password==null}">
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span
					class="c-red">*</span>密码：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="password" class="input-text" autocomplete="off"
						value="" placeholder="密码" id="password" name="password">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span
					class="c-red">*</span>确认密码：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="password" class="input-text" autocomplete="off"
						value="" placeholder="确认新密码" id="password2" name="password2">
				</div>
			</div>
		</c:if>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>真实姓名：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${user.realname }"
					placeholder="" id="realname" name="realname">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>性别：</label>
			<div class="formControls col-xs-8 col-sm-9 skin-minimal">
				<div class="radio-box">
					<input name="sex" type="radio" id="sex-1" value="1"
						<c:if test="${user.sex=='1'}">checked</c:if>> <label
						for="sex-1">男</label>
				</div>
				<div class="radio-box">
					<input type="radio" id="sex-2" name="sex" value="2"
						<c:if test="${user.sex=='2'}">checked</c:if>> <label
						for="sex-2">女</label>
				</div>
				<div class="radio-box">
					<input type="radio" id="sex-3" name="sex" value="3"
						<c:if test="${user.sex=='3'}">checked</c:if>> <label
						for="sex-3">保密</label>
				</div>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">院系：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="select-box" style="width: 150px;"> <select
					class="select" name="colleges" size="1">
						<c:forEach items="${collegeslist}" var="item">
							<option value="${item.collegesid}"
								<c:if test="${user.collegesid==item.collegesid}">  selected="selected"</c:if>>${item.collegesname}</option>
						</c:forEach>
				</select>
				</span>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>手机：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${user.phone}"
					placeholder="" id="phone" name="phone">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>邮箱：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" placeholder="@" name="email"
					value="${user.email}" id="email">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">头像：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="btn-upload form-group"> <input
					class="input-text upload-url" type="text" name="uploadfile"
					id="uploadfile" readonly nullmsg="请添加附件！" style="width: 200px">
					<a href="javascript:void();"
					class="btn btn-primary radius upload-btn"><i
						class="Hui-iconfont">&#xe642;</i> 浏览文件</a> <input type="file"
					name="file" class="input-file">
				</span>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">地址：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" name="address"
					value="${user.address}" id="address">
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<input class="btn btn-primary radius" type="submit"
					value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
			</div>
		</div>
	</form>
	</article>

	<!--_footer 作为公共模版分离出去-->
	<script type="text/javascript"
		src="http://lib.h-ui.net/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript"
		src="http://lib.h-ui.net/layer/2.1/layer.js"></script>
	<script type="text/javascript"
		src="http://lib.h-ui.net/icheck/jquery.icheck.min.js"></script>
	<script type="text/javascript"
		src="http://lib.h-ui.net/jquery.validation/1.14.0/jquery.validate.min.js"></script>
	<script type="text/javascript"
		src="http://lib.h-ui.net/jquery.validation/1.14.0/validate-methods.js"></script>
	<script src="http://malsup.github.io/jquery.form.js"></script>
	<script type="text/javascript"
		src="http://lib.h-ui.net/jquery.validation/1.14.0/messages_zh.min.js"></script>
	<script type="text/javascript" src="${ctx}/static/h-ui/js/H-ui.js"></script>
	<script type="text/javascript"
		src="${ctx}/static/h-ui.admin/js/H-ui.admin.js"></script>
	<!--/_footer /作为公共模版分离出去-->

	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript">
		$(function() {
			$("#form-member-add")
					.validate(
							{
								rules : {
									username : {
										required : true,
									},
									realname : {
										required : true,
									},
									sex : {
										required : true,
									},
									password : {
										required : true,
									},
									password2 : {
										required : true,
										equalTo : "#password"
									},
									phone : {
										required : true,
										isPhone : true,

									},
									email : {
										required : true,
										email : true,
									},
								},
								onkeyup : false,
								focusCleanup : true,
								success : "valid",
								submitHandler : function(form) {
									$(form)
											.ajaxSubmit(
													{
														type : "POST",
														url : "${ctx}/user/save",
														success : function(data) {
															var index = parent.layer
																	.getFrameIndex(window.name);
															parent
																	.$(
																			'.btn-refresh')
																	.click();
															if (data.msg == "true") {
																parent.layer
																		.msg(
																				"操作成功",
																				{
																					icon : 1,
																					time : 1000
																				});
																window.parent.location
																		.reload();
																parent.layer
																		.close(index);

															} else {
																parent.layer
																		.msg(
																				"操作失败",	
																				{
																					icon : 2,
																					time : 1000
																				});

															}

														}
													});
									return false; // 阻止表单自动提交事件
								}
							});
		});
	</script>
	<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>