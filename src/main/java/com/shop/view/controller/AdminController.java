package com.shop.view.controller;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.shop.biz.PageMaker;
import com.shop.biz.ProductService;
import com.shop.biz.ProductVO;
import com.shop.biz.paginationVO;
import com.shop.biz.Admin.AdminService;
import com.shop.biz.Admin.AdminVO;
import com.shop.biz.Cart.CartService;
import com.shop.biz.Order.OrderService;
import com.shop.biz.Order.OrderVO;
import com.shop.biz.Qna.QnaService;
import com.shop.biz.Qna.QnaVO;
import com.shop.biz.UploadFile.FileVO;
import com.shop.biz.UserMember.MemberService;
import com.shop.biz.UserMember.UserMemberVO;

@Controller
public class AdminController {
	@Autowired
	MemberService memberService;
	@Autowired
	ProductService productService;
	@Autowired
	CartService cartService;
	@Autowired
	QnaService qnaService;
	@Autowired
	AdminService adminService;
	@Autowired
	OrderService orderService;
	

	
	private String[] kinds = {"TOP", "PANTS", "OUTER", "OPS/SKIRT", "JEWELRY"};
	
	@RequestMapping(value="admin_login_form",method=RequestMethod.GET)
	public String adminLoginForm() {
		

		return "admin/adminLogin";
	}

	
	@RequestMapping(value="admin_login",method=RequestMethod.POST)
	public String adminLogin(AdminVO vo, HttpSession session,Model model,paginationVO cri){
	
		AdminVO vo1= adminService.getAdmin(vo);
		
		if(vo1 != null) {
		
			List<ProductVO> productList =  productService.getList(cri);
			
			model.addAttribute("productList", productList);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(productService.listCount());
			
			model.addAttribute("pageMaker", pageMaker);
		  
			
			return "admin/product/productList";
		}else {
			return "admin/adminLogin";
		}

	}

	
	@RequestMapping(value="admin_logout",method=RequestMethod.GET)
	public String adminLogout(HttpSession session) {
		
		session.invalidate();
		
		return "admin/adminLogin";
	}
	
	@RequestMapping(value="admin_product_list",method=RequestMethod.GET) 
	  public String productList_g(ProductVO vo,Model model,paginationVO cri) {
		
			List<ProductVO> productList =  productService.getList(cri);
			
			model.addAttribute("productList", productList);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(productService.listCount());
			
			model.addAttribute("pageMaker", pageMaker);
		  
		return "admin/product/productList";

	  }
	@RequestMapping(value="list",method=RequestMethod.GET) 
	  public String productList(Model model,paginationVO cri) {
		
			List<ProductVO> productList =  productService.getList(cri);
			
			model.addAttribute("productList", productList);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(productService.listCount());
			
			model.addAttribute("pageMaker", pageMaker);
		  
		return "admin/product/productList";

	  }
	
	@RequestMapping(value="admin_product_list",method=RequestMethod.POST) 
	  public String proList(Model model,paginationVO cri) {
			
			List<ProductVO> productList =  productService.getList(cri);
			
			model.addAttribute("productList", productList);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(productService.listCount());
			
			model.addAttribute("pageMaker", pageMaker);
		  
		return "admin/product/productList";

	  }

	
	@RequestMapping(value="admin_product_detail")
	public String productDetail(ProductVO vo,Model model,@RequestParam("pseq")int pseq) {
	
		ProductVO proDetail = productService.getProduct(vo);

		model.addAttribute("kind", kinds[Integer.parseInt(proDetail.getKind())-1]);
		model.addAttribute("productVO", proDetail);
		
		
		return "admin/product/productDetail";
	}

	  @RequestMapping(value="admin_product_write",method=RequestMethod.GET) 
	  public String productWrite_get(ProductVO vo) throws IOException{
 
		  String fileName ="";
		  MultipartFile upload = vo.getUpload();
		  if(!upload.isEmpty()) {
			  fileName = upload.getOriginalFilename();
			  upload.transferTo(new File("C:\\Users\\Administrator\\workspace\\upload\\"+fileName));

		  }
		  vo.setImage(fileName);
		  productService.insertProduct(vo);
		  	  
		  return "admin/product/productWrite"; 
	  }
	  @RequestMapping(value="admin_product_write",method=RequestMethod.POST) 
	  public String productWrite(ProductVO vo) throws IOException{
 
		  String fileName = "";
		  MultipartFile upload = vo.getUpload();
		  if(!upload.isEmpty()) {
			  fileName = upload.getOriginalFilename();
			  upload.transferTo(new File("C:\\Users\\Administrator\\workspace\\upload\\"+fileName));
		  }
		 
		  vo.setImage(fileName);
		  productService.insertProduct(vo);
		  	  
		  return "redirect:admin_product_list"; 
	  }

	  

