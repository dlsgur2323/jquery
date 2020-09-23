<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = (String)request.getAttribute("idvalue");
	if(id==null){// 사용가능 
%>
		{ "sw" : "사용 가능 id입니다" }

<%		
	} else {// 사용불가능
%>
		{ "sw" : "사용 불가능 id입니다." }

<%	
	}
%>