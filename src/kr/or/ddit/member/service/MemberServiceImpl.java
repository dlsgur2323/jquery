package kr.or.ddit.member.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.member.dao.IMemberDao;
import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;

public class MemberServiceImpl implements IMemberService{
	private IMemberDao dao;
	private static IMemberService service;
	
	private MemberServiceImpl() {
		 dao = MemberDaoImpl.getInstance();
	}
	
	public static IMemberService getInstance(){
		if(service==null) service = new MemberServiceImpl();
		return service;
	}
	
	@Override
	public String checkById(String id){
		return dao.checkById(id);
	}

	@Override
	public List<ZipVO> selectByDong(String dong){
		return dao.selectByDong(dong);
	}

	@Override
	public String insertMember(MemberVO vo){
		return dao.insertMember(vo);
	}

}
