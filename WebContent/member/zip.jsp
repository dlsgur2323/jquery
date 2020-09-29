<%@page import="kr.or.ddit.member.vo.ZipVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	.ziptr:hover{
		background : lime;
	}
</style>
<script>
	
	 
</script>
		<table>
			<tr><td>우편번호</td><td>주소</td><td>번지</td></tr>
			<%
				List<ZipVO> list = (List<ZipVO>)request.getAttribute("listvalue");
			
				for(int i=0; i<list.size();i++){
					ZipVO vo = list.get(i);
					if(vo.getBunji()==null){
						vo.setBunji("");
					}
			%>
					<tr class="ziptr">
						<td><%=vo.getZipcode() %></td>
						<td><%=vo.getSido() + " " + vo.getGugun() +" "+ vo.getDong() %></td>
						<td><%=vo.getBunji() %></td>
					</tr>
			<%
				}
			%>
		</table>
