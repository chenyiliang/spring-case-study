<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--[if IE 9]>         <html class="ie9 no-focus"> <![endif]-->
<!--[if gt IE 9]><!-->
<html class="no-focus">
<!--<![endif]-->
<head>
<meta charset="utf-8">

<title>上传文件测试</title>
</head>
<body>
	<form action="/main/upload1" enctype="multipart/form-data" method="post">
		<p>
			username:<input type="text" name="username">
		</p>
		<p>
			file:<input type="file" name="file">
		</p>
		<p>
			<input type="submit" value="Submit">
		</p>
	</form>
</body>
</html>