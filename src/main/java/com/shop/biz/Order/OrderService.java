package com.shop.biz.Order;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.shop.biz.Cart.CartVO;

public interface OrderService {

	int selectMaxOseq();
	
	int insertOrder(OrderVO vo);

	void insertOrderDetail(OrderVO vo);

	List<OrderVO> listOrderById(OrderVO vo);

	List<Integer> selectSeqOrdering(OrderVO vo);
	
	List<OrderVO> getOrderList(OrderVO vo);

}