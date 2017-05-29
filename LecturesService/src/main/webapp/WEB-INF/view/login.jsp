<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE HTML>
<html>
<head>
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<script type="text/javascript" src="lib/PIE_IE678.js"></script>
<![endif]-->
<link href="${ctx}/static/h-ui/css/H-ui.min.css" rel="stylesheet"
	type="text/css" />
<link href="${ctx}/static/h-ui.admin/css/H-ui.login.css"
	rel="stylesheet" type="text/css" />
<link href="${ctx}/static/h-ui.admin/css/style.css" rel="stylesheet"
	type="text/css" />
<link href="${ctx}/lib/Hui-iconfont/1.0.7/iconfont.css" rel="stylesheet"
	type="text/css" />
<!--[if IE 6]>
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>高校讲座管理平台</title>

</head>
<body>
	<input type="hidden" id="TenantId" name="TenantId" value="" />
	<div class="header"></div>
	<div class="loginWraper">
		<div class="loginBox">
			<form class="form form-horizontal" id="loginform">
				<div class="row cl">
					<label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60d;</i></label>
					<div class="formControls col-xs-8">
						<input id="username" name="username" type="text" placeholder="账户"
							class="input-text size-L">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60e;</i></label>
					<div class="formControls col-xs-8">
						<input id="password" name="password" type="password"
							placeholder="密码" class="input-text size-L">
					</div>
				</div>
				<div class="row cl">
					<div class="formControls col-xs-8 col-xs-offset-3">
						<input class="input-text size-L" name="validateCode"
							id="validateCode" type="text" placeholder="验证码"
							style="width: 150px;"> <a href="#"><img
							id="validateCodeImg" src="${ctx}/validateCode" /></a>
					</div>
				</div>
				<div class="row cl">
					<div class="formControls col-xs-8 col-xs-offset-3">
						<input name="" type="button" class="btn btn-success radius size-L"
							id="submit_btn" value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;">
						<input name="" type="reset" class="btn btn-default radius size-L"
							value="&nbsp;取&nbsp;&nbsp;&nbsp;&nbsp;消&nbsp;">
					</div>
				</div>
			</form>
		</div>
	</div>
	<div class="footer">Copyright 张一铭 by H-ui.admin.v2.5</div>
	<script type="text/javascript"
		src="${ctx}/lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="${ctx}/lib/layer/2.1/layer.js"></script>
	<script type="text/javascript" src="${ctx}/lib/laypage/1.2/laypage.js"></script>
	<script type="text/javascript" src="${ctx}/static/h-ui/js/H-ui.js"></script>
	<script type="text/javascript">
		$("#validateCodeImg").click(
				function() {
					//如果需要点击图片改变图片的内容，则必须添加时间戳
					$("#validateCodeImg").attr("src",
							"${ctx}/validateCode?rmd=" + new Date().getTime())
				});

		//支持Enter键登录
		document.onkeydown = function(e) {
			if (!e)
				e = window.event;
			if ((e.keyCode || e.which) == 13) {
				var obtnLogin = document.getElementById("loginform")
				obtnLogin.focus();
			}
		}

		//提交表单
		$('#submit_btn').click(
				function() {
					var username = document.getElementById("username").value;
					var password = document.getElementById("password").value;
					var validateCode = document.getElementById("validateCode").value;

					if (username == "") {
						alert("用户名为空")
					} else if (password == "") {
						alert("密码为空")
					}else if(validateCode==""){
						alert("验证码为空")
					}else{
						$.ajax({
							url : "${ctx}/adminlogin",
							data : $("#loginform").serialize(),
							type : "post",
							success : function(data) {//ajax返回的数据
								if (data.code == '1') {
									layer.msg(data.msg, {
										icon : 2,
										time : 1000
									});
									$("#validateCodeImg").attr(
											"src",
											"${ctx}/validateCode?rmd="
													+ new Date().getTime())
								} else if (data.code == '0') {
									window.location.href = "${ctx}/index";

								}

							}
						});
					}
				});
	</script>
</body>
</html>