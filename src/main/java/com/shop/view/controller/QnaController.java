package com.shop.view.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shop.biz.Qna.QnaService;
import com.shop.biz.Qna.QnaVO;
import com.shop.biz.UserMember.UserMemberVO;


@Controller
public class QnaController {

	@Autowired
	private QnaService qnaService;
	
	@RequestMapping(value="qna_list",method=RequestMethod.GET)
	public String qnaList(HttpServletRequest request,QnaVO vo, Model model) {
		
		UserMemberVO loginUser = (UserMemberVO) request.getSession().getAttribute("loginUser");
		String userId = "";
		
		if(loginUser != null) {
			userId = loginUser.getId();
			vo.setId(userId);
			List<QnaVO> qnaList = qnaService.listQna(vo);
			
			model.addAttribute("qnaList", qnaList);
			
			return "qna/qnaList";
		}else {
			return "member/login";
		}
	}
	
	@RequestMapping(value="qna_write_form",method=RequestMethod.GET)
	public String qnaWrite(HttpServletRequest request,QnaVO vo) {
		
		UserMemberVO loginUser = (UserMemberVO) request.getSession().getAttribute("loginUser");
		String userId = "";
		
		if(loginUser != null) {
			userId = loginUser.getId();
			vo.setId(userId);
			
			return "qna/qnaWrite";
		}else {
			return "member/login";
		}	
	}
	
	@RequestMapping(value="qna_write", method=RequestMethod.POST)
	public String quainsert(HttpServletRequest request, QnaVO vo, Model model) {
		
		UserMemberVO loginUser = (UserMemberVO) request.getSession().getAttribute("loginUser");
		String userId = "";
	
		if(loginUser != null) {
			userId = loginUser.getId();
			vo.setId(userId);
			
			qnaService.insertQna(vo);
			
			List<QnaVO> listQna = qnaService.listQna(vo);
			
			
			return "redirect:qna_list";
		}else {
			return "member/login";
		}

	}
	
	@RequestMapping(value="qna_view", method=RequestMethod.GET)
	public String qnaView(@RequestParam(value="qseq")int qseq,HttpServletRequest request, QnaVO vo,Model model) {
		
		UserMemberVO loginUser = (UserMemberVO) request.getSession().getAttribute("loginUser");
		String userId = "";
		
		if(loginUser != null) {
			userId = loginUser.getId();
			vo.setId(userId);
		
			vo.setQseq(qseq);
			
			QnaVO qnavo = qnaService.getQna(qseq);

			
			
			model.addAttribute("qnaVO", qnavo);
			
			return "qna/qnaView";
		}else {
			return "member/login";
		}
	}
	
	@RequestMapping(value="qna_delete", method=RequestMethod.GET)
	public String deleteQna(@RequestParam(value="qseq")int qseq){

		qnaService.deleteQna(qseq);
		
		
		return "redirect:qna_list";
	}
}

