<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Add a new product on this page</title>
	</head>
	<body>
		<h1>Hi, you can add a new product on this page</h1>
		<form action="add" method="post" enctype="multipart/form-data">
			Description: <input type="text" name="description"/><br><br>
			Price:   	<input type="text" name="price"/><br><br>
			Image: <input type="file" name="imgFile"><br>
			<input type="submit" value="Add"/>
		</form>
	</body>
</html>