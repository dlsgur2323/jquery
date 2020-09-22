<%@page import="kr.or.ddit.prod.vo.ProdVO"%>
<%@page import="kr.or.ddit.buyer.vo.BuyerVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.ibatis.config.BuildSqlMapClient"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	SqlMapClient smc = BuildSqlMapClient.getSqlMapClient();
	
	String prod_id = request.getParameter("id");
	ProdVO prodVo = (ProdVO)smc.queryForObject("myprod.selectById", prod_id);

%>
{
	"id" : "<%= prodVo.getProd_id() %>",
	"name" : "<%= prodVo.getProd_name() %>",
	"lgu" : "<%= prodVo.getProd_lgu() %>",
	"buyer" : "<%= prodVo.getProd_buyer() %>",
	"cost" : "<%= prodVo.getProd_cost() %>",
	"price" : "<%= prodVo.getProd_price() %>",
	"sale" : "<%= prodVo.getProd_sale() %>",
	"outline" : "<%= prodVo.getProd_outline() %>",
	"detail" : "<%= prodVo.getProd_detail() %>"
}
