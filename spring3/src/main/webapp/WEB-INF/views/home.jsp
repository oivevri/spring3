<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<body>
	<h1>홈 화면 페이지</h1>
	<div>
		<div>
			<h3>카카오</h3>
		</div>
		<p>세션의 값을 받아오는거고, 동의해서 null이 아닐때만 받아올수있음</p>
		닉네임 : ${kname}<br> 이메일 : ${kemail}<br> 생일 : ${kbirthday}<br>
		연령대 : ${kage}<br> 이미지 : <img src="${kimage}">
	</div>
</body>
</html>
