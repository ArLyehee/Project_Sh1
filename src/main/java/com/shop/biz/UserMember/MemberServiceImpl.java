package com.shop.biz.UserMember;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.biz.paginationVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Autowired
	private UserMemberDAO userMemberDAO;
	
	@Override
	public UserMemberVO getMember(UserMemberVO vo) {
		
		return userMemberDAO.getMember(vo);
	}

	@Override
	public int confirmID(UserMemberVO vo) {
		String id = userMemberDAO.confirmID(vo);
		
		if(id == null) {
			return -1;
		}else {
			return 1;
		}
	}

	@Override
	public int insertUser(UserMemberVO vo) {

		return userMemberDAO.insertUser(vo);
	}

	@Override
	public void updateUser(UserMemberVO vo) {
		userMemberDAO.updateUser(vo);
	}

	@Override
	public UserMemberVO memberInfo(UserMemberVO vo) {
		
		return userMemberDAO.memberInfo(vo);
	}
	
	@Override
	public List<UserMemberVO> memberList(UserMemberVO vo) {
		
		return userMemberDAO.memberList(vo);
	}


	

}
