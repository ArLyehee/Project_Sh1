package com.shop.biz.Cart;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public interface CartService {

	void insertCart(CartVO vo);

	void deleteCart(int cseq);

	void updateCart(CartVO vo);
	
	List<CartVO> listCart(CartVO vo);

}