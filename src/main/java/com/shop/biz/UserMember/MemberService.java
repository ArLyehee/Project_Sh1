package com.shop.biz.UserMember;

import java.util.List;

import com.shop.biz.paginationVO;

public interface MemberService {

	UserMemberVO getMember(UserMemberVO vo);

	int confirmID(UserMemberVO vo);

	int insertUser(UserMemberVO memberVO);

	void updateUser(UserMemberVO vo);
	
	UserMemberVO memberInfo(UserMemberVO vo);
	
	List<UserMemberVO> memberList(UserMemberVO vo);
	

}