package com.shop.biz.UserMember;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shop.biz.paginationVO;

@Repository("userMemberDAO")
public class UserMemberDAO extends SqlSessionDaoSupport  {
	
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	public UserMemberVO getMember(UserMemberVO vo) {
		
		return getSqlSession().selectOne("userMemberDAO.getMember", vo);
	}
	public String confirmID(UserMemberVO vo) {
		// 호출후 id가 넘어오니까 String id는 String이다.
		return getSqlSession().selectOne("userMemberDAO.confirmID", vo);
	}
	public int insertUser(UserMemberVO vo) {	
		return getSqlSession().insert("userMemberDAO.insertUser", vo);
	}
	
	public void updateUser(UserMemberVO vo) {
		getSqlSession().update("userMemberDAO.updateUser", vo);
	}
	
	public UserMemberVO memberInfo(UserMemberVO vo){
		return getSqlSession().selectOne("userMemberDAO.memberInfo", vo);
	}
	
	public List<UserMemberVO> memberList(UserMemberVO vo) {
		return getSqlSession().selectList("userMemberDAO.memberList", vo);
	}
}
