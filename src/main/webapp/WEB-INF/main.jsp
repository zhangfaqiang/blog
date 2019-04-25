<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!doctype html>
<html>
<head>
<title>个人博客</title>
<%@include file="./include/jsp-resources.jsp"%>
<%@include file="./include/resources.jsp"%>
<meta http-equiv="pragma" content="no-cache">

<meta http-equiv="cache-Control" content="no-cache">

<meta http-equiv="expires" content="0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="Keywords"
	content="杨青个人博客网站,杨青网站，杨青博客,个人博客,原创博客,个人博客网站,独立个人博客模板下载,个人网站博客设计,html5 个人博客网站">
<meta name="Description"
	content="个人原创博客，提供本站博客div+css源码分享，喜欢的朋友可以直接下载。如果需要整站asp代码，请到留言版留下你的邮箱...">
<link href="../lib/css/index.css" rel="stylesheet">

<link href='http://fonts.googleapis.com/css?family=La+Belle+Aurore'
	rel='stylesheet' type='text/css'>
</head>
<body>
	<figure>
		<div style="float:right; margin-right:50px;">
			<h4 style="cursor: pointer" onclick=window.location.href="${rootPath}/user/exit">
				退出系统</h4>
		</div>
	</figure>

	<header>
		<h1>
			<a href="/">夏随枫散尽</a>
		</h1>
		<p>如果没有为陌上悄然伫立并为陌上风情所陶醉的人，那么花开也寂寞,风情也苍白...</p>
	</header>
	<!--nav begin-->
	<div id="nav">
		<ul>
			<li><a href="/">网站首页</a></li>
			<li><a href="/news/" target="_blank" title="慢生活">慢生活</a></li>
			<li><a href="/jstt/" target="_blank" title="技术探讨">技术探讨</a></li>
			<li><a href="/download/" target="_blank" title="模板下载">模板下载</a></li>
			<li><a href="/newstalk/" target="_blank" title="碎言碎语">碎言碎语</a></li>
			<li><a href="/newshtml5/" target="_blank" title="HTML5业界">HTML5业界</a></li>
			<li><a href="/news/case/" target="_blank" title="作品展示">作品展示</a></li>
			<li><a href="/news/jsex/" target="_blank" title="JS 实例代码演示">JS实例</a></li>
			<li><a href="/e/tool/gbook/?bid=1" target="_blank" title="留言版">留言版</a></li>
		</ul>
	</div>
	<!--nav end-->
	<div class="lace_hd_ft"></div>
	<article>
		<div class="blog" id="showArticle">
			<h3>
				<p>
					最新文章<span>New Blog</span>
				</p>
			</h3>
	
			<%-- <div class="bloglist">
					<h2>
						<a href="/">${re.title }</a>
					</h2>
					<p class="datetime">${re.riqi }</p>
					<ul class="topimg">
						<img src="../lib/images/2011713195450617.jpg">
					</ul>
					<ul class="content">
						 <p>女孩子都有着浪漫的小情怀，对于求婚更是抱着满满的浪漫期待，也希望在求婚那一天对方可以给自己一个最浪漫的求婚词。</p>
						<p>you are the apple of my eyes.</p>
						<p>你是我这辈子最珍贵的人。请让我永远守护在你身边，我一定将你当成掌心的珍宝，一辈子悉心呵护。你，愿意嫁给我吗？</p>
						<p>女孩子都有着浪漫的小情怀，对于求婚更是抱着满满的浪漫期待，也希望在求婚那一天对方可以给自己一个最浪漫的求婚词。</p>
						<p>you are the apple of my eyes.</p>
						<p>你是我这辈子最珍贵的人。请让我永远守护在你身边，我一定将你当成掌心的珍宝，一辈子悉心呵护。你，愿意嫁给我吗？</p>
					</ul>
					<p class="read">
						<button class="btn btn-primary">删除</button>
						<button class="btn btn-primary">修改分类</button>
					</p>
				</div>
			 --%>
		</div>
				<script>
			//显示文章
		$(function(){
			
			$.ajax({
				url : '${rootPath }/user/showArticle',
				type : 'post',
				dataType : 'json',
				success : function(data){
				if(data==null||data==""){
					$('#showArticle').append('<div class="bloglist">暂无内容</div>');
				}
					$.each(data, function(i,item){ 
						var riqi=new Date(item.riqi).toLocaleString();
						var id=data[i].id;
						$('#showArticle').append('<div class="bloglist" id="'+id+'"> <h2><a href="/">'+item.title+'</a></br>分类('+item.fenlei+')</h2><p class="datetime">'+riqi+'</p><ul class="topimg"><img src="../lib/images/2011714152744924.jpg"></ul><ul class="content">'+item.content+'</p></ul><p class="read"><button onclick="deleteArticle(\''+id+'\')" class="btn btn-primary">删除</button><button onclick="updateArticle(\''+id+'\')" class="btn btn-primary">修改文章</button><button class="btn btn-primary" onclick="updatefenlei(\''+id+'\')">修改分类</button></p> </div>');
						var h=$('#'+data[i].id).height();
						if(h<270){
							$('#'+data[i].id).height(270);
						}
					});
				} 
			});
		});
		//删除文章
		function deleteArticle(id){
			$.ajax({
				url:'${rootPath }/user/deleteArticle',
				type: 'POST',   
				datatype:'json',
				data:{'id':id},
				success:function(data){
					alert(data.message);
					location.reload(true);
				}
			});
		}
		//更改文章分类
		function updatefenlei(id){
			var id=id;
			$('#articleid').attr('value',id);
			$('#updateFenLeiModal').modal('show');
			$('#savaFenLei').click(function(){
				$.ajax({
					url:'${rootPath}/user/updateFenLei',
					type:'post',
					datatype:'json',
					data:$('#fenleiForm').serialize(),
					success:function(data){
						$('#updateFenLeiModal').modal('hide');
						alert(data.message);
						location.reload(true);
						
					}
				});
			});
		}
		//更改文章
		function updateArticle(id){
			var id=id;
			$('#updateArticleModal').modal('show');
			$('#updatearticleid').attr('value',id);
			$.ajax({
				url:'${rootPath}/user/updateArticle',
				type:'post',
				datatype:'json',
				data:{"id":id},
				success:function(data){
					dangeResult=data.dangeResult;
					console.log(dangeResult);
					$('#title').attr('value',dangeResult.title);
					$('#content').html(dangeResult.content);
				}
			});
			$('#saveupdateArticle').click(function(){
				$.ajax({
					url:'${rootPath}/user/saveupdateArticle',
					type:'post',
					datatype:'json',
					data:$('#updateArticleForm').serialize(),
					success:function(data){
						alert(data.message);
						$('#updateArticleModal').modal('hide');
						location.reload(true);
					}
				});
			});
		}
	</script>
		<aside>
			<img src="${rootPath }/${user.id}/${user.id}.jpg" class="about"
				id="pto" style="height:250px">
			<form name="uploadFileForm" id="uploadPic"
				action="${rootPath }/user/upload/photo" method="post"
				enctype="multipart/form-data">
				<input type="file" name="img"> <input type="button"
					onclick="uploadFiles()" class="btn btn-primary btn-sm btn-block"
					value="上传">

			</form>
			<script>  
	function uploadFiles(){    
	//  var uploadFile = $('#excelFile').get(0).files[0];  
	    var uploadFile = new FormData($("#uploadPic")[0]);  
	    console.log(uploadFile);  
	    if("undefined" != typeof(uploadFile) && uploadFile != null && uploadFile != ""){  
	        $.ajax({  
	            url:'${rootPath }/user/upload/photo',  
	            type:'POST',  
	            data:uploadFile,  
	            async: false,    
	            cache: false,   
	            contentType: false, //不设置内容类型  
	            processData: false, //不处理数据  
	            success:function(data){  
	                alert(data.success); 
	                $('#pto').attr("src",data.photomessage);
	                location.reload();
	            },  
	            error:function(){  
	                alert("上传失败！");  
	            }  
	        })  
	    }else {  
	        alert("选择的文件无效！请重新选择");  
	    }  
	}     
