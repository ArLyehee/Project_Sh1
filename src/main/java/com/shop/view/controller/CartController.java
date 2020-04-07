package com.shop.view.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shop.biz.ProductService;
import com.shop.biz.ProductVO;
import com.shop.biz.Cart.CartService;
import com.shop.biz.Cart.CartVO;
import com.shop.biz.UserMember.UserMemberVO;


@Controller
public class CartController {
	
	@Autowired
	CartService cartService;
	@Autowired
	ProductService productService;
	
	@RequestMapping(value="cart_insert", method=RequestMethod.POST)
	public String insertCart(CartVO vo, HttpServletRequest request) {
		
		UserMemberVO loginUser = (UserMemberVO) request.getSession().getAttribute("loginUser");
		
		if(loginUser != null) {
			vo.setId(loginUser.getId());			
			cartService.insertCart(vo);
			
			return "redirect:cart_list";
		}else {
			return "member/login";
		}

	}
	 
	
	  @RequestMapping(value="cart_list",method=RequestMethod.GET) 
	  public String cartList(CartVO vo, Model model, HttpServletRequest request){
	  
		  UserMemberVO loginUser = (UserMemberVO) request.getSession().getAttribute("loginUser");
		  
		if(loginUser != null) {
			vo.setId(loginUser.getId());	
			List<CartVO> cartList = cartService.listCart(vo); 
		  	
			int totalPrice = 0;
			
			for(CartVO cartvo:cartList) {
		  		totalPrice += cartvo.getPrice2();
		  	}
			
			model.addAttribute("cartList", cartList);
			model.addAttribute("totalPrice", totalPrice);
			
		  	
			return "detail/cartList";
		}else {
			return "member/login";
		}
	  }
	  
	
	  @RequestMapping(value="cart_delete",method=RequestMethod.POST) 
	  public String deleteList(@RequestParam(value="cseq")String[] cseq,Model model) { 
		  for(int i=0;i< cseq.length;i++) {
			  cartService.deleteCart(Integer.parseInt(cseq[i]));
		  }
				  
		return "redirect:cart_list"; 
	  }
	  
	 @RequestMapping(value="index",method=RequestMethod.GET)
	 public String index(Model model) {
		 
		  List<ProductVO> newList = productService.getNewProductList();
		  
		  List<ProductVO> bestList = productService.getBestProductList();
		  
		  model.addAttribute("newProductList",newList);
		  model.addAttribute("bestProductList",bestList);
		 
		 return "index";
	 }
	 
	  
	 
}
