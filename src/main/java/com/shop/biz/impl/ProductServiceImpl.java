package com.shop.biz.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.biz.ProductService;
import com.shop.biz.ProductVO;
import com.shop.biz.paginationVO;

@Service("productService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAOMyBatis productDAO;
	

	@Override
	public ProductVO getProduct(ProductVO vo) {
	
		return productDAO.getProduct(vo);
	}
	
	@Override
	public void insertProduct(ProductVO vo) {

		productDAO.insertProduct(vo);

	}

	@Override
	public void updateProduct(ProductVO vo) {

		productDAO.updateProduct(vo);

	}

	@Override
	public void deleteProduct(ProductVO vo) {
		
		productDAO.deleteProduct(vo);

	}

	@Override
	public List<ProductVO> getProductList(ProductVO vo) {
		return productDAO.getProductList(vo);
	}

	@Override
	public List<ProductVO> getNewProductList() {
		// TODO Auto-generated method stub
		return productDAO.listNewProduct();
	}

	@Override
	public List<ProductVO> getBestProductList() {
		// TODO Auto-generated method stub
		return productDAO.listBestProduct();
	}

	@Override
	public List<ProductVO> getKindProductList(String kind) {
		// TODO Auto-generated method stub
		return productDAO.listKindProduct(kind);
	}

	@Override
	public List<ProductVO> getList(paginationVO cri) {
		
		return productDAO.getList(cri);
	}

	@Override
	public int listCount() {
		
		return productDAO.listCount();
	}
}
