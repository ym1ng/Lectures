<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="${ctx}/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/lib/Hui-iconfont/1.0.7/iconfont.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/lib/icheck/icheck.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="${ctx}/static/h-ui.admin/css/style.css" />
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<LINK rel="Bookmark" href="/favicon.ico" >
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
	<form action="" method="post" class="form form-horizontal" id="role-add">
		<input type="hidden" id="enrollid" name="collectionid" value="${collection.collectionid}" />
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>讲座编号：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${collection.lecturesid}" placeholder="" id="lecturesid" name="lecturesid">
			</div>
		</div>
	
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>用户编号：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${collection.userid}" placeholder="" id="userid" name="userid">
			</div>
		</div>
	
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
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
	$(function(){
		$("#role-add").validate({
			rules:{
				roleName:{
					required:true,
				},
			},
			onkeyup:false,
			focusCleanup:true,
			success:"valid",
			submitHandler:function(form){
				$(form).ajaxSubmit({
					type : "post",
					url : "${ctx}/collection/save",
					dataType : "json",
					success : function(data) {	
						
						var index = parent.layer							
						.getFrameIndex(window.name);
						parent.$('.btn-refresh').click();
						
						if(data.msg=="true"){
						parent.layer.msg("操作成功", {
							icon : 1,
							time : 1000
						});
						window.parent.location.reload();
						parent.layer.close(index);
					
						}
						else{
							parent.layer.msg("操作失败"+ data.msg, {
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