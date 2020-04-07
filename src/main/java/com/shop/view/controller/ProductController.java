package com.shop.view.controller;
  
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shop.biz.ProductService;
import com.shop.biz.ProductVO;

	@Controller
	public class ProductController {
		@Autowired
		ProductService productService;
	
	  @RequestMapping(value="product_detail",method = RequestMethod.GET)
	public String productDetailAction(ProductVO vo, Model model, 
			/* request 파라미터에서 “pseq”를 읽어온다. */@RequestParam("pseq")int pseq) {
		  
		  /* productService에서 getProduct()를 호출하여 상품 정보를 조회한다*/		  
		  ProductVO vo1 = productService.getProduct(vo);

		/* request 파라미터에 “productVO”를 키로 위에서 조회한 상품을 저장한다 */
		  model.addAttribute("productVO", vo1);
		 
		  return "product/productDetail";
	  

	  }
	  @RequestMapping(value="category",method = RequestMethod.GET)
	 public String ProductKindAction(ProductVO vo, Model model) {
	
		  List<ProductVO> vo1 = productService.getKindProductList(vo.getKind());
		  
		  model.addAttribute("productKindList",vo1);
	 
		  return "product/productKind"; 
	 	}
	}
 