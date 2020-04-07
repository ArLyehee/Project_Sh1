package com.shop.biz;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement(name = "productList")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductListVO {
	@XmlElement(name = "product")
	private List<ProductVO> productList;
	
	
	public List<ProductVO> getProductList() {
		return productList;
	}
	public void setProductList(List<ProductVO> productList) {
		this.productList = productList;
	}
}