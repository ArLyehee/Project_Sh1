package com.shop.biz.Address;

import java.util.List;

public interface AddressService {

	List<AddressVO> selectAddressByDong(String dong);

}