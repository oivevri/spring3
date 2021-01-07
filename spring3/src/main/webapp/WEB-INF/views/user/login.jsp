<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>view/user/login.jsp</title>
</head>
<body>
	<h3>login</h3>
	<form action="login" method="post">
		<input name="id" placeholder="id"><br>
		<input name="password" placeholder="password"><br>
		<button>로그인</button>
	</form>
<a href="${kakao_url}">카카오 로그인</a>
</body>
</html>