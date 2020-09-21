<%@page import="kr.or.ddit.lprod.vo.LprodVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.ibatis.config.BuildSqlMapClient"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
[
<%

SqlMapClient smc = BuildSqlMapClient.getSqlMapClient();

List<LprodVO> list = smc.queryForList("mylprod.selectAllLprod");


for(int i = 0; i < list.size(); i++){
	if(i > 0) out.print(",");
%>
	{
	"id" : "<%= list.get(i).getLprod_id() %>",
	"gu" : "<%= list.get(i).getLprod_gu() %>",
	"nm" : "<%= list.get(i).getLprod_nm() %>"
	}
<%
}
%>
]