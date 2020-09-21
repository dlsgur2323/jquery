<%@page import="kr.or.ddit.buyer.vo.BuyerVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.ibatis.config.BuildSqlMapClient"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
[
<%
SqlMapClient smc = BuildSqlMapClient.getSqlMapClient();

List<BuyerVO> list = smc.queryForList("mybuyer.selectByName");


for(int i = 0; i < list.size(); i++){
	if(i > 0) out.print(",");
%>
	{
	"id" : "<%= list.get(i).getBuyer_id() %>",
	"name" : "<%= list.get(i).getBuyer_name() %>"
	}
<%
}
%>
]