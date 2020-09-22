<%@page import="kr.or.ddit.prod.vo.ProdVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.ibatis.config.BuildSqlMapClient"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
[
<%
SqlMapClient smc = BuildSqlMapClient.getSqlMapClient();

String lprod_gu = request.getParameter("gu"); 

List<ProdVO> list = smc.queryForList("myprod.selectByGu", lprod_gu);


for(int i = 0; i < list.size(); i++){
	if(i > 0) out.print(",");
%>
	{
	"id" : "<%= list.get(i).getProd_id() %>",
	"name" : "<%= list.get(i).getProd_name() %>"
	}
<%
}
%>
]