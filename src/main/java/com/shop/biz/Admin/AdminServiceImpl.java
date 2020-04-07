package com.shop.biz.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.biz.ProductVO;
import com.shop.biz.impl.ProductDAOMyBatis;

@Service("adminService")
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDAO adminDAO;
	@Autowired
	private ProductDAOMyBatis productDAO;
	
	
	@Override
	public AdminVO getAdmin(AdminVO vo) {
		
		return adminDAO.getAdmin(vo);
	}

}
