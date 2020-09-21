<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@page import="kr.or.ddit.ibatis.config.BuildSqlMapClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
[
<%

SqlMapClient smc = BuildSqlMapClient.getSqlMapClient();

List<MemberVO> memList = smc.queryForList("mymember.selectAllMember");


for(int i = 0; i < memList.size(); i++){
	if(i > 0) out.print(",");
%>
	{
	"id" : "<%= memList.get(i).getMem_id() %>",
	"name" : "<%= memList.get(i).getMem_name() %>",
	"addr" : "<%= memList.get(i).getMem_add1() %> <%= memList.get(i).getMem_add2() %>",
	"hp" : "<%= memList.get(i).getMem_hp() %>",
	"mail" : "<%= memList.get(i).getMem_mail() %>"
	}
<%
}
%>
]