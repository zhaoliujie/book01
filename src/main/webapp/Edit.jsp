<%@page import="com.oraclewdp.big.model.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="charset=UTF-8">
<head>
<title>修改</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link href="bower_components/bootswatch/dist/materia/bootstrap.css"
	rel="stylesheet" type="text/css" />
<style type="text/css">
.custom-file-label::after {
	content: "浏览";
}
</style>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="card">
					<div class="card-body">

						<form method="post" action="doEdit" enctype="multipart/form-data">
							<%
								Book book = (Book) request.getAttribute("book");
							%>
							<input type="hidden" name="id" value="<%=book.getId() %>">
							<div class="form-group row">
								<label for="inputEmail"
									class="col-sm-2 col-form-label text-right">大类</label>
								<div class="col-sm-10">
									<select name="bid" class="form-control" id="inputid">
										<option value="-1">--请选择类别--</option>
									</select>
								</div>
							</div>
							<div class="form-group row">
								<label for="inputEmails"
									class="col-sm-2 col-form-label text-right">小类</label>
								<div class="col-sm-10">
									<select name="xid" class="form-control" id="inputxid">

									</select>
								</div>
							</div>

							<div class="form-group row">
								<label for="inputEmail3"
									class="col-sm-2 col-form-label text-right">书名</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="inputEmail3"
										placeholder="书名" name="shuming" value="<%=book.getShuming()%>">
								</div>
							</div>
							<div class="form-group row">
								<label for="inputEmail3"
									class="col-sm-2 col-form-label text-right">价格</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="inputEmail3"
										placeholder="价格" name="jiage" value="<%=book.getJiage()%>">
								</div>
							</div>
							<div class="form-group row">
								<label for="inputEmail3"
									class="col-sm-2 col-form-label text-right">作者</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="inputEmail3"
										placeholder="作者" name="zuozhe" value="<%=book.getZuozhe()%>">
								</div>
							</div>
							<div class="form-group row">
								<label for="inputEmail3"
									class="col-sm-2 col-form-label text-right">字数</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="inputEmail3"
										placeholder="字数" name="zishu" value="<%=book.getZishu()%>">
								</div>
							</div>
							<div class="form-group row">
								<label for="inputEmail3"
									class="col-sm-2 col-form-label text-right">简介</label>
								<div class="col-sm-10">
									<textarea class="form-control" placeholder="简介" name="jianjie"
										id="inputEmail3"><%=book.getJianjie() %></textarea>
								</div>
							</div>
							<div class="form-group row">
								<label for="inputBirthday"
									class="col-sm-2 col-form-label text-right">日期</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="inputBirthday"
										placeholder="日期" name="riqi" readonly="readonly" value="<%=book.getRiqi() %>">
								</div>
							</div>
							<div class="form-group row">
								<label for="inputPhoto"
									class="col-sm-2 col-form-label text-right">图片</label>
								<div class="col-sm-10">
									<div class="input-group">
										<div class="custom-file">
											<input type="file" class="custom-file-input" id="inputPhoto"
												aria-describedby="inputGroupFileAddon04" name="tupian">
											<label class="custom-file-label" for="inputGroupFile04">请选择文件</label>
										</div>
									</div>
								</div>
								<img src="upload/<%=book.getTupian() %>">
							</div>
							<div class="form-group row">
								<label for="inputEmail3"
									class="col-sm-2 col-form-label text-right">出版社</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="inputEmail3"
										placeholder="出版社" name="chuban" value="<%=book.getChuban()%>">
								</div>
							</div>
							<div class="form-group row">
								<div class="col-sm-2"></div>
								<div class="col-sm-10">
									<button type="submit" class="btn btn-primary">提交</button>
								</div>
							</div>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="bower_components/bootstrap/dist/js/bootstrap.js"></script>
	<script type="text/javascript"
		src="bower_components/jquery/dist/jquery.js"></script>
	<script type="text/javascript">
		function fillSel(types) {
			for (var i = 0; i < types.length; i++) {
				var op = new Option(types[i].name, types[i].id);
				document.getElementById("inputid").appendChild(op);
			}
			 $("#inputid").val('<%=request.getAttribute("bid")%>');
			 $("#inputid").trigger("change");
		}
		$.ajax({
			type : "GET",
			url : "findAllBigType",
			jsonpCallback : "fillSel",
			dataType : "jsonp"
		});
		function fillSels(types) {
			document.getElementById("inputxid").innerHTML = "";
			for (var i = 0; i < types.length; i++) {
				var op = new Option(types[i].name, types[i].id);
				document.getElementById("inputxid").appendChild(op);
			}
			  $("#inputxid").val('<%=book.getXid()%>');

		}
		$("#inputid").change(function() {
			$.ajax({
				type : "GET",
				url : "shuBigType",
				jsonpCallback : "fillSels",
				data : "bid=" + $(this).val(),
				dataType : "jsonp"
			});
		});
	</script>
	<script type="text/javascript"
		src="bower_components/bootstrap-datepicker/dist/js/bootstrap-datepicker.js"></script>
	<script type="text/javascript"
		src="bower_components/bootstrap-datepicker/js/locales/bootstrap-datepicker.zh-CN.js"></script>
	<script type="text/javascript">
		$('#inputBirthday').datepicker({
			language : 'zh-CN',
			format : 'yyyy-mm-dd',
			autoclose : true,
			defaultViewDate : {
				year : new Date().getFullYear() - 18
			}
		});
	</script>
</body>
</html>