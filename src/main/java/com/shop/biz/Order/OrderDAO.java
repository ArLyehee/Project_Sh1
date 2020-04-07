package com.shop.biz.Order;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shop.biz.Cart.CartVO;

@Repository
public class OrderDAO extends SqlSessionDaoSupport {

	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	public int selectMaxOseq() {
		return getSqlSession().selectOne("OrderDAO.selectMaxOseq");
	}
	public int insertOrder(OrderVO vo) {

		return getSqlSession().insert("OrderDAO.insertOrder",vo);
	}
	
	public void insertOrderDetail(OrderVO vo) {
		getSqlSession().insert("OrderDAO.insertOrderDetail", vo);
	}
	public List<OrderVO> listOrderById(OrderVO vo){
		return getSqlSession().selectList("OrderDAO.listOrderById", vo);
	}
	public List<Integer> selectSeqOrdering(OrderVO vo){
		return getSqlSession().selectList("OrderDAO.selectSeqOrdering", vo);
	}
	
	public List<OrderVO> getOrderList(OrderVO vo){
		return getSqlSession().selectList("OrderDAO.getOrderList", vo);
	}
}
