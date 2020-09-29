package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;

@WebServlet("/insert.do")
public class InsertMember extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		// 1. 클라이언트 요청시 전송되는 값을 받는다.
		
		String id = request.getParameter("mem_id");
		String name = request.getParameter("mem_name");
		String pass = request.getParameter("mem_pass");
		String email = request.getParameter("mem_mail");
		String hp = request.getParameter("mem_hp");
		String bir = request.getParameter("mem_bir");
		String zip = request.getParameter("mem_zip");
		String add1 = request.getParameter("mem_add1");
		String add2 = request.getParameter("mem_add2");
		MemberVO vo = new MemberVO();
		vo.setMem_id(id);
		vo.setMem_add1(add1);;
		vo.setMem_add2(add2);;
		vo.setMem_bir(bir);;
		vo.setMem_hp(hp);;
		vo.setMem_mail(email);;
		vo.setMem_name(name);;
		vo.setMem_pass(pass);;
		vo.setMem_zip(zip);;
		// 2. service 객체를 얻어오기
		
		IMemberService service = MemberServiceImpl.getInstance();
		
		// 3. 결과값 = service 메서드 호출
		String inid = service.insertMember(vo);
		
		// 4. 결과값을 request scope에 저장
		request.setAttribute("inid", inid);
		
		// 5. jsp로 forward
		RequestDispatcher disp = request.getRequestDispatcher("member/insert.jsp");
		disp.forward(request, response);
		
		
	}

}
