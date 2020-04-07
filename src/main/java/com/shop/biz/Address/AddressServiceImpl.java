package com.shop.biz.Address;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("addressService")
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressDAO addressDAO;
	
	@Override
	public List<AddressVO> selectAddressByDong(String dong) {
		
		return addressDAO.selectAddressByDong(dong);
	}

}
