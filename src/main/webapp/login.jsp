<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="com.oraclewdp.book.model.Admin" %>
<%@ page import="java.util.Map" %>

<%@ page import="java.util.Set" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>登陆</title>
<!-- 告诉浏览器不要缩放 -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- css样式 -->

<link href="bower_components/bootswatch/dist/materia/bootstrap.css"
	rel="stylesheet" type="text/css" />
<link
	href="bower_components/bootstrap-datepicker/dist/css/bootstrap-datepicker3.css"
	rel="stylesheet" type="text/css" />

</head>
<body>
	<!-- 响应式设计 -->
	<div class="container-fluid" style="width: 80%;">
		<div class="row">
			<div class="col-md-12">
				<div class="card">
					<div class="card-body">
						<%--
						<!--登陆 前先验证验证码-->
						<%
							Map<String, String> errors= (Map<String, String>) request.getAttribute("errors");
						if(errors!=null){
							Set<String> keySet=errors.keySet();
							for (String key:
									keySet ) {
							    out.print(key+"--->"+errors.get(key));

							}
						}
						--%>


						%>

						<form method="post" autocomplete="off" action="login" id="loginForm">

							<%
								Map<String, String> errors= (Map<String, String>) request.getAttribute("errors");
								Admin admin= (Admin) request.getAttribute("admin");
								if (admin != null) {
							
							%>
							<div class="form-group row">
								<!-- lable 作用是当你点击 它内部的文字，for告诉那个输入框获取焦点-->

								<label for="inputName"
									class="col-sm-2 col-form-label text-right">用户名</label>
								<div class="col-sm-10">
									<%
									if(errors!=null&&errors.get("name")!=null){
									    %>


									<input type="text" class="form-control is-invalid" id="inputName"
										placeholder="用户名" name="name" value="<%=admin.getName()%>">
							<div class="invalid-feedback">
								<%=errors.get("name")%>
							</div>
									<%
										}else{
									    %>
									<input type="text" class="form-control" id="inputName"
										   placeholder="用户名" name="name" value="<%=admin.getName()%>">
									<%
										}
									%>
								</div>
							</div>
							<div class="form-group row">
								<label for="inputPwd" class="col-sm-2 col-form-label text-right">密码</label>
								<div class="col-sm-10">
									<%
										if(errors!=null&&errors.get("name")!=null){
									%>

									<input type="password" class="form-control is-invalid" id="inputPwd"
										placeholder="密码" name="vpwd"  <%=admin.getPwd()%>>
									<div class="invalid-feedback">
										<%=errors.get("pwd")%>
									</div>
									<%
									}else{
									%>
									<input type="password" class="form-control " id="inputPwd"
										   placeholder="密码" name="vpwd"  <%=admin.getPwd()%>>

									<%
										}
									%>
								</div>
							</div>
							<!--验证码-->
							<div class="form-group row">
								<label for="inputPwd" class="col-sm-2 col-form-label text-right">验证码</label>
								<div class="col-sm-5">

									<%
									if(errors!=null&&errors.get("name")!=null){
									    %>
									<input type="text" class="form-control is-invalid" id="inputVcode"
										   placeholder="验证码" name="vcode"  >
									<div class="invalid-feedback">
										<%=errors.get("vcode")%>
									</div>

									<%
									}else{
									    %>
									<input type="text" class="form-control" id="inputVcode"
										   placeholder="验证码" name="vcode"  >

									<%
									}
									%>



								<div class="col-sm-5">
									<<img src="vcode.png" alt="" id="vcodeImg" title="看不清  换一张">
								</div>
								<!--在输入框下面显示-->
								<div class="valid-feedback">
									<%
										if(request.getAttribute("msg")!=null){
									%>

									<%=request.getAttribute("msg")%>
									<%
										}
									%>
								</div>
							</div>

							<div class="form-group row">
								<div class="col-sm-2"></div>
								<div class="col-sm-10">
									<button type="submit" class="btn btn-primary">登陆</button>
								</div>
							</div>
						</form>
						<%
							} else {
						%>


						<div class="form-group row">
							<label for="inputEmail3"
								class="col-sm-2 col-form-label text-right">用户名</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="inputEmail3"
									placeholder="用户名" name="name">
							</div>
						</div>
						<div class="form-group row">
							<label for="inputPwd" class="col-sm-2 col-form-label text-right">密码</label>
							<div class="col-sm-10">
								<input type="password" class="form-control" id="inputPwd"
									placeholder="密码" name="pwd">
							</div>
						</div>
						<!--验证码-->
						<div class="form-group row">
							<label for="inputPwd" class="col-sm-2 col-form-label text-right">验证码</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="inputVcode"
									   placeholder="验证码" name="vcode"  >

							</div>
							<div class="col-sm-5">
								<<img src="vcode.png" alt="" id="vcodeImg" title="看不清  换一张">
							</div>
							<!--在输入框下面显示-->
							<div class="valid-feedback">
								<%
									if(request.getAttribute("msg")!=null){
								%>

								<%=request.getAttribute("msg")%>
								<%
									}
								%>
							</div>
						</div>


						<div class="form-group row">
							<div class="col-sm-2"></div>
							<div class="col-sm-10">
								<button type="submit" class="btn btn-primary">登陆</button>
							</div>
						</div>
						</form>

						<%
							}
						%>



					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="bower_components/bootstrap/dist/js/bootstrap.js"></script>
	<script type="text/javascript"
		src="bower_components/jquery/dist/jquery.slim.js"></script>
<script>
	$(function () {
		$("#vcodeImg").click(function () {
			$(this).attr("src","vcode.png?t="+Math.random());
        });
    });
	
</script>
	<!--添加验证脚本-->
	<script type="text/javascript" src="bower_components/jquery-validation/dist/jquery.validate.js"></script>
<script type="text/javascript">

    $(function () {
        $("#loginForm").validate({
            rules:{//规则
                name:{//描述
                    required:true,
                    maxlength:20,
					minlength:4
                },
                pwd:{//设置图片上传
                    required:true,
                    maxlength:20,
                    minlength:4
                }

            },
            messages:{//错误信息显示


            },
            errorElement:"div",
            errorClass:"invalid-feedback",//错误信息
            highlight:function (element, errorClass,validClass) {//对错误i信息高亮显示
                $(element).addClass("is-invalid").removeClass(validClass);
            },
            unheight:function (element, errorClass,validClass) {//对改正后的信息显示
                $(element).removeClass("is-invalid").addClass(validClass);
            },
            validClass:"is-invalid"//对改正后的信息显示
        });
    });
</script>
</body>
</html>
