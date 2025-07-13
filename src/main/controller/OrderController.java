package main.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import main.dto.CustomerDto;
import main.dto.OrderDto;
import main.service.OrderService;
import main.service.UserService;
import main.service.Implements.OrderServiceImpl;
import main.service.Implements.UserServiceImpl;

public class OrderController {
	
	OrderService login = new OrderServiceImpl();
	
	// 상품 주문
	public int order(OrderDto odo, String userName) throws SQLException {
		
		int result = login.insertOrder(odo, userName);
		
		return result;
		
	}
	
	// 고객별 주문한 상품조회
	public ArrayList<CustomerDto> customerEachProductFind() {
		
		return null;
		
	}
	
	// 고객별 현재까지 할인받은은 금액
	public ArrayList<CustomerDto> customerEachDiscountPrice() {
		
		return null;
		
	}
	
}
