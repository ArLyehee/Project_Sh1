package com.shop.biz.Address;

public class AddressVO {
	private String zip_num;
	private String sido;
	private String gugun;
	private String dong;
	private String zipCode;
	private String bunji;
	
	public String getZip_num() {
		return zip_num;
	}
	public void setZip_num(String zip_num) {
		this.zip_num = zip_num;
	}
	public String getSido() {
		return sido;
	}
	public void setSido(String sido) {
		this.sido = sido;
	}
	public String getGugun() {
		return gugun;
	}
	public void setGugun(String gugun) {
		this.gugun = gugun;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getBunji() {
		return bunji;
	}
	public void setBunji(String bunji) {
		this.bunji = bunji;
	}
	@Override
	public String toString() {
		return "AddressVO [zip_num=" + zip_num + ", sido=" + sido + ", gugun=" + gugun + ", dong=" + dong + ", zipCode="
				+ zipCode + ", bunji=" + bunji + "]";
	}
}
