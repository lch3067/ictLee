package main.dto;

import java.sql.Timestamp;

// 주문
public class OrderDto extends WineDto {

	private String idx;
	private String order_Id;
	private String cusomter_Id;
	private String wine_Number;
	private Timestamp order_Date;
	private int product_Price;
	private int Order_Count;
	private boolean discount;
	
	public OrderDto() {}

	public OrderDto(String idx, String order_Id, String cusomter_Id, String wine_Number, Timestamp order_Date,
			int product_Price, int order_Count, boolean discount) {
		this.idx = idx;
		this.order_Id = order_Id;
		this.cusomter_Id = cusomter_Id;
		this.wine_Number = wine_Number;
		this.order_Date = order_Date;
		this.product_Price = product_Price;
		Order_Count = order_Count;
		this.discount = discount;
	}

	public String getIdx() {
		return idx;
	}

	public void setIdx(String idx) {
		this.idx = idx;
	}

	public String getOrder_Id() {
		return order_Id;
	}

	public void setOrder_Id(String order_Id) {
		this.order_Id = order_Id;
	}

	public String getCusomter_Id() {
		return cusomter_Id;
	}

	public void setCusomter_Id(String cusomter_Id) {
		this.cusomter_Id = cusomter_Id;
	}

	public String getWine_Number() {
		return wine_Number;
	}

	public void setWine_Number(String wine_Number) {
		this.wine_Number = wine_Number;
	}

	public Timestamp getOrder_Date() {
		return order_Date;
	}

	public void setOrder_Date(Timestamp order_Date) {
		this.order_Date = order_Date;
	}

	public int getProduct_Price() {
		return product_Price;
	}

	public void setProduct_Price(int product_Price) {
		this.product_Price = product_Price;
	}

	public int getOrder_Count() {
		return Order_Count;
	}

	public void setOrder_Count(int order_Count) {
		Order_Count = order_Count;
	}

	public boolean isDiscount() {
		return discount;
	}

	public void setDiscount(boolean discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "OrderDto [order_Id=" + order_Id + ", cusomter_Id=" + cusomter_Id + ", wineName="
				+ getWine_name() + ", region=" + getRegion() + ", country=" + getCountry() + ", orderDate="
				+ getOrder_Date() + "]\n";
	}

}
