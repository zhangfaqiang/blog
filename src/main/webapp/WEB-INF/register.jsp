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
<body>
	<div class="container-fluid">

		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h1>用户注册</h1>
					</div>
					<div class="panel-body">
						<!-- 表单内容 -->
						<form class="form-horizontal" action="${rootPath}/user/register"
							method="post">
							<!-- 账号 -->
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-2 control-label">账号:</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="username"
										id="username" placeholder="账号">
								</div>
							</div>
							<!-- 昵称 -->
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-2 control-label">昵称:</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="nickname"
										id="nickname" placeholder="昵称">
								</div>
							</div>
							<!-- 网名 -->
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-2 control-label">网名:</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="netname"
										id="netname" placeholder="网名">
								</div>
							</div>
							<!-- 地址 -->
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-2 control-label">地址:</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="address"
										id="address" placeholder="地址">
								</div>
							</div>
							<!-- 职业 -->
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-2 control-label">职业:</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="occupation"
										id="occupation" placeholder="职业">
								</div>
							</div>
							<!-- 密码 -->
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-2 control-label">密码:</label>
								<div class="col-sm-10">
									<input type="password" class="form-control" name="password"
										id="password" placeholder="密码">
								</div>
							</div>
							<!-- 确认密码 -->
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-2 control-label">确认密码:</label>
								<div class="col-sm-10">
									<input type="password" class="form-control" name="password2"
										id="password2" placeholder="确认密码">
								</div>
							</div>
							<!-- 提交 -->
							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									<button type="submit" class="btn btn-success btn-lg btn-block"
										id="mashangzuche">马上注册</button>
										<button type="button" class="btn btn-success btn-lg btn-block"
										id="gotoLogin">去登陆</button>
								</div>
								
								<script type="text/javascript">
									if ("${message}"!="") {
										alert("${message}");
									}
								</script>
							</div>
						</form>
							<script>
							$("#gotoLogin").click(function(){
								window.location.href='${rootPath}/login'
							})
							
							</script>
					</div>
					<div class="panel-footer">
						<h6>版本所有权归个人所有</h6>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>