</script>
			<div class="vcard">
				<p class="fn">昵称:${nickname}</p>
				<p class="nickname">网名：${netname}</p>
				<p class="address">现居：${address}</p>
				<p class="role">职业：${occupation}</p>
				<!-- Button trigger modal -->
				<button type="button" class="btn btn-primary btn-sm"
					data-toggle="modal" data-target="#myModal">修改个人资料</button>


			</div>
			<h2 style="cursor:pointer;" onclick=window.location.href="${rootPath }/user/article">写文章</h2>
			<h2>博客分类</h2>
			<ul>
				<!-- <li><a href="/">经典美文(39)</a></li> -->
				<c:forEach items="${articleResult }" var="result" end="4">

					<li>${result.fenlei }(3)</li>

				</c:forEach>
			</ul>
			<h2>近期文章</h2>
			<!-- <ul>
				<li><a href="/">女孩都有浪漫的小情怀</a></li>
				<li><a href="/">也许下个路口就会遇见希望</a></li>
				<li><a href="/">6月毕业季，祝福送给你</a></li>
				<li><a href="/">生活常有缺席的-可搞笑从来不缺席</a></li>
				<li><a href="/">为了一个不存在的梦，执念了那么多年</a></li>
			</ul> -->
			<ul>
				<c:forEach items="${articleResult }" var="result" end="4">

					<li>${result.title }</li>

				</c:forEach>
			</ul>
			<h2>文章归档</h2>
			<ul>
				<c:forEach items="${articleResult }" var="result" end="4">

					<li>${result.riqi }</li>

				</c:forEach>
			</ul>
			<h2>友情链接</h2>
			<ul>
				<li><a href="http://www.yangqq.com">流氓兔个人博客</a></li>
			</ul>
			<!-- Baidu Button BEGIN -->
			<div id="bdshare"
				class="bdshare_t bds_tools_32 get-codes-bdshare share">
				<a class="bds_tsina"></a> <a class="bds_qzone"></a> <a
					class="bds_tqq"></a> <a class="bds_renren"></a> <span
					class="bds_more"></span>
			</div>
			<script type="text/javascript" id="bdshare_js"
				data="type=tools&amp;uid=6574585"></script>
			<script type="text/javascript" id="bdshell_js"></script>
			<script type="text/javascript">
				document.getElementById("bdshell_js").src = "http://bdimg.share.baidu.com/static/js/shell_v2.js?cdnversion=" + Math.ceil(new Date()/3600000)
			</script>
			<!-- Baidu Button END -->
		</aside>
	</article>
	<div class="blank"></div>
	<div id="copright">Design by DanceSmile</div>
	<script src="../lib/js/silder.js"></script>
	<!-- 修改文章模态框开始 -->
	<div class="modal fade" id="updateArticleModal" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">修改文章</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="updateArticleForm">

						<!-- id字段 -->
						<input type="hidden" id="updatearticleid" name="id" value="">
						<!-- 标题 -->
						<div class="form-group">
							<label for="title" class="col-sm-2 control-label">标题:</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="title"
									id="title" value="">
							</div>
						</div>
						<!-- 内容 -->
						<div class="form-group">
							<label for="content" class="col-sm-2 control-label">内容:</label>
							<div class="col-sm-10">
							<textarea  id="content"  name="content" style="height:350px; width:468px"></textarea>
								
							</div>
						</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button"  onclick="saveupdateArticle()" id="saveupdateArticle" class="btn btn-primary">确认修改</button>
				</div>
			</div>
		</div>
	</div>
	</form>
	<!-- 修改文章模态框结束 -->
	<!-- 加入更新文章分类模态框开始 -->
	<div class="modal fade" id="updateFenLeiModal" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">修改文章类型</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="fenleiForm">
	
						<!-- id字段 -->
						<input type="hidden" id="articleid" name="id" value="">

						<!-- 分类 -->
						
						<div class="form-group">
							<label for="fenlei" class="col-sm-2 control-label">分类为:</label>
							<div class="col-sm-10">
								<Select name="fenlei" style="width:444px;height:36px">
										<option value='慢生活'>慢生活</option>
										<option value='时光的痕迹'>时光的痕迹</option>
								</Select>
							</div>
						</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" id="savaFenLei" class="btn btn-primary">确认修改</button>
				</div>
			</div>
		</div>
	</div>
	</form>
	<!-- 加入更新文章分类模态框结束 -->
	<!-- 加入修改个人资料模态框开始 -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">修改个人资料</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" action="${rootPath}/user/editdata"
						method="post">
						<!-- id字段 -->
						<input type="text" value="${userid }" name="id" hidden="hidden">


						<!-- 昵称 -->
						<div class="form-group">
							<label for="nickname" class="col-sm-2 control-label">昵称:</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="nickname"
									id="nickname" value="${nickname}">
							</div>
						</div>
						<!-- 网名 -->
						<div class="form-group">
							<label for="netname" class="col-sm-2 control-label">网名:</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="netname"
									id="netname" value="${netname}">
							</div>
						</div>
						<!-- 地址 -->
						<div class="form-group">
							<label for="address" class="col-sm-2 control-label">地址:</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="address"
									id="address" value="${address}">
							</div>
						</div>
						<!-- 职业 -->
						<div class="form-group">
							<label for="occupation" class="col-sm-2 control-label">职业:</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="occupation"
									id="occupation" value="${occupation }">
							</div>
						</div>
						<!-- 密码 -->
						<div class="form-group">
							<label for="password" class="col-sm-2 control-label">密码:</label>
							<div class="col-sm-10">
								<input type="password" class="form-control" name="password"
									id="password" value="${password }">
							</div>
						</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="submit" class="btn btn-primary">确认修改</button>
				</div>
			</div>
		</div>

		<script>
				 if ("${updateMessage }"!="") {
					alert("${updateMessage }");
				}
				
		</script>
	</div>
	</form>
	<!-- 加入模态框结束 -->

</body>
</html>
