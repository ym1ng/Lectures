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
<title> </title>
</head>
<body>
	<article class="page-container">
	<form action="" method="post" class="form form-horizontal"  enctype="multipart/form-data"
		id="form-member-add">
		<input type="hidden" id="lecturesid" name="lecturesid"
			value="${lectures.lecturesid}" />
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>讲座名：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text"
					value="${lectures.lecturesname}" placeholder="" id="lecturesname"
					name="lecturesname">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>演讲人：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text"
					value="${lectures.speechmaker}" placeholder="" id="speechmaker"
					name="speechmaker">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>演讲时间：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" name="lecturestime"
					onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})"
					class="input-text Wdate" style="width: 200px;"
					value='<fmt:formatDate value='${lectures.lecturestime }'
									pattern='yyyy-MM-dd HH:mm' />' />
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">讲座海报：</label>
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
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>讲座地点：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="select-box" style="width: 150px;"> <select
					class="select" name="classroom" size="1">
						<c:forEach items="${classroomlist}" var="item">
							<option value="${item.classroomid}"
								<c:if test="${lectures.classroomid==item.classroomid}">  selected="selected"</c:if>>${item.classroomname}</option>
						</c:forEach>
				</select>
				</span>
			</div>

		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>讲座类型：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="select-box" style="width: 150px;"> <select
					class="select" name="lecturestype" size="1">
					<c:forEach items="${lecturesTypelist}" var="item">
							<option value="${item.lecturestypeid}"
								<c:if test="${lectures.lecturestype==item.lecturestypeid}">  selected="selected"</c:if>>${item.lecturestypename}</option>
						</c:forEach>
				</select>
				</span>
			</div>

		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span> 报名类型：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="select-box" style="width: 150px;"> <select
					class="select" name="registrationtypeid" size="1">
						<option value="1" <c:if test="${lectures.registrationtype==1}">  selected="selected"</c:if> >不限人模式</option>
						<option value="2" <c:if test="${lectures.registrationtype==2}">  selected="selected"</c:if>>抢票模式</option>
				</select>
				</span>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>报名人数：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" name="total"
					value="${lectures.enrollnumber}" id="total">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">面向院系：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="select-box" style="width: 150px;"> <select
					class="select" name="colleges" size="1">
						<c:forEach items="${collegeslist}" var="item">
							<option value="${item.collegesid}"
								<c:if test="${lectures.collegesid==item.collegesid}">  selected="selected"</c:if>>${item.collegesname}</option>
						</c:forEach>
				</select>
				</span>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">讲座介绍：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<!-- 加载编辑器的容器 -->
				<script id="container" name="content" type="text/plain"
					style="width:100%;height:200px;">${lectures.lecturescontent} </script>
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
	<script type="text/javascript"
		src="${ctx}/lib/My97DatePicker/WdatePicker.js"></script>

	<!--/_footer /作为公共模版分离出去-->
	<script type="text/javascript"
		src="${ctx}/utf8-jsp/ueditor.config.js"></script>
	<script type="text/javascript"
		src="${ctx}/utf8-jsp/ueditor.all.min.js">
		
	</script>
	<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
	<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
	<script type="text/javascript"
		src="${ctx}/utf8-jsp/lang/zh-cn/zh-cn.js"></script>
	<!-- 实例化编辑器 -->
	<script type="text/javascript">
		UEDITOR_CONFIG.UEDITOR_HOME_URL = '${ctx}/utf8-jsp/'; //一定要用这句话，否则你需要去ueditor.config.js修改路径的配置信息
		var ue = UE.getEditor('container');
	</script>

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
														type : "post",
														url : "${ctx}/lectures/save ",
														dataType : "json",
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
																window.parent.location.reload();
															} else {
																parent.layer
																		.msg(
																				"操作失败"
																						+ data.msg,
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