<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	span {
		font-size : 1.5em;
		color : red;
	}
</style>

</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	String userId = request.getParameter("id");
%>
<%= name%><span>님 환영합니다.</span><br>
<%= userId%><span>님 즐거운 하루 되세요.</span>
</body>
</html>