package kr.or.ddit.member.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.BuildSqlMapClient;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;

/*
 * SqlMapClient 객체를 얻어온다.
 * dao객체를 service에서 사용할 수 있도록 자신의 객체를 생성하고 리턴한다.
 */
public class MemberDaoImpl implements IMemberDao{
	private SqlMapClient smc;
	private static IMemberDao dao;
	
	private MemberDaoImpl() {
		smc = BuildSqlMapClient.getSqlMapClient();
	}
	public static IMemberDao getInstance(){
		if(dao==null) dao = new MemberDaoImpl();
		return dao;
	}
	
	@Override
	public String checkById(String id){
		String mem_id = null;
		try {
			mem_id = (String)smc.queryForObject("join.checkById",id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mem_id;
	}

	@Override
	public List<ZipVO> selectByDong(String dong){
		List<ZipVO> list = null;
		try {
			list = smc.queryForList("join.selectByDong", dong);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String insertMember(MemberVO vo){
		String mem_id = null;
		try {
			mem_id = (String)smc.insert("join.insertMember", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mem_id;
	}

}
