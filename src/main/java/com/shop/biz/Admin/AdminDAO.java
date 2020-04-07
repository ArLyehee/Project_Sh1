package com.shop.biz.Admin;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shop.biz.ProductVO;


@Repository("adminDAO")
public class AdminDAO extends SqlSessionDaoSupport{
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	public AdminVO getAdmin(AdminVO vo) {
		return getSqlSession().selectOne("adminDAO.getAdmin", vo);
	}
	
	

}
