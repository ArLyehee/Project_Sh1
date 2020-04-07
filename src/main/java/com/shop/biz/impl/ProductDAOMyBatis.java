package com.shop.biz.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shop.biz.ProductService;
import com.shop.biz.ProductVO;
import com.shop.biz.paginationVO;


@Repository("productDAO")
public class ProductDAOMyBatis extends SqlSessionDaoSupport{

	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	public void insertProduct(ProductVO vo) {
		getSqlSession().insert("productDAO.insertProduct", vo);
	}
	
	public void updateProduct(ProductVO vo) {
		getSqlSession().update("productDAO.updateProduct", vo);
	}
	
	public void deleteProduct(ProductVO vo) {
		getSqlSession().delete("productDAO.deleteProduct", vo);
	}


	public ProductVO getProduct(ProductVO vo) {
		return (ProductVO)getSqlSession().selectOne("productDAO.getProduct", vo);
	}
	
	public List<ProductVO> getProductList(ProductVO vo){
		List<ProductVO> result = getSqlSession().selectList("productDAO.getProductList");
		return result;
	}
	public List<ProductVO> listNewProduct() {
		 return getSqlSession().selectList("productDAO.listNewProduct");
	} 
	public List<ProductVO> listBestProduct() {	  
		 return getSqlSession().selectList("productDAO.listBestProduct"); 
	} 
	public List<ProductVO> listKindProduct(String kind) {	  
	 	 return getSqlSession().selectList("productDAO.listKindProduct", kind); 
	}
	public List<ProductVO> getList(paginationVO cri){
		return getSqlSession().selectList("productDAO.getList", cri);
	}
	public int listCount() {
		return getSqlSession().selectOne("productDAO.listCount");
	}
}
