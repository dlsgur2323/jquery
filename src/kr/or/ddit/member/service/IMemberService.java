package kr.or.ddit.member.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;

public interface IMemberService {
	
	// 아이디 중복검사
	public String checkById(String id);
	
	// 우편번호 찾기
	public List<ZipVO> selectByDong(String dong);
	
	// 가입하기
	public String insertMember(MemberVO vo);
	
	
	
}
