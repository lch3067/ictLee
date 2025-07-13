package main.dto;

import java.sql.Timestamp;

// 주문
public class OrderDto {

	private String idx;
	private String order_Id;
	private String cusomter_Id;
	private String wine_Number;
	private Timestamp order_Date;
	private int product_Price;
	private boolean discount;
	
	public OrderDto() {}

	public OrderDto(String order_Id, String cusomter_Id, String wine_Number, Timestamp order_Date, int product_Price,
			boolean discount) {
		this.order_Id = order_Id;
		this.cusomter_Id = cusomter_Id;
		this.wine_Number = wine_Number;
		this.order_Date = order_Date;
		this.product_Price = product_Price;
		this.discount = discount;
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

	public boolean isDiscount() {
		return discount;
	}

	public void setDiscount(boolean discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "OrderDto [idx=" + idx + ", order_Id=" + order_Id + ", cusomter_Id=" + cusomter_Id + ", wine_Number="
				+ wine_Number + ", order_Date=" + order_Date + ", product_Price=" + product_Price + ", discount="
				+ discount + "]";
	};
	
}
