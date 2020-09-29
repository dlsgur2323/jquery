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
import kr.or.ddit.member.vo.ZipVO;

@WebServlet("/SelectByDong.do")
public class SelectByDong extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectByDong() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		// 1. 클라이언트 요청시 전송되는 값을 받는다.
		String dongvalue = request.getParameter("dong");
		// 2. service 객체를 얻어오기
		
		IMemberService service = MemberServiceImpl.getInstance();
		
		// 3. 결과값 = service 메서드 호출
		List<ZipVO> list = service.selectByDong(dongvalue);
		
		// 4. 결과값을 request scope에 저장
		request.setAttribute("listvalue", list);
		
		// 5. jsp로 forward
		RequestDispatcher disp = request.getRequestDispatcher("member/zip.jsp");
		disp.forward(request, response);
	}

}
