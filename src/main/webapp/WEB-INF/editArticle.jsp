<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>editData</title>
</head>
<%@include file="include/jsp-resources.jsp"%>
<%@include file="include/resources.jsp"%>
<body>
	<form id="baocunwenzhangForm" method="post" name="baocunwz">
		<div>
			<a href="${rootPath }/user/main" style="float:right;">返回首页</a>
		</div>
		<!-- 栅格布局 -->

		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-10">
				<!-- 面板 -->
				<div class="panel panel-default">

					<div class="panel-heading">
						<input type=text name="title" placeholder="标题" />
					</div>
					<div class="panel-heading">
						<!--  <input type=text name="fenlei" placeholder="分类"  />-->
						<select name="fenlei" style="width:176px;height:36px">
								<option value="时光的痕迹">时光的痕迹</option>
								<option value="慢生活">慢生活</option>
						</select>
					</div>
					<!-- 嵌入ueEdit编辑器form表单 -->
					<div class="panel-body">

						<!-- 加载编辑器的容器 -->
						<div>
							<script id="container" name="content" type="text/plain">
        					
    						</script>
							<!-- 配置文件 -->
							<script type="text/javascript"
								src="../lib/ueditor/ueditor.config.js"></script>
							<!-- 编辑器源码文件 -->
							<script type="text/javascript"
								src="../lib/ueditor/ueditor.all.js"></script>
							<!-- 实例化编辑器 -->
							<script type="text/javascript">
								var ue = UE.getEditor('container');
								ue.ready(function() {
									ue.setHeight(350);
									//设置编辑器的内容
									// ue.setContent('hello');
									// //获取html内容，返回: <p>hello</p>
									// var html = ue.getContent();
									// //获取纯文本内容，返回: hello
									// var txt = ue.getContentTxt();
								});
							</script>

						</div>

					</div>
					<!-- 表单的页脚 -->
					<div class="panel-footer">
						<div class="row">
							<div class="col-md-2"></div>
							<div class="col-md-8">
								<button id="baocunwenzhang" type="button"
									class="btn btn-info btn-lg btn-block">保存</button>
							</div>
							<div class="col-md-2"></div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-1"></div>
		</div>
		<input type=text hidden="hidden" name="uid" value="${userid }">

	</form>
	<script>
		$('#baocunwenzhang').click(function() {
			$.ajax({
				url : '${rootPath }/user/baocunarticle',
				type : 'post',
				dataType : 'json',
				data : $("#baocunwenzhangForm").serialize(),
				success : function(result) {
					alert(result.code);
				},
				error : function() {
					alert("保存文章失败！");
				}
			});
		});
	</script>
</body>
</html>
