package main.dto;

import main.common.enums.WineOrigin;

public class WineDto {
	private int wine_idx;
	private String wine_number;
	private String wine_name;
	private int wine_price;
	private WineOrigin region;
	private WineOrigin country;
	private String wine_strength;

	public WineDto() {
	}

	public WineDto(int wine_idx, String wine_number, String wine_name, int wine_price, WineOrigin region,
			WineOrigin country, String wine_strength) {
		this.wine_idx = wine_idx;
		this.wine_number = wine_number;
		this.wine_name = wine_name;
		this.wine_price = wine_price;
		this.region = region;
		this.country = country;
		this.wine_strength = wine_strength;
	}

	public int getWine_idx() {
		return wine_idx;
	}

	public void setWine_idx(int wine_idx) {
		this.wine_idx = wine_idx;
	}

	public String getWine_number() {
		return wine_number;
	}

	public void setWine_number(String wine_number) {
		this.wine_number = wine_number;
	}

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

	public WineOrigin getRegion() {
		return region;
	}

	public void setWine_Region(WineOrigin region) {
		this.region = region;
	}

	public WineOrigin getCountry() {
		return country;
	}

	public void setWine_Country(WineOrigin country) {
		this.country = country;
	}

	public String getWine_strength() {
		return wine_strength;
	}

	public void setWine_strength(String wine_strength) {
		this.wine_strength = wine_strength;
	}

	@Override
	public String toString() {
		return "WineDto [wine_idx=" + wine_idx + ", wine_number=" + wine_number + ", wine_name=" + wine_name
				+ ", wine_price=" + wine_price + ", region=" + region + ", country=" + country + ", wine_strength="
				+ wine_strength + "]\n";
	}
	

}
