package com.shop.biz.Cart;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("cartService")
public class CartServiceImpl implements CartService {

	@Autowired
	private CartDAO cartDAO;

	@Override
	public void insertCart(CartVO vo) {
		
		cartDAO.insertCart(vo);
	}

	@Override
	public void deleteCart(int cseq) {
		
		cartDAO.deleteCart(cseq);
	}

	@Override
	public List<CartVO> listCart(CartVO vo) {

		return cartDAO.listCart(vo);
	}

	@Override
	public void updateCart(CartVO vo) {
		cartDAO.updateCart(vo);
		
	}
}
