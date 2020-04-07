package com.shop.view.controller;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.biz.ProductService;
import com.shop.biz.ProductVO;
import com.shop.biz.UserMember.MemberService;
import com.shop.biz.UserMember.UserMemberVO;


@Controller
public class MemberController {
	@Autowired
	MemberService memberService;
	@Autowired
	ProductService productService;
	
	@RequestMapping(value="login_form",method=RequestMethod.GET)
	public String loginForm() {
		
		return "member/login";
	}
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String login(UserMemberVO vo,Model model, HttpSession session) {
		
		UserMemberVO vo1 = memberService.getMember(vo);
		
		  if(vo1 != null) {
			List<ProductVO> newList = productService.getNewProductList();
		  
		  	List<ProductVO> bestList = productService.getBestProductList();
		  
		  	model.addAttribute("newProductList",newList);
		  	model.addAttribute("bestProductList",bestList);
		  
		  	session.setAttribute("loginUser", vo1);  
		  	
		  	
		  	return "index";
		  } else 
			return "member/login_fail";
	}

	
	 @RequestMapping(value= {"contract", "join"},method=RequestMethod.GET) 
	 public String contract() {
		 return "member/contract"; 
	 }
	 
	 @RequestMapping(value="join_form", method=RequestMethod.POST)
	 public String joinForm() {
		 return "member/join";
	 }

	 @RequestMapping(value="id_check_form",method=RequestMethod.GET)
	 public String idCheck(@RequestParam(value="id")String id,Model model,UserMemberVO vo) {
		 

		 model.addAttribute("id",id);
		 
		 return "member/idcheck";
	 }
	
	  @RequestMapping(value="id_check_form",method=RequestMethod.POST) 
	  public String checkForm(UserMemberVO vo,Model model) {
		  
		  int idCheck = memberService.confirmID(vo);
		  
		  if(idCheck == -1) {
			  model.addAttribute("message", -1);
		  }else {
			  model.addAttribute("message", 1);
		  }
		  
		  model.addAttribute("id",vo.getId());
		  
		  return "member/idcheck"; 
	  }
	  
	  @RequestMapping(value="join", method=RequestMethod.POST)
	  public String joinMember(@RequestParam("addr1")String addr1,
			  @RequestParam(value="addr2")String addr2,UserMemberVO vo) {
		  
		  vo.setAddress(addr1);
		  vo.setAddress2(addr2);
		 
		  
		  memberService.insertUser(vo);
		  
		  return "member/login";
	  }
	  
	  @RequestMapping(value="logout", method=RequestMethod.GET)
	  public String logout(HttpServletRequest request) {

		  HttpSession session = request.getSession();
		  
		  session.invalidate();
		/* session.setAttribute("loginUser", null); */
		  
		  return "member/login";
	  }
	  
	  @RequestMapping(value="mypage",method=RequestMethod.GET)
	  public String mypage(UserMemberVO vo,HttpServletRequest request,Model model) {

			UserMemberVO loginUser = (UserMemberVO) request.getSession().getAttribute("loginUser");
			String userId = "";
			
			if(loginUser != null) {
				userId = loginUser.getId();

				
				model.addAttribute("usermember", vo);
				
				return "member/mypage";
			}else {
				return "member/login";
			}
	  }
	  
	  @RequestMapping(value="updateUser",method= RequestMethod.POST)
	  public String updateUser_GET(UserMemberVO vo,HttpServletRequest request,Model model) {
		  
		  UserMemberVO loginUser = (UserMemberVO) request.getSession().getAttribute("loginUser");
			String userId = "";
			
			if(loginUser != null) {
				userId = loginUser.getId();

				memberService.updateUser(vo);
				
				UserMemberVO update = memberService.memberInfo(vo);
				
				model.addAttribute("loginUser", update);
				 
				return "member/mypage";
			}else {
				return "member/login";
			}
		  
	  }
}
