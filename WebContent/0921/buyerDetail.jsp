<%@page import="kr.or.ddit.buyer.vo.BuyerVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.ibatis.config.BuildSqlMapClient"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	SqlMapClient smc = BuildSqlMapClient.getSqlMapClient();
	
	String buyer_id = request.getParameter("id");
	BuyerVO buyerVo = (BuyerVO)smc.queryForObject("mybuyer.selectByDetail", buyer_id);

%>
{
	"id" : "<%= buyerVo.getBuyer_id() %>",
	"name" : "<%= buyerVo.getBuyer_name() %>",
	"lgu" : "<%= buyerVo.getBuyer_lgu() %>",
	"comtel" : "<%= buyerVo.getBuyer_comtel() %>",
	"bank" : "<%= buyerVo.getBuyer_bank() %>",
	"bankNo" : "<%= buyerVo.getBuyer_bankno() %>",
	"bankName" : "<%= buyerVo.getBuyer_bankname() %>",
	"mail" : "<%= buyerVo.getBuyer_mail() %>",
	"zip" : "<%= buyerVo.getBuyer_zip() %>",
	"add1" : "<%= buyerVo.getBuyer_add1() %>",
	"add2" : "<%= buyerVo.getBuyer_add2() %>"
}
