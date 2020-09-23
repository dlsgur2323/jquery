package kr.or.ddit.member.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;

/**
 * Servlet implementation class CheckById
 */
@WebServlet("/CheckById")
public class CheckById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckById() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// 1. 클라이언트 요청시 전송되는 데이터를 받는다.
		String userId = request.getParameter("id");
		// 2. service객체 얻어오기
		IMemberService service = MemberServiceImpl.getInstance();
		// 3. 결과값 변수 = service메소드 호출
		String checkId = service.checkById(userId);
		
		// 4. 결과값을 view페이지에서 사용하기 위해 request scope에 저장한다.
		request.setAttribute("idvalue", checkId);
		// 5. view 페이지로 이동 (forward/redirect) - 처리결과를 출력
				// 처리한 결과를 출력 대신 응답데이터를 생성 -json object
		RequestDispatcher disp = request.getRequestDispatcher("member/idcheck.jsp");
		
		disp.forward(request, response);
		
		
	}

}
