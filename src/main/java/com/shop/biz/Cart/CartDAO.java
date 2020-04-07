package com.shop.biz.Cart;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("cartDAO")
public class CartDAO extends SqlSessionDaoSupport{
	
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	public void insertCart(CartVO vo) {
		getSqlSession().insert("cartDAO.insertCart", vo);
	}
	
	public void deleteCart(int cseq) {
		getSqlSession().delete("cartDAO.deleteCart", cseq);
	}
	
	public List<CartVO> listCart(CartVO vo){
		
		return getSqlSession().selectList("cartDAO.listCart", vo);
	}
	public void updateCart(CartVO vo) {
		getSqlSession().update("cartDAO.updateCart", vo);
	}
}
