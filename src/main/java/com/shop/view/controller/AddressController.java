package com.shop.view.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shop.biz.Address.AddressService;
import com.shop.biz.Address.AddressVO;

@Controller
public class AddressController {
	
	@Autowired
	AddressService addressService;
	
	@RequestMapping(value="find_zip_num",method=RequestMethod.GET)
	public String findZip() {
		
		return "member/findZipNum";
	}
	
	@RequestMapping(value="find_zip_num",method=RequestMethod.POST)
	public String findZipNum(AddressVO vo,Model model) {
		

		List<AddressVO> vo1 = addressService.selectAddressByDong(vo.getDong());
		System.out.println("findZipNum() POST:"+vo.getDong());
		for(AddressVO vo2 : vo1) {
			System.out.println(vo2.getDong());
		}
		model.addAttribute("addressList", vo1);
		
		return "member/findZipNum";
	}

}
