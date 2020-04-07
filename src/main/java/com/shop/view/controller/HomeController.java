
  package com.shop.view.controller;
  
  
  import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.stereotype.Controller;
  import org.springframework.ui.Model;
  import  org.springframework.web.bind.annotation.RequestMapping;

import com.shop.biz.ProductService;
import com.shop.biz.ProductVO;

 
  
  @Controller 
  public class HomeController {
  
	  @Autowired
	  private ProductService productService;
	  
	  @RequestMapping(value="/") 
	  public String index(Model model) {
		  List<ProductVO> newList = productService.getNewProductList();
		  
		  List<ProductVO> bestList = productService.getBestProductList();
		  
		  model.addAttribute("newProductList",newList);
		  model.addAttribute("bestProductList",bestList);
		  
		  return "index";
	  }
  
  }
 