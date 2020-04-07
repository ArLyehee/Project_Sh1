package com.shop.biz;

import java.util.List;



public interface ProductService {

	ProductVO getProduct(ProductVO vo);
	
	void insertProduct(ProductVO vo);
	
	void updateProduct(ProductVO vo);

	void deleteProduct(ProductVO vo);

	List<ProductVO> getProductList(ProductVO vo);
	
	List<ProductVO> getNewProductList();
	
	List<ProductVO> getBestProductList();
	
	List<ProductVO> getKindProductList(String kind);
	
	List<ProductVO> getList(paginationVO cri);
	
	int listCount();

}