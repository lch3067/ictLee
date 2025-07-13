package main.dto;

import main.common.enums.WineOrigin;

// 와인
public class WineDto {

	// 와인 제품 번호
	private String wine_number;
	// 와인 이름
	private String wine_name;
	// 와인 가격
	private int wine_price;
	// 와인 산지
	private WineOrigin region;
	// 와인 나라
	private WineOrigin country;
	// 도수
	private String wine_strength;
	
	// 기본 생성자는 매개변수가 없는 경우 생성하는 목적이지만, 
	// 굳히 setter와 getter를 사용하여 맴버변수이 넣을거면, 생성자로 넣지 않아도 된다.
	// 자동으로 생성해주기 때문이다.
	public WineDto() {}
	
	// 하지만, 매개변수가 있는 생성자를 만들면 기본 생성자도 같이 만들어 줘야한다.
	public WineDto(String wine_name, int wine_price, WineOrigin region, String wine_strength) {
		this.wine_name = wine_name;
		this.wine_price = wine_price;
		this.region = region;
		this.wine_strength = wine_strength;
	}

	// getter, setter : 맴버변수 값을 반환 및 입력을 위한 목적
	public String getWine_name() {
		return wine_name;
	}
	public void setWine_name(String wine_name) {
		this.wine_name = wine_name;
	}
	public int getWine_price() {
		return wine_price;
	}
	public void setWine_price(int wine_price) {
		this.wine_price = wine_price;
	}
	public WineOrigin region() {
		return region;
	}
	public void setWine_growing(WineOrigin region) {
		this.region = region;
	}
	public String getWine_strength() {
		return wine_strength;
	}
	public void setWine_strength(String wine_strength) {
		this.wine_strength = wine_strength;
	}
	
	
}
