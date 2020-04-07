package com.shop.view.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shop.biz.Cart.CartService;
import com.shop.biz.Cart.CartVO;
import com.shop.biz.Order.OrderService;
import com.shop.biz.Order.OrderVO;
import com.shop.biz.UserMember.UserMemberVO;



@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private CartService cartService;
	
	@RequestMapping(value="order_insert",method=RequestMethod.POST)
	public String insertOrder(OrderVO vo, HttpServletRequest request,Model model) {

		UserMemberVO loginUser = (UserMemberVO) request.getSession().getAttribute("loginUser");
		String userId = "";
		
		if(loginUser != null) {
			userId = loginUser.getId();
			
			int oseq = orderService.selectMaxOseq();
			vo.setId(userId);	
			vo.setOseq(oseq);
			
			orderService.insertOrder(vo);
			
			CartVO cartvo = new CartVO();
			cartvo.setId(userId);
			List<CartVO> cartList = cartService.listCart(cartvo);
			
			for(CartVO vo1 : cartList) {
				OrderVO orderDetail = new OrderVO();
				orderDetail.setOseq(oseq);
				orderDetail.setPseq(vo1.getPseq());
				orderDetail.setQuantity(vo1.getQuantity());
				
				orderService.insertOrderDetail(orderDetail);
				cartService.updateCart(vo1);
			}

			model.addAttribute("oseq", oseq);
			
			return "redirect:order_list";
		}else {
			return "member/login";
		}
	}
	
	@RequestMapping(value="order_list",method = RequestMethod.GET)
	public String orderList(@RequestParam(value="oseq")int oseq,OrderVO vo,Model model, HttpServletRequest request) {
		
		UserMemberVO loginUser = (UserMemberVO) request.getSession().getAttribute("loginUser");
		String userId = "";
		
		userId = loginUser.getId();
		
		vo.setOseq(oseq);
		vo.setId(userId);
		vo.setResult("1");
		
		List<OrderVO> orderBy = orderService.listOrderById(vo);
		model.addAttribute("orderList", orderBy);
		
		int totalPrice = 0;
		
		for(OrderVO ordervo: orderBy) {
			totalPrice += ordervo.getPrice2();
		}
		
		model.addAttribute("totalPrice", totalPrice);
		
		
		return "detail/orderList";
	}

	@RequestMapping(value="cartDetail",method = RequestMethod.GET)
	public String order(OrderVO vo,HttpServletRequest request, Model model) {
		
		UserMemberVO loginUser = (UserMemberVO) request.getSession().getAttribute("loginUser");
		
		if(loginUser != null) {
		String userId = "";
		
		userId = loginUser.getId();
		
		vo.setId(userId);
		
		
		List<Integer> oseqList = orderService.selectSeqOrdering(vo);
		
		List<OrderVO> orderList = new ArrayList<OrderVO>();
		
		for(int oseq:oseqList) {
			vo.setOseq(oseq);
			vo.setResult("1");
			List<OrderVO> orderBy = orderService.listOrderById(vo);
			
			OrderVO order = new OrderVO();
			
			order.setOseq(orderBy.get(0).getOseq());
			order.setIndate(orderBy.get(0).getIndate());
			
			order.setPname(orderBy.get(0).getPname()+" 외 "+(orderBy.size()-1)+"건");
			
			int total = 0;
			
			for(int i=0;i<orderBy.size();i++) {
				total += orderBy.get(i).getPrice2();
			}
			
			order.setPrice2(total);
			
			orderList.add(order);
			
		}
		
			model.addAttribute("title", "진행 중인 주문 내역");
			model.addAttribute("orderList", orderList);
			
			return "detail/cartDetail";
		}else {
			return "member/login";
		}
	}
	
	@RequestMapping(value="cartDetail",method = RequestMethod.POST)
	public String ordermypage(OrderVO vo,HttpServletRequest request, Model model) {
		
		UserMemberVO loginUser = (UserMemberVO) request.getSession().getAttribute("loginUser");
		
		if(loginUser != null) {
		String userId = "";
		
		userId = loginUser.getId();
		
		vo.setId(userId);
		
		
		List<Integer> oseqList = orderService.selectSeqOrdering(vo);
		
		List<OrderVO> orderList = new ArrayList<OrderVO>();
		
		for(int oseq:oseqList) {
			vo.setOseq(oseq);
			vo.setResult("1");
			List<OrderVO> orderBy = orderService.listOrderById(vo);
			
			OrderVO order = new OrderVO();
			
			order.setOseq(orderBy.get(0).getOseq());
			order.setIndate(orderBy.get(0).getIndate());
			
			order.setPname(orderBy.get(0).getPname()+" 외 "+(orderBy.size()-1)+"건");
			
			int total = 0;
			
			for(int i=0;i<orderBy.size();i++) {
				total += orderBy.get(i).getPrice2();
			}
			
			order.setPrice2(total);
			
			orderList.add(order);
			
		}
		
			model.addAttribute("title", "진행 중인 주문 내역");
			model.addAttribute("orderList", orderList);
			
			return "detail/cartDetail";
		}else {
			return "member/login";
		}
	}
	
	@RequestMapping(value="order_detail",method = RequestMethod.GET)
	public String orderDetail(@RequestParam(value="oseq")int oseq, HttpServletRequest request,OrderVO vo,Model model) {
		
		UserMemberVO loginUser = (UserMemberVO) request.getSession().getAttribute("loginUser");
		String userId = "";
		
		List<OrderVO> orderList = new ArrayList<OrderVO>();
		
		if(loginUser != null) {
			userId = loginUser.getId();
			
			vo.setOseq(oseq);
			vo.setResult("1");
			vo.setId(userId);
			List<OrderVO> listOrder = orderService.listOrderById(vo);
			
			OrderVO orderDetail = new OrderVO();
			
			orderDetail.setIndate(listOrder.get(0).getIndate());
			orderDetail.setOseq(oseq);
			orderDetail.setMname(listOrder.get(0).getMname());
			
			model.addAttribute("orderDetail", orderDetail);
			
			int totalPrice = 0;
			
			for(OrderVO vo1:listOrder) {
				totalPrice += vo1.getPrice2();
			}
			
			model.addAttribute("totalPrice", totalPrice);
			
			model.addAttribute("orderList", listOrder);
		
			

			return "detail/orderDetail";
		}else {
			return "member/login";
		}
	}
	
	@RequestMapping(value="order_all", method=RequestMethod.GET)
	public String orderAll(HttpServletRequest request,OrderVO vo,Model model) {
		
		UserMemberVO loginUser = (UserMemberVO) request.getSession().getAttribute("loginUser");
		String userId = "";
		
		if(loginUser != null) {
			userId = loginUser.getId();
			vo.setId(userId);
			List<Integer> orderSeq = orderService.selectSeqOrdering(vo);
			
			List<OrderVO> orderList = new ArrayList<OrderVO>();
			
			for(Integer oseq:orderSeq) {
				vo.setOseq(oseq);
				vo.setId(userId);
				vo.setResult("1");
			
				List<OrderVO> orderBy = orderService.listOrderById(vo);
			
				OrderVO vo1 = new OrderVO();
				
				vo1.setOseq(orderBy.get(0).getOseq());
				vo1.setIndate(orderBy.get(0).getIndate());
				vo1.setPname(orderBy.get(0).getPname()+" 외 "+(orderBy.size()-1)+"건");


				int total = 0;
				
				for(int i=0;i<orderBy.size();i++) {
					total += orderBy.get(i).getPrice2();
				}
				
				vo1.setPrice2(total);
				
				orderList.add(vo1);
			}
			
			model.addAttribute("title", "총 주문 내역");
			model.addAttribute("orderList", orderList);
			
			
			return "detail/cartDetail";
		}else{
			return "member/login";
		}
	}

}
