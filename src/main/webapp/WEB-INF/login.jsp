<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>登录 - 学生考勤管理系统</title>
<meta charset="utf-8">
<%@include file="include/jsp-resources.jsp"%>
<%@include file="include/resources.jsp"%>
</head>
<body style="background-color:#0FA854;">
	<form action="${rootPath}/user/login" method="post">
		<div id="myModal">
			<div class="modal-dialog " style="width: 500px;">
				<div class="modal-content ">
					<div class="modal-header ">
						<h4 class="modal-title">用户登陆</h4>
					</div>
					<div class="modal-body">
						<div class="row">
							<div class="col-md-2"></div>
							<div class="col-md-8">
								<div class="form-group">
									<input type="text" class="form-control" id="userName"
										name="userName" placeholder="用户名" value=${userName } >
								</div>
								<div class="form-group">
									<input type="password" class="form-control" id="userPassword"
										name="userPassword" placeholder="密码" />
								</div>

								<div class="input-group">
									<input type="text" class="form-control" id="captcha"
										name="captcha" placeholder="验证码" maxlength="4"> <span
										class="input-group-btn"> <img id="captchaImg"
										src="${rootPath}/captcha.html" alt="显示验证码" title="单击更换验证码" />
									</span>
								</div>

							</div>
							<div class="col-md-2"></div>
						</div>
					</div>
					<div class="modal-footer">
						<div class="text-center">
							<button type="submit" class="btn btn-success btn-lg">登陆</button>
							<button type="button" class="btn btn-info btn-lg" id="register">注册</button>
						</div>
						
					</div>
				</div>
				<div style="padding-top: 20px; color: red; font-size: 18px;">
					${requestScope.message}</div>
			</div>
		</div>
	</form>
	<script>
		$(function() {
			$("#captchaImg").click(
					function() {
						$(this).attr(
								"src",
								"${pageContext.request.contextPath}/captcha.html?time="
										+ new Date().getTime());
					});
			
			$("#register").click(function(){
				window.location.href="${rootPath}/register";
			});
		});
	</script>
</body>
</html>