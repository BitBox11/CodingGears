<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>리뷰 등록</h1>
<div>
<label>id</label>
<input type='text' name = 'userId'> </div>
<div>
<label>메뉴번호</label>
<input type='number' name = 'menuNo'> </div>
<div>
<label>점수</label>
<input type='number' name = 'score'> </div>

<div>
<label>리뷰</label>
<textarea rows="5" name='review'></textarea></div>

<form method='post'>


<button>등록</button>
</form>

</body>
</html>