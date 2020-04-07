package com.shop.biz.Order;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.biz.Cart.CartVO;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderDAO orderDAO;


	@Override
	public int insertOrder(OrderVO vo) {

		return orderDAO.insertOrder(vo);
	}

	@Override
	public void insertOrderDetail(OrderVO vo) {
		orderDAO.insertOrderDetail(vo);

	}

	@Override
	public List<OrderVO> listOrderById(OrderVO vo) {
	
		return orderDAO.listOrderById(vo);
	}

	@Override
	public List<Integer> selectSeqOrdering(OrderVO vo) {

		return orderDAO.selectSeqOrdering(vo);
	}

	@Override
	public int selectMaxOseq() {
		
		return orderDAO.selectMaxOseq();
	}

	@Override
	public List<OrderVO> getOrderList(OrderVO vo) {
		
		return orderDAO.getOrderList(vo);
	}

}