	  @RequestMapping(value="admin_product_write_form",method=RequestMethod.POST) 
	  public String proWrite() {
		  
		  return "admin/product/productWrite";
	  }

	  
	  @RequestMapping(value="admin_product_update_form",method=RequestMethod.POST)
	  public String updateProduct(@RequestParam(value="pseq")int pseq,ProductVO vo,Model model){
		  
		
		  ProductVO update = productService.getProduct(vo);
		  List<String> kindList = Arrays.asList(kinds);
		 	  
		  model.addAttribute("productVO", update);
		  model.addAttribute("kindList", kindList);
		  
		  return "admin/product/productUpdate";
	  }
	  @RequestMapping(value="admin_product_update",method=RequestMethod.GET)
	  public String updatePro_g(@RequestParam(value="pseq")int pseq,ProductVO vo,Model model)throws IOException{
		  
			  
		  MultipartFile upload = vo.getUpload();
		  if(!upload.isEmpty()) {
			  String fileName = upload.getOriginalFilename();
			  vo.setImage(fileName);
			  upload.transferTo(new File("C:\\Users\\Administrator\\workspace\\show2\\src\\main\\webapp\\WEB-INF\\views\\admin\\images"+fileName));
		  }
		  

		  ProductVO update = productService.getProduct(vo);
		  productService.updateProduct(vo);
		  List<String> kindList = Arrays.asList(kinds);
		
		  
		  model.addAttribute("productVO", vo);
		  model.addAttribute("kindList", kindList);
		  
		  return "admin/product/productDetail";
	  }
	  
	  @RequestMapping(value="admin_product_update",method=RequestMethod.POST)
	  public String updatePro(@RequestParam(value="pseq")int pseq,ProductVO vo,Model model)throws IOException{
		  
		  MultipartFile upload = vo.getUpload();
		  if(!upload.isEmpty()) {
			  String fileName = upload.getOriginalFilename();
			  vo.setImage(fileName);
			  upload.transferTo(new File("C:\\Users\\Administrator\\workspace\\show2\\src\\main\\webapp\\WEB-INF\\views\\admin\\images"+fileName));
		  }
		  

		  ProductVO update = productService.getProduct(vo);
		  productService.updateProduct(vo);
		  List<String> kindList = Arrays.asList(kinds);
		
		  
		  model.addAttribute("productVO", vo);
		  model.addAttribute("kindList", kindList);
		  
		  return "admin/product/productDetail";
	  }
	  
	  
	 @RequestMapping(value="admin_order_list",method=RequestMethod.GET)
	 public String adminOrder(OrderVO vo,Model model) {
		 
		 List<OrderVO> orderList = orderService.getOrderList(vo);
		 
		 model.addAttribute("orderList", orderList);

		 
		 return "admin/order/orderList";
	 }
	 
	

	 @RequestMapping(value="admin_order_save",method=RequestMethod.POST)
	 public String OrderSave(OrderVO vo,Model model) {
		 
		 
		 List<OrderVO> orderList = orderService.getOrderList(vo);
		 
		 model.addAttribute("orderList", orderList);
		 
		 
		 return "admin/order/orderList";
	 }

	
	  @RequestMapping(value="admin_member_list",method=RequestMethod.GET)
	  public String adminMemeberList(UserMemberVO vo,Model model) {
		  
		  
		  	List<UserMemberVO> userList = memberService.memberList(vo);
		  
		  	model.addAttribute("userMemberList", userList);
		  
		  
		  return "admin/member/memberList"; 
	  }
	  
	  
		 
	 @RequestMapping(value="admin_qna_list")
	 public String adminQna_g(QnaVO vo,Model model) {
		 
		 List<QnaVO> qnaList = qnaService.getListQna();
		 
		 model.addAttribute("qnaList", qnaList);
		 
		 return "admin/qna/qnaList";
	 }

	 @RequestMapping(value="admin_qna_detail",method = RequestMethod.POST)
	 public String qnaDetail(@RequestParam(value="qseq")int seq,Model model,QnaVO vo) {
		 
		 QnaVO qnaDetail = qnaService.getQna(seq);
		
		 model.addAttribute("qnaVO", qnaDetail);
		 
		 return "admin/qna/qnaDetail";
	 }

	 
	 @RequestMapping(value="admin_qna_repsave",method = RequestMethod.POST)
	 public String qnarepsave(@RequestParam(value="qseq")int seq,Model model,QnaVO vo) {
 
		 QnaVO qnaDetail = qnaService.getQna(seq);
		 qnaService.updateQna(qnaDetail);
		 model.addAttribute("qnaVO", qnaDetail);
		 
		 return "redirect:admin_qna_list";
	 }

}
