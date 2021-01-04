<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="userInsert" method="post" encType="multipart/form-data"> 
	아 이 디 <input type="text" name="id"><br/>
	패스워드 <input type="text" name="password"><br/>
	이    름 <input type="text" name="name"><br/>
	권    한
	<input type="radio" name="role" value="Admin">Admin
	<input type="radio" name="role" value="User">User
	첨부파일 <input type="file" name="uploadFile"/><br/>
	<input type="submit" value="저장">
</form>
</body>
</html>